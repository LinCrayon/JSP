<%@ page contentType="text/html" %>
<%@ page pageEncoding = "utf-8" %>
<style>
    #textStyle{
        font-family:宋体;font-size:36px;color:blue
    }
</style>
<% request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="play" class="red.star.Play" scope="session" />
<%
    String webDir = request.getContextPath();
    webDir = webDir.substring(1);
%>
<jsp:setProperty  name="play" property="webDir" value="<%= webDir %>"/>
<jsp:setProperty  name="play" property="index"  param = "index" />
<HTML><body bgcolor = cyan><p id = textStyle>
    <image src="./flower.png"  width=300 height =200>
           <jsp:getProperty name="play" property="index"/>
    </image><br>
    <a href ="?index=<%=play.getIndex()+1 %>">下一张</a>
    <a href ="?index=<%=play.getIndex()-1 %>">上一张</a>
</p></body></HTML>
