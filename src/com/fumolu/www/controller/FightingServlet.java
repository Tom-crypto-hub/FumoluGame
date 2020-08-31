package com.fumolu.www.controller;

import com.fumolu.www.data.FightStatus;
import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Player;
import com.fumolu.www.service.EnemyService;
import com.fumolu.www.service.PlayerService;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-30 15:20
 *
 *  战斗场景界面
 */
@javax.servlet.annotation.WebServlet(name = "FightingServlet")
public class FightingServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        response.setContentType("text/html;charset=utf-8");
        // 获取玩家使用的攻击方式
        String index = request.getParameter("index");
        FightStatus fightStatus = getFightStatus(index);

        // 获取session
        HttpSession httpSession = request.getSession(true);
        // 从session中获取enemy和player
        Enemy enemy = (Enemy) httpSession.getAttribute("enemy");
        Player player = (Player) httpSession.getAttribute("player");

        if(player.getHp() > 0 && enemy.getHp() > 0) {
            ArrayList<String> strings = (ArrayList<String>) httpSession.getAttribute("msgList");
            // 如果敌人速度比玩家快，就敌人先攻击，否则，玩家先攻击
            if (enemy.getSpeed() > player.getSpeed()) {
                strings.add("敌人先手！");
                strings.add(EnemyService.enemyAttack(enemy, player));
                if (player.getHp() <= 0) {
                    strings.add("玩家生命值为0，玩家挑战失败！");
                    boolean flag = PlayerService.fail(player, enemy);
                    strings.add("玩家将损失经验和金币，损失值为怪物身上的金币的50%，和怪物经验值的30%");

                    httpSession.setAttribute("isRunAway", "false");
                } else {
                    strings.add(PlayerService.fight(player, enemy, fightStatus, index));
                    if (fightStatus == FightStatus.FIGHT_RUN_AWAY) {

                        httpSession.setAttribute("isRunAway", "true");
                    } else if (enemy.getHp() <= 0) {
                        strings.add("敌人生命值为0，玩家挑战成功！");
                        PlayerService.victory(player, enemy);
                        strings.add("玩家获得经验值和金币！");
                    }
                }
            } else {
                strings.add("玩家先手！");
                strings.add(PlayerService.fight(player, enemy, fightStatus, index));
                if (fightStatus == FightStatus.FIGHT_RUN_AWAY) {
                    // 重定向到客户端
                    httpSession.setAttribute("isRunAway", "true");
                } else if (enemy.getHp() <= 0) {
                    strings.add("敌人生命值为0，玩家挑战成功！");
                    PlayerService.victory(player, enemy);
                    strings.add("玩家获得经验值和金币！");
                    // 重定向到客户端
                    httpSession.setAttribute("isRunAway", "false");
                } else {
                    strings.add(EnemyService.enemyAttack(enemy, player));
                    if (player.getHp() <= 0) {
                        strings.add("玩家生命值为0，玩家挑战失败！");
                        PlayerService.fail(player, enemy);
                        strings.add("玩家将损失经验和金币，损失值为怪物身上的金币的50%，和怪物经验值的30%");
                    }
                }
            }
            httpSession.setAttribute("msgList", strings);

            // 重定向到客户端
            httpSession.setAttribute("isRunAway", "false");
            httpSession.setAttribute("player", player);
            httpSession.setAttribute("enemy", enemy);
            response.sendRedirect("/fight.jsp");
        }
        else if(player.getHp() <= 0 && enemy.getHp() > 0){
            response.setCharacterEncoding("GBK");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("if(window.confirm(" + "\"" + "战斗失败了，请前往商店购买复活甲？" + "\"" + ")){location.href = \"shop.jsp\";}");
            response.setContentType("text/html;charset=utf-8");
            out.println("open(\"skill.jsp\", \"_self\");");//重新打开新的页面, _self在原窗口打开
            out.println("</script>");
            out.close();
        }
        else {
            response.sendRedirect("/fight.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request, response);
    }

    private FightStatus getFightStatus(String index){
        FightStatus fightStatus = FightStatus.FIGHT_ERROR;
        switch (index){
            case "普通攻击":
                fightStatus = FightStatus.FIGHT_PYHSICAL_ATTACK;
                break;
            case "法术攻击":
                fightStatus = FightStatus.FIGHT_MAGIC_ATTACK;
                break;
            case "火球术":
            case "烈火流星":
            case "春风吹又生":
            case "御剑术":
            case "嗜狼印":
            case "万剑诀":
                fightStatus = FightStatus.FIGHT_SKILL_ATTACK;
                break;
            case "逃跑":
                fightStatus = FightStatus.FIGHT_RUN_AWAY;
                break;
            default:
                break;

        }
        return fightStatus;
    }
}
