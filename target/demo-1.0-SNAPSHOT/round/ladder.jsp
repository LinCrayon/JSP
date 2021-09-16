
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! public String getArea(double a , double b , double c ) {
    if (a > 0 & b > 0 & c > 0) {
        double area = (a + b) * c / 2;
        return "" + area;//返回字符串类型double->String
    } else {
        return ("梯形的上底、下底、高" + a + "、" + b + " 、 " + c + "不能为小于零");
    }
}
%>
<%  String sideA = request.getParameter("sideA");//获取参数值
    String sideB = request.getParameter("sideB");
    String sideC = request.getParameter("sideC");
    double a = Double.parseDouble(sideA);
    double b = Double.parseDouble(sideB);
    double c = Double.parseDouble(sideC);
%>
<br><b>我是被加载的文件，负责计算梯形的面积</b><br>
给我传递的上底、下底、高是：<%= sideA%> <%= sideB %>  <%= sideC %>
    <br>梯形的面积是：<%= getArea( a , b , c) %>