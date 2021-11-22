
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
              center: new kakao.maps.LatLng(37.56646, 126.98121), // 지도의 중심좌표
              level: 3, // 지도의 확대 레벨
              mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
          };

      // 지도를 생성한다
      var map = new kakao.maps.Map(mapContainer, mapOption);











function locationLoadSuccess(pos){
    var orderCount1=2;
    var orderCount2=5;
    var orderCount3=8;

    var centerImageSrc = 'https://cdn-icons-png.flaticon.com/512/1673/1673221.png', // 마커이미지의 주소입니다
        centerImageSize = new kakao.maps.Size(35, 30) // 마커이미지의 크기입니다
    var redImageSrc = 'https://cdn.pixabay.com/photo/2013/07/13/11/42/map-158493__480.png', // 마커이미지의 주소입니다
        redImageSize = new kakao.maps.Size(35, 30) // 마커이미지의 크기입니다
    var blueImageSrc = 'https://cdn.pixabay.com/photo/2013/07/13/11/42/map-158492__480.png', // 마커이미지의 주소입니다
        blueImageSize = new kakao.maps.Size(35, 30) // 마커이미지의 크기입니다
    var greenImageSrc = 'https://cdn.pixabay.com/photo/2013/07/13/11/42/map-158494__480.png', // 마커이미지의 주소입니다
        greenImageSize = new kakao.maps.Size(35, 30) // 마커이미지의 크기입니다

    var shakeContent = '<div class="wrap">' +
                '    <div class="info">' +
                '        <div class="title">' +
                '            쉐이크쉑 서면점' +
                '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
                '        </div>' +
                '        <div class="body">' +
                '            <div class="img">' +
                            '                <img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F5uNRE%2FbtqzeKRRyzM%2FBMvgi2Qx3KWUzKgBjnIK80%2Fimg.jpg" width="73" height="70">' +
                            '           </div>' +
                '            <div class="desc">' +
                '                <div class="jibun ellipsis">부산광역시 부산진구 부전2동 중앙대로 672 삼정타워 1F</div>' +
                '                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">상세페이지</a></div>' +
                '            </div>' +
                '        </div>' +
                '    </div>' +
                '</div>';

                var macContent = '<div class="wrap">' +
                                '    <div class="info">' +
                                '        <div class="title">' +
                                '            노브랜드버거 서면점' +
                                '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
                                '        </div>' +
                                '        <div class="body">' +
                                '            <div class="img">' +
                                            '                <img src="http://newsroom.etomato.com/userfiles/%EB%85%B8%EB%B8%8C%EB%9E%9C%EB%93%9C%20%EB%B2%84%EA%B1%B0%20%EB%A1%9C%EA%B3%A0.jpg" width="73" height="70">' +
                                            '           </div>' +
                                '            <div class="desc">' +
                                '                <div class="jibun ellipsis">부산광역시 부산진구 부전동 중앙대로 681-1</div>' +
                                '                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">상세페이지</a></div>' +
                                '            </div>' +
                                '        </div>' +
                                '    </div>' +
                                '</div>';

                                var momContent = '<div class="wrap">' +
                                                '    <div class="info">' +
                                                '        <div class="title">' +
                                                '            맘스터치 서면점' +
                                                '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
                                                '        </div>' +
                                                '        <div class="body">' +
                                                '            <div class="img">' +
                                                            '                <img src="https://blog.kakaocdn.net/dn/LHPs0/btqwTxzowbo/eHnnBFUQ9CkPSEcRaDhq3k/img.jpg" width="73" height="70">' +
                                                            '           </div>' +
                                                '            <div class="desc">' +
                                                '                <div class="ellipsis">제주특별자치도 제주시 첨단로 242</div>' +
                                                '                <div class="jibun ellipsis">부산광역시 부산진구 부전2동 중앙대로 687</div>' +
                                                '                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">상세페이지</a></div>' +
                                                '            </div>' +
                                                '        </div>' +
                                                '    </div>' +
                                                '</div>';


    var centerMarkerImage = new kakao.maps.MarkerImage(centerImageSrc, centerImageSize),
     currentPos = new kakao.maps.LatLng(pos.coords.latitude,pos.coords.longitude);

     //색상별 마크 이미지, 사이즈 지정
     var redMarkerImage = new kakao.maps.MarkerImage(redImageSrc, redImageSize)
     var blueMarkerImage = new kakao.maps.MarkerImage(blueImageSrc, blueImageSize)
     var greenMarkerImage = new kakao.maps.MarkerImage(greenImageSrc, greenImageSize)

    // 지도 이동(기존 위치와 가깝다면 부드럽게 이동)
    map.panTo(currentPos);

    // 마커 생성
    var marker = new kakao.maps.Marker({
        position: currentPos,
        image:centerMarkerImage //마커이미지 설정
    });

// 마커가 표시될 위치입니다
var shakePosition  = new kakao.maps.LatLng(35.153103, 129.059581);
var macPosition  = new kakao.maps.LatLng(35.153693, 129.058895);
var momPosition  = new kakao.maps.LatLng(35.154078, 129.058898);

// 마커를 생성합니다
var shakeMarker = new kakao.maps.Marker({
    position: shakePosition,
    image:greenMarkerImage
});
if(orderCount3 > 5){
var shakeMarker = new kakao.maps.Marker({
    position: shakePosition,
    image:redMarkerImage
    });
}
console.log(shakeMarker);


var macMarker = new kakao.maps.Marker({
    position: macPosition,
    image:greenMarkerImage
});
var momMarker = new kakao.maps.Marker({
    position: momPosition,
    image:greenMarkerImage
});

// 마커가 지도 위에 표시되도록 설정합니다
shakeMarker.setMap(map);
macMarker.setMap(map);
momMarker.setMap(map);

    // 기존에 마커가 있다면 제거 후 생성 내위치 마커임 지우면 안댐
    marker.setMap(null);
    marker.setMap(map);

// 마커 위에 커스텀오버레이를 표시합니다
// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
var shakeOverlay = new kakao.maps.CustomOverlay({
    content: shakeContent,
    map: map,
    position: shakeMarker.getPosition()
});
var macOverlay = new kakao.maps.CustomOverlay({
    content: macContent,
    map: map,
    position: macMarker.getPosition()
});
var momOverlay = new kakao.maps.CustomOverlay({
       content: momContent,
       map: map,
       position: momMarker.getPosition()
   });
// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
    kakao.maps.event.addListener(shakeMarker, 'click', function() {
        shakeOverlay.setMap(map);
    });
    kakao.maps.event.addListener(macMarker, 'click', function() {
            macOverlay.setMap(map);
        });
        kakao.maps.event.addListener(momMarker, 'click', function() {
                momOverlay.setMap(map);
            });
            console.log();


// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
function closeOverlay() {
    shakeOverlay.setMap(null);
    macOverlay.setMap(null);
    momOverlay.setMap(null);
}

};





function locationLoadError(pos){
    alert('위치 정보를 가져오는데 실패했습니다.');
};
function getMyPosition(){
    navigator.geolocation.getCurrentPosition(locationLoadSuccess,locationLoadError);
};

getMyPosition();







