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
import java.io.PrintWriter;

/**
 * @ClassName: ${NAME}
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-29 8:37
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");//获取页面传过来的参数
        String password = request.getParameter("password");
        Player player = PlayerService.login(username, password);
        // 登录成功
        if(player != null){
            HttpSession session = request.getSession(true);
            // 将玩家账号存入session
            session.setAttribute("loginuser", username);
            session.setAttribute("player", player);
//            request.getSession().setAttribute("player", player);
            // 显示首页
            request.getRequestDispatcher("/change.jsp").forward(request, response);
//            response.sendRedirect("/change.jsp");
        }else {
            response.setCharacterEncoding("GBK");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert(" + "\"" + "用户不存在或者密码错误" + "\"" + ")");
//            System.out.println(Logs.log);

            response.setContentType("text/html;charset=utf-8");
            out.println("open(\"login.jsp\", \"_self\");");//重新打开新的页面, _self在原窗口打开
            out.println("</script>");
            out.close();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
