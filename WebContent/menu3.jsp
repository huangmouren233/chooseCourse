<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
	    <div class="a">
            <h2 style="color: black;">欢迎学号为<%=id%>的同学登录！</h2>
        
        </div>
        <div class="a">
            <a href="TSservlet?method=courselist">浏览课程信息</a>
        </div>
        <div class="a">
            <a href="TSservlet?method=getbyidc1&id=<%=id%>">修改个人信息</a>
    	</div>
    	<div class="a">
            <a href="TSservlet?method=courselist1">选课</a>
    	</div>
    	<div class="a">
            <a href="over.jsp">退出系统</a>
    	</div>
    </div>
</body>
</html>