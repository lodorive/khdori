<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

   <form action="login" method="post" autocomplete="off">
	                        <div class="row">
	                            <div class="col text-center">
	                                <h2>로그인</h2>
	                            </div>
	                        </div>

                        <div class="row mt-4">
                            <div class="col-md-6 offset-md-3 col-sm-8 offset-sm-2">
                                <div class="form-floating">
                                    <input type="text" name="memberId" class="form-control is-valid" placeholder="이글자는안보임">
                                    <label>아이디
                                        <span class="fa-solid fa-asterisk text-danger"></span>
                                    </label>
                                    <div class="invalid-feedback">아이디를 다시 입력하세요</div>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-3">
                            <div class="col-md-6 offset-md-3 col-sm-8 offset-sm-2">
                                <div class="form-floating">
                                    <input type="password" name="memberPw" class="form-control is-valid" placeholder="이글자는안보임">
                                    <label>비밀번호
                                        <span class="fa-solid fa-asterisk text-danger"></span>
                                    </label>
                                    <div class="invalid-feedback">비밀번호를 다시 입력하세요</div>
                                </div>
                            </div>
                        </div>

                        <div class="row mt-2">
                            <div class="col-md-6 offset-md-3 col-sm-8 offset-sm-2">
                                <div class="form-check form-switch">
                                    <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault" name="remember">
                                    <label class="form-check-label" for="flexSwitchCheckDefault">아이디 저장</label>
                                  </div>
                            </div>
                        </div>

                        <div class="row mt-2">
                            <div class="col-md-6 offset-md-3 col-sm-8 offset-sm-2">
                                    <button type="button" class="btn btn-lg btn-success w-100">로그인</button>
                            </div>
                        </div>
                   

                        <hr class="col-md-6 offset-md-3 col-sm-8 offset-sm-2">
                        <div class="row">
                            <div class="col-md-6 offset-md-3 col-sm-8 offset-sm-2 text-center mb-5">
                                <a href="findPw" class="link-underline link-underline-opacity-0 link-underline-opacity-75-hover">비밀번호 찾기</a>
                            </div>
                        </div>
<%-- 
	EL은 출력을 쉽게 하기 위한 언어이므로 여러 데이터를 쉽게 접근할 수 있다.
	파라미터를 읽고 싶을 경우 param이라는 내장객체를 사용할 수 있다.
	param을 이용하여 파라미터를 비교할 수 있다.
 --%>
<c:if test="${param.error != null}">
<div class="row">
	<h4>아이디 또는 비밀번호가 일치하지 않습니다</h4>
	</div>
</c:if>	
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>