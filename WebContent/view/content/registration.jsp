<%@ page contentType="text/html; charset=UTF-8"%>

<!-- header -->
<jsp:include page="../main/header.jsp" flush="false"/>
<link rel="stylesheet" type="text/css" href="../../css/registration.css" />
<script src="../../js/jquery.js"></script>
<script src="../../js/reg_test.js"></script>

<section id="backimg">
 <article>
  <div id="r9">
   <form  name="ck" method="post" action="#" enctype="multipart/form-data" id="cK_form" onsubmit="return check();">
 <div id="re">
  <div id="re_1">
  <h1>레시피 등록</h1>
  </div>
 <ul id="rs">
  <li><span style="font-size:16px">요리 제목 </span><input id="ck_title" name="ck_title" placeholder="요리제목을 입력해주세요."></li><br/>
  </ul>
  </div>
  
  <div>
	<ul>
<li><span style="font-size:16px"> 카테고리</span> <select name="cook" id="cate">
	<option value="Korean food">한식</option>
	<option value="Western food">양식</option>
	<option value="Japanese food">일식</option>
	</select>
	</li>
	</ul>
</div>

<div>
  <ul>
  <li><span style="font-size:16px"> 내용 </span><input id="ck_cont" name="ck_cont" placeholder="요리에 관한 레시피내용을 입력해주세요."></li><br/>
  <li><span style="font-size:16px"> 재료 </span><input id="ck_ing" name="ck_ma" placeholder="요리에 들어가는 재료를 기입해주세요."></li><br/>
  <li><span style="font-size:16px"> 나만의 팁 </span><input id="ck_tip" placeholder="나만의 꿀팁을 적어보세요."></li><br/>
 </ul>
 </div>
 <div id='image_preview'>
<ul>
<li><span style="font-size:16px"> 요리사진 </span>
<div id='att_zone'> <input  id='btnAtt' type="file" name="ck_file" multiple>
</div>
</li>
</ul>
 </div>
<div>
<ul>
<li><span style="font-size:16px"> 요리 동영상</span> <input type="url" id="ck_video" placeholder="요리에 대한 동영상이있다면 주소를 넣어주세요(단 유튜브주소만 가능)"><br/>
</ul>
</div>
<div>
<input type="submit" class="btn green rounded" value="등록">
<input type="reset" class="btn red rounded" value="취소" onclick="ck.title.focus()">
</div>
</form>
</div>
</article>
</section>


<script src="js/reg_multi_img.js"></script>



<!-- footer -->
<jsp:include page="../main/footer.jsp" flush="false"/>