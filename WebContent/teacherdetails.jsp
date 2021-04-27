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
        <h1 style="color: black;">教师详细信息列表</h1>
        <a href="menu3.jsp">返回主页</a>
        <table class="tb">
            <tr>
                <td>教师名称</td>
                <td>教师性别</td>
                <td>教师所属院系</td>
                <td>教师职称</td>
            </tr>
                <tr>
                	<td>${teacher.name}</td>
                	<td>${teacher.sex}</td>
                	<td>${teacher.college}</td>
                    <td>${teacher.zhicheng}</td>
                </tr>

</body>
</html>