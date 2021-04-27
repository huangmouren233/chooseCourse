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
	<form action="TSservlet?method=update1&id=<%=id%>" method="post" onsubmit="return check()">
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
        <h1 style="color: black;">学生个人信息列表</h1>
        <a href="menu3.jsp">返回主页</a>
        <table class="tb">
            <tr>
            	<td>学号：</td>	
                <td>名字：</td>
                <td>性别：</td>
                <td>密码：</td>
                <td>专业：</td>
                <td>班级：</td>
            </tr>
                <tr>
                    <td>${student.idc}</td>
                    <td>${student.name}</td>
                    <td>${student.sex}</td>
                    <td>${student.password}</td>
                    <td>${student.major}</td>
                    <td>${student.class1}</td>
                </tr>
            <tr>
            		<td>学生姓名：<input type="text" id="name" name="name" /></td>
            </tr>
            <tr>
                	<td>密码：<input type="text" id="password" name="password" /></td>
            </tr>
            <tr>
               		<td>性别：
                                                男<input type="radio" name="sex" value="男" checked="checked">
		                                女<input type="radio" name="sex" value="女" ></td>
            </tr>
            <tr>
            		<td>所在专业：<input type="text" id="major" name="major" /></td>
           	</tr>
           	<tr>
            		<td>所在班级：<input type="text" id="class" name="class" /></td>
           			<td>
            		<button type=submit class="btn" >提交</button>
            		</td>
           	</tr>
        </table>
    </div>
</form>
    
    <script type="text/javascript">
        function check() {
            var name = document.getElementById("name");;
            var major = document.getElementById("major");
            var password = document.getElementById("password");
            var class1 = document.getElementById("class");

            
            //非空/
            if(class1.value == '') {
                alert('班级为空');
                return false;
            }
            if(name.value == '') {
                alert('名字为空');
                return false;
            }
            if(college.value == '') {
                alert('专业为空');
                return false;
            }if(password.value == '') {
                alert('密码为空');
                return false;
            }
            
            return true;
            
        }
    </script>
</body>
</html>