$(function(){
    //객체를 하나 만들어서 검사 결과를 저장
    //-검사 결과를 이곳에 저장
    var status = {
        memberId:false,
        memberPw:false,
        memberPwCheck:false,
        memberNickName:false,
        memberEmail:false,
        memberContact:false,
        memberBirth:false,
        memberAddress:false,
        ok:function(){
            return this.memberId && this.memberPw && this.memberPwCheck
            && this.memberNickName && this.memberEmail && this.memberContact 
            && this.memberBirth && this.memberAddress;
        }
    };

    $("[name=memberId]").blur(function(){      
        var regex = /^[a-z0-9]{5,20}$/;
        var isValid = regex.test($(this).val());

        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        
        //검사 결과를 status에 저장
        status.memberId = isValid;
    });

    $("[name=memberPw]").blur(function(){
        var regex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
        var isValid = regex.test($(this).val());

        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");

        //검사 결과를 status에 저장
        status.memberPw = isValid;

        //비밀번호 확인창에 강제로 blur이벤트를 발생시킨다(트리거
        $("#password-chek").blur();
    });

    $("#password-check").blur(function(){
        
        var originPw = $("[name=memberPw]").val();
        var checkPw =$(this).val();

        $(this).removeClass("success fail fail2");

        if(originPw.length == 0) { //비밀번호 미입력
            $(this).addClass("fail2");
            status.memberPwCheck = false;
        }
        else if(originPw == checkPw) { //비밀번호 일치
            $(this).addClass("success");
            status.memberPwCheck = true;
        }
        else { //비밀번호 불일치
            $(this).addClass("fail");
            status.memberPwCheck = false;
        }
    });

    $("[name=memberNickname]").blur(function(){

        var regex = /^[ㄱ-ㅎㅏ-ㅣ-가-힣0-9]{2,10}$/;
        var isValid = regex.test($(this).val());

        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");

        status.memberNickName = isValid;
    });

    $("[name=memberEmail]").blur(function(){

        var regex = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/;
        var email = $(this).val();
        var isValid = email.length == 0 || regex.test(email);

        $(this).removeClass("success fail")
        $(this).addClass(isValid ? "success" : "fail");

        status.memberEmail = isValid;
    });

    $("[name=memberContact]").blur(function(){

        var regex = /^010[1-9][0-9]{7}$/;
        var contact = $(this).val();
        var isValid = contact.length == 0 || regex.test(contact);

        $(this).removeClass("success fail")
        $(this).addClass(isValid ? "success" : "fail");

        status.memberContact = isValid;

    });

    $("[name=memberBirth]").blur(function(){

        var regex = /^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$/;
        var birth = $(this).val();
        var isValid = birth.length == 0 || regex.test(birth);

        $(this).removeClass("success fail")
        $(this).addClass(isValid ? "success" : "fail");

        status.memberBirth= isValid;
    });

    $("[name=memberPost],[name=memberAddr1],[name=memberAddr2]").blur(function(){
        //this 사용 불가(확실히 누군지 알 수 없음)
        var input1 = $("[name=memberPost]").val();
        var input2 = $("[name=memberAddr1]").val();
        var input3 = $("[name=memberAddr2]").val();

        var isBlank = input1.length == 0 && input2.length == 0 && input3.length == 0;
        var isFill = input1.length > 0 && input2.length > 0 && input3.length > 0;
        var isValid = isBlank || isFill;

        $("[name=memberPost],[name=memberAddr1],[name=memberAddr2]").removeClass("success fail");
        $("[name=memberPost],[name=memberAddr1],[name=memberAddr2]").addClass(isValid ? "success" : "fail");
        
        // $("[name=memberPost]").removeClass("success fail");
        // $("[name=memberAddr1]").removeClass("success fail");    
        // $("[name=memberAddr2]").removeClass("success fail"); 
        
        // $("[name=memberPost]").addClass(isValid ? "success" : "fail");
        // $("[name=memberAddr1]").addClass(isValid ? "success" : "fail");
        // $("[name=memberAddr2]").addClass(isValid ? "success" : "fail");

        status.memberAddress = isValid;
    });

    //페이지 이탈 방지
    //- window에 beforeunload 이벤트 설정
    $(window).on("beforeunload", function(){
        return false;
    });

    //- form 전송할 때는 beforeunload 이벤트를 제거
    $(".join-form").submit(function(e){
        $(".form-input").blur();

        if(!status.ok()){
            e.preventDefault();
        }
        else {
            $(window).off("beforeunload");
        }
    });
});