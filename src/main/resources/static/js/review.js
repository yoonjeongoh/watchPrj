$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';
    var reviewMemberNum = $('#js-memberNum').text();
    var reviewMemberNickname = $('#js-memberNickname').text();
    var storeNum = $('#js-storeNum').text();
    var review = $('textarea[name="reviewText"]');
//    var memberNum = $('#modal-rv-memberNum').text();
//    var memberNum = [[${member.memberNum}]];
    //var storeNum = [[${dto.storeNum}]];

    $(".rv-close21").click(function(){
        $('.reviewModal').modal('hide')
    });

    //리뷰 데이터 넘기기
    $("#rv-btn").click(function(){
        //alert("benny");
        var data = {
            memberNum: reviewMemberNum,
            storeNum: storeNum,
            text: review.val()
            };
        //console.log(">>>>"+data);

        $.ajax({
            url: contextPath+'/addReview/'+storeNum,
            type:"POST",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"text",
            success: function(data){
                console.log("result: "+data);
                var reviewNum = parseInt(data);
                console.log("result: "+reviewNum);
                self.location.reload();
             },
            error:function(data){
            alert("errorrrrrrrrrrrrrrrr");
            }
        });
    });

    //리뷰 리스트 보기
    function getStoreReviews() {
        function formatTime(str) {
            var date = new Date(str);
            return date.getFullYear()+'/'+
            (date.getMonth() + 1)+'/' +
            date.getDate() + ' ' +
            date.getHours()+':'+
            date.getMinutes();
        }

        $.getJSON(contextPath+"/addReview/"+storeNum+"/list", function(arr) {
        var str = "";

            $.each(arr, function(idx, review) {
                str += ' <div class="review-body" data-reviewNum="'+review.reviewNum+'">';
                str += ' <b class="reviewNum">'+review.reviewNum+'</b>';
                str += ' <b class="rv-memberNum">'+review.memberNum+'</b>';
                str += ' <p class="reviewNickname rv-bold">'+review.memberNickname+'</p>';
                str += ' <p class="reviewText">'+review.text+'</p>';
                //str += ' <h5 class="reviewText" onclick="showModal2('+review.reviewNum+','+review.text+')">'+review.text+'</h5>';
                str += ' <p class="reviewTime">'+formatTime(review.regDate)+'</p>';
                str += ' </div>';
            //console.log("review>>>>>>>>>>>"+review);
            });

            $(".rv-list-table").html(str);
            //console.log(">>>>>>>>>>>"+str);
        });
    }
    getStoreReviews();

    //수정삭제 모달창 띄우기+ 본인만 가능
    $(".rv-list-table").on("click", ".review-body", function(){
        var memberNum = $(this).find('.rv-memberNum').html();
//            console.log("reviewmemberNum: " + reviewMemberNum);
//            console.log("memberNum2: " + memberNum);

    if (reviewMemberNum == memberNum) {
        //데이터로 불러오기
        //var reviewNum = $(this).data("reviewNum");
        //console.log("this: " + this);
        //console.log("reviewNum: " + reviewNum);
        //$("input[name='reviewNum']").val(reviewNum);

        //직접 불러오기
        $("input[name='reviewNum']").val($(this).find('.reviewNum').html());
        $("input[name='reviewNickname']").val($(this).find('.reviewNickname').html());
        $("textarea[name='modal-text']").val($(this).find('.reviewText').html());
        $('.reviewModal').modal('show');
    } else {
        console.log("not yours");
    }
    });

    //리뷰삭제
    $(".rv-del21").on("click", function(){
        var reviewNum = $("input[name='reviewNum']").val();
        console.log(reviewNum);
        var data = {reviewNum: reviewNum}

        $.ajax({
        url: contextPath + '/addReview/'+storeNum+"/"+reviewNum ,
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
    });

    //리뷰수정
    $(".rv-modify").on("click", function(){
        var reviewNum = $("input[name='reviewNum']").val();
        //var review = $("input[name='text']");
        var reviewNickname = $("input[name='reviewNickname']").val();
        var review = $("textarea[name='modal-text']");

        var data = {
            reviewNum: reviewNum,
            memberNum: reviewMemberNum,
            memberName: reviewNickname,
            storeNum: storeNum,
            text: review.val()
            };
        console.log(data);

        $.ajax({
        url: contextPath + '/addReview/'+storeNum+"/"+reviewNum ,
        type:"PUT",
        data:JSON.stringify(data),
        contentType:"application/json; charset=utf-8",
        dataType:"text",
        success: function(data){
                console.log("result: " + data);
                self.location.reload();
            }
        })
    $('.reviewModal').modal('hide');
    });
}); //end script
