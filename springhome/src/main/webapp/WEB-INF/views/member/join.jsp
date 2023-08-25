<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="join" method="post" autocomplete="off">
	 <div class="container w-500">
        <div class="row mt-30 mb-20">
            <h2>회원가입</h2>
        </div>
            <div class="row left">
            <!-- 
                라벨에는 for를 이용하여 특정 대상을 연결시킬 수 있다 
                for="대상ID"
                체크박스 등도 선택하게 만들 수 있다(디자인적으로 활용)
            -->
            <label for="id-input" class="text-size">아이디<span class="important">*</span></label>
            <input type="text" name="memberId" 
            class="form-input w-100"
            id="id-input" 
            placeholder="영문 소문자+숫자 8~20자 이내">
        </div>
        <div class="row left">
            <label class="text-size">비밀번호<span class="important"> *</span></label>
            <input type="password" name="memberPw" 
            class="form-input w-100" placeholder="영문 대소문자+숫자+특수문자 8~16자 이내">
        </div>
        <div class="row left">
            <label class="text-size">닉네임<span class="important"> *</span></label>
            <input type="text" name="memberNickname" 
            class="form-input w-100" placeholder="한글, 숫자 2~10자 이내">
        </div>
        <div class="row w-100 left">
            <label class="text-size">이메일</label>
            <input type="email" name="memberEmail" 
            class="form-input w-100" placeholder="testuser@kh.com">
        </div>
        <div class="row left">
            <label class="text-size">연락처</label>
            <input type="tel" name="memberContact" 
            class="form-input w-100" placeholder="- 제외하고 입력">
        </div>
        <div class="row left">
            <label class="text-size">생년월일</label>
            <input type="date" name="memberBirth" 
            class="form-input w-100" placeholder="생년월일">
        </div>
        <div class="row left">
            <label style="display: block;" class="text-size">주소</label>
            <input type="text" name="memberPost" class="form-input form-post" placeholder="우편번호">
            <button type="button" class="btn btn-post">우편번호 찾기</button>
            <input type="text" name="memberAddr1" class="form-input w-100 mt-10" placeholder="기본주소">
            <input type="text" name="memberAddr2" class="form-input w-100 mt-10" placeholder="상세주소">
        </div>
        <div class="row mt-20 mb-30">
            <button type="submit" class="btn btn-positive w-100">가입하기</button>
        </div>
    </div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>