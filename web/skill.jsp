<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/29 0029
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>技能</title>
    <link rel="stylesheet" href="css/skill.css">
</head>
<body>

<div class="skill">
    <div class="content">
        <div class="fight">
            <div class="pic">
                <a href="">
                    <img src="img/fight.gif" alt="">
                </a>
            </div>
            <div class="word">
                <a href="">打怪</a>
            </div>
        </div>
        <div class="heal">
            <div class="pic">
                <a href="">
                    <img src="img/heal.gif" alt="">
                </a>
            </div>
            <div class="word">
                <a href="heal.html">疗伤</a>
            </div>
        </div>
        <div class="learn">
            <div class="pic">
                <a href="">
                    <img src="img/learn.gif" alt="">
                </a>
            </div>
            <div class="word">
                <a href="learn.html">学习技能</a>
            </div>
        </div>
        <div class="shop">
            <div class="pic">
                <a href="">
                    <img src="img/heal-2.gif" alt="">
                </a>
            </div>
            <div class="word">
                <a href="shop.html">商店</a>
            </div>
        </div>
        <div class="return">
            <a href="occupation.html">返回</a>
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
