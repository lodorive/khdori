function checkId(){
    var input = document.querySelector("[name=memberId]");

    var regex = /^[a-z0-9]{5,20}$/;
    var isValid = regex.test(input.value);

    input.classList.remove("success", "fail");           
    if(isValid){
        input.classList.add("success"); //클래스 추가
    }
    else{
        input.classList.add("fail");
    }
}

function checkPw(){
    var input = document.querySelector("[name=memberPw]");

    var regex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
    var isValid = regex.test(input.value);

    input.classList.remove("success", "fail");
    input.classList.add(isValid ? "success" : "fail");
}

function checkPw2(){
    var pw = document.querySelector("[name=memberPw]")
    var pwCheck = document.querySelector("#password-check");

    // 비밀번호가 1글자 이상 입력되어 있고 두 입력값이 같으면
    var isValid = pw.value.length >= 1 && pw.value == pwCheck.value;

    pwCheck.classList.remove("success", "fail", "fail2");
    if(pw.value.length == 0){
        pwCheck.classList.add("fail2");
    }
    else if(isValid){
        pwCheck.classList.add("success");
    }
    else{
        pwCheck.classList.add("fail");
    }
}
    function checkForm() {
        var result1 = checkId();
        var result2 = checkPw();
        var result3 = checkPw2();
        return result1 && result2 & result3;
    }
