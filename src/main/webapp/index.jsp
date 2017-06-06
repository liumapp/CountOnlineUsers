<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liumapp.countuser.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: liumapp
  E-mail:liumapp.com@gmail.com
  Home-Page:http://www.liumapp.com
  Date: 6/5/17
  Time: 2:37 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>统计在线人数</title>
  </head>
  <body>

  当前在线人数：${currentUser}

  <table>
    <tr>
      <th>sessionId</th>
      <th>lastLoginTime</th>
      <th>ip</th>
    </tr>
  <%
    ArrayList<User> userList = (ArrayList<User>)request.getServletContext().getAttribute("userList");
    if (userList != null) {
      for (int i = 0 ; i < userList.size() ; i++) {
          User user = userList.get(i);
  %>

    <tr>
      <td><%= user.getSessionId()%></td>
      <td><%= user.getLastLoginTime()%></td>
      <td><%= user.getIp()%></td>
    </tr>

  <%
      }
    }
  %>
  </table>
  </body>
</html>
