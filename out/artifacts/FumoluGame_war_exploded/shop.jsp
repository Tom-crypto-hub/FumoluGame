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
    <script type="text/javascript" src="js/shop.js"></script>
    <script type="text/javascript" src="jQuery/jquery-3.5.1.min.js"></script>
</head>
<body>
<div class="shop">
    <div class="content">
        <div class="contentLeft">
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-2.png" alt="">
                </a>
                <a onclick="if(window.confirm('您确定要购买大力丸吗？')){buyGoods(1);}" class="pingWord" id="goods1">大力丸</a>
                <a href="" class="pingMoney">2000</a>
                <a href="" class="pingDescription" id="description1">根据职业永久增加30点物理攻击或法术攻击</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-3.png" alt="">
                </a>
                <a onclick="if(window.confirm('您确定要购买健体丸吗？')){buyGoods(2);}" class="pingWord" id="goods2">健体丸</a>
                <a href="" class="pingMoney">2000</a>
                <a href="" class="pingDescription" id="description2">全 永久增加15点 玩家的物理防御和法术防御</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-4.png" alt="">
                </a>
                <a onclick="if(window.confirm('您确定要购买七星散吗？')){buyGoods(3);}" class="pingWord" id="goods3">七星散</a>
                <a href="" class="pingMoney">800</a>
                <a href="" class="pingDescription" id="description3">全 恢复玩家300点生命值和300点法力值</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-6.png" alt="">
                </a>
                <a onclick="if(window.confirm('您确定要购买改名卡吗？')){buyGoods(4);}" class="pingWord" id="goods4">改名卡</a>
                <a href="" class="pingMoney">1000</a>
                <a href="" class="pingDescription" id="description4">更改玩家姓名和头像（头像随机生成）</a>
            </div>
        </div>
        <div class="contentRight">
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-1.png" alt="">
                </a>
                <a onclick="if(window.confirm('您确定要购买雷神甲吗？')){buyGoods(5);}" class="pingWord" id="goods5">雷神甲</a>
                <a href="" class="pingMoney">8000</a>
                <a href="" class="pingDescription" id="description5">永久增加玩家生命上限200点和物理魔法防御各20点</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-2.png" alt="">
                </a>
                <a onclick="if(window.confirm('您确定要购买伏魔刃吗？')){buyGoods(6);}" class="pingWord" id="goods6">伏魔刃</a>
                <a href="" class="pingMoney">8000</a>
                <a href="" class="pingDescription" id="description6">永久增加玩家4%的暴击率，物理攻击和法术攻击各10点</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-3.png" alt="">
                </a>
                <a onclick="if(window.confirm('您确定要购买轻灵靴吗？')){buyGoods(7);}" class="pingWord" id="goods7">轻灵靴</a>
                <a href="" class="pingMoney">8000</a>
                <a href="" class="pingDescription" id="description7">永久增加玩家4%的闪避率和1的速度值</a>
            </div>
            <div class="ping">
                <a href="" class="pingPic">
                    <img src="img/s-4.png" alt="">
                </a>
                <a onclick="if(window.confirm('您确定要购买复活甲吗？')){buyGoods(8);}" class="pingWord" id="goods8">复活甲</a>
                <a href="" class="pingMoney">2000</a>
                <a href="" class="pingDescription" id="description8">在战斗中死亡后购买，可以复活并脱离战场，复活后拥有最大生命值得60%和最大法力值的50%</a>
            </div>
        </div>
        <div class="return">
            <a href="skill.jsp">返回</a>
        </div>
    </div>
</div>

<script>
    function buyGoods(index) {
        var url = "GoodsServlet?index=" + index;
        if(index === 4){
            url += "&name=" + prompt("请输入您的名字：", "比如周杰伦");
        }
        location.href = url;
    }

</script>
</body>
</html>
