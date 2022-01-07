//myinfo에서 사용하는 스크립트
$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';

    var waitingMemberNum = $('.wt-waitingMemberNum').text();

    //대기 모달 띄우기
    $(".waiting-table").on("click",".waiting-box", function(){
    //console.log("click_modal");
        $('#storeName').val($(this).find('.wt-storeName').html());
        console.log("1"+this);
        $("#memberNickname").val($(this).find('.wt-nickName').html());
        $("#memberMobile").val($(this).find('.wt-memberMobile').html());
        $("#partyMember").val($(this).find('.wt-partyMember').html());
        $("#modal-waitingNum").val($(this).find('.wt-waitingNum').html());
        $("#modal-storeNum").val($(this).find('.wt-storeNum').html());
        $("#modal-memberNum").val($(this).find('.wt-memberNum').html());
        $('.waitingModal').modal('show');
    });

    //대기 모달 닫기
    $(".waiting-close21").click(function(){
        $('.waitingModal').modal('hide')
    });

    //대기 수정
    $(".go-modify21").on("click", function(){
        var waitingNum = $("#modal-waitingNum").val();
        var waitingMobile = $("#modal-memberMobile").val();
        var waitingMemberNum = $("#modal-memberNum").val();
        var waitingNickname = $("#memberNickname").val();
        var waitingStoreNum = $("#modal-storeNum").val();
        var waitingPartyMember = $("#partyMember");

        var data = {
            waitingNum: waitingNum,
            memberNum: waitingMemberNum,
            memberName: waitingNickname,
            memberMobile: waitingMobile,
            storeNum: waitingStoreNum,
            partyMember: waitingPartyMember.val()
            };
        console.log(data);

        $.ajax({
        url: contextPath + '/modifyWaiting/'+waitingNum ,
        type:"PUT",
        data:JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType:"text",
        success: function(data){
                console.log("result: " + data);
                self.location.reload();
            },
        error:function(data){
            alert("delete_errorrrrrrrrrrrrrrrr");
            }

        })
    $('.waitingModal').modal('hide');
    });

    //웨이팅 취소
    $(".go-cancel21").on("click", function(){
        var waitingNum = $("#modal-waitingNum").val();
        console.log(waitingNum);
        var data = {
            waitingNum: waitingNum
            }
        console.log(data);

        $.ajax({
        url: contextPath + '/modifyWaiting/'+waitingNum,
        type:"DELETE",
        data:JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType:"text",
        success: function(data){
                console.log("result: " + data);
                self.location.reload();
             },
        error:function(data){
            alert("delete_errorrrrrrrrrrrrrrrr");
            }
    });
    $('.waitingModal').modal('hide');
    });

    //모달창에서 가게로 이동하기
    $(".go-store21").on("click", function(){
        var storeNum = $("#modal-storeNum").val();
        console.log("storenum: " + storeNum);

        var url = contextPath + '/store/detail/' + '?storeNum=' + storeNum;
        $('.waitingModal').modal('hide');

        location.href=url;
    });

}); //script end


