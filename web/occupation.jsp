<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/29 0029
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>职业</title>
    <link rel="stylesheet" href="css/occupation.css">
</head>
<body>
<div class="occupation">
    <div class="user">
        <div class="userContent">
            <div class="userName">
                <a href="" onclick="return false;">
                    <%
                        HttpSession httpSession = request.getSession(true);
                        int avatar_id = (int)httpSession.getAttribute("avatar_id");
                        System.out.println(avatar_id);
                        String loginuser = (String) httpSession.getAttribute("loginuser");
                        String imgSrc = "";
                        if(avatar_id > 2) {
                            imgSrc = "img/h-" + avatar_id + ".png";
                        }else {
                            imgSrc = "img/h-" + avatar_id + ".jpg";
                        }
                    %>
                    <img src=<%=imgSrc%> alt="" onclick="return false;">
                </a>
                <span><%=loginuser%></span>
            </div>
        </div>
    </div>
    <div class="content">
        <div class="wellcome">
            <p>欢迎来到伏魔录</p>
        </div>
        <div class="occupations">
            <div class="lestPic">
                <img src="img/swordsman.jpg" alt="" onclick="return false;">
            </div>
            <div class="midele">
                <div class="swordsman">
                    <a href="InitPlayerServlet?index=0">剑客</a>
                </div>
                <div class="magician">
                    <a href="InitPlayerServlet?index=1">术士</a>
                </div>
            </div>
            <div class="rightPic">
                <img src="img/magician.jpg" alt="" onclick="return false;">
            </div>

        </div>
    </div>

</div>
</body>
</html>
