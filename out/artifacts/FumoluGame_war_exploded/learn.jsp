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
    <script type="text/javascript" src="jQuery/jquery-3.5.1.min.js"></script>
</head>
<body>
<div class="learn">
    <div class="content">
        <div class="yu">
            <div class="picture">
                <img src="img/yu.jpg" alt="">
            </div>
            <div class="world">
                <a onclick="learnSkill(3)">御剑术</a>
            </div>
        </div>
        <div class="wan">
            <div class="picture">
                <img src="img/wan.jpg" alt="">
            </div>
            <div class="world">
                <a onclick="learnSkill(5)">万剑诀</a>
            </div>
        </div>
        <div class="return">
            <a href="skill.jsp">返回</a>
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

    function learnSkill(index) {
        var url = "LearnSkillServlet?index=" + index;
        if(index === 3) {
            if (window.confirm("奇哉大道，壮哉大道，天得一以清，地得一以宁，神得一以灵,谷得一以盈，万物得一以生。\n   ... ..." +
                "\n\n 功力一般者，十步之内凌空御剑杀敌，或是御剑飞行；功力高深者飞剑千里取人首级。" +
                "\n您将支付5000金币，您是否要学习御剑术？")) {
                location.href = url;
            }
            else {
                return false;
            }
        }else {
            if (window.confirm("万剑齐发，罡气纵横，剑气所向，地裂天崩！\n   ... ..." +
                "\n\n您将支付50000金币，您是否要学习万剑诀？")) {
                location.href = url;
            }
            else {
                return false;
            }
        }
    }
</script>
</body>
</html>
