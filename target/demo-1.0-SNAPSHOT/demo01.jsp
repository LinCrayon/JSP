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
