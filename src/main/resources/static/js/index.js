
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
              center: new kakao.maps.LatLng(37.56646, 126.98121), // 지도의 중심좌표
              level: 3, // 지도의 확대 레벨
              mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
          };

      // 지도를 생성한다
      var map = new kakao.maps.Map(mapContainer, mapOption);











function locationLoadSuccess(pos){
    var orderCount1 = $('#0').attr("value");
    console.log(orderCount1);
    var orderCount2= $('#1').attr("value");
    console.log(orderCount2);
    var orderCount3= $('#2').attr("value");
    console.log(orderCount3);

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
if(orderCount1 < 4){
var shakeMarker = new kakao.maps.Marker({
    position: shakePosition,
    image:greenMarkerImage
    });
}
if(orderCount1 > 3 && orderCount1 < 7){
var shakeMarker = new kakao.maps.Marker({
    position: shakePosition,
    image:blueMarkerImage
    });
}
if(orderCount1 > 6){
 var shakeMarker = new kakao.maps.Marker({
     position: shakePosition,
     image:redMarkerImage
     });
 }


var macMarker = new kakao.maps.Marker({
    position: macPosition,
    image:greenMarkerImage
});
if(orderCount2 < 4){
var macMarker = new kakao.maps.Marker({
    position: macPosition,
    image:greenMarkerImage
    });
}
if(orderCount2 > 3 && orderCount2 < 7){
var macMarker = new kakao.maps.Marker({
    position: macPosition,
    image:blueMarkerImage
    });
}
if(orderCount2 > 6){
 var macMarker = new kakao.maps.Marker({
     position: macPosition,
     image:redMarkerImage
     });
 }
var momMarker = new kakao.maps.Marker({
    position: momPosition,
    image:greenMarkerImage
});
if(orderCount3 < 4){
var momMarker = new kakao.maps.Marker({
    position: momPosition,
    image:greenMarkerImage
    });
}
if(orderCount3 > 3 && orderCount3 < 7){
var momMarker = new kakao.maps.Marker({
    position: momPosition,
    image:blueMarkerImage
    });
}
if(orderCount3 > 6){
 var momMarker = new kakao.maps.Marker({
     position: momPosition,
     image:redMarkerImage
     });
 }


// 마커가 지도 위에 표시되도록 설정합니다
shakeMarker.setMap(map);
macMarker.setMap(map);
momMarker.setMap(map);

    // 기존에 마커가 있다면 제거 후 생성 내위치 마커임 지우면 안댐
    marker.setMap(null);
    marker.setMap(map);

// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
var macContent = '<div class="wrap">' +
                   '<div class="info">' +
                   '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=2" target="_blank" class="link">노브랜드버거 서면점</a>  ' +
                   '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                   '        </div>' +
                   '        <div class="body">' +
                   '            <div class="img">' +
                   '                <img src="https://lh3.googleusercontent.com/proxy/4fmd5t0nG3XDBZ8qth-lBbs_q_7PZtSPXy1TGUM82YaPrA_u5g64xPuJ-vGeR1SArGZIIQhExP8_udUHiO6yjzptLAlQxyT2BIJuEuYVnuMQ8DNx_tgOsbTAddRUusA3nPUqRshnvRW-fqtiirjnQo9JXfZv63lLXNxYkd1oaWHf790gDZ-6FxS7JG-weo91zUXOBfMEKg6b5HkP4sueOL07hq3rqwmOXzKQynO30Zy-zoRKwXMQ_wzpmFVrz6iE1fE5Jg" width="73" height="70">' +
                   '           </div>' +
                   '            <div class="desc">' +
                   '                <div class="ellipsis">부산광역시 부산진구 부전2동 중앙대로 683</div>' +
                   '                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">상세페이지</a></div>' +
                   '            </div>' +
                   '        </div>' +
                   '    </div>' +
                   '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    macRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

    var shakeContent = '<div class="wrap">' +
                                          '    <div class="info">' +
                                          '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=1" target="_blank" class="link">쉐이크쉑 서면점</a>  ' +
                                          '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                          '        </div>' +
                                          '        <div class="body">' +
                                          '            <div class="img">' +
                                          '                <img src="https://lh3.googleusercontent.com/-v6SRSsAiXis/VqknYmJmoBI/AAAAAAAAAAU/44bXdE-beLE/s1600/Shack_Logo_Neutra2_620.jpg" width="73" height="70">' +
                                          '           </div>' +
                                          '            <div class="desc">' +
                                          '                <div class="ellipsis">부산광역시 부산진구 부전2동 중앙대로 672 삼정타워 1F</div>' +
                                          '            </div>' +
                                          '        </div>' +
                                          '    </div>' +
                                          '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        shakeRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

        var momContent = '<div class="wrap">' +
                                                                   '    <div class="info">' +
                                                                   '    <div class="info">' +
                                                                   '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=3" target="_blank" class="link">맘스터치 서면점</a>  ' +
                                                                   '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                   '        </div>' +
                                                                   '        <div class="body">' +
                                                                   '            <div class="img">' +
                                                                   '                <img src="https://blog.kakaocdn.net/dn/LHPs0/btqwTxzowbo/eHnnBFUQ9CkPSEcRaDhq3k/img.jpg" width="73" height="70">' +
                                                                   '           </div>' +
                                                                   '            <div class="desc">' +
                                                                   '                <div class="ellipsis">부산광역시 부산진구 부전2동 중앙대로 687</div>' +
                                                                   '                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">상세페이지</a></div>' +
                                                                   '            </div>' +
                                                                   '        </div>' +
                                                                   '    </div>' +
                                                                   '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
            momRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// 인포윈도우를 생성합니다
var macInfowindow = new kakao.maps.InfoWindow({
    content : macContent,
    removable : macRemoveable
});
var shakeInfowindow = new kakao.maps.InfoWindow({
    content : shakeContent,
    removable : shakeRemoveable
});
var momInfowindow = new kakao.maps.InfoWindow({
    content : momContent,
    removable : momRemoveable
});

// 마커에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(macMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      macInfowindow.open(map, macMarker);
});
kakao.maps.event.addListener(shakeMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      shakeInfowindow.open(map, shakeMarker);
});
kakao.maps.event.addListener(momMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      momInfowindow.open(map, momMarker);
});

};





function locationLoadError(pos){
    alert('위치 정보를 가져오는데 실패했습니다.');
};
function getMyPosition(){
    navigator.geolocation.getCurrentPosition(locationLoadSuccess,locationLoadError);
};

getMyPosition();







