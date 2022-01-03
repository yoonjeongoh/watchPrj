     window.onload = function () {
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
            var use = $('#orderCountBasket2').attr('value');
//                console.log(use);
            var left = 9-use;
//            console.log(left);
        new Chart(document.getElementById("piechart"), {
            type: 'pie',
            data: {
              labels: ["사용중", "사용가능"],
              datasets: [{
                label: "Population (millions)",
                backgroundColor: ["#CE2B38", "#5A8F5E"],
                data: [use,left]
              }]
            },
            options: {
            responsive:false,
              title: {
                display: true,
              }
            }
        });
    }
}