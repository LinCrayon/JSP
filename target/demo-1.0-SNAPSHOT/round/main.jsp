
<%@page contentType="text/html;charset=utf-8"%>
<html>
<body>
<%
    double r=3,a=4,b=5,c=23;
%>
<br>加载circle.jsp计算半径为<%= r %>的圆的面积：
<jsp:include page="circle.jsp">
    <jsp:param value="<%=r %>" name="sideR"/>
</jsp:include>
<br>加载ladder.jsp计算上底、下底、高为<%=a %>,<%=b %><%=c %>的梯形面积
<jsp:include page="ladder.jsp">
    <jsp:param value ="<%=a %>" name ="sideA"/>
    <jsp:param value ="<%=b %>" name ="sideB"/>
    <jsp:param value ="<%=c %>" name ="sideC"/>
</jsp:include>
</body>
</html>