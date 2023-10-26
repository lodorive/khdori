<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<h1>가장 일반적인 결제</h1>

<div class="product-list">
	<c:forEach var="productDto" items="${list}">
		<div class="product-item">
			<input type="checkbox" name="productNo" value="${productDto.productNo}">
			[${productDto.productNo}] ${productDto.productName} (${productDto.productPrice}원)
			<input type="number" name="qty" value="1" min="1">		
		</div>
	</c:forEach>
	
	<button type="button" class="purchase-btn">구매하기</button>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
$(function(){
	//버튼 누르면 폼을 만들어서 체크된 항목의 "상품번호"와 "구매수량"을 입력창으로 만들어 추가
	$(".purchase-btn").click(function(){
		var form = $("<form>").attr("action", "test3/purchase").attr("method", "get");
		
		var count = 0;
		
		$(".product-item").each(function(index, tag){
			//현재 위치의 체크박스가 체크되어 있다면 상품번호와 상품수량을 불러와서 form에 추가하겠다
			var checked = $(this).find("[name=productNo]").prop("checked"); //현재 위치의 체크박스가 체크되어있는 것을 찾아라 
			if(checked == false) return; //체크가 되어있지 않다면 리턴
			
			var productNo = $(this).find("[name=productNo]").val();
			var qty = $(this).find("[name=qty]").val();
			//console.log(productNo, qty);
			
			//이렇게 따로 만드는 이유은 수량의 기본값이 전부 넘어오기 때문에
			$("<input>").attr("name", "product["+count+"].productNo")
							.attr("type", "hidden")
							.val(productNo)
							.appendTo(form);
			
			$("<input>").attr("name", "product["+count+"].qty")
							.attr("type", "hidden")
							.val(qty)
							.appendTo(form);
			count++;
		});
		
		$("body").append(form);
		form.submit(); //form을 전송해라
	});
});
</script>