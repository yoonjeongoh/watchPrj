//managemyinfo에서 쓰는 스크립트
$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';

//모달 띄우기
    $(".waiting-table").on("click",".waiting-box", function(){
    console.log("click_modal");
        $('.waitingModal').modal('show');
    });

    //대기 모달 닫기
    $(".waiting-close21").click(function(){
        $('.waitingModal').modal('hide')
    });

});