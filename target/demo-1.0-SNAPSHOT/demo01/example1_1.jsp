
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body bgcolor="#ffc0cb">
<h1>hello jsp</h1>
<% int i , sum = 0;
    for ( i = 0; i < 100; i++) {
        sum = sum + i;
    }
%>
<p style="font-family:宋体; font-size: 36px;color: blue">
    1到100的连续和:<%= sum%>
</p>
</body>
</html>
