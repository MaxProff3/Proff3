<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="domain.Content"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="js/myjs.js"></script>
</head>
<% List<Content> listContent = (List<Content>)request.getAttribute("contents"); %>

<body>	
	
   <div class="wrap">
       <div class="head">
           <img src="img/main_banner1.jpg" alt="">
           <img src="img/main_banner2.jpg" alt="">
           <img src="img/main_banner2.png" alt="">
       </div>
       <div class="content">
        <div class="listContent">
            <% for(Content cont: listContent){%>
            	<div class="itemListContent">
               		<h4><% out.println(cont.getCatalog().getName());%></h4>
                	<p><% out.println(cont.getText());%></p>
            	</div>
            <%} %>
        </div>
        <input id="btnAddTryam" type="button" value="+">         
        <div class="newContent">
            <select id="catalogNewContent" placeholder="Выберите категорию">
                <option value="1">type 1</option>
                <option value="2">type 2</option>
            </select>
            <input type="button" id="btnAdd" onclick="sendInfoToAjax()" value="Добавить">
            <textarea placeholder="трям" cols=20 rows=4 id= "textareaNewContent"> </textarea>
            
        </div>
    <hr>
    <select id="block1"><% out.println((String)request.getAttribute("selectBlock1"));%></select>
    <select id="block2"></select>
           
       </div>
       <div class="footer">&#169; Все права закомпенсированы! 2016г.</div>
   </div>
    
</body>
</html>