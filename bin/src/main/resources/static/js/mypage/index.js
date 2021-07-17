window.addEventListener("load", function(){
	let copyBtn = document.querySelector(".copy-email");
	let	copy = document.querySelector(".copy");
	

	copyBtn.onclick = function(){
		copy.select();
		document.execCommand("copy");
		alert("관리자 이메일이 클립보드에 복사되었습니다");
	}
	
})