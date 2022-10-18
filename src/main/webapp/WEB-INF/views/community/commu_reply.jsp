<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 답변폼</title>
<link href="${pageContext.request.contextPath}/css/commu.css"
	rel="stylesheet" type="text/css">
<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/commu.js"></script>
</head>
<body>
 <div id="bsW_wrap">
  <h2 class="bsW_title">자료실 답변글</h2>
  <form method="post" action="comm_reply_ok"
  onsubmit="return write_check();"  >
  <%--답변글 히든값 --%>
  <input type="hidden" name="comm_ref" value="${c.comm_ref}" />
  <%-- bbs_ref는 원본그과 답변글을 묶어주는 글 그룹번호 역할 --%>
  <input type="hidden" name="comm_step" value="${c.comm_step}"/>
  <%-- bbs_step은 원본글일때는 0,첫번째 답변글이면1,두번째 답변글이면 2,즉 원본글과 답변글을 
  	구분하는 번호값이면서 몇번째 답변글인가를 알려줌. --%>
  <input type="hidden" name="comm_level" value="${c.comm_level}" />
  <%-- bbs_level은 답변글 정렬 순서 --%>
  
  <%--페이징 쪽번호 히든값=>책갈피 기능  --%>
  <input type="hidden" name="page" value="${page}" />
  <table id="bsW_t">
   <tr>
    <th>이름</th>
    <td><input name="comm_name" id="comm_name" size="14" /></td>
   </tr>
   <tr>
    <th>제목</th>
    <td><input name="comm_title" id="comm_title" size="33" 
    value="Re:${c.comm_title}"/></td>
   </tr>
   <tr>
    <th>비밀번호</th>
    <td><input type="password" name="comm_pwd" id="comm_pwd"
    size="14" /></td>   
   </tr>
   <tr>
    <th>글내용</th>
    <td><textarea name="comm_cont" id="comm_cont" rows="8"
    cols="34"></textarea></td>
   </tr>  
  </table>
  <div id="bsW_menu">
   <input type="submit" value="답변" />
   <input type="reset" value="취소" 
   onclick="$('#comm_name').focus();" >
   <input type="button" value="목록" 
   onclick="location='commu_list?page=${page}';" >
  </div>
  </form>
 </div>
</body>
</html>