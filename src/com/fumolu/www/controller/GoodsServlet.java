package com.fumolu.www.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fumolu.www.model.Player;
import com.fumolu.www.service.npc.NpcStoreService;
import com.mysql.cj.xdevapi.JsonArray;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-30 10:58
 */
@WebServlet(name = "GoodsServlet")
public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 获取选择的物品编号
        String string = request.getParameter("index");
        String newName = request.getParameter("name");
        int index = Integer.parseInt(string);
        System.out.println(index + "  :  " + newName);

        Player player = (Player) request.getSession(true).getAttribute("player");
        String result = "";
        if(index == 8 && player.getHp() > 0){
            // 如果玩家是复活，先判断玩家血量是否为空
            result = "你当前不需要复活甲！ 只能在战斗中死亡时才能购买！";
            System.out.println(result);
        }else {
            boolean flag = new NpcStoreService().helpPlayer(player, index, newName);
            if(flag){
                result = "您成功购买了该物品，已经获得了相应的属性，加油少年！";
            }else {
                result = "您的金币不足！或者购买失败！";
            }
            request.getSession(true).setAttribute("player", player);
        }

        response.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        out.println("<script type='text/javascript'>");
        out.println("alert(" + "\"" + result + "\"" + ")");
        response.setContentType("text/html;charset=utf-8");
        out.println("open(\"shop.jsp\", \"_self\");");//重新打开新的页面, _self在原窗口打开
        out.println("</script>");
        out.close();


        System.out.println("这是购买商品的页面");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
