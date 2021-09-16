
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! public String getArea(double r)
{
    if(r > 0){
        double area = r * r * 3.14;
        return ""+ area;//返回字符串类型double->String
    }else{
        return ("半径为" + r + "不能小于零");
    }
}
%>
<% String sideR = request.getParameter("sideR");//获取参数值
        double r = Double.parseDouble(sideR);
%>
<p style="font-family: 宋体; color:pink">
    <br><b>我是被加载的文件，负责计算圆的面积<br>
    给我传递的半径是：<%=r %>
    <br><b><i><%=getArea(r)%></i></b></>i>
</p>