<%--
  Created by IntelliJ IDEA.
  User: Kevin Marrec
  Date: 12/14/2015
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><% String mytask = (String) request.getAttribute("mytask");
    out.println("mytask = " + mytask);%></p>
</body>
</html>
