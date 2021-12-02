<%--
  Created by IntelliJ IDEA.
  User: linshengqian
  Date: 2021/12/1
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><body bgcolor=>
<form action="query" id=tom method=post>
    <b>数据库<input type='text' id=tom name='dataBase' value ='bookDatabase'/>
        <br>表名<input type='text' id=tom name='tableName' value='bookList'/>
        <br>用户名(默认root)<input type='text' id=tom name='user' value='root'/>
        <br>用户密码(默认空)<input type='text'id=tom name='password'/>
        <br><input type='submit' name='submit' id=tom value='提交'>
</form>
</body></HTML>
