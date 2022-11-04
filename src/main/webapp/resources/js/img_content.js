    let num = 1;
        const add_textbox = () => {
            const box = document.getElementById("box");
            const newP = document.createElement('p');  
            newP.innerHTML = "<input type='file'/><textarea type='text' style='height:30px; width:300px; margin: 0px 5px -13px 0px;' name='recipe" + num + "'></textarea><input type='button' id='btn_orange' value='삭제' onclick='remove(this)'>";
            box.appendChild(newP);
            num += 1;
        }
        const remove = (obj) => {
            document.getElementById('box').removeChild(obj.parentNode);
        }
