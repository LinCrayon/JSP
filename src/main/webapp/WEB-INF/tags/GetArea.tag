<%@ tag pageEncoding="utf-8" %>
<%@ attribute name="sideA" required="true" %>
<%@ attribute name="sideB" required="true" %>
<%@ attribute name="sideC" required="true" %>
<%@ variable name-given="area" variable-class="java.lang.Double" scope="AT_END" %>
<%
        double a = Double.parseDouble(sideA);
        double b = Double.parseDouble(sideB);
        double c = Double.parseDouble(sideC);
        if (a + b > c && a + c > b && c + b > a) {
            double p = (a + b + c) / 2.0;
            double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            jspContext.setAttribute("area", new Double(area));
        } else {
            jspContext.setAttribute("area", new Double(0));
        }
%>