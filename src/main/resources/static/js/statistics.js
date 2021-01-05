var chart, seriesTotalvsActive = [], seriesNewVsRecoveries = [], category = [];
$(document).ready(function () {

    prepareTotalVsActiveData(getTotallVsActiveBarData());
    prepareNewVsRecoveriesData(getNewVsRecoveriesBarData());
    createChart('Total Cases vs Active Cases Counts', seriesTotalvsActive);

    $('#btnTotalVsActive').click(function () {
        updateChart('Total Cases vs Active Cases Counts', seriesTotalvsActive, 'column');
        this.className = 'active';

    });

    $('#btnNewVsRecoveries').click(function () {
        updateChart('New vs Recoveries vs Deaths', seriesNewVsRecoveries, '');
        this.className = 'active';
    });

});

function createChart(text, series) {
    chart = Highcharts.chart('containerBarChart', {
        chart: {
            type: 'column'
        },
        title: {
            text: text
        },
        xAxis: {
            categories: category,
        },
        series: series
    });
}

function updateChart(text, series, chartType) {
    chart.update({
        chart: {
            type: chartType
        },
        title: {
            text: text
        },
        xAxis: {
            categories: category,
        },
        series: series
    });

    document.querySelectorAll('.buttons button.active').forEach(function (active) {
        active.className = '';
    });
}




function prepareNewVsRecoveriesData(data) {

    category = [];
    var newCases = [];
    var recoveries = [];
    var deaths = [];

    for (var i = 0; i < data.length; i++) {
        category.push(data[i].name);
        newCases.push(data[i].y);
        recoveries.push(data[i].y2);
        deaths.push(data[i].y3);
    }

    seriesNewVsRecoveries = [{
            type: 'column',
            name: 'Active Cases',
            id: 'main',
            dataSorting: {
                enabled: true,
                matchByName: true
            },
            dataLabels: [{
                    enabled: true,
                    inside: true,
                    style: {
                        fontSize: '16px'
                    }
                }],
            data: deaths
        }, {
            type: 'column',
//            color: 'rgb(158, 159, 163)',
            pointPlacement: -0.2,
            linkedTo: 'main',
            data: newCases,
            name: 'Total Cases'
        }, {
            type: 'spline',
            name: 'Average',
            data: recoveries,
            marker: {
                lineWidth: 2,
                lineColor: Highcharts.getOptions().colors[3],
                fillColor: 'white'
            }
        }];
}



function prepareTotalVsActiveData(data) {

    category = [];
    var totalCases = [];
    var activeCases = [];

    for (var i = 0; i < data.length; i++) {
        category.push(data[i].name);
        totalCases.push(data[i].y);
        activeCases.push(data[i].y2);
    }

    seriesTotalvsActive = [{
            type: 'column',
            name: 'Active Cases',
            id: 'main',
            dataSorting: {
                enabled: true,
                matchByName: true
            },
            dataLabels: [{
                    enabled: true,
                    inside: true,
                    style: {
                        fontSize: '16px'
                    }
                }],
            data: activeCases
        },
        {
//            color: 'rgb(158, 159, 163)',
            type: 'column',
            pointPlacement: -0.2,
            linkedTo: 'main',
            data: totalCases,
            name: 'Total Cases'
        }];

}


