package com.fumolu.www.controller;

import com.fumolu.www.model.Player;
import com.fumolu.www.service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-29 14:52
 */
@WebServlet(name = "InitPlayerServlet")
public class InitPlayerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("初始化角色信息");
        response.setContentType("text/html;charset=utf-8");
        String value = request.getParameter("index");//获取页面传过来的参数
        System.out.println("选择职业序号：" + value);
        int professionID = Integer.parseInt(value);
        // 通过session获取玩家username
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("loginuser");
        // 初始化玩家信息
        Player player = PlayerService.initPlayer(username, professionID);
        // 存入session，同时从定向到skill页面
        session.setAttribute("player", player);
        response.sendRedirect("/skill.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
