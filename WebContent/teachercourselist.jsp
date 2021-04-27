<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
    <%
         Object message = request.getAttribute("message");
         if(message!=null && !"".equals(message)){
     
    %>
         <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>");
         </script>
    <%} %>
    <div align="center">
        <h1 style="color: black;">课程信息列表</h1>
        <a href="menu2.jsp">返回主页</a>
        <table class="tb">
            <tr>
                <td>课程编码</td>
                <td>课程名称</td>
                <td>授课讲师</td>
                <td>选课名额</td>
            </tr>
            <c:forEach items="${courses}" var="item">
                <tr>
                	<td>${item.idc}</td>
                    <td><a href="TSservlet?method=chosecoursestudentlist&course=${item.name}">${item.name}</a></td>
                    <td>${item.teacher}</td>
                    <td>${item.peoplenumber}</td>
                </tr>
			</c:forEach>

</body>
</html>