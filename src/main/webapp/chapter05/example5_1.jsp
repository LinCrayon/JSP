<%@ page contentType="text/html" %>
<%@ page pageEncoding = "utf-8" %> 
<style>
   #textStyle{
      font-family:宋体;font-size:36px;color:blue
   }
</style>
<HTML><body bgcolor = #ffccff>
<p id = "textStyle">
<jsp:useBean id="circle" class="tom.jiafei.Circle" scope="page" />
圆的初始半径是：<%=circle.getRadius()%>
<%  double newRadius =100;  
    circle.setRadius(newRadius);
%>
<br>修改半径为<%= newRadius %>
<br><b>圆的半径是：<%=circle.getRadius()%>
<br><b>圆的周长是：<%=circle.circleLength()%>
<br><b>圆的面积是：<%=circle.circleArea()%>
</p></body></HTML>
