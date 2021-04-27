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
        <h1 style="color: black;">添加教师信息</h1>
        <h2 style="color: black;">欢迎工号为<%=id%>的管理员进行学生信息添加！</h2>
        <a href="menu1.jsp">返回主页</a>
     <form name = "form1" action="TSservlet?method=addteacher" method="post" onsubmit="return checkForm()">
    		<div class="a">
                        教师姓名：<input type="text" id="name" name="name" />
            </div>
            <div class="a">
                        工号：<input type="text" id="idc" name="idc" />
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
                        所在学院：<input type="text" id="college" name="college" />
            </div>
            <div class="a">
                        职称：
                        教授<input type="radio" id="zhicheng" name="zhicheng" value="教授" checked="checked">
                        副教授<input type="radio" id="zhicheng" name="zhicheng" value="fujiaoshou" >
 			讲师<input type="radio" id="zhicheng" name="zhicheng" value="jiangshi" >
 			助教<input type="radio" id="zhicheng" name="zhicheng" value="zhujiao" >         
            </div>
            <div class="a">
            <button type=submit class="btn" >提交</button>
            </div>
            </form>
   <script type="text/javascript">
   function checkForm(){
       var name = document.getElementById("name").value;
       var college = document.getElementById("college").value;
       var idc = document.getElementById("idc").value;
       var password = document.getElementById("password").value;
       if(password == ''|| password == null) {
           alert("密码为空");
           return false;
       }if(idc == ''|| idc == null) {
           alert('工号为空');
           return false;
       }if(name == ''|| name == null) {
           alert('姓名为空');
           return false;
       }if(college == ''|| college == null) {
           alert('学院为空');
           return false;
       }
       return true;
   }
    </script>
</body>
</html>