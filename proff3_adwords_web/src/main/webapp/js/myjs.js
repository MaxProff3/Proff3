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
});

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

