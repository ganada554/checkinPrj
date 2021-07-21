window.addEventListener("load", function(){
	let copyBtn = document.querySelector(".copy-email");
	let	copy = document.querySelector(".copy");
	let logout = document.querySelector(".logout");
	
	copyBtn.onclick = function(){
		copy.select();
		document.execCommand("copy");
		alert("관리자 이메일이 클립보드에 복사되었습니다");
	}
	
	logout.addEventListener("click", ()=>{
		var accessToken = Kakao.Auth.getAccessToken();
		Kakao.API.request({
			url: "/v1/user/unlink"
		});
	})
})