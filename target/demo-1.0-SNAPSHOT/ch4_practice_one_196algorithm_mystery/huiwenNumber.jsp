<%@ page contentType="text/html" %>
<%@ page pageEncoding = "utf-8" %>
<%@ page import = "java.math.BigInteger" %>
<HTML><body bgcolor = cyan>
<p style="font-family:宋体;font-size:36;color:black">
    <%!
        public static String reverse(String s) {  //定义方法返回参数的反序。
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
        BigInteger reverseNumber = new BigInteger(reverse(number.toString())); //反序后的数。
        BigInteger resultNumber = number.add(reverseNumber);
        out.print("<br>"+number+"+"+reverseNumber+"="+resultNumber);
        BigInteger p = new BigInteger(reverse(resultNumber.toString()));  //二者和的结果的反序。
        while(!resultNumber.equals(p)) {   //判断是否是回文数。
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
