<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="js/myjs.js"></script>
    
</head>
<body>
   <div class="wrap">
       <div class="head">
           <img src="img/main_banner1.jpg" alt="">
           <img src="img/main_banner2.jpg" alt="">
           <img src="img/main_banner2.png" alt="">
       </div>
       <div class="content">
           <% String userName = (String)request.getAttribute("userName"); %>


           <% if(userName==null){%>    
	           <form method="post" >
	               <input type="text" name="nLogin" id="textLogin" placeholder="Введите логин">
	             <% String error = (String)request.getAttribute("error"); %>
	             <% String errorText = ""; if(error!=null) errorText = "<p class='Error'>"+error+"</p>";%>
	               <p id="picLogin"></p>
	               <% out.println(errorText);%>
	               <input name="nPass" type="password" placeholder="Введите пароль">
	               <input type="submit" value="Войти">
	           </form>
	       <% } else { %>
	       		<div style="margin-left: 400px;">UserName:<% out.println(userName);%></div>>	
	       		<form method="post" >
	       			<input name="logout" value="logout_value" type="hidden">
	       			<input type="submit" value="Выйти">
	       		</form>
	       <%} %>    
              <div class="menu">
               <p>privet1</p>
               <p>privet2</p>
               <p>privet3</p>
           </div>
           <div class="findBlock">
               jdjkdjf
           </div>
           
           
       </div>
       <div class="footer">&#169; ÐÑÐµ Ð¿ÑÐ°Ð²Ð° Ð·Ð°ÐºÐ¾Ð¼Ð¿ÐµÐ½ÑÐ¸ÑÐ¾Ð²Ð°Ð½Ñ! 2016Ð³.</div>
   </div>
    
</body>
</html>