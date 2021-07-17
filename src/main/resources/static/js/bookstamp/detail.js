window.addEventListener("load", function() {
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 5 // 지도의 확대 레벨 
	    }; 

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		
	// *------ 지도에 서점 나타내기 ------*
	// 1. 서점 정보 얻어내기		
	function getBookstores() {
		const response = fetch("http://localhost:8080/api/bookstore/list");
		return response
		.then(res => 
			res.json())
		.then(bookstore => {
			var list = bookstore.list;
			return list;			
		})
	}
	
	// 2. 마커를 표시할 title과 위치 객체 배열
	var bookstores = new Array();
	
	// 마커 이미지의 이미지 주소
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	
	(async() => {
		try {
		    var list = await getBookstores();
		    
			for(var i=0; i<list.length; i++) {
				
				var bookstoreJson = new Object();
				
				bookstoreJson.title = list[i].name;
				bookstoreJson.latlng = new kakao.maps.LatLng(list[i].latitude, list[i].longitude);
				
				bookstores.push(bookstoreJson);	
			}
			
			// 3. 마커 이미지 표시하기
			for (var i = 0; i < bookstores.length; i++) {
    
			    // 마커 이미지의 이미지 크기 입니다
			    var imageSize = new kakao.maps.Size(24, 35); 
			    
			    // 마커 이미지를 생성합니다    
			    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			    
			    // 마커를 생성합니다
			    var marker = new kakao.maps.Marker({
			        map: map, // 마커를 표시할 지도
			        position: bookstores[i].latlng, // 마커를 표시할 위치
			        title : bookstores[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
			        image : markerImage // 마커 이미지 
			    });
				            
				let url = "https://map.kakao.com/link/map/" + list[i].name + ',' + list[i].latitude + ',' + list[i].longitude; 
				            
				// 커스텀 오버레이에 표시할 컨텐츠
				let content = `<div class="wrap">
				                <div class="info">
				                    <div class="title">
				            			 ${list[i].name}  
				                        <div class="close" title="닫기"></div>
				                    </div>
				                    <div class="body"> 
				                        <div class="img">
				                            <img src="${list[i].bgImg}" width="53" height="51">
				                       </div> 
				                       <div class="desc">
				                            <div class="ellipsis">
				            					<a href="${url}" target="_blank">${list[i].address}</a>
				            				 </div>
				            				 <div>
				            				 	<a href="${list[i].instagramUrl}" target="_blank" class="link">Instagram에 방문해보세요!</a>
				            				 </div>
				                        </div>
				                    </div>
				                </div>  
				            </div>`;
		
				// 마커 클릭 시 커스텀 오버레이 표시
				(function(marker, bookstore) {
					kakao.maps.event.addListener(marker, 'click', function() {
						var overlay = new kakao.maps.CustomOverlay({
						    content: content,
						    map: map,
						    position: marker.getPosition()
						});
						
						// X 버튼 클릭 시 커스텀 오버레이 닫기
						let closeBtn = document.querySelector(".close");
						closeBtn.onclick = function() {
							overlay.setMap(null);     
						}
					});
				})(marker, bookstores[i]);
				
			}
		}
		catch(error){
		    console.log(error);
		}
	})();
		

	// *------ 구 위치 나타내기 ------*
	// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
    let input = document.querySelectorAll("input[type=hidden]")
	let latitude = input[0].value
	let longitude = input[1].value

	console.log(latitude, longitude);



	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	       
	        var locPosition = new kakao.maps.LatLng(latitude, longitude), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px; font-size: 12px; font-weight: normal;">독립서점을 찾아보세요!</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        displayMarker(locPosition, message);
	            
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
	    
	    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
	        message = 'geolocation을 사용할 수 없어요..!'
	        
	    displayMarker(locPosition, message);
	}
	
	// 지도에 마커와 인포윈도우를 표시하는 함수
	function displayMarker(locPosition, message) {
	
	    // 마커를 생성합니다
	    var marker = new kakao.maps.Marker({  
	        map: map, 
	        position: locPosition
	    }); 
	    
	    var iwContent = message, // 인포윈도우에 표시할 내용
	        iwRemoveable = true;
	
	    // 인포윈도우를 생성합니다
	    var infowindow = new kakao.maps.InfoWindow({
	        content : iwContent,
	        removable : iwRemoveable
	    });
	    
	    // 인포윈도우를 마커위에 표시합니다 
	    infowindow.open(map, marker);
	    
	    // 지도 중심좌표를 접속위치로 변경합니다
	    map.setCenter(locPosition);      
	}   

});