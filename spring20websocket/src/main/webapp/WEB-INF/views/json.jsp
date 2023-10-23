<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<link rel="stylesheet" type="text/css"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.2/sandstone/bootstrap.min.css" rel="stylesheet">
<!-- <link href="test.css" rel="stylesheet"> -->

<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/toastify-js"></script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 offset-md-2">
		
			<div class="row">
				<div class="col">
					<h1>회원 전용 웹소켓 예제 (+JSON 추가)</h1>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="input-group">
						<input type="text" class="message-input form-control" placeholder="전송할 메세지">
						<button type="button" class="btn btn-primary send-btn">전송</button>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col message-list">
					
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	window.socket = new WebSocket("ws://localhost:8080/ws/json");
	socket.onmessage = function(e) {
		//console.log(e.data);
		
		var data = JSON.parse(e.data);//JSON 문자열을 자바스크립트 객체로 해석(<--> JSON.stringify())
		//console.log(data);
		
		var memberId = $("<span>").text(data.memberId).addClass("badge bg-primary");
		var memberLevel = $("<span>").text(data.memberLevel).addClass("badge bg-secondary ms-1");
		var content = $("<div>").text(data.content).addClass("p-2 mt-1 border border-secondary rounded");
		
		$("<div>").addClass("mt-4")
						.append(memberId)
						.append(memberLevel)
						.append(content)
						.appendTo(".message-list");
		
		Toastify({
			text : data.content,
			duration : 3000,
			//destination : "https://github.com/apvarun/toastify-js",
			newWindow : true,
			close : true,
			gravity : "bottom", // `top` or `bottom`
			position : "right", // `left`, `center` or `right`
			stopOnFocus : true, // Prevents dismissing of toast on hover
			style : {
				background : "linear-gradient(to right, #00b09b, #96c93d)",
			},
			onClick : function() {
			} // Callback after click
		}).showToast();
	};

	//전송 버튼을 클릭하면 입력한 메세지를 가져와서 서버로 전달
	$(".send-btn").click(function() {
		//var input = document.querySelector(".message-input").value;
		var input = $(".message-input").val();
		if (input.length == 0)
			return;

		window.socket.send(input);
		$(".message-input").val("");
	});
</script>



