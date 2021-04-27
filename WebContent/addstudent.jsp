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
     	<h1 style="color: black;">添加学生信息</h1>
        <h2 style="color: black;">欢迎工号为<%=id%>的管理员进行学生信息添加！</h2>
        <a href="menu1.jsp">返回主页</a>
         <form name = "form1" action="TSservlet?method=addstudent" method="post" onsubmit="return checkForm()">
    		<div class="a">
                        学生姓名：<input type="text" id="name" name="name" />
            </div>
            <div class="a">
                        学号：<input type="text" id="idc" name="idc" />
            </div>
            <div class="a">
                        密码：<input type="text" id="password" name="password" />
            </div>
            <div class="a">
                        性别：
                        男<input type="radio" name="sex" value="男" checked="checked">
		        女<input type="radio" name="sex" value="女" >
            </div>
            <div class="a">
                        所在专业：<input type="text" id="major" name="major" />
            </div>
            <div class="a">
                        所在班级：<input type="text" id="class1" name="class1" />         
            </div>
            <div class="a">
            <button type=submit class="btn" >提交</button>
            </div>
            </form>
   <script type="text/javascript">
   function checkForm(){
       var name = document.getElementById("name").value;
       var major = document.getElementById("major").value;
       var idc = document.getElementById("idc").value;
       var class1 = document.getElementById("class1").value;
       var password = document.getElementById("password").value;
       if(idc == '') {
           alert('学号为空');
           return false; 
       }if(password == '') {
           alert('密码为空');
           return false;
       }if(name == ''|| name == null) {
           alert('姓名为空');
           return false;
       }if(major == ''|| major == null) {
           alert('专业为空');
           return false;
       }if(class1 == ''|| class1 == null) {
           alert('班级为空');
           return false;
       }
       return true;
   }
    </script>
</body>
</html>