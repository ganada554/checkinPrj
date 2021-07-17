window.addEventListener("load", ()=>{
	
	let bookstore = document.querySelectorAll(".bookstore-card");
	let bookmarkCount = document.querySelector(".count").value;
	let valueArr = [];
	
	for(var i=0; i<bookmarkCount; i++) {
		
		valueArr.push(document.querySelectorAll(".bookmark")[i].value);
		let value = valueArr[i];
		
		bookstore[i].addEventListener("click", ()=>{
			console.log(value);
			location.href=`/bookstore/detail/${value}`;
		})
	}
	
});