<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<jsp:include page="../main/header.jsp" flush="false"/>
<link href="../../css/category.css" rel="stylesheet" type="text/css">
<%-- 절대경로.--%>
<%-- -----------------------header------------------------ --%>
<div style="width: 1240px; height: auto; display: flex; margin-right: auto; margin-left:auto; flex-wrap: wrap;
border: solid 1px white; ">
<div id="h123">
	<div id="category">
		<button class="button1" type="button" >전체</button> 
		<button type="button" >종류</button> 
		<button type="button" >재료</button> 
		<button type="button" >방법</button>
		<button type="button" >테마</button> 
		<button type="button" >기념일</button> 
		<button class="button2" type="button" >도구</button>
	</div>
</div>
	
	
<div id="tow1">
	<div id="two">
		<tr>
			<th><span>종류별</span> <span>상황별</span>
				<span>재료별</span> <span>방법별</span></th>
		</tr>
				
			</div>
				<div id="three">
					<div style="width:100%; height:20px;border:solid 2px gray; border-top-left-radius: 5px; 
					border-top-right-radius: 5px; border-bottom:0px;margin:0px;">
						<a href="" class="">전체</a>
						<a href="">밑반찬</a>
						<a href="">메인반찬</a>
						<a href="">국/탕</a>
						<a href="">찌개</a>
						<a href="">디저트</a>
						<a href="">면/만두</a>
						<a href="">밥/죽/떡</a>
						<a href="">퓨전</a>
						<a href="">김치/젓갈/장류</a>
						<a href="">양념/소스/잼</a>
						<a href="">양식</a>
						<a href="">샐러드</a>
						<a href="">스프</a>
						<a href="">빵</a>
						<a href="">과자</a>
						<a href="">차/음료/술</a>
						<a href="">기타</a>
					</div>
					
					<div style="width:100%;height:20px;border:solid 2px gray; margin:0px;">
						<a href="">전체</a>
						<a href="">일상</a>
						<a href="">초스피드</a>
						<a href="">손님접대</a>
						<a href="">술안주</a>
						<a href="">다이어트</a>
						<a href="">도시락</a>
						<a href="">영양식</a>
						<a href="">간식</a>
						<a href="">야식</a>
						<a href="">푸드스타일링</a>
						<a href="">해장</a>
						<a href="">명절</a>
						<a href="">이유식</a>
						<a href="">기타</a>
					</div>
					
					<div style="width:100%;height:20px;border:solid 2px gray; border-top:0px; margin:0px;">
						<a href="">전체</a>
						<a href="">소고기</a>
						<a href="">돼지고기</a>
						<a href="">닭고기</a>
						<a href="">육류</a>
						<a href="">채소류</a>
						<a href="">해물류</a>
						<a href="">달걀/유제품</a>
						<a href="">가공식품류</a>
						<a href="">쌀</a>
						<a href="">밀가루</a>
						<a href="">건어물류</a>
						<a href="">버섯류</a>
						<a href="">과일류</a>
						<a href="">콩/견과류</a>
						<a href="">곡류</a>
						<a href="">기타</a>
					</div>
					
					<div style="width:100%;border:solid 2px gray; border-bottom-left-radius: 5px;
					 border-bottom-right-radius: 5px; border-top:0px;margin:0px;height:20px;">
						<a href="">전체</a>
						<a href="">볶음</a>
						<a href="">끓이기</a>
						<a href="">부침</a>
						<a href="">조림</a>
						<a href="">무침</a>
						<a href="">비빔</a>
						<a href="">찜</a>
						<a href="">절임</a>
						<a href="">튀김</a>
						<a href="">삶기</a>
						<a href="">굽기</a>
						<a href="">데치기</a>
						<a href="">회</a>
						<a href="">기타</a>
					</div>
					
				</div>
		
	</div>

<div id="dash"></div>
<%--여기밑으로는 카테고리별 이미지 나올 곳 --%>
<div id="fimage">
 <div id="image">
  <div>
   <img alt="1" src="../../images/food/image1.jpg">
   <span id="span1">1번 레시피</span><span id="span2">별점 ★</span>
  </div>
  <div>
   <img alt="2" src="../../images/food/image2.jpg">
   <span id="span1">2번 레시피</span><span id="span2">별점 ★</span>
  </div>
  <div>
   <img alt="3" src="../../images/food/image3.jpg">
   <span id="span1">3번 레시피</span><span id="span2">별점 ★</span>
  </div>
 
  <div>
   <img alt="4" src="./images/food/image4.jpg">
   <span id="span1">4번 레시피</span><span id="span2">별점 ★</span>
  </div>
  <div>
   <img alt="5" src="./images/food/image5.jpg">
   <span id="span1">5번 레시피</span><span id="span2">별점 ★</span>
  </div>
  <div>
   <img alt="6" src="./images/food/image6.jpg">
   <span id="span1">6번 레시피</span><span id="span2">별점 ★</span>
  </div>
 
  <div>
   <img alt="7" src="./images/food/image7.jpg">
   <span id="span1">7번 레시피</span><span id="span2">별점 ★</span>
  </div>
  <div>
   <img alt="8" src="./images/food/image8.jpg">
   <span id="span1">8번 레시피</span><span id="span2">별점 ★</span>
  </div>
  <div>
   <img alt="9" src="./images/food/image9.jpg">
   <span id="span1">9번 레시피</span><span id="span2">별점 ★</span>
  </div>
 
  <div>
   <img alt="10" src="./images/food/image10.jpg">
   <span id="span1">10번 레시피</span><span id="span2">별점 ★</span>
  </div>
  <div>
   <img alt="11" src="./images/food/image11.jpg">
   <span id="span1">11번 레시피</span><span id="span2">별점 ★</span>
  </div>
  <div>
   <img alt="12" src="./images/food/image12.jpg">
   <span id="span1">12번 레시피</span><span id="span2">별점 ★</span>
  </div>
  
 </div>
</div>
</div>



<%--밑에부턴 숫자페이지 --%>
<nav id="nav1">
	<ul id="num">
		<li><a href="">1</a></li>
		<li><a href="">2</a></li>
		<li><a href="">3</a></li>
		<li><a href="">4</a></li>
		<li><a href="">5</a></li>
		<li><a href="">6</a></li>
		<li><a href="">7</a></li>
		<li><a href="">8</a></li>
		<li><a href="">9</a></li>
		<li><a href="">10</a></li>
		<li><a href="">다음</a></li> <%--aria-label="Next"><span aria-hidden="true"--%> 
	</ul>
</nav>
<%-- -----------------------footer------------------------ --%>
<jsp:include page="../main/footer.jsp" flush="false"/>