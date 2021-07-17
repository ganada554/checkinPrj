window.addEventListener("load", function(){
	let myHashBtn = document.querySelector(".my-hash-btn");
	let hashBtn = document.querySelector(".hash-btn");
	let myHash = document.querySelector(".my-hash");
	let hash = document.querySelector(".hash");
	const selected = new Set();
	
	let mylovehash = document.querySelector(".mylovehash-board");
	let color = document.querySelectorAll(".color-box");
	let colorCount = document.querySelectorAll(".box-count");
	let entireCount = 0;
	let pk = 0;
	let million = 0;
	let afterCount = 0;
	
	for(var i of colorCount){
		let entire = parseInt(i.textContent);
		entireCount = entireCount + entire;
		console.log("entireCount" + entireCount)
	}
	setTimeout(function() {
		for(var e of colorCount){
			if(pk>0){
				let afterafterCount = (e.textContent / afterCount) * 100;
				color[pk].style.width = afterafterCount+'%';
						color[pk].style.backgroundColor = '#ba6b6c';
			} else if(pk==0){
			color[pk].style.width = '95%';
			color[pk].style.backgroundColor = '#26a69a';
			afterCount = e.textContent;
			}
			pk++;
		}
	}, 100);
	
		
	myHashBtn.addEventListener("click", function(){
		hash.classList.remove("d-none");
		myHash.classList.add("d-none");
			
		let selectedId = document.querySelectorAll(".selected");
		for(let j = 0; j < selectedId.length; j++){
			let selectedValue = selectedId[j].nextElementSibling.value;
			selected.add(selectedValue);
		}
	})
	
	hashBtn.addEventListener("click", function(){
		
		let selectArray = Array.from(selected);
		console.log(selectArray);
		let data = {
			"selected" : selectArray
		}
 		$.ajax({
            url         :   '/api/hashUpdate',
            type        :   "post",
            dataType    :   "json",
            contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
            data        :   data,
            success     :   function(result){console.log(result)}
        });
        
        setTimeout(function() {
			location.href = location.href;
		}, 300);
        
	})
	
	hash.addEventListener("click", (e)=>{
		if(!e.target.classList.contains("hash-edit-list")){
			return;
		}
		
		if(selected.size > 2 && !e.target.classList.contains("selected")){
			alert("3개까지만 선택 가능합니다");
			return;
		}
		
		let hashId = e.target.nextElementSibling.value;
		console.log(hashId);
		if(!e.target.classList.contains("selected")){
			e.target.classList.add("selected");
			selected.add(hashId);
		} else {
			e.target.classList.remove("selected");
			for(let i of selected) {
			  if(i === hashId)  {
			    selected.delete(hashId);
			  }
			}
		}
	})
	
})