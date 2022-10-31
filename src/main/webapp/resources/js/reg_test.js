/**			
		    if(checkText != ""){
            $(this).siblings("p").html(checkText);
            $(this).siblings("p").addClass("vali");
            $(this).siblings("p").slideDown();
        } else {
            $(this).siblings("p").slideUp(function(){
                $(this).removeClass("vali");
 * 
 */


function check(){
		if($.trim($('#ck_title').val()) == ""){
			alert('요리제목을 입력해주세요!');
		}
		if($.trim($('#ck_cont').val()) == ""){
			alert('요리내용을 입력해주세요!');
		}
		if($.trim($('#ck_tag').val()) == ""){
			alert('태그를 입력해주세요!');
		}
		if($.trim($('#ck_ing').val()) == ""){
			alert('요리관한 재료를 입력해주세요!');
		}
		if($.trim($('#btnAtt').val()) == ""){
			alert('요리관한 사진을 올려주세요!');
		}
   }
        
        

                
    
