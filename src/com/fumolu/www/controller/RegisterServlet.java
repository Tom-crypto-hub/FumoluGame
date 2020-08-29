package com.fumolu.www.controller;

import com.fumolu.www.dao.PlayerDao;
import com.fumolu.www.model.Player;
import com.fumolu.www.service.PlayerService;
import com.fumolu.www.utils.RandomUtil;

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
 * @createDate: 2020-08-29 11:46
 */
@WebServlet(name = "RegisteServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");//获取页面传过来的参数
        String password = request.getParameter("password");
        int img_id = RandomUtil.random.nextInt(11) + 1;
        boolean flag = PlayerService.register(username, password, img_id);
        if(flag){
            // 将玩家账号存入session
            Player p = new PlayerDao().inquiry(username);
            HttpSession session = request.getSession(true);
            session.setAttribute("loginuser", username);
            session.setAttribute("avatar_id", img_id);
            // 显示首页
            response.sendRedirect("/occupation.jsp");
//            request.getRequestDispatcher("/occupation.jsp").forward(request, response);
        }else {
            response.setCharacterEncoding("GBK");
            PrintWriter out = response.getWriter();
            out.println("<script type='text/javascript'>");
            out.println("alert(" + "\"" + "注册失败，用户名已存在" + "\"" + ")");

            response.setContentType("text/html;charset=utf-8");
            out.println("open(\"regester.html\", \"_self\");");//重新打开新的页面, _self在原窗口打开
            out.println("</script>");
            out.close();
        }
        // 显示首页
//        request.getRequestDispatcher("/skill.html").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
