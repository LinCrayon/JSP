<%@ page contentType="text/html" %>
<%@ page pageEncoding = "utf-8" %>
<style>
    #tom{
        font-family:宋体;font-size:26px;color:blue
    }
</style>
<%
    String s ="120,120";
%>
<HTML><body id=tom bgcolor=#ffccff>
<form action="drawCircle" id= tom method=post>
    输入圆心坐标格式是m,n( 0<=m<=800,0<=n<=600)<br>
    <input type=text name = 'center' id=tom value='<%=s%>'/>
    <input type=text name = 'radius' id=tom value='100'/>
    <br><input type=submit id=tom value="提交"/>
</form>
</body></HTML>