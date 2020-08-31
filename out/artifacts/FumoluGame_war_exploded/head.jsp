<%@ page import="com.fumolu.www.model.Player" %>
<%@ page import="com.fumolu.www.model.Skill" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/29 0029
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
<%--    <title>头信息</title>--%>
    <link rel="stylesheet" href="css/heal.css">
</head>
<body>
<%
    HttpSession httpSession = request.getSession(true);
    String loginuser = (String) httpSession.getAttribute("loginuser");
    Player player = (Player) httpSession.getAttribute("player");
//    int avatar_id = (int)httpSession.getAttribute("avatar_id");
    int avatar_id = player.getImg_id();
    String imgSrc = "";
    if(avatar_id > 2) {
        imgSrc = "img/h-" + avatar_id + ".png";
    }else {
        imgSrc = "img/h-" + avatar_id + ".jpg";
    }
    System.out.println(player == null);
%>

<div class="user">
    <div class="userContent">
        <div class="userName">
            <a href="" class="headPic">
                <img src=<%=imgSrc%> alt="">
            </a>
            <span class="names" id="panda"><%=player.getCharacterName()%></span>
            <div class="information" id="infor">
                <div class="employee">
                    <span>职业：</span>
                    <a href=""> <%=player.getProfession().getProfessionName()%> </a>
                </div>
                <div class="employee">
                    <span>等级：</span>
                    <a href=""><%=player.getLevel()%></a>
                </div>
                <div class="employee">
                    <span>经验：</span>
                    <a href=""><%=player.getExp()%></a>
                </div>
                <div class="employee">
                    <span>金币：</span>
                    <a href=""><%=player.getMoney()%></a>
                </div>
                <div class="employee">
                    <span>物理攻击力：</span>
                    <a href=""><%=player.getPhysicalAttack()%></a>
                </div>
                <div class="employee">
                    <span>魔法攻击：</span>
                    <a href=""><%=player.getMagicAttack()%></a>
                </div>
                <div class="employee">
                    <span>物理防御力：</span>
                    <a href=""><%=player.getPhysicalDefense()%></a>
                </div>
                <div class="employee">
                    <span>魔法防御：</span>
                    <a href=""><%=player.getMagicDefense()%></a>
                </div>
                <div class="employee">
                    <span>血量：</span>
                    <a href=""><%=player.getHp()%></a>
                    <span>/</span>
                    <a href=""><%=player.getMaxHp()%></a>
                </div>
                <div class="employee">
                    <span>法力：</span>
                    <a href=""><%=player.getMana()%></a>
                    <span>/</span>
                    <a href=""><%=player.getMaxMana()%></a>
                </div>
                <div class="employee">
                    <span>闪避率：</span>
                    <a href=""><%=player.getDodgeRate()%></a>
                    <span>/</span>
                    <a href=""><%=player.getMaxDodgeRate()%></a>
                </div>
                <div class="employee">
                    <span>暴击率：</span>
                    <a href=""><%=player.getCritRate()%></a>
                    <span>/</span>
                    <a href=""><%=player.getMaxCritRate()%></a>
                </div>
                <div class="employee">
                    <span>掌握技能：</span>
                    <%
                        List<Skill> list = player.getSkills();
                        int i = 0;
                        while (i < list.size()){
                    %>
                            <a href=""><%=list.get(i).getSkillName()%></a>
                    <%
                            if(++i != list.size()){
                    %>
                                <span>、</span>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
