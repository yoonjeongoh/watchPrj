
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







