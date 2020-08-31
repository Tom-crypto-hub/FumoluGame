<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/30 0030
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>打怪</title>
    <link rel="stylesheet" href="css/daguai.css">
    <script src="fonts/iconfont.js"></script>
    <style>
    </style>
</head>
<body>
<ul class="sx">
    <li>
        <img src="img/xincun.jpg">
        <a onclick="chooseScrene(0)">
            <p class="qq">新手村</p></a>
    </li>
    <li>
        <img src="img/jiaowai.jpg">
        <a onclick="chooseScrene(1)">
            <p class="qq">洛阳郊外</p></a>
    </li>
    <li>
        <img src="img/difu.jpg">
        <a onclick="chooseScrene(2)">
            <p class="qq">阴曹地府</p></a>
    </li>
</ul>
<nav id="fnav">
    <div class="fitem">
        <a href="skill.jsp">
            <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-xingzhuanggongnengtubiao-"></use>
            </svg>
            <p><a href="#">返回</a></p>
        </a>
    </div>
</nav>

<script>
    function chooseScrene(index) {
        var url = "SelectSceneServlet?index=" + index;
        location.href = url;
    }
</script>

</body>
</html>
