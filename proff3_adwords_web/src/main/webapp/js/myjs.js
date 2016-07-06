$(document).ready(function() {
	$("#btnAddTryam").click(function() {
		if($('.newContent').css('display') == 'none'){
			$('.newContent').css('display','block');
			$("#btnAddTryam").val('-');
		} else {
			$('.newContent').css('display','none');
			$("#btnAddTryam").val('+');
		}
		
	});
	$("#textLogin").blur(function(){
		checkLogin();
	});
	$("#block1").change(function(){
		selectBlock2FromBlock1();
	});
});


function selectBlock2FromBlock1(){
	var code = $("#block1").val();
	$.ajax({			
		type: "POST",
		data: "code="+code,
		url: "ajaxSelect",
		dataType: "json",
		success: function(data)	{
			if(data.res != '') {
				$("#block2").html(data.res);
			}
		},
		error: function(data){
			console.log("ajax, error!");
		}
	});			

}


function sendInfoToAjax(){
	var cat = $("#catalogNewContent").val();
	var text = $("#textareaNewContent").val();
	console.log('cat='+cat+', text='+text);
	$.ajax({			
		type: "POST",
		data: "cat="+cat+"&text="+text,
		url: "ajax",
		dataType: "json",
		success: function(data)	{
			if(data.result == 'ok') {
				console.log('ok');
				var catal = data.catalog;
				var content = '<div class="itemListContent">';
					content += '<h4>'+catal+'</h4>';
					content += '<p>'+text+'</p>';
					content += '</div>';
				$('.listContent').append(content);
			}
		},
		error: function(data){
			alert("error!");
		}
	});			

}

function checkLogin(){
	var text = $("#textLogin").val();
	console.log('text='+text);
	$.ajax({			
		type: "POST",
		data: "text="+text,
		url: "ajaxLogin",
		dataType: "json",
		success: function(data)	{
			console.log('ajax, data='+data);
			if(data.count != '') {
				console.log('ajax, data.count='+data.count);
				$("#picLogin").html(data.count);
				$("#picLogin").css('display','block');
				if(data.count==2) redirect('http://www.ukr.net');
			}
		},
		error: function(data){
			console.log("ajax, error!");
		}
	});			

}
function redirect(str){
	location.replace(str);
}
