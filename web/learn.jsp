<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/29 0029
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>学习技能</title>
    <link rel="stylesheet" href="css/learn.css">
</head>
<body>
<div class="learn">
    <div class="content">
        <div class="yu">
            <div class="picture">
                <img src="img/yu.jpg" alt="">
            </div>
            <div class="world">
                <a href="">御剑术</a>
            </div>
        </div>
        <div class="wan">
            <div class="picture">
                <img src="img/wan.jpg" alt="">
            </div>
            <div class="world">
                <a href="">万剑诀</a>
            </div>
        </div>
        <div class="return">
            <a href="skill.html">返回</a>
        </div>
    </div>
</div>

<script>
    var panda = document.getElementById('panda');
    var infor = document.getElementById('infor');
    panda.onmouseover= function () {
        infor.style.display = 'block';
    }
    infor.onmouseleave= function () {
        infor.style.display = 'none';
    }
</script>
</body>
</html>
