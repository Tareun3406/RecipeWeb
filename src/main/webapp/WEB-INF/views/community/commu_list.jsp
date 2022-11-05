<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<c:import url="/header"/>
<script>
    $(document).ready(function(){
        $("#btnWrite").click(function(){
            // 페이지 주소 변경(이동)
            location.href = "/community/comu_write";
        });
    });
</script>
    <link href="../css/commu.css" rel="stylesheet" type="text/css">
	<section id="contents">
		<div class="container" >
			<section id="cont_left">
				<article class="column col1">
					<h4 class="col_tit">Menu</h4>
					<p class="col_desc">커뮤니티 페이지 입니다.</p>
					<!-- 메뉴 -->
					<div class="menu">
						<ul>
							<li><a href="/commu_list">자유게시판 <i
									class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
						

						</ul>
					</div>
					<!-- //메뉴 -->
				</article>
				<!-- //col1 -->
				<article class="column col2">
					<h4 class="col_tit">Notice</h4>
					<p class="col_desc">
						<a href="#">* 커뮤니티 이용관련 공지사항 *</a>
					</p>
					<!-- 게시판 -->
			
				</article>

			</section>

			<section id="cont_center">
			<article class="column col5">
				<form method="get" action="commu_list">
				
					<div id="bList_wrap">
						<h2 class="bList_title">자료실 목록</h2>
						<div class="bList_count">글개수: ${listcount}</div>
						<table id="bList_t">
							<tr>
								<th width="6%" height="26">번호</th>
								<th width="50%">제목</th>
								<th width="14%">작성자</th>
								<th width="17%">작성일</th>
								<th width="14%">조회수</th>
							</tr>

							<c:if test="${!empty blist}">
								<c:forEach var="b" items="${blist}">
								<tr>
							<td align="center">${b.comu_no}</td>
							<td align="center">
							<a href="/commu_cont?comu_no=${b.comu_no}">${b.title}</a>
							</td>
							<%-- ?bbs_no=번호&state=cont&page=쪽번호 주소창에 노출되는get방식으로 3개의 피라미터
     				이름에 인자값이 저장되어 전달된다. --%>
							<td align="center">${b.nickname}</td>
							<td align="center">${fn:substring(b.regdate,2,16)}</td>
							<%-- 0이상 10미만 사이의 년월일만 반환--%>
							<td align="center">${b.viewcnt}</td>
							</tr>
							</c:forEach>
							</c:if>

							<c:if test="${empty blist}">
								<tr>
									<th colspan="5">자료실 목록이 없습니다.</th>
								</tr>
							</c:if>
						</table>

						<%--페이징(쪽나누기)--%>
						<div id="bList_paging">
							<%--검색전 페이징 --%>
							<c:if test="${(empty find_field)&&(empty find_name)}">
								<c:if test="${page <=1}">
   [이전]&nbsp;
   </c:if>
								<c:if test="${page >1}">
									<a href="commu_list?page=${page-1}">[이전]</a>&nbsp;
   </c:if>

								<%--쪽번호 출력부분 --%>
								<c:forEach var="a" begin="${startpage}" end="${endpage}"
									step="1">
									<c:if test="${a == page}"><${a}></c:if>
									<%--현재 쪽번호가 선택된 경우 --%>

									<c:if test="${a != page}">
										<%--현재 쪽번호가 선택 안된경우 --%>
										<a href="commu_list?page=${a}">[${a}]</a>&nbsp;
    </c:if>
								</c:forEach>

								<c:if test="${page>=maxpage}">[다음]</c:if>
								<c:if test="${page<maxpage}">
									<a href="commu_list?page=${page+1}">[다음]</a>
								</c:if>
							</c:if>

							<%--검색후 페이징 --%>
							<c:if test="${(!empty find_field) || (!empty find_name)}">
								<c:if test="${page <=1}">
   [이전]&nbsp;
   </c:if>
								<c:if test="${page >1}">
									<a
										href="commu_list?page=${page-1}&find_field=${find_field}&find_name=${find_name}">[이전]</a>&nbsp;
   </c:if>

								<%--쪽번호 출력부분 --%>
								<c:forEach var="a" begin="${startpage}" end="${endpage}"
									step="1">
									<c:if test="${a == page}"><${a}></c:if>

									<c:if test="${a != page}">
										<a
											href="commu_list?page=${a}&find_field=${find_field}&find_name=${find_name}">[${a}]</a>&nbsp;
    </c:if>
								</c:forEach>

								<c:if test="${page>=maxpage}">[다음]</c:if>
								<c:if test="${page<maxpage}">
									<a
										href="commu_list?page=${page+1}&find_field=${find_field}&find_name=${find_name}">[다음]</a>
								</c:if>
							</c:if>

						</div>

						<div id="bList_menu">
							
							 <s:authorize access="isAnonymous()"></s:authorize>
                    
              				  
               				 <s:authorize access="isAuthenticated()">
                  					  <input type="button" value="글쓰기"
											onclick="location='commu_write?page=${page}';" />
               				 </s:authorize>
							
								
							<c:if test="${(!empty find_field) && (!empty find_name)}">
								<input type="button" value="전체목록"
									onclick="location='commu_list?page=${page}';" />
							</c:if>
						</div>

						<%--검색폼 --%>
						<div id="bFind_wrap">
							<select name="find_field">
								<option value="title"
									<c:if test="${find_field == 'bbs_title'}">
   ${'selected'}</c:if>>제목</option>
								<option value="content"
									<c:if test="${find_field == 'bbs_cont'}">
    ${'selected'}</c:if>>내용</option>
							</select> <input name="find_name" id="find_name" size="14"
								value="${find_name}" /> <input type="submit" value="검색" />
						</div>
					</div>
				</form>
			</article>
      </section>
      <section id="cont_right">
         <article class="column col6">
            <h4 class="col_tit">광고</h4>
            <p class="col_ppl">이 곳은 광고 부분입니다.</p>
         </article>

      </section>

   </div>
</section>

<jsp:include page="../main/footer.jsp" flush="false" />