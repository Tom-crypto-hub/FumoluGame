package com.fumolu.www.controller;

import com.fumolu.www.model.Player;
import com.fumolu.www.service.npc.NpcMasterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-29 22:21
 */
@WebServlet(name = "LearnSkillServlet")
public class LearnSkillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 获取数据
        String index = request.getParameter("index");
        System.out.println(index);
        int skillID = Integer.parseInt(index);
        Player player = (Player) request.getSession(true).getAttribute("player");
        // 通过service让角色学习技能
        String string = new NpcMasterService().helpPlayer(player, skillID);

        response.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        out.println("<script type='text/javascript'>");
        out.println("alert(" + "\"" + string + "\"" + ")");
        response.setContentType("text/html;charset=utf-8");
        out.println("open(\"learn.jsp\", \"_self\");");//重新打开新的页面, _self在原窗口打开
        out.println("</script>");
        out.close();
        System.out.println("这是学习技能的页面");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
