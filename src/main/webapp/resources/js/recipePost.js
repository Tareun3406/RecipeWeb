window.onload = function (){
	add_textbox();
}

function onSubmitCheck(){
		if($.trim($('#ck_title').val()) == ""){
			alert('요리제목을 입력해주세요!');
			return false;
		}
		if($.trim($('#post_tag').val()) == ""){
			alert('태그를 입력해주세요!');
			return false;
		}
		if($.trim($('#ck_ing').val()) == ""){
			alert('요리관한 재료를 입력해주세요!');
			return false;
		}
   }

// 레시피 내용 추가
let num = 1;
const add_textbox = () => {
	const box = document.getElementById("box");
	const newP = document.createElement('p');
	newP.innerHTML = "<input type='file' name='recipeImgs[]'/>" +
		"<textarea style='margin: 5px;' rows='20' cols='60' name='recipeText[]' id='recipe" + num + "'></textarea>";
	box.appendChild(newP);
	num += 1;
}
const remove = () => {
	if(num > 2){
		num -= 1;
		let lastTextBox = 'recipe' + num;
		let obj = document.getElementById(lastTextBox);
		document.getElementById('box').removeChild(obj.parentNode);
	}
}


// 태그 관련
