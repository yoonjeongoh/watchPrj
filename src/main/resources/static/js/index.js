var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
              center: new kakao.maps.LatLng(37.56646, 126.98121), // 지도의 중심좌표
              level: 4, // 지도의 확대 레벨
              mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
          };

      // 지도를 생성한다
      var map = new kakao.maps.Map(mapContainer, mapOption);

function locationLoadSuccess(pos){

var blackImageSrc = 'https://e7.pngegg.com/pngimages/417/307/png-clipart-computer-icons-google-map-maker-map-marker-angle-black-thumbnail.png', // 마커이미지의 주소입니다
    blackImageSize = new kakao.maps.Size(40, 35), // 마커이미지의 크기입니다
    blackImageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

    // 현재 위치 받아오기
    var blackMarkerImage = new kakao.maps.MarkerImage(blackImageSrc, blackImageSize, blackImageOption),
     currentPos = new kakao.maps.LatLng(pos.coords.latitude,pos.coords.longitude);

    // 지도 이동(기존 위치와 가깝다면 부드럽게 이동)
    map.panTo(currentPos);

    // 마커 생성
    var marker = new kakao.maps.Marker({

        position: currentPos,
        image:blackMarkerImage //마커이미지 설정

    });

    // 기존에 마커가 있다면 제거
    marker.setMap(null);
    marker.setMap(map);
};

function locationLoadError(pos){
    alert('위치 정보를 가져오는데 실패했습니다.');
};
function getMyPosition(){
    navigator.geolocation.getCurrentPosition(locationLoadSuccess,locationLoadError);
};

getMyPosition();






// 마커가 표시될 위치입니다
var subPosition = new kakao.maps.LatLng(33.450701, 126.570667); // 마커가 표시될 위치입니다
var shakePosition  = new kakao.maps.LatLng(35.153103, 129.059581);
var macPosition  = new kakao.maps.LatLng(35.153693, 129.058895);
var momPosition  = new kakao.maps.LatLng(35.154078, 129.058898);

// 마커를 생성합니다
var subMarker = new kakao.maps.Marker({
    position: subPosition
});
var shakeMarker = new kakao.maps.Marker({
    position: shakePosition
});
var macMarker = new kakao.maps.Marker({
    position: macPosition
});
var momMarker = new kakao.maps.Marker({
    position: momPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
subMarker.setMap(map);
shakeMarker.setMap(map);
macMarker.setMap(map);
momMarker.setMap(map);

