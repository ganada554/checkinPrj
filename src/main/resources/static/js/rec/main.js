/**
 * li도 div감싸면 안됨
 *span -> 모양 css에서 블럭타입
 *ul li> div , onClick
 */

window.addEventListener("load", function() {

	let subBtn = document.querySelector(".subBtn");
	let content = document.querySelector("#content")

	subBtn.onclick = function(e) {
		e.preventDefault();

		let q = document.querySelector("input[name='q']").value;
		let fSelect = document.querySelector("select[name='f']");
		let f = fSelect.options[fSelect.selectedIndex].value;

		console.log(q)
		console.log(f)

		//쿼리문을 받는 거면 url를 굳이 fetch에 넣는 URL을 RestAPI로 하면 안된다. 
		//recommends?f=&q=
		//#은 인코딩 안해주면 안된다.. 
		let url = `http://localhost:8080/api/recommend/list/?f=${f}&q=` + encodeURIComponent(q);

		function showResult() {
			const response = fetch(url);
			console.log(url)
			return response
				.then(res =>
					res.json())
				.then(bookstore => {
					let store = bookstore.list;
					return store;
				})
		}
		

		(async () => {
			try {
				let store = await showResult();
				console.log(store)
				let resultContent = ""; //결과가 여러개니까 전의 결과에 + 해서 연결. 배열로 하면 , 이 나온다
				
				for (let i = 0; i < store.length; i++) {
					
					if(store[i].bgImg==null){
						store[i].bgImg = "/images/location.png";
					}
					
					resultContent = resultContent + `<section id="bookstore">
					        <div onclick="window.location.href='/bookstore/detail/${store[i].id}'">
					            <div class="H180">
					                <img src="${store[i].bgImg}">
					            </div>
					            <div class="BS">
					                <span class="title">${store[i].name}</span>
					                <div class="hashtag">
					                	<img src='/images/hashtag.png'>
						                <span>${store[i].hashtagName}</span>
					                </div>
					                <div class="address">
						                <img src='/images/clock.png'>
						                <span class="truncate">${store[i].address}</span>
					                </div>
					            </div>
					        </div>
					    </section>`;
				}
				content.innerHTML = resultContent;

			} catch (error) {
				console.log(error);
			}


		})();



	}

})






window.addEventListener("load", function() { //책방 선택시 디테일 페이지로 이동
	let divs = document.querySelectorAll('.bookstore');

	for (const div of divs) {
		div.onclick = function(e) {
			e.preventDefault();

			if (!e.currentTarget.classList.contains("bookstore")) {
				return;
			}
			console.log(e.currentTarget);

			let bsName = e.currentTarget.querySelector("span").innerText;
			console.log(bsName);

			/*let link = `서점디테일페이지?id=${id}`;
			location.href = link;*/

		}

	}


});


/* 
window.addEventListener("load", function(){
		let siled = document.querySelector('.slides');
		let slides = document.querySelectorAll('.sildes li');
		let currentIdx = 0;
		let slideCount = slide.length;
		let preBtn = document.querySelector('.prev');
		let nextBtn = document.querySelector('.next');
		let recTitles = document.querySelectorAll('.recTitle');
		
		let recTitle1 = recTitles[0];
		let recTitle2 = recTitles[1];
		let recTitle3 = recTitles[2];
	
	
	
});
 */


window.addEventListener("load", function() {

	let section = document.querySelector("form");
	let selectBox = section.querySelector("select[name='h']");
	let inputBox = section.querySelector("input[name='q']");
	let fieldBox = section.querySelector("select[name='f']");




	selectBox.onclick = function(e) {
		e.preventDefault();
		console.log("ok");

		let selectValue = e.target.value; //선택한 옵션값의 value값
		console.log(selectValue);

		let selectText = selectBox.querySelector(`option[value='${selectValue}']`).innerText;
		//value값으로 옵션의 innerText 찾기
		console.log(selectText);

		inputBox.setAttribute('value', selectText); //검색창 value에 옵션 text 넣기

	}

})

