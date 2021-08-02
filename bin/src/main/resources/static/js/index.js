window.addEventListener("load", ()=>{
	
	let bookstore = document.querySelector(".bookstore-card")
	let id = document.querySelector("input[type=hidden]").value;
	
	bookstore.addEventListener("click", ()=>{
		location.href=`/bookstore/detail/${id}`;
	})
	
	let review = document.querySelector(".review-card");
	review.addEventListener("click", (e)=>{
		
		location.href='/review/list';
	})
	
})