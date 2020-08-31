package com.fumolu.www.controller;

import com.fumolu.www.model.Player;
import com.fumolu.www.service.npc.NpcDoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-29 20:42
 */
@WebServlet(name = "HealServlet")
public class HealServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 通过session获取玩家对象
        Player player = (Player) request.getSession(true).getAttribute("player");
        // 通过services更改玩家属性值
        boolean flag = new NpcDoctorService().helpPlayer(player);

        // 添加session
        if(flag){
            request.getSession(true).setAttribute("healMsg", "你已经疗伤完成啦！！哈哈哈哈~~~");
        }else {
            request.getSession(true).setAttribute("healMsg", "非常抱歉，您的金币不足啦~~~");
        }
        // 重定向到页面
        response.sendRedirect("/heal.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
