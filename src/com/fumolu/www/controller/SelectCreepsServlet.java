package com.fumolu.www.controller;

import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Place;
import com.fumolu.www.model.Player;
import com.fumolu.www.service.EnemyService;
import com.fumolu.www.service.PlaceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-30 16:05
 *
 * 选择野怪
 */
@WebServlet(name = "SelectCreepsServlet")
public class SelectCreepsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int value = Integer.parseInt(request.getParameter("index"));
        System.out.println("" + value);

        HttpSession session = request.getSession(true);
        Place place = (Place) session.getAttribute("place");
        Player player = (Player) session.getAttribute("player");

        // 初始化敌人
        Enemy enemy = EnemyService.choiceEnemy(place.getEnemys().get(value), player.getLevel());

        // 设置session
        request.getSession(true).setAttribute("enemy", enemy);
        ArrayList<String> msgList = new ArrayList<>();
        request.getSession(true).setAttribute("msgList", msgList);
        response.sendRedirect("/fight.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
