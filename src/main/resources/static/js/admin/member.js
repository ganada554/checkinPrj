window.addEventListener("load", function(){
	let assignBtn = document.querySelectorAll(".assign-btn");
	
	
	for(var i = 0; i<assignBtn.length; i++) {
		assignBtn[i].addEventListener("click", (e)=>{
				assignList = e.target.parentNode.querySelector(".assign-list");
				if(assignList.classList.contains("d-none")){
					assignList.classList.replace("d-none", "animation");
				} else {
					assignList.classList.replace("animation", "d-none");
				}	
		})
	}
	
	/*
	let bye = document.querySelector("bye-btn");
	
	bye.addEventListener("click", function(e){
		e.preventDefault()
		return confirm('정말 탈퇴하시겠습니까?');
	})
	*/
})