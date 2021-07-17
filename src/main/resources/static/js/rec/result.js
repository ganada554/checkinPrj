



window.addEventListener("load", function() {

	let subBtn = document.querySelector(".subBtn");

	subBtn.onclick = function(e) {
		e.preventDefault();
		
		let q = document.querySelector("input[name='q']").value;
		let fSelect = document.querySelector("select[name='f']");
		let f = fSelect.options[fSelect.selectedIndex].value;

		console.log(q)
		console.log(f)

		let url = 'http://localhost:8080/api/rec/result/' + f + "/" + encodeURIComponent(q);

		console.log(url)
		
		
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

				for (let i = 0; i < store.length; i++) {
					let content = `<section id="bookstore">
					        <div>
					            <div>
					                <img src="/images/bs.jpg">
					            </div>
					            <div class="bsInfo">
					                <span>${store[i].name}</span>
					                <span>#해시태그</span>
					                <span>${store[i].address}</span>
					            </div>
					        </div>
					    </section>`

					let d1 = document.getElementById('search');
					d1.insertAdjacentHTML('afterend', content);

				}

			} catch (error) {
				console.log(error);
			}


		})();



	}
})