
const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");

function id_check(){
    $userid = $.trim($("#userid").val());
    const messageInput = $("#idCheckMessage");
    let message;
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
                messageInput.text('');
                messageInput.append(message);
                $("#userid").val('').focus();
                return false;

            }else{//중복 아이디가 아니면
                message ='<font color="blue" size="3"><b>사용가능한 아이디입니다.</b></font>';
                messageInput.text('');
                messageInput.append(message);
                $("#userpw").focus();
            }
        },
        error:function(){
            alert("data error");
        }
    });

}