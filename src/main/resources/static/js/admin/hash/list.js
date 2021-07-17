


window.addEventListener("load", function() {
	let addBtn = document.querySelector(".addBtn");
	let delBtn = document.querySelector(".delBtn");
	let xBtn = document.querySelectorAll(".img");
	
	let selected = null; //버튼 중 하나만 눌리게 하려면 사용
	
	addBtn.onclick = function(e) {
		e.preventDefault();

		if (selected != e.target && selected != null) {
			selected.classList.remove("selected");
		}

		selected = e.target;
		console.log(selected)
		selected.classList.toggle("selected");

		let sibling = e.target.parentElement.nextElementSibling;
		sibling.classList.toggle("d-none");

	}


	delBtn.onclick = function() {
		
		delBtn.classList.toggle("selected");
		
		for(let i=0; i<xBtn.length; i++){ //모든 해시태그 카드에 X버튼 할당
			xBtn[i].classList.toggle("d-none");
			console.log(xBtn[i])
		}
		
	}
	
	

	
})

