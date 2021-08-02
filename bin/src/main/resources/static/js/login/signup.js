window.addEventListener("load", function(){
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
	
	let emailCheck = false;	let pwdCheck = false; let nicknameCheck = false;

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
		}
		validRemove();
		
	
	}
	
	
	pwdBtn.onmouseover = function(){
		pwd.type='text';
		console.log(emailCheck);
		console.log(nicknameCheck);
		console.log(pwdCheck);
	}
	
	pwdBtn.onmouseleave = function(){
		pwd.type='password';
	}
	
	
	function validRemove(){
		if(emailCheck && pwdCheck){
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
	
	
	
})