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
        		<h3>当前课程为：${course}</h3>
        	</tr>
            <tr>
                <td>学生姓名</td>
                <td>学生学号</td>
                <td>所属院系</td>
                <td>所在班级</td>
            </tr>
            <c:forEach items="${students}" var="item">
                <tr>
                	<td>${item.name}</td>
                    <td>${item.idc}</td>
                    <td>${item.major}</td>
                    <td>${item.class1}</td>
                </tr>
			</c:forEach>

</body>
</html>