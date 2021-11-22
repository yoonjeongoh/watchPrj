$(document).ready(function(e){
    var contextPath = $('#contextPathHolder').attr('data-contextPath') ? $('#contextPathHolder').attr('data-contextPath') : '';
    var memberNum = $('#js-memberNum').text();
    var storeNum = $('#js-storeNum').text();
    //var memberNum = [[${member.memberNum}]];
    //var storeNum = [[${dto.storeNum}]];
    var review = $('textarea[name="reviewText"]');

    $(".rv-close21").click(function(){
        $('.reviewModal').modal('hide')
    });

    //리뷰 데이터 넘기기
    $("#rv-btn").click(function(){
        //alert("benny");
        var data = {
            memberNum: memberNum,
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
                str += ' <div class="card-body" data-reviewNum="'+review.reviewNum+'">';
                str += ' <b class="reviewNum">'+review.reviewNum+'</b>';
                str += ' <h5 class="reviewText">'+review.text+'</h5>';
                //str += ' <h5 class="reviewText" onclick="showModal2('+review.reviewNum+','+review.text+')">'+review.text+'</h5>';
                str += ' <p>'+formatTime(review.regDate)+'</p>';
                str += ' </div>';
            //console.log("review>>>>>>>>>>>"+review);
            });

            $(".rv-list-table").html(str);
            //console.log(">>>>>>>>>>>"+str);
        });
    }
    getStoreReviews();

    //수정삭제 모달창 띄우기
     $(".rv-list-table").on("click", ".card-body", function(){
        //var reviewNum = $(this).data("reviewNum");
        //console.log("this: " + this);
        //console.log("reviewNum: " + reviewNum);

        //$("input[name='reviewNum']").val(reviewNum);
        $("input[name='reviewNum']").val($(this).find('.reviewNum').html());
        $("input[name='text']").val($(this).find('.reviewText').html());
        $('.reviewModal').modal('show');
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
        var review = $("input[name='text']");

        var data = {
            reviewNum: reviewNum,
            memberNum: memberNum,
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
