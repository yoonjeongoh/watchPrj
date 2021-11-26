
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
    var orderCount2 = $('#1').attr("value");
    var orderCount3 = $('#2').attr("value");
    var orderCount4 = $('#3').attr("value");
    var orderCount5 = $('#4').attr("value");
    var orderCount6 = $('#5').attr("value");
    var orderCount7 = $('#6').attr("value");
    var orderCount8 = $('#7').attr("value");
    var orderCount9 = $('#8').attr("value");
    var orderCount10 = $('#9').attr("value");
    var orderCount11 = $('#10').attr("value");

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
var ricePosition  = new kakao.maps.LatLng(35.152721, 129.058867);
var obackPosition  = new kakao.maps.LatLng(35.151950, 129.058617);
var gobongPosition  = new kakao.maps.LatLng(35.152414, 129.059606);
var sigolPosition  = new kakao.maps.LatLng(35.152275, 129.057613);
var issuePosition  = new kakao.maps.LatLng(35.152817, 129.058326);
var subPosition  = new kakao.maps.LatLng(35.154147, 129.059392);
var angelPosition  = new kakao.maps.LatLng(35.152927, 129.058844);
var kfcPosition  = new kakao.maps.LatLng(35.153554, 129.058893);



// 마커를 생성합니다
var kfcMarker = new kakao.maps.Marker({
    position: kfcPosition,
    image:greenMarkerImage
});
if(orderCount11 < 4){
var kfcMarker = new kakao.maps.Marker({
    position: kfcPosition,
    image:greenMarkerImage
    });
}
if(orderCount11 > 3 && orderCount11 < 7){
var kfcMarker = new kakao.maps.Marker({
    position: kfcPosition,
    image:blueMarkerImage
    });
}
if(orderCount11 > 6){
 var kfcMarker = new kakao.maps.Marker({
     position: kfcPosition,
     image:redMarkerImage
     });
 }


var angelMarker = new kakao.maps.Marker({
    position: angelPosition,
    image:greenMarkerImage
});
if(orderCount10 < 4){
var angelMarker = new kakao.maps.Marker({
    position: angelPosition,
    image:greenMarkerImage
    });
}
if(orderCount10 > 3 && orderCount10 < 7){
var angelMarker = new kakao.maps.Marker({
    position: angelPosition,
    image:blueMarkerImage
    });
}
if(orderCount10 > 6){
 var angelMarker = new kakao.maps.Marker({
     position: angelPosition,
     image:redMarkerImage
     });
 }


var subMarker = new kakao.maps.Marker({
    position: subPosition,
    image:greenMarkerImage
});
if(orderCount9 < 4){
var subMarker = new kakao.maps.Marker({
    position: subPosition,
    image:greenMarkerImage
    });
}
if(orderCount9 > 3 && orderCount9 < 7){
var subMarker = new kakao.maps.Marker({
    position: subPosition,
    image:blueMarkerImage
    });
}
if(orderCount9 > 6){
 var subMarker = new kakao.maps.Marker({
     position: subPosition,
     image:redMarkerImage
     });
 }


var issueMarker = new kakao.maps.Marker({
    position: issuePosition,
    image:greenMarkerImage
});
if(orderCount8 < 4){
var issueMarker = new kakao.maps.Marker({
    position: issuePosition,
    image:greenMarkerImage
    });
}
if(orderCount8 > 3 && orderCount8 < 7){
var issueMarker = new kakao.maps.Marker({
    position: issuePosition,
    image:blueMarkerImage
    });
}
if(orderCount8 > 6){
 var issueMarker = new kakao.maps.Marker({
     position: issuePosition,
     image:redMarkerImage
     });
 }


var sigolMarker = new kakao.maps.Marker({
    position: sigolPosition,
    image:greenMarkerImage
});
if(orderCount7 < 4){
var sigolMarker = new kakao.maps.Marker({
    position: sigolPosition,
    image:greenMarkerImage
    });
}
if(orderCount7 > 3 && orderCount7 < 7){
var sigolMarker = new kakao.maps.Marker({
    position: sigolPosition,
    image:blueMarkerImage
    });
}
if(orderCount7 > 6){
 var sigolMarker = new kakao.maps.Marker({
     position: sigolPosition,
     image:redMarkerImage
     });
 }


var gobongMarker = new kakao.maps.Marker({
    position: gobongPosition,
    image:greenMarkerImage
});
if(orderCount6 < 4){
var obackMarker = new kakao.maps.Marker({
    position: gobongPosition,
    image:greenMarkerImage
    });
}
if(orderCount6 > 3 && orderCount6 < 7){
var obackMarker = new kakao.maps.Marker({
    position: gobongPosition,
    image:blueMarkerImage
    });
}
if(orderCount6 > 6){
 var obackMarker = new kakao.maps.Marker({
     position: gobongPosition,
     image:redMarkerImage
     });
 }


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
gobongMarker.setMap(map);
sigolMarker.setMap(map);
issueMarker.setMap(map);
subMarker.setMap(map);
angelMarker.setMap(map);
kfcMarker.setMap(map);


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

                                              var gobongContent = '<div class="wrap">' +
                                                                                                                                                    '    <div class="info">' +
                                                                                                                                                    '    <div class="info">' +
                                                                                                                                                    '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=6" target="_blank" class="link">고봉민김밥 서면점</a>  '+
                                                                                                                                                    '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                                                                                                    '        </div>' +
                                                                                                                                                    '        <div class="body">' +
                                                                                                                                                    '            <div class="img">' +
                                                                                                                                                    '                <img src="data:image/jpeg;base64,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" width="73" height="70">' +
                                                                                                                                                    '           </div>' +
                                                                                                                                                    '            <div class="desc">' +
                                                                                                                                                    '                <div class="ellipsis">부산광역시 부산진구 부전2동 중앙대로 668</div>' +

                                                                                                                                                    '            </div>' +
                                                                                                                                                    '        </div>' +
                                                                                                                                                    '    </div>' +
                                                                                                                                                    '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                                                                            gobongRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

                                                                                            var sigolContent = '<div class="wrap">' +
                                                                                                                                                                  '    <div class="info">' +
                                                                                                                                                                  '    <div class="info">' +
                                                                                                                                                                  '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=7" target="_blank" class="link">시골한우시골돼지 서면점</a>  '+
                                                                                                                                                                  '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                                                                                                                  '        </div>' +
                                                                                                                                                                  '        <div class="body">' +
                                                                                                                                                                  '            <div class="img">' +
                                                                                                                                                                  '                <img src="https://mblogthumb-phinf.pstatic.net/MjAxODA5MTJfMjIw/MDAxNTM2NzEwOTM3NzMz.SOX1mqoTv0D8gvtX83j4tsAhdfaiEBxtcVajYyFM5hAg.E63yjYQ1cQz9pgLAfdg62lWUbIZ42Hv9UyJTnAg3j9gg.JPEG.dlrldus9212/IMG_4165.jpg?type=w800" width="73" height="70">' +
                                                                                                                                                                  '           </div>' +
                                                                                                                                                                  '            <div class="desc">' +
                                                                                                                                                                  '                <div class="ellipsis">부산광역시 부산진구 부전2동 서면로 17</div>' +

                                                                                                                                                                  '            </div>' +
                                                                                                                                                                  '        </div>' +
                                                                                                                                                                  '    </div>' +
                                                                                                                                                                  '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                                                                                                                                                                        sigolRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

                                                                                                                                                                                                var issueContent = '<div class="wrap">' +
                                                                                                                                                                                                                                                                                                                                            '    <div class="info">' +
                                                                                                                                                                                                                                                                                                                                            '    <div class="info">' +
                                                                                                                                                                                                                                                                                                                                            '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=8" target="_blank" class="link">이슈모리</a>  '+
                                                                                                                                                                                                                                                                                                                                            '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                                                                                                                                                                                                                                                                                            '        </div>' +
                                                                                                                                                                                                                                                                                                                                            '        <div class="body">' +
                                                                                                                                                                                                                                                                                                                                            '            <div class="img">' +
                                                                                                                                                                                                                                                                                                                                            '                <img src="https://s3-ap-northeast-1.amazonaws.com/dcreviewsresized/20200413065509546_photo_4edf91cf4b71.jpg" width="73" height="70">' +
                                                                                                                                                                                                                                                                                                                                            '           </div>' +
                                                                                                                                                                                                                                                                                                                                            '            <div class="desc">' +
                                                                                                                                                                                                                                                                                                                                            '                <div class="ellipsis">부산광역시 부산진구 부전동 233-15</div>' +

                                                                                                                                                                                                                                                                                                                                            '            </div>' +
                                                                                                                                                                                                                                                                                                                                            '        </div>' +
                                                                                                                                                                                                                                                                                                                                            '    </div>' +
                                                                                                                                                                                                                                                                                                                                            '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                                                                                                                                                                                                                                                                    issueRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
                                                                                                                                                                                                                                                                                    var subContent = '<div class="wrap">' +
                                                                                                                                                                                                                                                                                                                                            '    <div class="info">' +
                                                                                                                                                                                                                                                                                                                                            '    <div class="info">' +
                                                                                                                                                                                                                                                                                                                                            '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=9" target="_blank" class="link">써브웨이 서면점</a>  '+
                                                                                                                                                                                                                                                                                                                                            '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                                                                                                                                                                                                                                                                                            '        </div>' +
                                                                                                                                                                                                                                                                                                                                            '        <div class="body">' +
                                                                                                                                                                                                                                                                                                                                            '            <div class="img">' +
                                                                                                                                                                                                                                                                                                                                            '                <img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FoRfXF%2FbtqwUD0pkG9%2FoKW7last16X2QkJjhBvy30%2Fimg.jpg" width="73" height="70">' +
                                                                                                                                                                                                                                                                                                                                            '           </div>' +
                                                                                                                                                                                                                                                                                                                                            '            <div class="desc">' +
                                                                                                                                                                                                                                                                                                                                            '                <div class="ellipsis">부산광역시 부산진구 부전동 중앙대로 690</div>' +

                                                                                                                                                                                                                                                                                                                                            '            </div>' +
                                                                                                                                                                                                                                                                                                                                            '        </div>' +
                                                                                                                                                                                                                                                                                                                                            '    </div>' +
                                                                                                                                                                                                                                                                                                                                            '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                                                                                                                                                                                                                                                                    subRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
                                                                                                                                                                                                                                                                                    var angelContent = '<div class="wrap">' +
                                                                                                                                                                                                                                                                                                                                            '    <div class="info">' +
                                                                                                                                                                                                                                                                                                                                            '    <div class="info">' +
                                                                                                                                                                                                                                                                                                                                            '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=10" target="_blank" class="link">엔제리너스 서면점</a>  '+
                                                                                                                                                                                                                                                                                                                                            '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                                                                                                                                                                                                                                                                                            '        </div>' +
                                                                                                                                                                                                                                                                                                                                            '        <div class="body">' +
                                                                                                                                                                                                                                                                                                                                            '            <div class="img">' +
                                                                                                                                                                                                                                                                                                                                            '                <img src="https://w.namu.la/s/5a382c8f5a12a61260c8ec675cc2dfd2d7e9307b5e15f9f515472cea73932be17ba1e020ee5fa79689991ac1a96d3aba2d11e373164ae5b49697c612bdaa2cf80ec2397b3645f70d891320aa8fd55635" width="73" height="70">' +
                                                                                                                                                                                                                                                                                                                                            '           </div>' +
                                                                                                                                                                                                                                                                                                                                            '            <div class="desc">' +
                                                                                                                                                                                                                                                                                                                                            '                <div class="ellipsis">부산광역시 부산진구 부전2동 232-24</div>' +

                                                                                                                                                                                                                                                                                                                                            '            </div>' +
                                                                                                                                                                                                                                                                                                                                            '        </div>' +
                                                                                                                                                                                                                                                                                                                                            '    </div>' +
                                                                                                                                                                                                                                                                                                                                            '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                                                                                                                                                                                                                                                                    angelRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
                                                                                                                                                                                                                                                                                    var kfcContent = '<div class="wrap">' +
                                                                                                                                                                                                                                                                                                                                            '    <div class="info">' +
                                                                                                                                                                                                                                                                                                                                            '    <div class="info">' +
                                                                                                                                                                                                                                                                                                                                            '        <div class="title"> <a href="http://localhost:8080/watchtable/store/detail?storeNum=11" target="_blank" class="link">kfc 서면점</a>  '+
                                                                                                                                                                                                                                                                                                                                            '            <div class="close" onclick="macCloseOverlay()" title="닫기"></div>' +
                                                                                                                                                                                                                                                                                                                                            '        </div>' +
                                                                                                                                                                                                                                                                                                                                            '        <div class="body">' +
                                                                                                                                                                                                                                                                                                                                            '            <div class="img">' +
                                                                                                                                                                                                                                                                                                                                            '                <img src="https://t1.daumcdn.net/thumb/R550x0/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fencyclop%2Fm149%2FeKDfQHga0oIRA20hCe2XdU34l8sjnGAYzpxgzKjx%3Ft%3D1476410598000" width="73" height="70">' +
                                                                                                                                                                                                                                                                                                                                            '           </div>' +
                                                                                                                                                                                                                                                                                                                                            '            <div class="desc">' +
                                                                                                                                                                                                                                                                                                                                            '                <div class="ellipsis">부산광역시 부산진구 부전동 중앙대로 681-1</div>' +

                                                                                                                                                                                                                                                                                                                                            '            </div>' +
                                                                                                                                                                                                                                                                                                                                            '        </div>' +
                                                                                                                                                                                                                                                                                                                                            '    </div>' +
                                                                                                                                                                                                                                                                                                                                            '</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                                                                                                                                                                                                                                                                                    kfcRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

















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
var gobongInfowindow = new kakao.maps.InfoWindow({
    content : gobongContent,
    removable : gobongRemoveable
});
var sigolInfowindow = new kakao.maps.InfoWindow({
    content : sigolContent,
    removable : sigolRemoveable
});
var issueInfowindow = new kakao.maps.InfoWindow({
    content : issueContent,
    removable : issueRemoveable
});
var subInfowindow = new kakao.maps.InfoWindow({
    content : subContent,
    removable : subRemoveable
});
var angelInfowindow = new kakao.maps.InfoWindow({
    content : angelContent,
    removable : angelRemoveable
});
var kfcInfowindow = new kakao.maps.InfoWindow({
    content : kfcContent,
    removable : kfcRemoveable
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
kakao.maps.event.addListener(gobongMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      gobongInfowindow.open(map, gobongMarker);
});
kakao.maps.event.addListener(sigolMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      sigolInfowindow.open(map, sigolMarker);
});
kakao.maps.event.addListener(issueMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      issueInfowindow.open(map, issueMarker);
});
kakao.maps.event.addListener(subMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      subInfowindow.open(map, subMarker);
});
kakao.maps.event.addListener(angelMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      angelInfowindow.open(map, angelMarker);
});
kakao.maps.event.addListener(kfcMarker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      kfcInfowindow.open(map, kfcMarker);
});

};





function locationLoadError(pos){
    alert('위치 정보를 가져오는데 실패했습니다.');
};
function getMyPosition(){
    navigator.geolocation.getCurrentPosition(locationLoadSuccess,locationLoadError);
};

getMyPosition();







