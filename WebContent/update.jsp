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
    <form  action="TSservlet?method=update&id=${teacher.idc}" method="post" onsubmit="return check()">
    <%
         Object message = request.getAttribute("message");
         if(message!=null && !"".equals(message)){
     
    %>
         <script type="text/javascript">
              alert("<%=request.getAttribute("message")%>");
         </script>
    <%} %>
    <div align="center">
        <h1 style="color: black;">教师个人信息列表</h1>
        <a href="menu2.jsp?id=${teacher.idc}">返回主页</a>
        <table class="tb">
            <tr>
            	<td>工号：</td>	
                <td>名字：</td>
                <td>性别：</td>
                <td>密码：</td>
                <td>学院：</td>
                <td>职称：</td>
            </tr>
                <tr>
                    <td>${teacher.idc}</td>
                    <td>${teacher.name}</td>
                    <td>${teacher.sex}</td>
                    <td>${teacher.password}</td>
                    <td>${teacher.college}</td>
                    <td>${teacher.zhicheng}</td>
                </tr>
            <tr>
            		<td>教师姓名：<input type="text" id="name" name="name" /></td>
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
            		<td>所在学院：<input type="text" id="college" name="college" /></td>
           	</tr>
           	<tr>
            		<td> 职称：
                                                  教授<input type="radio" id="zhicheng" name="zhicheng" value="jiaoshou" checked="checked">
                                                  副教授<input type="radio" id="zhicheng" name="zhicheng" value="fujiaoshou" >
 			                          讲师<input type="radio" id="zhicheng" name="zhicheng" value="jiangshi" >
 			                          助教<input type="radio" id="zhicheng" name="zhicheng" value="zhujiao" ></td>
           			<td>
            		<button type=submit class="btn" >提交</button>
            		</td>
           	</tr>
        </table>
    	</div>
    	</form>
    <script type="text/javascript">
        function check(){
            var name = document.getElementById("name").value;
            var college = document.getElementById("college").value;
            var password = document.getElementById("password").value;
            //非空
            if(name == ''|| name == null) {
                alert('名字为空');
                return false;
            }
            if(college == ''|| college == null) {
                alert('学院为空');
                return false;
            }if(password == ''|| password == null) {
                alert('密码为空');
                return false;
            }
            return true;
        }
    </script>
</body>
</html>