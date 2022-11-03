<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<jsp:include page="../main/header.jsp" flush="false"/>
<link href="${pageContext.request.contextPath}/resources/css/category.css" rel="stylesheet" type="text/css">
<%-- 절대경로.--%>
<%-- -----------------------header------------------------ --%>
<div style="width: 1240px; height: auto; display: flex; margin-right: auto; margin-left:auto; flex-wrap: wrap;
border: solid 1px white; ">
<div id="categoryhead">
	<div id="category">
		<form class="categoryform"action="/category" name="find_name">
		<div><input class="button1" type="submit" value="전체" name=""  /><input type="submit" value="한식" name="find_name" /><input type="submit" value="일식" name="find_name" /><input type="submit" value="중식" name="find_name" /><input type="submit" value="양식" name="find_name" /><input class="button2" type="submit" value="디저트" name="find_name" /></div>
		</form>
	</div>
</div>

<div id="dash"><span class="listcount">전체 게시글 수 ${listcount}</span></div>
<%--여기밑으로는 카테고리별 이미지 나올 곳 --%>
<div id="fimage">
 <div id="image">
	 <%-- 레시피 게시판 반복문으로 게시물 표시하기 --%>
  <c:forEach var="recipe" items="${blist}" varStatus="i" step="1" begin="0" end="11">
	  <div>
   <a href="/content?post_no=${recipe.post_no}"><img alt="1" width="300" height="300" src=${recipe.thumnail}  ></a>
   <div class="contents">
   <div style="margin-left: 2px;">${recipe.post_no}.${recipe.title}</div>
   <div style="margin-left: 2px;">작성자 : ${recipe.nickname} </div>
   <div class="hitandpoint">
    <span style="margin-left: 2px;">평점 : ${recipe.score}</span> <%-- 댓글불러와서 평점만들기--%>
    <span>추천수 : ${recipe.bookmark}</span>
    <span>조회수 : ${recipe.hit}</span>
   </div>
   </div>
  </div>
  </c:forEach>
		 <c:choose>
			 <c:when test="${empty blist[0].post_no}">
				 작성된 레시피 글이 없습니다. <hr/>
				 <button type="button">레시피 등록 하기</button>
			 </c:when>
		 </c:choose>

  <%-- 여기까지 한 세트 --%>

 </div>
</div>
</div>



<%--밑에부턴 숫자페이지 --%>
<nav id="nav1">
	<ul id="num">

			<%--검색전 페이징 --%>
			<c:if test="${(empty find_field)&&(empty find_name)}">
				<c:if test="${page <=1}">
					[이전]&nbsp;
				</c:if>
				<c:if test="${page >1}">
					<a href="category?page=${page-1}">[이전]</a>&nbsp;
				</c:if>

				<%--쪽번호 출력부분 --%>
				<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
					<c:if test="${a == page}"><${a}></c:if>
					<%--현재 쪽번호가 선택된 경우 --%>

					<c:if test="${a != page}">
						<%--현재 쪽번호가 선택 안된경우 --%>
						<a href="category?page=${a}">[${a}]</a>&nbsp;
					</c:if>
				</c:forEach>

				<c:if test="${page>=maxpage}">[다음]</c:if>
				<c:if test="${page<maxpage}">
					<a href="category?page=${page+1}">[다음]</a>
				</c:if>
			</c:if>

			<%--검색후 페이징 --%>
			<c:if test="${(!empty find_field) || (!empty find_name)}">
				<c:if test="${page <=1}">  [이전]&nbsp;  </c:if>	<c:if test="${page >1}">
				<a href="category?page=${page-1}&find_field=${find_field}&find_name=${find_name}">
					[이전]</a>&nbsp;</c:if>

				<%--쪽번호 출력부분 --%>
				<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
					<c:if test="${a == page}"><${a}></c:if><c:if test="${a != page}">
					<a href="category?page=${a}&find_field=${find_field}&find_name=${find_name}">
						[${a}]</a>&nbsp;</c:if>
				</c:forEach>

				<c:if test="${page>=maxpage}">[다음]</c:if>
				<c:if test="${page<maxpage}">
					<a href="category?page=${page+1}&find_field=${find_field}&find_name=${find_name}">
						[다음]</a> </c:if>
			</c:if>

	</ul>
</nav>
<%-- -----------------------footer------------------------ --%>
<jsp:include page="../main/footer.jsp" flush="false"/>