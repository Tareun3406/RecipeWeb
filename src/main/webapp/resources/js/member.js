
const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");

let isInvalidId = true;
let isDuplicatedId = true;
let isInvalidPw = true;
let isInvalidNickName= true;
let isInvalidEmail = true;

// 아이디 중복체크
function id_check(){
    const messageOut = $("#idCheckMessage");
    $userid = $.trim($("#userid").val());
    let message;
    if(!isInvalidId){
        $.ajax({
            type:"POST",
            url:"/member/idCheck",
            data: {"userid":$userid},
            beforeSend : function (xhr){
                xhr.setRequestHeader(header, token)
            },
            datatype:"int",
            success: function (data) {
                if(data==1){//중복 아이디가 있다면
                    message ='<font color="red" size="3"><b>중복 아이디입니다.</b></font>';
                    messageOut.text('');
                    messageOut.append(message);
                    $("#userid").val('').focus();
                    isDuplicatedId = true;
                    return false;

                }else{//중복 아이디가 아니면
                    message ='<font color="blue" size="3"><b>사용가능한 아이디입니다.</b></font>';
                    messageOut.text('');
                    messageOut.append(message);
                    $("#userpw").focus();
                    isDuplicatedId = false;
                }
            },
            error:function(){
                alert("통신오류. 관리자에게 문의해주세요.");
            }
        });
    }

}

// 아이디 유효성 확인
function idInputOnChange(input){
    let idValue = input.value;
     validateUseridPrint(idValue);
}
const pattern= new RegExp(/^[a-z0-9_]+$/);//아이디를 영문소문자와 숫자 와 _조합으로 처리
function validateUseridPrint(idValue){
    const messageOut = $("#idCheckMessage");
     if (pattern.test(idValue)){
         messageOut.text('');
         messageOut.append("<font color=\"blue\" size=\"3\">사용가능한 아이디입니다. 중복체크 해주세요.");
         isInvalidId = false;
     }else {
         messageOut.text('');
         messageOut.append("<font color=\"red\" size=\"3\">영문소문자,숫자,_의 조합만 가능합니다.")
         isInvalidId = true;
     }
     isDuplicatedId = true;
};

// 비밀번호 일치 확인

function pwCheckOnChange(){
    const pwInput = document.getElementById("userpw");
    const pwInputCheck = document.getElementById("pwCheck");
    const messageOut = $("#pwCheckMessage");
    let isEquals = pwInput.value === pwInputCheck.value;
    if (isEquals){
        messageOut.text('');
        messageOut.append("<font color=\"blue\" size=\"3\">비밀번호가 일치합니다.");
        isInvalidPw = false;
    }else {
        messageOut.text('');
        messageOut.append("<font color=\"red\" size=\"3\">비밀번호가 일치하지 않습니다.");
        isInvalidPw = true
    }
}

//닉네임 유효성 검사
const regexKo = new RegExp(/^[가-힣|0-9]+$/);
const regexEn = new RegExp(/^[a-z|A-Z|0-9]+$/);
function nickNameOnChange(){
    const nicknameInputText = document.getElementById('nickname').value;
    const messageOut = $("#nickNameCheckMessage");

    if(regexEn.test(nicknameInputText)){    //영문+숫자 확인
        isInvalidNickName = !(nicknameInputText.length >= 4 && nicknameInputText.length <= 12);
    }else if(regexKo.test(nicknameInputText)){  // 한글+숫자 확인
        isInvalidNickName = !(nicknameInputText.length >= 2 && nicknameInputText.length <= 6);
    }else { // 둘다 아님
        isInvalidNickName = true;
    }

    if (isInvalidNickName){
        messageOut.text('');
        messageOut.append("<font color=\"red\" size=\"3\">영문+숫자 4~12글자. 한글+숫자 2~6글자만 가능합니다.");
    }else{
        messageOut.text('');
        messageOut.append("<font color=\"blue\" size=\"3\">사용가능합니다.");
    }
}

// 이메일 유효성 검사
const regexMail = new RegExp('^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$');
function emailOnChangeCheck(){
    const messageOut = $("#emailCheckMessage");
    let emailValue = document.getElementById('email').value;

    if (regexMail.test(emailValue)){
        messageOut.text('');
        messageOut.append("<font color=\"blue\" size=\"3\">사용가능합니다.");
        isInvalidEmail = false;
    }else{
        messageOut.text('');
        messageOut.append("<font color=\"red\" size=\"3\">올바르지 않습니다. 다시 확인해주세요");
        isInvalidEmail = true;
    }
}


// 회원가입 유효성 검사.
function joinCheck(){
    if(!isDuplicatedId && !isInvalidId && !isInvalidPw && !isInvalidNickName && !isInvalidEmail){
        return true;
    }else{
        if (isInvalidId || isDuplicatedId)
            document.getElementById('userid').focus();
        else if(isInvalidPw)
            document.getElementById('userpw').focus();
        else if(isInvalidNickName)
            document.getElementById('nickname').focus();
        else
            document.getElementById('email').focus();
    }
    return false
}