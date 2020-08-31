<%@ page import="com.fumolu.www.model.Place" %>
<%@ page import="com.fumolu.www.model.Player" %>
<%@ page import="com.fumolu.www.model.Enemy" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/30 0030
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        // 获取session
        HttpSession httpSession = request.getSession(true);
        // 从session中获取place
        Place place = (Place) httpSession.getAttribute("place");
        // 初始化图片的URL
        List<Enemy> enemys = place.getEnemys();
        String bg_url = "../img/bg" + (place.getID() + 1) + ".jpg";
        String bg_monster = "../img/bg" + (place.getID() + 1) + "_monster";
        String bg_monster1 = bg_monster + "1.jpg";
        String bg_monster2 = bg_monster + "2.jpg";
        String bg_monster3 = bg_monster + "3.jpg";
    %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%=place.getPlaceName()%></title>
    <script src="fonts/iconfont.js"></script>
    <link rel="stylesheet" href="css/scene.css">
</head>
<body style="background-image:url(<%=bg_url%>);">

<div class="zy">
    <a href="#">
        <img src="<%=bg_monster1%>">
    </a>
    <div class="text">
        <a onclick="fight(0)"> <h4><%=enemys.get(0).getCharacterName()%></h4>
        </a>
    </div>
</div>
<div class="zy">
    <a href="#">
        <img src="<%=bg_monster2%>">
    </a>
    <div class="text">
        <a onclick="fight(1)"><h4><%=enemys.get(1).getCharacterName()%></h4></a>
    </div>
</div>
<div class="zy">
    <a href="#">
        <img src="<%=bg_monster3%>">
    </a>
    <div class="text">
        <a onclick="fight(2)"><h4><%=enemys.get(2).getCharacterName()%></h4></a>
    </div>
</div>
<nav id="fnav">
    <div class="fitem">
        <a href="chooseScene.jsp">
            <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-xingzhuanggongnengtubiao-"></use>
            </svg>
            <p><a href="chooseScene.jsp">返回</a></p>
        </a>
    </div>
</nav>

<script>
    function fight(index) {
        if(window.confirm("您确定要攻击此敌人吗？")) {
            location.href = "SelectCreepsServlet?index=" + index;
        }
        else {
            return false;
        }
    }
</script>


</body>
</html>
