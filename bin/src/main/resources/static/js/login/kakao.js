window.Kakao.init("41cefddc70d106e89cd2a27e1221cba6");
function kakaoLogin(){
	window.Kakao.Auth.login({
		scope: 'profile_nickname, profile_image, account_email',
		success: function(authObj) {
			console.log(authObj);
			window.Kakao.API.request({
				url:'/v2/user/me',
				success: res => {
					const kakao_account = res.kakao_account;
					let member ={
						email: kakao_account.email,
						profileImg: kakao_account.profile.profile_image_url,
						nickname: kakao_account.profile.nickname
					};
					
					console.log(kakao_account);
					fetch('api/login/kakao',{
						method: 'POST',
						headers: {
        				    'Content-Type': 'application/json'
    				    },
    				    body: JSON.stringify(member)
					})
					.then(response => response.text())
					.then(text => {
						console.log(text)
						location.href="/mypage"}); // 중괄호로 끝
				}
			});
		}			
	})
}