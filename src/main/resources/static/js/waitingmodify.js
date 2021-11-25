$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';

    var waitingMemberNum = $('.wt-waitingMemberNum').text();

    //대기 모달 띄우기
    $(".waiting-table").on("click",".waiting-box", function(){
    //console.log("click_modal");
        $('#storeName').val($(this).find('.wt-storeName').html());
        console.log(this);
        $("#memberNickname").val($(this).find('.wt-nickName').html());
        $("#memberMobile").val($(this).find('.wt-memberMobile').html());
        $("#partyMember").val($(this).find('.wt-partyMember').html());
        $("#modal-waitingNum").val($(this).find('.wt-waitingNum').html());
//        storeNum 마저하기
        $('.waitingModal').modal('show');
    });

    $(".waiting-close21").click(function(){
        $('.waitingModal').modal('hide')
    });

    //대기 수정
    $(".go-modify21").on("click", function(){
        var waitingNum = $("#modal-waitingNum").val();
        var waitingMobile = $("#modal-memberMobile").val();
        var waitingNickname = $("#memberNickname").val();
        var waitingStoreNum = $(".wt-waitingStoreNum").val();
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
            }
        })
    $('.waitingModal').modal('hide');
    });



}); //script end


