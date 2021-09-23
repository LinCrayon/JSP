<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.text.*" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="computer" %>
<html>
<body>
<form action="" method=get name=form>
  <h3>请输入三角形三边长:</h3>
  <table>
    <tr>
      <td>a：</td>
      <td><input type="text" name="a"></td>
    </tr>
    <tr>
      <td>b：</td>
      <td><input type="text" name="b"></td>
    </tr>
    <tr>
      <td>c：</td>
      <td><input type="text" name="c"></td>
    </tr>
    <tr>
      <td>结果</td>
      <td><input type="submit" value="计算" name=submit></td>
      <td>(保留三位小数)</td>
    </tr>
  </table>

  <%
    String a = request.getParameter("a");
    String b = request.getParameter("b");
    String c = request.getParameter("c");
    if (a == null || b == null || c == null) {
      a = "0";
      b = "0";
      c = "0";
    }
    if (a.length() > 0 && b.length() > 0 && c.length() > 0) {
  %>
  <computer:GetArea sideA="<%=a %>" sideB="<%=b %>" sideC="<%=c %>"/>
  <%
      NumberFormat f = NumberFormat.getInstance();
      f.setMaximumFractionDigits(3);
      double result = area.doubleValue();
      String str = f.format(result);
      out.println(str);
    }
  %>
</form>
</body>
</html>