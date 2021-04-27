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
    <h1 style="color: black;">添加课程信息</h1>
        <h2 style="color: black;">欢迎工号为<%=id%>的教师进行课程信息添加！</h2>
        <a href="menu2.jsp">返回主页</a>
    <form name = "form1" action="TSservlet?method=addclass" method="post" onsubmit="return checkForm()">
    		<div class="a">
                        课程名称：<input type="text" id="name" name="name" />
            </div>
            <div class="a">
                        课程编号：<input type="text" id="idc" name="idc" />
            </div>
            <div class="a">
		        任课老师：<input type="text" id="teacher" name="teacher" />
            </div>
            <div class="a">
                        选课人数：<input type="text" id="peoplenumber" name="peoplenumber" />
            </div>
            <div class="a">
            <button type=submit >提交</button>
            </div>
            </form>
   <script type="text/javascript">
   function checkForm(){
       var name = document.getElementById("name").value;
       var teacher = document.getElementById("teacher").value;
       var idc = document.getElementById("idc").value;
       var peoplenumber = document.getElementById("peoplenumber").value;
       if(idc == '') {
           alert('课程编号为空');
           return false;
       }if(name == ''|| name == null) {
           alert('课程名称为空');
           return false;
       }if(teacher == ''|| teacher == null) {
           alert('任课教师为空');
           return false;
       }if(peoplenumber == ''|| peoplenumber == null) {
           alert('选课人数为空');
           return false;
       }
       return true;
   }
    </script>

</body>
</html>