window.addEventListener("load", function() {
	
	let reviewContainer = document.querySelector(".review-container");
	
	reviewContainer.onclick = function(e) {
		
		let like = e.target;
		
		if(!like.classList.contains("like"))
			return;
			
		if(!like.classList.contains("likeAdded")) {
			let formData = new FormData(like.parentElement);
			
			let request = new XMLHttpRequest();
			request.onload = function(e) {
				like.src="/images/thumb-up.png";
				like.classList.add("likeAdded");
			};
			request.open("POST", "/review/like", true);
			request.send(formData);
		} else {
			let formData = new FormData(like.parentElement);
			
			let request = new XMLHttpRequest();
			request.onload = function(e) {
				like.src="/images/like.png";
								
				like.classList.remove("likeAdded");
			};
			request.open("POST", "/review/like/del", true);
			request.send(formData);
		}	
		
	}
	
});