<%@ page contentType="text/html" %>
<%@ page pageEncoding = "utf-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Random" %>
<HTML><body bgcolor = #ffccff>
<style>
    #textStyle{
        font-family:宋体;font-size:36;color:blue
    }
</style>
<%!  static ArrayList<String> list = new  ArrayList<String>();
    static {
        list.add("☆");
        list.add("○");
        list.add("△");
        list.add("□");
        list.add("◇");
    }
    String getNextTestString(int length) {
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for(int i=0;i<length;i++) {
            int index = random.nextInt(list.size());
            String str = list.get(index);
            buffer.append(str);
        }
        return new String(buffer);
    }
%>
<%  String grade = request.getParameter("grade");
    if(grade == null){
        grade =(String) session.getAttribute ("grade");
    }
    int number = Integer.parseInt(grade);
    session.setAttribute ("grade" ,grade);
    String testString = null;
    String yesORNo = null;
    yesORNo = (String)session.getAttribute ("yesORNo");
    if(yesORNo == null) {
        testString = getNextTestString(number);
        session.setAttribute ("testString" ,testString);
    }
    else if(yesORNo.equals("yes")){
        response.sendRedirect("answerTest.jsp");
        return;
    }
    else if(yesORNo.equals("no")){
        testString = getNextTestString(number);
        session.setAttribute ("yesORNo" ,"yes");
        session.setAttribute ("testString" ,testString);
    }
%>
<p id = "textStyle">给5秒种记住您看到的字符序列:<br>
    <%=testString %>
    <br>5秒种后，将转到答题页。
    <%  response.setHeader("refresh","5");
    %>
</p></body></HTML>
