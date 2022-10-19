<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="../main/header.jsp" flush="false" />
<link href="${pageContext.request.contextPath}/css/commu.css"
	rel="stylesheet" type="text/css">

<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/commu.js"></script>
<script>
    $(document).ready(function(){
        $("#btnDelete").click(function(){
            if(confirm("삭제하시겠습니까?")){
                document.form1.action = "${path}/commu_del_ok";
                document.form1.submit();
            }
        });
  
    });
</script>
<body>
<form id="bsW_title" name="form1" method="post" >
 <div id="bsC_wrap">
  <h2 class="bsC_title">자료실 내용보기</h2>
  <table id="bsC_t">
   <tr>
    <th>제목</th> <td bordercolor="#c0c0c0;">${dto.title}</td>   
   </tr>
   <tr>
    <th>내용</th> <td>${dto.content}</td>
   </tr>
   <tr>
    <th>조회수</th> <td>${dto.viewcnt}</td>   
   </tr>
   
  </table>
  <div id="bsC_menu">
   
<input type="button" value="수정"onclick="location='/community/commu_edit?comu_no=${dto.comu_no}';" />
<button type="button" id="btnDelete">삭제</button>
<input type="button" value="목록"onclick="location='commu_list?page=${page}';" />     
  </div>
 </div>
</form>

<jsp:include page="../main/footer.jsp" flush="false" />