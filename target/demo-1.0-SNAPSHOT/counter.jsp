<%--
  Created by IntelliJ IDEA.
  User: THER
  Date: 2021/10/3
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    Integer hitsCount = (Integer)application.getAttribute("hitCounter");
    if( hitsCount ==null || hitsCount == 0 ){
        out.println("欢迎访问本网站!!");
        hitsCount = 1;
    }else{
        out.println("欢迎访问本网站!");
        hitsCount += 1;
    }
    application.setAttribute("hitCounter", hitsCount);
%>

    <p>你是第个 <%= hitsCount%>访问! </p>

</body>
</html>
