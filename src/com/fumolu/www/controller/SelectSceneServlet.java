package com.fumolu.www.controller;

import com.fumolu.www.model.Place;
import com.fumolu.www.service.PlaceService;

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
 * @createDate: 2020-08-30 15:31
 *
 * 选择场景的
 */
@WebServlet(name = "SelectSceneServlet")
public class SelectSceneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String value = request.getParameter("index");
        System.out.println("选择场景：" + value);
        // 创建场景
        Place place = PlaceService.choicePlace(Integer.parseInt(value));
        // 设置session
        request.getSession(true).setAttribute("place", place);
        System.out.println("选择场景结束！");
        response.sendRedirect("/chooseMonster.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
