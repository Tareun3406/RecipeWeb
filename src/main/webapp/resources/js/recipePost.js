window.onload = function (){
	add_textbox();
	const inputPostTag = document.querySelector('input[name=post_tag]')
	let postTagTagify = new Tagify(inputPostTag,{
		originalInputValueFormat: valuesArr => valuesArr.map(item => item.value).join(',')
	});

	const ingredientTag = document.querySelector('input[name=ingredient]')
	let ingredientTagify= new Tagify(ingredientTag,{
		originalInputValueFormat: valuesArr => valuesArr.map(item => item.value).join(','),
		pattern: /[a-z|A-Z|0-9|가-힣]+:+[a-z|A-Z|0-9|가-힣]/
	});

	// 태그가 추가되면 이벤트 발생
		postTagTagify.on('add', function() {
		console.log(tagify.value); // 입력된 태그 정보 객체
	})
}

function onSubmitCheck(){
		if($.trim($('#ck_title').val()) == ""){
			alert('요리제목을 입력해주세요!');
			return false;
		}
		if(!$('#thumnail').val()) {
			alert("썸네일을 등록해주세요");
		return false;
		}
		if($.trim($('#post_tag').val()) == ""){
			alert('태그를 입력해주세요!');
			return false;
		}
		if(checkContent()){
			alert('요리 순서에 빈 곳이 없도록 해주세요(이미지 포함)')
			return false;
		}

		if($.trim($('#ck_ing').val()) == ""){
			alert('요리관한 재료를 입력해주세요!');
			return false;
		}

		function checkContent(){
			let fileId;
			let textId;
			for(let i = 0; i<num; i++){
				fileId = "recipeImgs["+i+"]";
				textId = "recipe["+i+"]";
				let file = document.getElementById(fileId);
				let text = document.getElementById(textId);
				if(!file.value) return true;
				if(text.value === "") return true;
			}
			return false;
		}
   }

// 레시피 내용 추가
let num = 0;
const add_textbox = () => {
	const box = document.getElementById("box");
	const newP = document.createElement('p');
	newP.innerHTML = "<input type='file' name='recipeImgs["+num+"]' id='recipeImgs["+num+"]' accept=\"image/*\"/>" +
		"<textarea style='margin: 5px;' rows='20' cols='60' name='recipeText["+num+"]' id='recipe[" + num + "]'></textarea>";
	box.appendChild(newP);
	num += 1;
}
const remove = () => {
	if(num > 1){
		num -= 1;
		let lastTextBox = 'recipe' + num;
		let obj = document.getElementById(lastTextBox);
		document.getElementById('box').removeChild(obj.parentNode);
	}
}


// 태그 관련
