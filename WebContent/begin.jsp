<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
        <h2 style="color: black;">用户登陆</h2>
     
        <form name = "form1" action="servlet" method="post" onsubmit="return check_submit()">
    <table>
    		<tr>
                <td>管理员<input type="radio" id="jiese" name="jiese" value="1" checked="checked">
				</td>
                <td>教师<input type="radio" id="jiese" name="jiese" value="2" >
                </td>
                <td>学生<input type="radio" id="jiese" name="jiese" value="3" >
                </td>
            </tr>
            <tr>
                <td>登陆账号</td>
                <td colspan="2"> <input type="text" id="id" name="id"  maxlength="12" onblur="blur_id()" onfocus="focus_id()"/></td>
                <td width="300"><div id="result"></td>
            </tr>
            <tr>
                <td>登陆密码</td>
                <td colspan="2"> <input type="password" id="password" name="password" onblur="blur_pass()" onfocus="focus_pass()" /></td>
                <td width="300"><div id="result1"></td>
            </tr>
            <tr><td>验证码</td>
            <td>
            
     			<input type="text" value="" placeholder="请输入验证码（区分大小写）" onblur="sublim()"
     			style="height:20px;position: relative; font-size:16px;"id ="text">
     			<canvas id="canvas" width="110" height="30" onclick="dj()" 
      			style="border: 1px solid #ccc;
        		border-radius: 5px;"></canvas>
        	</td>
        	</tr>
        	<tr>
        		<td><button type=submit class="btn" >提交</button></td>
            </tr>
            


    </table>
    </form>
    </div>
    <script type="text/javascript">
/*
    表单验证
*/
var flag = true;   // flag 如果为true（即用户名合法）就允许表单提交， 如果为false（即用户名不合法）阻止提交
function focus_pass()
{
    var nameObj = document.getElementById("result1");
    nameObj.innerHTML = "由六位字符和数字组成";
    nameObj.style.color="#999";
    }
function blur_pass()
{
    var nameObj = document.getElementById("result1");
    // 判断用户名是否合法
    var str2 = check_user_pass(document.form1.password.value);
    nameObj.style.color="red";
    if ("密码合法" ==  str2)
    {
        flag = true;
        nameObj.innerHTML = str2;
    }
    else
    {
        nameObj.innerHTML = str2;
    }
}

function check_user_pass(str)
{  var str2 = "密码合法";
if ("" == str)
{
    str2 = "密码为空";
    return str2;
}
else if (str.length!=6)
{
    str2 = "用户名应是六位组成";
    return str2;
}
else if (!check_word(str))
{
    str2 = "未含有英文字符";
    return str2;
}

return str2;
    
    
    }





function focus_id()
{
    var nameObj = document.getElementById("result");
    nameObj.innerHTML = "由六到十二英文字符和数字组成";
    nameObj.style.color="#999";
    }
function blur_id()
{
    var nameObj = document.getElementById("result");
    // 判断用户名是否合法
    var str2 = check_user_id(document.form1.id.value);
    nameObj.style.color="red";
    if ("用户名合法" ==  str2)
    {
        flag = true;
        nameObj.innerHTML = str2;
    }
    else
    {
        nameObj.innerHTML = str2;
    }
}

function check_user_id(str)
{
    var str2 = "用户名合法";
    if ("" == str)
    {
        str2 = "用户名号为空";
        return str2;
    }
    else if ((str.length<=4)||(str.length>=12))
    {
        str2 = "用户名应是六到十二位组成";
        return str2;
    }
    else if (!check_word(str))
    {
        str2 = "未含有英文字符";          
        return str2;
    }
    else if(!check_firstword(str))
    {
        str2 = "必须以英文字母开头";
        return str2;
    }
    return str2;
}


function check_firstword(str)
{   var arr = ["a", "b", "c", "d", "e", "f", "g", "h","i","j", "k", "l", "m", "n", "o", "p", "q","r", "s", "t", "u", "v", "w", "x", "y","z","A", "B", "C", "D", "E", "F", "G", "H","I","J", "K", "L", "M", "N", "O", "P", "Q","R","S", "T", "U", "V", "W", "X", "Y", "Z"];
for (var i = 0; i < arr.length; i++)
{
        if (arr[i] == str.charAt(0))
        {
            return true;
        }
}   
return false;
    }


function check_word(str)
{   var arr = ["a", "b", "c", "d", "e", "f", "g", "h","i","j", "k", "l", "m", "n", "o", "p", "q","r", "s", "t", "u", "v", "w", "x", "y","z","A", "B", "C", "D", "E", "F", "G", "H","I","J", "K", "L", "M", "N", "O", "P", "Q","R","S", "T", "U", "V", "W", "X", "Y", "Z"];
for (var i = 0; i < arr.length; i++)
{
    for (var j = 0; j < str.length; j++)
    {
        if (arr[i] == str.charAt(j))
        {
            return true;
        }
    }
}   
return false;
    }

// 验证用户名是否含有特殊字符
function check_other_char(str)
{
    var arr = ["&", "\\", "/", "*", ">", "<", "@", "!"];
    for (var i = 0; i < arr.length; i++)
    {
        for (var j = 0; j < str.length; j++)
        {
            if (arr[i] == str.charAt(j))
            {
                return true;
            }
        }
    }   
    return false;
}*/
// 根据验证结果确认是否提交
function check_submit()
{
    if (flag == false)
    {
        return false;
    }
    return true;
}
</script>
</head>
</body>
<script>
 var show_num = [];
 draw(show_num);
function dj(){
 draw(show_num);   
 }
function sublim(){
var val=document.getElementById("text").value;  
            var num = show_num.join("");
            if(val==''){
                alert('请输入验证码！');
                flag=false;
            }else if(val == num){
                alert('提交成功！');
                document.getElementById(".input-val").val('');
                draw(show_num);
            }else{
                alert('验证码错误！\n你输入的是:  '+val+"\n正确的是:  "+num+'\n请重新输入！');
                document.getElementById("text").value='';
                draw(show_num);
                flag=false;
            }
        
       
        
          }
function draw(show_num) {
        var canvas_width=document.getElementById('canvas').clientWidth;
        var canvas_height=document.getElementById('canvas').clientHeight;
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "1,2,3,4,5,6,7,8,9,0,q,w,e,r,t,y,u,i,o,p,a,s,d,f,g,h,j,k,l,z,x,c,v,b,n,m";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度
            
        for (var i = 0; i <= 3; i++) {
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            var deg = Math.random() * 30 * Math.PI / 180;//产生0~30
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt;
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";

            context.translate(x, y);
            context.rotate(deg);

            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);

            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }
function randomColor() {//得到随机的颜色值
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
</script>
</html>