<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<jsp:include page="../main/header.jsp" flush="false" />
<link href="${pageContext.request.contextPath}/css/commu.css"
	rel="stylesheet" type="text/css">
<section id="contents">
	<div class="container">
		<section id="cont_left">
			<article class="column col1">
				<h4 class="col_tit">Menu</h4>
				<p class="col_desc">커뮤니티 페이지 입니다.</p>
				<!-- 메뉴 -->
				<div class="menu">
					<ul>
						<li><a href="commu.jsp">자유게시판 <i
								class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
						<li><a href="Q&A.jsp">Q&A <i
								class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
						<li><a href="comment.jsp">한줄댓글 <i
								class="fa fa-angle-double-right" aria-hidden="true"></i></a></li>
						<li><a href="tip.jsp">꿀 tip <i
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
				<div class="notice1">
					<h5>인기 게시물</h5>
					<ul>
						<li><a href="#">자유게시판 제목 넣어야징~~</a></li>
						<li><a href="#">자유게시판 제목 넣어야징~~</a></li>
						<li><a href="#">자유게시판 제목 넣어야징~~</a></li>
						<li><a href="#">자유게시판 제목 넣어야징~~</a></li>
					</ul>
					<a href="commu.jsp" class="more" title="더 보기">More<i
						class="fa fa-plus-circle" aria-hidden="true"></i></a>
				</div>
				<!-- //게시판 -->

				<!-- 게시판2 -->
				<div class="notice2 mt15">
					<h5>인기 꿀 tip</h5>
					<ul>
						<li><a href="#">인기있는 꿀 팁 제목 어쩌구~인기있는 꿀 팁 제목 어쩌구~ 인기있는 꿀 팁
								제목 어쩌구~</a></li>
						<li><a href="#">인기있는 꿀 팁 제목 어쩌구~인기있는 꿀 팁 제목 어쩌구~ 인기있는 꿀 팁
								제목 어쩌구~</a></li>
						<li><a href="#">인기있는 꿀 팁 제목 어쩌구~인기있는 꿀 팁 제목 어쩌구~ 인기있는 꿀 팁
								제목 어쩌구~</a></li>
						<li><a href="#">인기있는 꿀 팁 제목 어쩌구~인기있는 꿀 팁 제목 어쩌구~ 인기있는 꿀 팁
								제목 어쩌구~</a></li>
					</ul>
					<a href="tip.jsp" class="more" title="더 보기">More<i
						class="fa fa-plus-circle" aria-hidden="true"></i></a>
				</div>
				<!-- //게시판2 -->
			</article>

		</section>

		<section id="cont_center">
			<div id="cList_wrap">
				<h2 class="cList_title">자료실 목록</h2>
				<div class="cList_count">글개수: ${listcount}</div>
				<table id="cList_t">
					<tr>
						<th width="6%" height="26">번호</th>
						<th width="50%">제목</th>
						<th width="14%">작성자</th>
						<th width="17%">작성일</th>
						<th width="14%">조회수</th>
					</tr>

					<c:if test="${!empty list }">
						<c:forEach var="c" items="${list}">
							<tr>
								<th>${comu_no}</th>
								
								<td style="padding-left: 14px; font-weight: bolder;"><a
									href="/community/commu_cont?comu_no=${comu_no}&page=${page}">${title}
										
								</a></td>
								<%--?bno=번호&page=쪽번호 주소창에 노출되는 get방식으로 2개의 피라미터값이 전달됨 --%>
								<th>${writer}</th>
								<%--b.getWriter()를 사용한것 과 같은 효과가난다. --%>
								
								<th>${regdate}</th>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty list}">
						<tr>
							<th colspan="5">게시물 목록이 없습니다.</th>
						</tr>
					</c:if>
				</table>
			</div>



			<article class="column col6">
				<div id="writebtn">
					<input type="button" value="글쓰기"
						onclick="location='commu_write?page=${page}';" />
					<c:if test="${(!empty find_field) && (!empty find_name)}">
						<input type="button" value="전체목록"
							onclick="location='commu_list?page=${page}';" />
					</c:if>
				</div>

				<div id='liSearchOption'>
					<select id='selSearchOption'>
						<option value='T'><c:if test="${find_field == 'title'}">
   							${'selected'}</c:if>제목
						</option>
						<option value='C'><c:if test="${find_field == 'content'}">
   							${'selected'}</c:if>내용
						</option>
					</select> <input id='txtKeyWord' /> <input type='button' value='검색' />
				</div>
			</article>


			<article class="column col6">
				<%--페이징(쪽나누기)--%>
				<div class="list_n_menu">
					<%--검색전 페이징 --%>
					<c:if test="${(empty find_field)&&(empty find_name)}">
						<c:if test="${page <=1}">
   [이전]&nbsp;
   </c:if>
						<c:if test="${page >1}">
							<a href="commu_list?page=${page-1}">[이전]</a>&nbsp;
   </c:if>

						<%--쪽번호 출력부분 --%>
						<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
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
						<c:if test="${page <=1}">  [이전]&nbsp;  </c:if>
						<c:if test="${page >1}">
							<a
								href="commu_list?page=${page-1}&find_field=${find_field}&find_name=${find_name}">
								[이전]</a>&nbsp;</c:if>

						<%--쪽번호 출력부분 --%>
						<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
							<c:if test="${a == page}"><${a}></c:if>
							<c:if test="${a != page}">
								<a
									href="commu_list?page=${a}&find_field=${find_field}&find_name=${find_name}">
									[${a}]</a>&nbsp;</c:if>
						</c:forEach>

						<c:if test="${page>=maxpage}">[다음]</c:if>
						<c:if test="${page<maxpage}">
							<a
								href="commu_list?page=${page+1}&find_field=${find_field}&find_name=${find_name}">
								[다음]</a>
						</c:if>
					</c:if>
				</div>
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