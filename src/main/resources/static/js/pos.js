$(document).ready(function() {
   var actionForm = $('form');
   $('#btn_submit').click(function() {
       actionForm.submit();
   })

$('#orderCount').val( Number($('#table1').val()) + Number($('#table2').val()) + Number($('#table3').val()) + Number($('#table4').val()) +
                    Number($('#table5').val()) + Number($('#table6').val()) + Number($('#table7').val()) + Number($('#table8').val()) + Number($('#table9').val()) );


if(Number($('#table1').val()) == 1){
    $("#tb1").css("background-color","#fdb53c");
} else if(Number($('#table1').val()) == 0){
    $("#tb1").css("background-color","#75736e");
}
if(Number($('#table2').val()) == 1){
    $("#tb2").css("background-color","#fdb53c");
} else if(Number($('#table2').val()) == 0){
    $("#tb2").css("background-color","#75736e");
}
if(Number($('#table3').val()) == 1){
    $("#tb3").css("background-color","#fdb53c");
} else if(Number($('#table3').val()) == 0){
    $("#tb3").css("background-color","#75736e");
}
if(Number($('#table4').val()) == 1){
    $("#tb4").css("background-color","#fdb53c");
} else if(Number($('#table4').val()) == 0){
    $("#tb4").css("background-color","#75736e");
}
if(Number($('#table5').val()) == 1){
    $("#tb5").css("background-color","#fdb53c");
} else if(Number($('#table5').val()) == 0){
    $("#tb5").css("background-color","#75736e");
}
if(Number($('#table6').val()) == 1){
    $("#tb6").css("background-color","#fdb53c");
} else if(Number($('#table6').val()) == 0){
    $("#tb6").css("background-color","#75736e");
}
if(Number($('#table7').val()) == 1){
    $("#tb7").css("background-color","#fdb53c");
} else if(Number($('#table7').val()) == 0){
    $("#tb7").css("background-color","#75736e");
}
if(Number($('#table8').val()) == 1){
    $("#tb8").css("background-color","#fdb53c");
} else if(Number($('#table8').val()) == 0){
    $("#tb8").css("background-color","#75736e");
}
if(Number($('#table9').val()) == 1){
    $("#tb9").css("background-color","#fdb53c");
} else if(Number($('#table9').val()) == 0){
    $("#tb9").css("background-color","#75736e");
}

$('#btn1_1').click(function(){
  if( $('#table1').val() == 0 ) {
    $('#table1').val(Number( $('#table1').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb1").css("background-color","#fdb53c");
  }
})
$('#btn1_2').click(function(){
    if( $('#table1').val() == 1 && $('#orderCount').val() > 0) {
        $('#table1').val(Number( $('#table1').val() )-1);
        $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
        $("#tb1").css("background-color","#75736e");
    } else if($('#table1').val() == 1 && $('#orderCount').val() == 0) {
        $('#table1').val(Number( $('#table1').val() )-1);
        $("#tb1").css("background-color","#75736e");
    }
})
$('#btn2_1').click(function(){
 if( $('#table2').val() == 0 ) {
    $('#table2').val(Number( $('#table2').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb2").css("background-color","#fdb53c");
 }
})
$('#btn2_2').click(function(){
 if( $('#table2').val() == 1 && $('#orderCount').val() > 0) {
    $('#table2').val( Number( $('#table2').val() ) -1 );
    $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
    $("#tb2").css("background-color","#75736e");
 } else if( $('#table2').val() == 1 && $('#orderCount').val() == 0 ) {
        $('#table2').val(Number( $('#table2').val() )-1);
        $("#tb2").css("background-color","#75736e");
 }
})
$('#btn3_1').click(function(){
 if( $('#table3').val() == 0 ) {
    $('#table3').val(Number( $('#table3').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb3").css("background-color","#fdb53c");
 }
})
$('#btn3_2').click(function(){
 if( $('#table3').val() == 1 && $('#orderCount').val() > 0) {
    $('#table3').val( Number( $('#table3').val() ) -1 );
    $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
    $("#tb3").css("background-color","#75736e");
 } else if( $('#table3').val() == 1 && $('#orderCount').val() == 0 ) {
        $('#table3').val(Number( $('#table2').val() )-1);
        $("#tb3").css("background-color","#75736e");
 }
})
$('#btn4_1').click(function(){
 if( $('#table4').val() == 0 ) {
    $('#table4').val(Number( $('#table4').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb4").css("background-color","#fdb53c");
 }
})
$('#btn4_2').click(function(){
 if( $('#table4').val() == 1 && $('#orderCount').val() > 0) {
    $('#table4').val( Number( $('#table4').val() ) -1 );
    $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
    $("#tb4").css("background-color","#75736e");
 } else if( $('#table4').val() == 1 && $('#orderCount').val() == 0 ) {
        $('#table4').val(Number( $('#table4').val() )-1);
        $("#tb4").css("background-color","#75736e");
 }
})
$('#btn5_1').click(function(){
 if( $('#table5').val() == 0 ) {
    $('#table5').val(Number( $('#table5').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb5").css("background-color","#fdb53c");
 }
})
$('#btn5_2').click(function(){
 if( $('#table5').val() == 1 && $('#orderCount').val() > 0) {
    $('#table5').val( Number( $('#table5').val() ) -1 );
    $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
    $("#tb5").css("background-color","#75736e");
 } else if( $('#table5').val() == 1 && $('#orderCount').val() == 0 ) {
        $('#table5').val(Number( $('#table5').val() )-1);
        $("#tb5").css("background-color","#75736e");
 }
})
$('#btn6_1').click(function(){
 if( $('#table6').val() == 0 ) {
    $('#table6').val(Number( $('#table6').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb6").css("background-color","#fdb53c");
 }
})
$('#btn6_2').click(function(){
 if( $('#table6').val() == 1 && $('#orderCount').val() > 0) {
    $('#table6').val( Number( $('#table6').val() ) -1 );
    $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
    $("#tb6").css("background-color","#75736e");
 } else if( $('#table6').val() == 1 && $('#orderCount').val() == 0 ) {
        $('#table6').val(Number( $('#table6').val() )-1);
        $("#tb6").css("background-color","#75736e");
 }
})
$('#btn7_1').click(function(){
 if( $('#table7').val() == 0 ) {
    $('#table7').val(Number( $('#table7').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb7").css("background-color","#fdb53c");
 }
})
$('#btn7_2').click(function(){
 if( $('#table7').val() == 1 && $('#orderCount').val() > 0) {
    $('#table7').val( Number( $('#table7').val() ) -1 );
    $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
    $("#tb7").css("background-color","#75736e");
 } else if( $('#table7').val() == 1 && $('#orderCount').val() == 0 ) {
        $('#table7').val(Number( $('#table7').val() )-1);
        $("#tb7").css("background-color","#75736e");
 }
})
$('#btn8_1').click(function(){
 if( $('#table8').val() == 0 ) {
    $('#table8').val(Number( $('#table8').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb8").css("background-color","#fdb53c");
 }
})
$('#btn8_2').click(function(){
 if( $('#table8').val() == 1 && $('#orderCount').val() > 0) {
    $('#table8').val( Number( $('#table8').val() ) -1 );
    $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
    $("#tb8").css("background-color","#75736e");
 } else if( $('#table8').val() == 1 && $('#orderCount').val() == 0 ) {
        $('#table8').val(Number( $('#table2').val() )-1);
        $("#tb8").css("background-color","#75736e");
 }
})
$('#btn9_1').click(function(){
 if( $('#table9').val() == 0 ) {
    $('#table9').val(Number( $('#table9').val() )+1);
    $('#orderCount').val( Number( $('#orderCount').val() ) +1 );
    $("#tb9").css("background-color","#fdb53c");
 }
})
$('#btn9_2').click(function(){
 if( $('#table9').val() == 1 && $('#orderCount').val() > 0) {
    $('#table9').val( Number( $('#table9').val() ) -1 );
    $('#orderCount').val( Number( $('#orderCount').val() ) -1 );
    $("#tb9").css("background-color","#75736e");
 } else if( $('#table9').val() == 1 && $('#orderCount').val() == 0 ) {
        $('#table9').val(Number( $('#table9').val() )-1);
        $("#tb9").css("background-color","#75736e");
 }
})
})
