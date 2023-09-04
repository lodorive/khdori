<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script src="/js/memberJoin.js"></script>

 <style>
    .important{
        font-weight: bold;
         color: crimson;
    }
    .btn.btn-positive{
        border-color: black;
        background-color: black;
        color: white;
    }
    .form-input{
        font-size: 13px;
    }
    .form-input.form-post{
        width: 100px;
    }
    .btn.btn-post{
        font-size: 11.5px;
        width: 100px;
        height: 31px;
    }
    .text-size{
        font-size: 14px;
    }
    </style>
    
	 <div class="container w-400">
        <div class="row mt-10 mb-20">
            <h2>회원가입</h2>
        </div>
        
		<form action="join" method="post" autocomplete="off" onsubmit="return checkForm();" >
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
            oninput="checkId();"
            placeholder="영문 소문자+숫자 8~20자 이내">
            <div class="success-feedback">멋진 아이디입니다!</div>
            <div class="fail-feedback">아이디는 영문과 숫자 5~20자로 작성하세요</div>
        </div>
        <div class="row left">
            <label class="text-size">비밀번호<span class="important"> *</span></label>
            <input type="password" name="memberPw" 
            class="form-input w-100" 
            oninput="checkPw();"
            placeholder="영문 대소문자+숫자+특수문자 8~16자 이내">
            <div class="success-feedback">올바른 비밀번호 형식입니다</div>
            <div class="fail-feedback">비밀번호는 영문, 문자, 숫자, 특수문자를 반드시 포함하여 8~16자로 작성하세요</div>
        </div>
         <div class="row left">
            <label class="text-size">비밀번호 확인<span class="important"> *</span></label>
            <input type="password" 
            class="form-input w-100" 
            id="password-check"
            oninput="checkPw2();"
            placeholder="영문 대소문자+숫자+특수문자 8~16자 이내">
             <div class="success-feedback">비밀번호가 일치합니다</div>
            <div class="fail-feedback">비밀번호가 일치하지 않습니다</div>
            <div class="fail2-feedback">비밀번호를 먼저 작성하세요</div>
        </div>
        <div class="row left">
            <label class="text-size">닉네임<span class="important"> *</span></label>
            <input type="text" name="memberNickname" 
            class="form-input w-100" 
            placeholder="한글, 숫자 2~10자 이내">
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
            <button type="submit" class="btn btn-positive w-100">
            <i class="fa-solid fa-plus"></i>
            가입하기</button>
        </div>
</form>
    </div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>