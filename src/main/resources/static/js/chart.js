     window.onload = function () {
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
            var use = $('#orderCountBasket2').attr('value');
                console.log(use);
            var left = 9-use;
            console.log(left);
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['잔여좌석',   left  ],
          ['사용좌석',    use ],
        ]);

        var options = {
          title: '혼잡도',
          width: 470,
//          height: 400,
//          backgroundColor: {
//            fill: 'none',
//          },
          chartArea: {
            width: 300,
            height: 300,
            top: 30,
            backgroundColor: {
                stoke: 'none'
            }
          }
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
}