window.addEventListener("load", function() {
	let img = document.querySelector(".img-upload-box>img");
    let selButton = document.querySelector(".btn-sel");
    let fileButton = document.querySelector(".btn-file");
    let hashtag = document.querySelector(".hashtag");
    let hashtagList = hashtag.querySelector(".hashtag-list");
    let rating = document.querySelector(".rating");
	let ratingList = rating.querySelector(".rating-list");
	let hselected = null;
	let rselected = null;
	let submitBtn = document.querySelector(".review-submit-btn");

	
	fileButton.oninput = function(e) { // 파일 등록버튼 선택
		let file = fileButton.files[0]; // 파일에 대한 정보만 가져온 상태
		if(file.type.indexOf("image/") < 0)
			alert("이미지 형식만 사용할 수 있습니다");
		console.log(file);
			
		// 선택된 파일을 메모리에 올릴 수 있음, 로컬에 파일 로드 가능
		// 웹(원격)이라는 브라우저는 로컬의 문서에 접근하지 못함
		var reader = new FileReader(); // 파일 읽어오기 가능, Reader 하나당 파일 하나 읽기 가능
		reader.onload = function(evt) { // 아직 원격에 올라간 거 아닌데도 웹에서 이미지 보기 가능
			/*let img = document.createElement("img");*/
			img.style.width = "100%";
			img.style.height = "200px";
			img.style.borderRadius = "10px";
			img.src = evt.target.result; 
			console.log(evt.target.result);	
			/*uploadBox.insertAdjacentElement("afterbegin", img);*/
		}
	
		reader.readAsDataURL(file); // 비동기로 읽어옴, 위 코드가 바로 진행되지 않게 onload 이벤트에 넣어주기	
	}
	
	// 버튼 클릭해서 업로드
	selButton.onclick = function(e) {
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true, // 이벤트 버블링: true
            'cancelable': true
        });

       fileButton.dispatchEvent(event); // 이벤트 위임 - fileButton에게 이벤트가 발생했다고 알려주는 것: 트리거
    }
    
    
    // 해시태그 버튼 클릭 시 스타일 주기
    hashtag.onclick = function(e) {
		if(e.target.tagName != "SPAN") // tag name 대문자로 적기
			return;	
        
    	if(hselected != null && hselected != e.target) {
            hselected.classList.remove("selected");
            hselected.nextElementSibling.removeAttribute('name', "hashtag");
		}
                    
        hselected = e.target;
        hselected.classList.toggle("selected");  
        console.log(hselected.nextElementSibling);	
        	
        // selected된 input의 name값 지정	
		hselected.nextElementSibling.setAttribute('name', "hashtag");
		
	}
    
	rating.onclick = function(e) {
		if(e.target.tagName != "SPAN") 
			return;	
            
    	if(rselected != null && rselected != e.target) {
            rselected.classList.remove("selected");
			rselected.nextElementSibling.removeAttribute('name', "hashtag");	
		}
        
        rselected = e.target;
        rselected.classList.toggle("selected");
        
        // selected된 input의 name값 지정	
		rselected.nextElementSibling.setAttribute('name', "rating");
	}
	
	submitBtn.onclick = function(e) {
		let formData = new FormData(document.getElementById('form-content'));
		
		let request = new XMLHttpRequest();
		request.onload = function(e) {
			location.href = "list";
		};
		request.open("POST", "/review/reg", true);
		request.send(formData);
	}
	
});