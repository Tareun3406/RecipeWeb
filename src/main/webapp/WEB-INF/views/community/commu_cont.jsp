
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="s" %>
<c:import url="/header"/>
<link href="${pageContext.request.contextPath}/css/commu.css"
	rel="stylesheet" type="text/css">
<script src="/resources/js/jquery.js"></script>

<style type="text/css">
 /* type 속성은 생략해도  웹브라우저가 기본 값을 css로 인식한다*/
 /*댓글 수정 화면*/
  #modDiv{
    width:480px; height:60px; background-color:#fce7c2;
    border: 1px solid black;
    border-radius:5px;
    position:absolute; /*절대위치*/
    top:50%; left:50%;
    margin-top:500px; margin-left:-270px;
    padding:30px;
    z-index:1000; /*position 속성이 absolute or fixed 인 곳에서 사용한다. 이 속성은 요소가 겹쳐지는 순서를 제어할수있다.
    				물론, 큰숫자일수록 앞에 나온다.*/ 
  }
  
</style>
<script>
    $(document).ready(function(){
    	
    	//게시글 삭제 버튼 클릭 이벤트   	
        $("#btnDelete").click(function(){
            if(confirm("삭제하시겠습니까?")){
                document.form1.action = "${path}/community/commu_del_ok";
                document.form1.submit();
            }
        });
    }); 
   

</script>

<form id="bsW_title" name="form1" method="get" >
 <div id="bsC_wrap">
  <h2 class="bsC_title">자료실 내용보기</h2>
  <table id="bsC_t">
   <tr>
    <th>제목</th> <td>${dto.title}</td>   
   </tr>
   <tr>
    <th>내용</th> <td>${dto.content}</td>
   </tr>
   <tr>
    <th>작성자</th> <td>${dto.nickname}</td>   
   </tr>
   <tr>
    <th>조회수</th> <td>${dto.viewcnt}</td>   
   </tr>
   
  </table>
  <div id="bsC_menu">


<c:if test="${userlist.nickname == dto.nickname }">
<input type="hidden" name="comu_no" value="${dto.comu_no}">
<input type="button" value="수정"onclick="location='/community/commu_edit?comu_no=${dto.comu_no}';" />
<button type="button" id="btnDelete">삭제</button>
</c:if>
<input type="button" value="목록" onclick="location='/commu_list';" />     
  </div>
  </div>
</form>

<br/>
<hr/>
<br/>

 <%--댓글 수정화면 --%>
  <div id="modDiv" style="display:none;">
   <%-- css display:none;에 의해서 댓글 수정화면이 안보이게 함 --%>
    
    <div class="modal-title"></div>  <%--댓글번호 --%>
    <div>
      <textarea rows="2" cols="50" id="content"></textarea>
    </div>
    <div>
      <button type="button" id="replyModBtn">댓글 수정</button>
      <button type="button" id="replyDelBtn">댓글 삭제</button>
      <button type="button" id="closeBtn" onclick="modDivClose();">닫기</button>
    </div>
  </div>
  


  <div id="replyform">
<%--   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token"> --%>
  <div>
  	댓글 작성자:<input name="reviewer" id="newreviewer" value="${userlist.nickname}" readonly="${userlist.nickname}"/> 
  	<%--type속성을생략하면 기본값이 text이다. --%>
  </div>
  <br/>
  <div>
  	댓글 내용:<textarea rows="2" cols="50" name="content" id="newcontent"></textarea>
	<button id="commuReplyBtn" type="button">댓글 등록</button>
   </div> 
  </div>
  
  <br/>

  
  <%--댓글 목록 --%>
  <div id="replyList">
  <ul id="replies"></ul><%--비동기식으로 가져온 댓글목록 --%>
  </div>
  <script>
    $comu_no=${dto.comu_no};//게시판 번호
	
    getAllList();//댓글 목록함수를 호출
    
    //댓글 목록
    function getAllList(){
    	$.getJSON("/replies/all/"+$comu_no, function(data){//jQuery 비동기식 $.getJSON()함수는 get방식으로 접근하는 
    		//json데이터를 처리, 비동기식으로 가져온 것이 성공시 data 매개변수에 가져온 값을 저장한다.
    		$str="";

    		$(data).each(function(){//each()함수에의해서 li태그 단위로 댓글 개수만큼반복
    			$str += "<li data-reply_no='"+this.reply_no+"' class='replyLi'>"
    			+this.reply_no+this.nickname
    			+" : <span class='com' style='color:black;font-weight:bold;'>"
    			+this.content+"</span>"+"<button>댓글수정</button></li><br/>"    		
    		});
    		$('#replies').html($str);//html()함수로 문자와 태그를 함께변경 적용
    	});
    }//getAllList()
    
    //댓글 추가
    let csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
    let csrfHeader = $("meta[name='_csrf_header']").attr("content");
    let csrfToken = $("meta[name='_csrf']").attr("content");
    $('#commuReplyBtn').on("click",function(){     	
    	 $reviewer=$('#newreviewer').val();//댓글 작성자
    	 $content=$('#newcontent').val();//댓글내용
    	 
    	 $.ajax({
    		type:'post',//method 방식
    		url:'/replies/addreply',//URL매핑주소 경로
    		headers:{
    			"Content-Type":"application/json",
    			"X-HTTP-Method-Override":"POST"
    		},
    		beforeSend : function(xhr)
            {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
    		dataType:'text',
    		data:JSON.stringify({
    			comu_no:$comu_no,//게시판 번호값
    			reviewer:$reviewer,//댓글 작성자
    			content:$content//댓글 내용
    		}),
    		success:function(data){//비동기식으로 가져오는 것이 성공시 호출되는 콜백 함수, 가져온 문자는 data매개변수에 저장
    			if(data == 'SUCCESS'){
    				alert("댓글이 등록되었습니다!");
    				getAllList();//댓글 목록 함수를 호출
    			}
    		}
    				
    	});//jQuery 비동기식 아작스 함수
    });
    
    //댓글 수정 화면
    $('#replies').on('click',".replyLi button",function(){
    	var reply=$(this).parent();//this는 버튼,button의 부모요소인 li태그를 가리킴
    	$reply_no = reply.attr("data-reply_no");//댓글번호
    	$content = reply.children(".com").text();//댓글내용
    	    	
    	$('.modal-title').val($reply_no);//댓글번호가 표시
    	$('#content').val($content);//댓글 내용이 표시
    	$('#modDiv').show("slow");//display:none; css에 의해서 숨겨진 댓글 수정화면을 표시하게 한다.
    	
    });
        
    //댓글 수정화면 닫기
    function modDivClose(){
    	$('#modDiv').hide('slow');
    }
    
    //댓글 수정 완료
    $('#replyModBtn').on('click',function(){
    	var reply_no=$('.modal-title').html();//댓글 번호
    	$content=$('#content').val();//수정할 댓글 내용
    	$.ajax({
    		type:'put',
    		url:'/replies/'+$reply_no ,
    		headers:{
    			"Content-Type":"application/json",
    			"X-HTTP-Method-Override":"PUT"
    		},
    		beforeSend : function(xhr)
            {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
    		data:JSON.stringify({
    			content: $content //수정할내용
    			
    		}),
    		dataType:'text',
    		success:function(result){
    			if(result == 'SUCCESS'){
    				alert('댓글이 수정되었습니다!');
    				$('#modDiv').hide('slow');
    				getAllList();//댓글 목록 함수 호출	
    			}
    		}
    	});
    });
    
    
    //댓글 삭제
    $('#replyDelBtn').on('click',function(){
    	var reply_no=$('.modal-title').html();//댓글 번호
    	
    	$.ajax({
    		type:'delete',//ReplyController.java에서 지정한 삭제 메서드 방식
    		url: '/replies/'+$reply_no ,//삭제url매핑 주소
    		headers:{
    			"Content-Type":"application/json",
    			"X-HTTP-Method-Override":"DELETE"
    		},
    		beforeSend : function(xhr)
            {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
    		dataType:'text',
    		success:function(data){
    			if(data =="SUCCESS"){
    				alert("댓글이 삭제되었습니다!");
    				$('#modDiv').hide('slow');//댓글 수정화면을 닫는다.
    				getAllList();//댓글 목록함수 호출
    			}
    		}
    		
    	});
    });
  </script>
<jsp:include page="../main/footer.jsp" flush="false" />