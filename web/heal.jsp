<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/29 0029
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>疗伤</title>
    <link rel="stylesheet" href="css/heal.css">
</head>
<body>
<div class="heal">
 <!--   <div class="user">
        <div class="userContent">
            <div class="userName">
                <a href="" class="headPic">
                    <img src="img/h-5.png" alt="">
                </a>
                <span class="names" id="panda">pandas</span>
                <div class="information" id="infor">
                    <div class="employee">
                        <span>职业：</span>
                        <a href="">剑客</a>
                    </div>
                    <div class="employee">
                        <span>等级：</span>
                        <a href="">12</a>
                    </div>
                    <div class="employee">
                        <span>经验：</span>
                        <a href="">12000</a>
                    </div>
                    <div class="employee">
                        <span>物理攻击力：</span>
                        <a href="">500</a>
                    </div>
                    <div class="employee">
                        <span>魔法攻击：</span>
                        <a href="">5000</a>
                    </div>
                    <div class="employee">
                        <span>物理防御力：</span>
                        <a href="">50000</a>
                    </div>
                    <div class="employee">
                        <span>魔法防御：</span>
                        <a href="">50000</a>
                    </div>
                    <div class="employee">
                        <span>血量：</span>
                        <a href="">500</a>
                        <span>/</span>
                        <a href="">5000</a>
                    </div>
                    <div class="employee">
                        <span>法力：</span>
                        <a href="">500</a>
                        <span>/</span>
                        <a href="">5000</a>
                    </div>
                    <div class="employee">
                        <span>暴击率：</span>
                        <a href="">500</a>
                        <span>/</span>
                        <a href="">5000</a>
                    </div>
                    <div class="employee">
                        <span>掌握技能：</span>
                        <a href="">御剑术</a>
                        <span>、</span>
                        <a href="">万剑术</a>
                    </div>
                </div>
            </div>
        </div>
    </div>-->
    <div class="content">
        <div class="pics">
            <a href="">
                <img src="img/heal-2.gif" alt="">
            </a>
        </div>
        <div class="words">
            <p><%=(String)request.getSession(true).getAttribute("healMsg")%></p>
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
</script>
</body>
</html>
