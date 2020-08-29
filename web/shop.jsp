<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/29 0029
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商店</title>
    <link rel="stylesheet" href="css/shop.css">
</head>
<body>
<div class="shop">
    <div class="content">
        <div class="contentLeft">
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-2.png" alt="">
                </a>
                <a href="" class="pingWord">昆凌伞</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-3.png" alt="">
                </a>
                <a href="" class="pingWord">武功秘籍</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-4.png" alt="">
                </a>
                <a href="" class="pingWord">起死回生水</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-6.png" alt="">
                </a>
                <a href="" class="pingWord">乾坤袋</a>
            </div>
        </div>
        <div class="contentRight">
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-1.png" alt="">
                </a>
                <a href="" class="pingWord">疗伤粉</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-2.png" alt="">
                </a>
                <a href="" class="pingWord">昆凌伞</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-3.png" alt="">
                </a>
                <a href="" class="pingWord">葵花宝典</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-4.png" alt="">
                </a>
                <a href="" class="pingWord">忘情水</a>
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
