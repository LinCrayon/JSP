<%@ page contentType="text/html" %>
<%@ page pageEncoding = "utf-8" %>
<%@ page import = "java.math.BigInteger" %>
<HTML><body bgcolor = cyan>
<p style="font-family:宋体;font-size:36px;color:black">
    <%!
        public static String reverse(String s) {
            StringBuffer  buffer = new StringBuffer(s);
            StringBuffer  reverseBuffer = buffer.reverse();
            return  reverseBuffer.toString();
        }
    %>
    <%
        String regex = "[1-9][0-9]*";
        String startNumber=request.getParameter("number");
        if(startNumber==null||startNumber.length()==0) {
            startNumber = "520";
        }
        if(!startNumber.matches(regex)) {
            response.sendRedirect("inputNumber.jsp");
            return;
        }
        long step = 1;
        BigInteger number = new  BigInteger(startNumber);
        BigInteger reverseNumber = new BigInteger(reverse(number.toString()));
        BigInteger resultNumber = number.add(reverseNumber);
        out.print("<br>"+number+"+"+reverseNumber+"="+resultNumber);
        BigInteger p = new BigInteger(reverse(resultNumber.toString()));
        while(!resultNumber.equals(p)) {
            number = new  BigInteger(resultNumber.toString());
            reverseNumber = new  BigInteger(reverse(number.toString()));
            resultNumber = number.add(reverseNumber);
            p = new BigInteger(reverse(resultNumber.toString()));
            out.print("<br>"+number+"+"+reverseNumber+"="+resultNumber);
            step++;
        }
        out.print("<br>"+step+"步得到回文数:"+resultNumber);
    %>
</p></body></HTML>
