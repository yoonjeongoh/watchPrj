//detail에서 쓰는 웨이팅 스크립트
$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';
    var memberNum = $('#js-memberNum').text();
    var storeNum = $('#js-storeNum').text();
    var memberNickname = $('#js-memberNickname').text();
    var memberMobile = $('#md-memberMobile').text();
    var partyMember = $('select[name="partyMember"]');

    //대기등록 데이터 넘기기
    $(".go-waiting21").click(function(){
        //alert("benny");
        var data = {
            memberNum: memberNum,
            memberName: memberNickname,
            memberMobile: memberMobile,
            storeNum: storeNum,
            partyMember: partyMember.val()
            };
        console.log("waiting111>>>>"+data);

        $.ajax({
            url: contextPath+'/addWaiting/'+storeNum,
            type:"POST",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(data){
                console.log("waiting222>>>> "+data);
                var waitingNum = parseInt(data);
                console.log("waiting333>>>>"+waitingNum);
                self.location.reload();
             },
            error:function(data){
            alert("errorrrrrrrrrrrrrrrr");
            }
        });
        $('.waitingModal').modal('hide')
    });

    //대기등록 모달 열기
    $(".waiting-register21").click(function(){
        $('.waitingModal').modal('show')
//        $('.memberNickname').val();
//        $('.memberMobile').val();
//        $('.partyMember').val();
    });

    //대기등록 모달 닫기
    $(".waiting-close21").click(function(){
        $('.waitingModal').modal('hide')
//            $('.memberNickname').val();
//            $('.memberMobile').val();
//            $('.partyMember').val();
    });


}); //end script
