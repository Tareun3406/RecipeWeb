<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../main/header.jsp" flush="false" />
<link href="${pageContext.request.contextPath}/css/commu.css"
	rel="stylesheet" type="text/css">

<script src="/resources/js/jquery.js"></script>

<script>
$(document).ready(function(){
        $("#btnEdit").click(function(){
            //var title = document.form1.title.value; ==> name속성으로 처리할 경우
            //var content = document.form1.content.value;
            //var writer = document.form1.writer.value;
            let title_edit = $("#title").val();
            let content_edit = $("#content").val();
            let writer_edit = $("#writer").val();
            if(title_edit == ""){
                alert("제목을 입력하세요");
                document.form1.title.focus();
                return;
            }
            if(content_edit == ""){
                alert("내용을 입력하세요");
                document.form1.content.focus();
                return;
            }
            if(writer_edit == ""){
                alert("이름을 입력하세요");
                document.form1.writer_edit.focus();
                return;
            }
            document.form1.action="/community/commu_edit_ok"
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
        });
});
</script>
<div id="bsW_wrap">
	<h2 class="bsW_title">자료실 글수정</h2>
	<form name="form1" method="post" >

    <div>
        제목
        <input name="title" id="title" size="80" value="${dto.title}" placeholder="제목을 입력해주세요">
    </div>
    
    <div>
        내용
        <textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요">${dto.content}</textarea>
    </div>
    <div>
        이름
        <input name="writer" id="writer" value="${dto.writer}" placeholder="이름을 입력해주세요">
    </div>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden으로 처리 -->
        <input type="hidden" name="comu_no" value="${dto.comu_no}">
        <button type="button" id="btnEdit">수정</button>
        <input type="reset" value="취소">
		<button type="button"onclick="location='/commu_list';">목록</button>
    </div>
</form>
</div>


<jsp:include page="../main/footer.jsp" flush="false" />