let isInvalidPw = true;
let isInvalidNickName = true;
let isInvalidEmail = true;

function onLoadInvalidCheck() {
    pwCheckOnChange();
    nickNameOnChange();
    emailOnChangeCheck();
}

// 비밀번호 일치 확인

function pwCheckOnChange() {
    const pwInput = document.getElementById("userpw");
    const pwInputCheck = document.getElementById("pwCheck");
    const messageOut = $("#pwCheckMessage");
    let isEquals = pwInput.value === pwInputCheck.value;
    if (pwInput.value === '')
        messageOut.text('');
        messageOut.append("<font color=\"red\" size=\"3\">비밀번호를 변경해주세요.");
    isInvalidPw = false;
    if (isEquals) {
        messageOut.text('');
        messageOut.append("<font color=\"blue\" size=\"3\">비밀번호가 일치합니다.");
        isInvalidPw = false;
    } else {
        messageOut.text('');
        messageOut.append("<font color=\"red\" size=\"3\">비밀번호가 일치하지 않습니다.");
        isInvalidPw = true
    }
}

//닉네임 유효성 검사
const regexKo = new RegExp(/^[가-힣|0-9]+$/);
const regexEn = new RegExp(/^[a-z|A-Z|0-9]+$/);

function nickNameOnChange() {
    const nicknameInputText = document.getElementById('nickname').value;
    const messageOut = $("#nickNameCheckMessage");

    if (regexEn.test(nicknameInputText)) {    //영문+숫자 확인
        isInvalidNickName = !(nicknameInputText.length >= 4 && nicknameInputText.length <= 12);
    } else if (regexKo.test(nicknameInputText)) {  // 한글+숫자 확인
        isInvalidNickName = !(nicknameInputText.length >= 2 && nicknameInputText.length <= 6);
    } else { // 둘다 아님
        isInvalidNickName = true;
    }

    if (isInvalidNickName) {
        messageOut.text('');
        messageOut.append("<font color=\"red\" size=\"3\">영문+숫자 4~12글자. 한글+숫자 2~6글자만 가능합니다.");
    } else {
        messageOut.text('');
        messageOut.append("<font color=\"blue\" size=\"3\">사용가능합니다.");
    }
}

// 이메일 유효성 검사
const regexMail = new RegExp('^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$');

function emailOnChangeCheck() {
    const messageOut = $("#emailCheckMessage");
    let emailValue = document.getElementById('email').value;

    if (regexMail.test(emailValue)) {
        messageOut.text('');
        messageOut.append("<font color=\"blue\" size=\"3\">사용가능합니다.");
        isInvalidEmail = false;
    } else {
        messageOut.text('');
        messageOut.append("<font color=\"red\" size=\"3\">올바르지 않습니다. 다시 확인해주세요");
        isInvalidEmail = true;
    }
}


// 회원가입 유효성 검사.
function joinCheck() {
    if (!isInvalidPw && !isInvalidNickName && !isInvalidEmail) {
        return true;
    } else {
        if (isInvalidPw)
            document.getElementById('userpw').focus();
        else if (isInvalidNickName)
            document.getElementById('nickname').focus();
        else
            document.getElementById('email').focus();
    }
    return false
}