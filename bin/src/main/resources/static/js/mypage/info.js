window.addEventListener("load", function() {
    let fileBtn = document.querySelector(".fake-btn");
    let realBtn = document.querySelector(".real-btn");
    let profileImg = document.querySelectorAll(".profile-img");
	let profileSection = document.querySelector(".profile-section");
	realBtn.oninput = function(e) { // 파일 등록버튼 선택
		let file = realBtn.files[0]; // 파일에 대한 정보만 가져온 상태
		if(file.type.indexOf("image/") < 0)
			alert("이미지 형식만 사용할 수 있습니다");
		
	
		// 선택된 파일을 메모리에 올릴 수 있음, 로컬에 파일 로드 가능
		// 웹(원격)이라는 브라우저는 로컬의 문서에 접근하지 못함
		var reader = new FileReader(); // 파일 읽어오기 가능, Reader 하나당 파일 하나 읽기 가능
		reader.onload = function(evt) { // 아직 원격에 올라간 거 아닌데도 웹에서 이미지 보기 가능
			console.log(evt.target);
		
			profileImg[0].src = evt.target.result; 
			profileImg[1].src = evt.target.result; 
			console.log(evt.target.result);	
		}
	
		reader.readAsDataURL(file); // 비동기로 읽어옴, 위 코드가 바로 진행되지 않게 onload 이벤트에 넣어주기	
	}
	

	// 버튼 클릭해서 업로드
	fileBtn.onclick = function(e) {
        var event = new MouseEvent("click", {
            'view': window,
            'bubbles': true, // 이벤트 버블링: true
            'cancelable': true
        });

       realBtn.dispatchEvent(event); // 이벤트 위임 - fileButton에게 이벤트가 발생했다고 알려주는 것: 트리거
    }


	/*---유효성 검사---*/
	let email = document.querySelector("input[name=email]");
	let pwd = document.querySelector("input[name=password]");
	let nick = document.querySelector("input[name=nickname]");
	let message = document.querySelectorAll(".error-message");
	let valid = message[0];
	let emailError = message[1];
	let pwdError = message[2]; 
	let nickError = document.querySelector(".nickname-message");
	
	let nickBtn = document.querySelector(".nick-type");
	let pwdBtn = document.querySelector(".pwd-type")
	let btn = document.querySelector("input[type=submit]");
	
	let emailCheck = true;	let pwdCheck = true; let nicknameCheck = true;
	
	// 이메일 에러 메시지
	email.onchange = function(){
		emailCheck = false;
		if(emailError.classList.contains("d-none")){
			emailError.classList.remove("d-none");
		}
		
		let emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(email.value.match(emailPattern) == null){
			email.focus(); // 화면 커서 이동
			emailError.classList.add("animation");
			email.style.border = "2px solid red";
		} else {
			emailError.classList.add("d-none");
			emailCheck = true;
			email.style.border = "1px solid black";
		}
		
		
		if(emailCheck && pwdCheck && nicknameCheck){
			valid.classList.add("d-none");
		}
		
		validRemove();
	}
	
	
	// 패스워드 에러 메시지	
	pwd.onchange = function(){
		pwdCheck = false;
		if(pwdError.classList.contains("d-none")){
			pwdError.classList.remove("d-none");
		}
		
		if(pwd.value.length < 4 || pwd.value.length > 20){
			pwdError.classList.add("animation");
			pwd.focus(); // 화면 커서 이동
			pwd.style.border = "2px solid red";
		} else{
			pwdError.classList.add("d-none");
			pwdCheck = true;
			pwd.style.border = "1px solid black";
		}
		
		validRemove();
	}
	
	

	//닉네임 에러 메시지
	nick.onchange = function(){
		nicknameCheck = false;
		
		nickBtn.onclick = function(){
			
			if(nickError.classList.contains("d-none")){
				nickError.classList.remove("d-none");
			}
			
			let nickValue = nick.value;
			let url = '/api/member/'+nickValue;
			console.log(`input: ${nickValue}, url: ${url}`)
			fetch(url)
	        .then(response=>{
	            return response.text(); // false or true
	        })
	        .then(result=>{
				console.log(result)
				
				//중복 체크
				if(result == "false"){
					nickError.classList.add("animation");
					nick.focus(); // 화면 커서 이동
					nick.style.border = "2px solid red";
					nickError.textContent = '중복 닉네임입니다';
				
				//빈 문자열 체크
				} else if(nickValue == ''){
					nickError.textContent = '닉네임을 입력해 주세요';
				
				//성공
				} else if(result == "true"){
					nickError.classList.remove("animation");
					nicknameCheck = true;
					nick.style.border = "1px solid black";
					nickError.textContent = '사용 가능한 닉네임입니다';
				}
			})
			
			validRemove();
			}
		}
	
	pwdBtn.onmouseover = function(){
		pwd.type='text';
		console.log(nicknameCheck);
		console.log(emailCheck);
		console.log(pwdCheck);
	}
	
	pwdBtn.onmouseleave = function(){
		pwd.type='password';
	}
	
	function validRemove(){
		if(emailCheck && pwdCheck && nicknameCheck){
			valid.classList.add("d-none");
		}
	}
	
	
	btn.onclick = function(){
		if(emailCheck && pwdCheck && nicknameCheck){
			return true;		
		}
		valid.classList.remove("d-none");
		return false;
	}
	
	
});