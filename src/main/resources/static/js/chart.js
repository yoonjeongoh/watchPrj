      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['occupied',     11],
          ['available',      4],
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
