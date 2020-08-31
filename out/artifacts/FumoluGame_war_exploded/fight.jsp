<%@ page import="com.fumolu.www.model.Enemy" %>
<%@ page import="com.fumolu.www.model.Player" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fumolu.www.model.Place" %>
<%@ page import="com.fumolu.www.model.Skill" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/30 0030
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>战斗</title>
    <link rel="stylesheet" href="fonts/iconfont.css">
    <link rel="stylesheet" href="css/fight.css">
    <script src="fonts/iconfont.js"></script>

</head>
<%
    // 获取session
    HttpSession httpSession = request.getSession(true);
    // 从session中获取enemy和player
    Enemy enemy = (Enemy) httpSession.getAttribute("enemy");
    Player player = (Player) httpSession.getAttribute("player");
    Place place = (Place) httpSession.getAttribute("place");

    // 设定玩家所属的方向，true代表玩家在边显示，false代表玩家在右边显示
    int[] playerInRight = {1, 3, 6, 7, 8, 9};
    boolean flag = false; // 玩家默认在左边
    // 判断玩家是否在右边
    for(int i = 0; i < playerInRight.length; i++){
        if(enemy.getEnemy_id() == playerInRight[i]){
            flag = true;
            break;
        }
    }
    // 初始化图片的URL
    String enemy_img = "../img/da" + enemy.getID() + ".gif";
    String player_img = "";
    if(player.getImg_id() > 2){
        player_img = "../img/h-" + player.getImg_id() + ".png";
    }else {
        player_img = "../img/h-" + player.getImg_id() + ".jpg";
    }
    // 页面背景图片URL
    String bg_img_url = "../img/da";
    if(place.getID() == 0){
        bg_img_url += "a.jpg";
    }
    else if(place.getID() == 1){
        bg_img_url += "b.jpg";
    }
    else if(place.getID() == 2){
        bg_img_url += "c.jpg";
    }
    String isRunAway = (String)httpSession.getAttribute("isRunAway");
    String jsFunc = "";
    boolean isReturn = false;
    if(player.getHp() <= 0 || enemy.getHp() <= 0 || (isRunAway != null && isRunAway.equals("true"))){
        jsFunc = "return false;";
        isReturn = true;
    }

//    String[] color = [""]

    // 初始化技能URL
    List<Skill> skills = player.getSkills();
%>


<body style="background-image: url(<%=bg_img_url%>);">
<div class="nav">
    <div class="play1">

        <%
            if(flag){
        %>
        <div class="xueliang">
            <p>血量：<%=enemy.getHp()%> / <%=enemy.getMaxHp()%></p>
        </div>
        <div class="pic">
            <img src="<%=enemy_img%>">
        </div>
        <div class="name">
            <p><%=enemy.getCharacterName()%></p>
        </div>
        <%
            }else {
        %>
        <div class="xueliang">
            <p>血量：<%=player.getHp()%> / <%=player.getMaxHp()%></p>
        </div>
        <div class="pic">
            <img src="<%=player_img%>">
        </div>
        <div class="name">
            <p><%=player.getCharacterName()%></p>
        </div>
        <%
            }
        %>

    </div>
    <div class="data">
        <div class="xue">
            <div class="tubiao">
                <span class="iconfont icon-gongji"></span>
            </div>
            <div class="text">
                <a href="FightingServlet?index=普通攻击" onclick=<%=jsFunc%> ><p>普通攻击</p></a>
            </div>
        </div>
        <div class="xue">
            <div class="tubiao">
                <span class="iconfont icon-gongjiqusan"></span>
            </div>
            <div class="text">
                <a href="FightingServlet?index=法术攻击" onclick=<%=jsFunc%> ><p>法术攻击</p></a>
            </div>
        </div>

        <%
            for(int i = 0; i < skills.size(); i++){
                String url = "FightingServlet?index=" + skills.get(i).getSkillName();
        %>
        <div class="xue">
            <div class="tubiao">
                <span class="iconfont icon-jineng1"></span>
            </div>
            <div class="text">
                <a href="<%=url%>" onclick=<%=jsFunc%> ><p><%=skills.get(i).getSkillName()%></p></a>
            </div>
        </div>
        <%
            }
        %>

<%--        <div class="xue">--%>
<%--            <div class="tubiao">--%>
<%--                <span class="iconfont icon-jineng-copy"></span>--%>
<%--            </div>--%>
<%--            <div class="text">--%>
<%--                <a href="FightingServlet?index=0"><p>技能2</p></a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="xue">--%>
<%--            <div class="tubiao">--%>
<%--                <span class="iconfont icon-ziyuan"></span>--%>
<%--            </div>--%>
<%--            <div class="text">--%>

<%--                <a href="FightingServlet?index=5" onclick="">--%>
<%--                    <p><%= ? player.getSkills().get(2).getSkillName() : "技能3"%></p></a>--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="xue">
            <div class="tubiao">
                <span class="iconfont icon-f-run"></span>
            </div>
            <div class="text">
                <a href="FightingServlet?index=逃跑" onclick=<%=jsFunc%> ><p>逃跑</p></a>
            </div>
        </div>
        <div class="shuru">
            <%
                ArrayList<String> msgList = (ArrayList<String>) httpSession.getAttribute("msgList");
                int start = 0;
                if(msgList != null || msgList.size() != 0){
                    if(msgList.size() >= 9) start = msgList.size() - 9;
                    for(int i = start; i < msgList.size(); i++){
            %>
                 <p><%=msgList.get(i)%></p>
            <%
                    }
                }
            %>

        </div>
    </div>
    <div class="play1">
        <%
            if(flag){
        %>
        <div class="xueliang">
            <p>血量：<%=player.getHp()%> / <%=player.getMaxHp()%></p>
        </div>
        <div class="pic">
            <img src="<%=player_img%>">
        </div>
        <div class="name">
            <p><%=player.getCharacterName()%></p>
        </div>
        <%
        }else {
        %>
        <div class="xueliang">
            <p>血量：<%=enemy.getHp()%> / <%=enemy.getMaxHp()%></p>
        </div>
        <div class="pic">
            <img src="<%=enemy_img%>">
        </div>
        <div class="name">
            <p><%=enemy.getCharacterName()%></p>
        </div>
        <%
            }
        %>

        </div>
    </div>

</div>

<%
    if(isReturn){
%>
<nav id="fnav">
    <div class="fitem">
        <a href="chooseMonster.jsp">
            <svg class="icon" aria-hidden="true">
                <use xlink:href="#icon-xingzhuanggongnengtubiao-"></use>
            </svg>
            <p><a href="#">返回</a></p>
        </a>
    </div>
</nav>
<%
    }
%>


</body>

</html>