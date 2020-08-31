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
                <a href="chooseScene.jsp">打怪</a>
            </div>
        </div>
        <div class="heal">
            <div class="pic">
                <a href="">
                    <img src="img/heal.gif" alt="">
                </a>
            </div>
            <div class="word">
                <a onclick="healFunc()">华医师</a>
            </div>
        </div>
        <div class="learn">
            <div class="pic">
                <a href="">
                    <img src="img/learn.gif" alt="">
                </a>
            </div>
            <div class="word">
                <a href="learn.jsp">学习技能</a>
            </div>
        </div>
        <div class="shop">
            <div class="pic">
                <a href="">
                    <img src="img/heal-2.gif" alt="">
                </a>
            </div>
            <div class="word">
                <a href="shop.jsp">商店</a>
            </div>
        </div>
<%--        <div class="return">--%>
<%--            <a href="occupation.jsp">返回</a>--%>
<%--        </div>--%>
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

    // 治疗
    function healFunc() {
        var talks = ["您好！\n欢迎来到我的疗伤室，需要疗伤吗？",
            "又受伤了吗？\n来我这，获得满血重生的快感吧~",
            "体力不支？\n血量不足？\n缺乏蓝条？\n在我这里，这里都不是事~",
            "有我在，没有什么是我治不了的~"];
        // 0 ~ 3的随机数
        var randInt = Math.round(Math.random() * 3);
        var url = "HealServlet";
        if(window.confirm(talks[randInt] + "\n消耗金币：300")){
            location.href = url;
        }else {
            return false;
        }
    }

</script>
</body>
</html>
