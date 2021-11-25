
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
    var orderCount4= $('#3').attr("value");
        console.log(orderCount4);
    var orderCount5= $('#4').attr("value");
        console.log(orderCount5);

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
var ricePosition  = new kakao.maps.LatLng(35.153101, 129.058325);
var obackPosition  = new kakao.maps.LatLng(35.151950, 129.058617);

// 마커를 생성합니다
var obackMarker = new kakao.maps.Marker({
    position: obackPosition,
    image:greenMarkerImage
});
if(orderCount5 < 4){
var obackMarker = new kakao.maps.Marker({
    position: obackPosition,
    image:greenMarkerImage
    });
}
if(orderCount5 > 3 && orderCount5 < 7){
var obackMarker = new kakao.maps.Marker({
    position: obackPosition,
    image:blueMarkerImage
    });
}
if(orderCount5 > 6){
 var obackMarker = new kakao.maps.Marker({
     position: obackPosition,
     image:redMarkerImage
     });
 }

var riceMarker = new kakao.maps.Marker({
    position: ricePosition,
    image:greenMarkerImage
});
if(orderCount4 < 4){
var riceMarker = new kakao.maps.Marker({
    position: ricePosition,
    image:greenMarkerImage
    });
}
if(orderCount4 > 3 && orderCount4 < 7){
var riceMarker = new kakao.maps.Marker({
    position: ricePosition,
    image:blueMarkerImage
    });
}
if(orderCount4 > 6){
 var riceMarker = new kakao.maps.Marker({
     position: ricePosition,
     image:redMarkerImage
     });
 }
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
riceMarker.setMap(map);
obackMarker.setMap(map);

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
                   '                <img src="https://t1.daumcdn.net/cfile/tistory/990A0E465E006E6F19" width="73" height="70">' +
                   '           </div>' +
                   '            <div class="desc">' +
                   '                <div class="ellipsis">부산광역시 부산진구 부전2동 중앙대로 683</div>' +

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

                                                                   '            </div>' +
                                                                   '        </div>' +
                                                                   '    </div>' +
                                                                   '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
            momRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

            var riceContent = '<div class="wrap">' +
                                                                               '    <div class="info">' +
                                                                               '    <div class="info">' +
                                                                               '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=4" target="_blank" class="link">엽기떡볶이 서면점</a>  '+
                                                                               '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                               '        </div>' +
                                                                               '        <div class="body">' +
                                                                               '            <div class="img">' +
                                                                               '                <img src="data:image/jpeg;base64,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" width="73" height="70">' +
                                                                               '           </div>' +
                                                                               '            <div class="desc">' +
                                                                               '                <div class="ellipsis">부산광역시 부산진구 부전2동 신천대로62번길 51</div>' +

                                                                               '            </div>' +
                                                                               '        </div>' +
                                                                               '    </div>' +
                                                                               '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                       riceRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

                       var obackContent = '<div class="wrap">' +
                                                                                                      '    <div class="info">' +
                                                                                                      '    <div class="info">' +
                                                                                                      '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=5" target="_blank" class="link">오백당</a>  '+
                                                                                                      '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                                                      '        </div>' +
                                                                                                      '        <div class="body">' +
                                                                                                      '            <div class="img">' +
                                                                                                      '                <img src="https://mblogthumb-phinf.pstatic.net/MjAxOTA4MTNfMTky/MDAxNTY1Njc2MDk3Mjgw.UdaW1QEPignRhO34dGQcMSuhPpiESsP6YKqmzZrhDicg.0MwM6fBKx06ywm-3t7IDhoqvyaLgPD6lZz2h0__egx4g.JPEG.ghdwldus5555/IMG_7322.JPG?type=w800" width="73" height="70">' +
                                                                                                      '           </div>' +
                                                                                                      '            <div class="desc">' +
                                                                                                      '                <div class="ellipsis">부산광역시 부산진구 부전2동 신천대로62번길 28</div>' +

                                                                                                      '            </div>' +
                                                                                                      '        </div>' +
                                                                                                      '    </div>' +
                                                                                                      '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                              obackRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

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
var riceInfowindow = new kakao.maps.InfoWindow({
    content : riceContent,
    removable : riceRemoveable
});
var obackInfowindow = new kakao.maps.InfoWindow({
    content : obackContent,
    removable : obackRemoveable
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
kakao.maps.event.addListener(riceMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      riceInfowindow.open(map, riceMarker);
});
kakao.maps.event.addListener(obackMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      obackInfowindow.open(map, obackMarker);
});

};





function locationLoadError(pos){
    alert('위치 정보를 가져오는데 실패했습니다.');
};
function getMyPosition(){
    navigator.geolocation.getCurrentPosition(locationLoadSuccess,locationLoadError);
};

getMyPosition();







