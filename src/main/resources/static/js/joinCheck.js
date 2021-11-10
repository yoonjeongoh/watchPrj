$(document).ready(function() {
    var actionForm = $('form');
    //회원가입 버튼(회원가입 기능 작동)
    $('.join_button').click(function(){
        var data = $('.input11').val();
        if( data == null || data == '' ){
            alert("정보를 모두 입력하세요.");
            } else actionForm.submit();
    });

    const blank = /[\s]/g;
    const nameCheck = /^[가-힣]+$/;
    const idCheck = /^[a-zA-Z0-9]+$/;
    const nickCheck = /^[가-힣a-zA-Z0-9]+$/;
    const pwCheck = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    const mailCheck = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    const mobileCheck = /^[0-9]/g;

    $('#my_name').keyup(function(){
        var name = $('#my_name').val();
        if(nameCheck.test(name) && name.length > 1){
            $('#name_ok').show();
            $('#nameSpace').hide();
            $('#noEnglish').hide();
            $('#name_min').hide();
        } else if(blank.test(name)){
            $('#name_ok').hide();
            $('#nameSpace').show();
            $('#noEnglish').hide();
            $('#name_min').hide();
        } else if(name.length < 2) {
            $('#name_ok').hide();
            $('#nameSpace').hide();
            $('#noEnglish').hide();
            $('#name_min').show();
        } else {
            $('#name_ok').hide();
            $('#nameSpace').hide();
            $('#noEnglish').show();
            $('#name_min').hide();
        }
    });

    $('#my_id').keyup(function(){
        var id = $('#my_id').val();
        if(idCheck.test(id) && id.length > 3){
            $('#id_ok').show();
            $('#id_min').hide();
            $('#noKor').hide();
            $('#idSpace').hide();
        } else if(blank.test(id)){
            $('#idSpace').show();
            $('#id_min').hide();
            $('#noKor').hide();
            $('#id_ok').hide();
        } else if(id.length < 4) {
            $('#id_min').show();
            $('#id_ok').hide();
            $('#noKor').hide();
            $('#idSpace').hide();
        } else {
            $('#noKor').show();
            $('#id_min').hide();
            $('#id_ok').hide();
            $('#idSpace').hide();
        }
    });

    $('#my_nick').keyup(function(){
        var nick = $('#my_nick').val();
        if(nickCheck.test(nick) && nick.length > 1){
            $('#nick_ok').show();
            $('#nick_min').hide();
            $('#noSpecial').hide();
            $('#nickSpace').hide();
        } else if(blank.test(nick)){
            $('#nickSpace').show();
            $('#nick_min').hide();
            $('#noSpecial').hide();
            $('#nick_ok').hide();
        } else if(nick.length < 2) {
            $('#nick_min').show();
            $('#nick_ok').hide();
            $('#nickSpace').hide();
            $('#noSpecial').hide();
        } else {
            $('#noSpecial').show();
            $('#nick_min').hide();
            $('#nick_ok').hide();
            $('#nickSpace').hide();
        }
    });

   $('#my_pwd').keyup(function(){
        var pw = $('#my_pwd').val();
        if(pwCheck.test(pw) && pw.length > 7){
            $('#pw_ok').show();
            $('#pw_min').hide();
            $('#pw_error').hide();
        } else if(pw.length < 8) {
            $('#pw_min').show();
            $('#pw_error').hide();
            $('#pw_ok').hide();
        } else {
            $('#pw_error').show();
            $('#pw_ok').hide();
            $('#pw_min').hide();
        }
    });

     $('#pwd_check').keyup(function(){
        if( $('#my_pwd').val() == $('#pwd_check').val() ){
            $('#pwck_ok').show();
            $('#pwck_error').hide();
        } else {
            $('#pwck_ok').hide();
            $('#pwck_error').show();
        }
     });

     $('#my_add').keyup(function(){
        var mail = $('#my_add').val();
        if(mailCheck.test(mail)){
            $('#mail_ok').show();
            $('#mail_error').hide();
        } else {
            $('#mail_ok').hide();
            $('#mail_error').show();
        }
     });

     $('.input14').keyup(function(){
        var mobile = $('#st-tel1').val();
        if(mobileCheck.test(mobile) && mobile.length == 4){
                $('#mobile_ok').show();
                $('#mobile_error').hide();
        } else {
            $('#mobile_ok').hide();
            $('#mobile_error').show();
        }
     });
});