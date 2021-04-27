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
	<%! String id;%>
	<%
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie :cookies)
		{
			if(cookie.getName().equals("id"))
			{
				id = cookie.getValue();
			}
		}
		%>
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
        <h2 style="color: black;">欢迎学号为<%=id%>的同学进行选课！</h2>
        <a href="menu3.jsp">返回主页</a>
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
                    <td><a href="TSservlet?method=coursedetails&course=${item.name}">${item.name}</a></td>
                    <td>${item.teacher}</td>
                    <td>${item.peoplenumber}</td>
                    <td><a href="TSservlet?method=chosecourse&course=${item.name}&studentidc=<%=id%>">选课</a></td>
                </tr>
			</c:forEach>

</body>
</html>