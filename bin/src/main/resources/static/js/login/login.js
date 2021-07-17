window.addEventListener("load", function(){
	let email = document.querySelector("input[name=email]");
	let pwd = document.querySelector("input[name=password]");
	let message = document.querySelectorAll(".error-message");
	let valid = message[0];
	let emailError = message[1];
	let pwdError = message[2]; 
	
	let pwdBtn = document.querySelector(".pwd-type")
	let btn = document.querySelector("input[type=submit]");
	
	let emailCheck = false;
	let pwdCheck = false;
	
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
			emailCheck = true;
			emailError.classList.add("d-none");
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
			pwd.focus(); // 화면 커서 이동
			pwdError.classList.add("animation");
			pwd.style.border = "2px solid red";
		} else{
			pwdCheck = true;
			pwdError.classList.add("d-none");
			pwd.style.border = "1px solid black";
		}
		
		
		validRemove();
	}

	pwdBtn.onmouseover = function(){
		pwd.type='text';
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
		if(emailCheck == true && pwdCheck == true){
			return true;			
		}
		valid.classList.remove("d-none");
		return false;
	}
	
})