$(function(){
    //처음 로딩아이콘 숨김
    $(".btn-send").find(".fa-spinner").hide();
    $(".cert-wrapper").hide();

    //인증번호 보내기 버튼을 누르면 서버로 비동기 통신을 보내 인증 메일 발송 요청
    $(".btn-send").click(function(){
        var email = $("[name=memberEmail]").val();
        if(email.length == 0) return;

        $(".btn-send").prop("disabled", true);
        $(".btn-send").find(".fa-spinner").show();
        $(".btn-send").find("span").text("이메일 발송중");
        $.ajax({
            url:"http://localhost:8080/rest/cert/send",
            method:"post",
            data:{certEmail : email}, //certEmail이라는 이름으로 email을 보낸다
            success:function(){
                $(".btn-send").prop("disabled", false);
                $(".btn-send").find(".fa-spinner").hide();
                $(".btn-send").find("span").text("인증번호 보내기");
                // window.alert("이메일을 확인하세요");

                $(".cert-wrapper").show();
                window.email = email; //사용자가 바꿔도 적용이 안되게 저장해둠
            },
        });
    });
    //확인 버튼을 누르면 이메일과 인증번호를 서버로 전달하여 검사
    $(".btn-cert").click(function(){
        // var email = $("[name=memberEmail]").val();
        var email = window.email;
        var number = $(".cert-input").val();
        if(email.length == 0 || number.length == 0) return;

        $.ajax({
            url:"http://localhost:8080/rest/cert/check",
            method:"post",
            data:{
                certEmail : email,
                certNumber : number
            },
            success:function(response){
                // console.log(response);
                if(response.result) {//인증 성공
                    $(".cert-input").removeClass("success fail").addClass("success");
                    $(".btn-cert").prop("disabled", true);
                    //상태객체에 상태 저장하는 코드
                }
                else {
                    $(".cert-input").removeClass("success fail").addClass("fail");
                    //상태객체에 상태 저장하는 코드
                }
            },
        });
    });
});