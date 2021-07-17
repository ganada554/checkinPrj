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
					console.log(kakao_account);
				}
			});
		}			
	})
}

