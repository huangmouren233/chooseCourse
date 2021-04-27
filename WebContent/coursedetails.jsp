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
        <h1 style="color: black;">课程详细信息列表</h1>
        <a href="menu3.jsp">返回主页</a>
        <table class="tb">
            <tr>
                <td>课程编码</td>
                <td>课程名称</td>
                <td>授课讲师</td>
                <td>选课名额</td>
                <td>当前选课人数</td>
            </tr>
                <tr>
                	<td>${course.idc}</td>
                	<td>${course.name}</td>
                	<td>${course.teacher}</td>
                    <td>${course.peoplenumber}</td>
                    <td>${count}</td>
                </tr>

</body>
</html>