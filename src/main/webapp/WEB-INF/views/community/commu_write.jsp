<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../main/header.jsp" flush="false" />
<link href="${pageContext.request.contextPath}/css/commu.css"
	rel="stylesheet" type="text/css">

<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/commu.js"></script>
<script>
    $(document).ready(function(){
        $("#btnSave").click(function(){
            //var title = document.form1.title.value; ==> name속성으로 처리할 경우
            //var content = document.form1.content.value;
            //var writer = document.form1.writer.value;
            let title = $("#title").val();
            let content = $("#content").val();
            let writer = $("#writer").val();
            if(title == ""){
                alert("제목을 입력하세요");
                document.form1.title.focus();
                return;
            }
            if(content == ""){
                alert("내용을 입력하세요");
                document.form1.content.focus();
                return;
            }
           /* if(writer == ""){
                alert("이름을 입력하세요");
                document.form1.writer.focus();
                return;
            }*/
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
        });
    });
</script>
<div id="bsW_wrap">
	<h2 id="bsW_title">자료실 글쓰기</h2>
	<form id="bsW_title" name="form1" method="post" action="/commu_list">
    <div id="bsW_t">
        제목
        <input name="title" id="title" size="33" placeholder="제목을 입력해주세요">
    </div>
    <div id="bsW_t">
        내용
        <textarea name="content" id="content" rows="8"
    cols="34" placeholder="내용을 입력해주세요"></textarea>
    </div>
    <!-- <div id="bsW_t">
        이름
        <input name="writer" id="writer"  size="14"placeholder="이름을 입력해주세요">
    </div> -->
    <div id="bsW_t">
        <button type="button" id="btnSave">확인</button>
        <button type="reset">취소</button>
        <button type="button"onclick="location='commu_list?page=${page}';">목록</button>
    </div>
</form>
</div>


<jsp:include page="../main/footer.jsp" flush="false" />