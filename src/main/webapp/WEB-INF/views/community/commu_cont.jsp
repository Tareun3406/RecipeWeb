<%@ page contentType="text/html; charset=UTF-8"%>
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


		<!-- 내용보기+댓글 입력 +댓글 창  -->
		<section id="cont_center">
			<div id="bsC_wrap">
				<h2 class="bsC_title">자료실 내용보기</h2>
				<table id="bsC_t">
					<tr>
						<th>제목</th>
						<td>${b.comm_title}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${comm_cont}</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${b.comm_hit}</td>
					</tr>
					<c:if test="${!empty b.comm_file}">
						<%--첨부파일이 있는경우--%>
						<tr>
							<th>첨부이미지</th>
							<td><img src="/resources/upload${b.comm_file}" width="130"
								height="100" /></td>
						</tr>
					</c:if>
				</table>
				<div id="bsC_menu">
					<input type="button" value="답변"
						onclick="location='comm_cont?comm_no=${b.comm_no}&page=${page}&state=reply';" />
					<input type="button" value="수정"
						onclick="location='comm_cont?comm_no=${b.comm_no}&page=${page}&state=edit';" />
					<input type="button" value="삭제"
						onclick="location='comm_cont?comm_no=${b.comm_no}&page=${page}&state=del';" />
					<input type="button" value="목록"
						onclick="location='comm_list?page=${page}';" />
				</div>
			</div>
			
				<div id="bsW_wrap">
					<h2 class="bsW_title">자료실 답변글</h2>
					<form method="post" action="comm_reply_ok"
						onsubmit="return write_check();">
						<%--답변글 히든값 --%>
						<input type="hidden" name="bbs_ref" value="${b.comm_ref}" />
						<%-- bbs_ref는 원본그과 답변글을 묶어주는 글 그룹번호 역할 --%>
						<input type="hidden" name="bbs_step" value="${b.comm_step}" />
						<%-- bbs_step은 원본글일때는 0,첫번째 답변글이면1,두번째 답변글이면 2,즉 원본글과 답변글을 
  	구분하는 번호값이면서 몇번째 답변글인가를 알려줌. --%>
						<input type="hidden" name="bbs_level" value="${b.comm_level}" />
						<%-- bbs_level은 답변글 정렬 순서 --%>

						<%--페이징 쪽번호 히든값=>책갈피 기능  --%>
						<input type="hidden" name="page" value="${page}" />
						<table id="bsW_t">
							<tr>
								<th>이름</th>
								<td><input name="bbs_name" id="bbs_name" size="14" /></td>
							</tr>
							<tr>
								<th>제목</th>
								<td><input name="bbs_title" id="bbs_title" size="33"
									value="Re:${b.comm_title}" /></td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td><input type="password" name="bbs_pwd" id="bbs_pwd"
									size="14" /></td>
							</tr>
							<tr>
								<th>글내용</th>
								<td><textarea name="bbs_cont" id="bbs_cont" rows="8"
										cols="34"></textarea></td>
							</tr>
						</table>
						<div id="bsW_menu">
							<input type="submit" value="답변" /> <input type="reset"
								value="취소" onclick="$('#comm_name').focus();"> <input
								type="button" value="목록"
								onclick="location='commu_list?page=${page}';">
						</div>
					</form>
				</div>
		</section>


		<section id="cont_right">
			<article class="column col6">
				<h4 class="col_tit">광고</h4>
				<p class="col_ppl">이 곳은 광고 부분입니다.</p>
				<!-- -->

				<!-- // -->
			</article>

		</section>

	</div>
</section>




<jsp:include page="../main/footer.jsp" flush="false" />