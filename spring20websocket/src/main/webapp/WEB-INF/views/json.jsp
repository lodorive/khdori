<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/toastify-js/src/toastify.min.css">
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/toastify-js"></script>
   
<h1>회원 전용 웹소켓 예제 (+JSON)</h1>

<input type="text" class="message-input">
<button type="button" class="send-btn">전송</button>

<div class="message-list"></div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	window.socket = new WebSocket("ws://localhost:8080/ws/json");
	
	socket.onmessage = function(e){
		//console.log(e.data);
		var data = JSON.parse(e.data); //JSON 문자열을 자바스크립트 객체로 해석(<-->(반대명령) JSON.stringify())
// 		console.log(data);
		
		var memberId = $("<div>").text(data.memberId);
		var memberLevel = $("<div>").text(data.memberLevel);
		var content = $("<div>").text(data.content);
		
		$("<div>").css("display", "flex")
						.append(memberId)
						.append(memberLevel)
						.append(content)
						.appendTo(".message-list") 
						
						// 위의 3개는 <div>에 넣고 appendTo는 출력는 내용 
		
		Toastify({
			  text: data.content,
			  duration: 3000,
			  //destination: "https://github.com/apvarun/toastify-js", 
			  newWindow: true,
			  close: true,
			  gravity: "bottom", // `top` or `bottom`
			  position: "right", // `left`, `center` or `right`
			  stopOnFocus: true, // Prevents dismissing of toast on hover
			  style: {
			    background: "linear-gradient(to right, #00b09b, #96c93d)",
			  },
			  onClick: function(){} // Callback after click
			}).showToast();			
	};
	
	//전송 버튼을 클릭하면 입력한 메세지를 가져와서 서버로 전달
	$(".send-btn").click(function(){
		//var input = document.querySelector(".message-input").value;
		var input = $(".message-input").val();
		if(input.length == 0) return;
		
		window.socket.send(input);
		$(".message-input").val("");
	});
</script>