/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

console.log("infite js");

//var symptomsLoaded = false;

//window.onscroll = function (ev) {
//    if ((window.innerHeight + window.scrollY) >= (document.body.offsetHeight - 10)) {
//        console.log("bottom");
//        if (!$('#symptoms').html() && !symptomsLoaded) {
//            console.log("loading symptoms");
//            symptomsLoaded = true;
//            $('#symptoms').load('covidSymptoms');
//        }
//    }
//};

//$('#symptoms').load('covidSymptoms');

//$(document).ready(function () {
//    console.log("loading symptoms");
//    $('#symptoms').load('../covidSymptoms');
//
//
//});
$(document).ready(function () {
    var symptomsLoaded = false, mythsLoaded = false, dosDontsLoaded = false, faqsLoaded = false;
    var isContentLoaded = false;

    $('#generalMenu').addClass('active');
    $(window).scroll(function () {
        var mainWrapper = document.getElementById('main-wrapper');
        var contentHeight = document.body.offsetHeight; //gets page height//
//        var contentHeight = mainWrapper.offsetHeight; //gets page height//
        var yOffset = window.pageYOffset; //gets the vertical scroll bar height//
        var y = yOffset + window.outerHeight;
        if (y >= contentHeight) {
            if (!isContentLoaded) {
//                console.log('bottom reached');
                if (!$('#symptoms').html() && !symptomsLoaded) {
                    symptomsLoaded = true;
                    isContentLoaded = true;
                    $('#symptoms').html('<img th:src="@{/images/loader.gif}"/>')
                            .load('covidSymptoms');
                    isContentLoaded = false;
                } else if (!$('#dosDonts').html() && !dosDontsLoaded) {
                    dosDontsLoaded = true;
                    isContentLoaded = true;
                    $('#dosDonts').html('<img th:src="@{/images/loader.gif}"/>')
                            .load('covidDosAndDonts');
                    isContentLoaded = false;
                } else if (!$('#myths').html() && !mythsLoaded) {
                    mythsLoaded = true;
                    isContentLoaded = true;
                    $('#myths').html('<img th:src="@{/images/loader.gif}"/>')
                            .load('covidMyths');
                    isContentLoaded = false;
                } else if (!$('#faqs').html() && !faqsLoaded) {
                    faqsLoaded = true;
                    isContentLoaded = true;
                    $('#faqs').html('<img th:src="@{/images/loader.gif}"/>')
                            .load('covidFaq');
                    isContentLoaded = false;
                }
            }
        }

        if (isScrolledIntoView('#contact')) {
            if (!$('#contactMenu').attr('class') || $('#contactMenu').attr('class').indexOf('active') == -1) {
                $('.chiller-theme .sidebar-wrapper .sidebar-menu ul li').removeClass('active');
                $('#contactMenu').addClass('active');
            }
        } else if (isScrolledIntoView('#faqs')) {
            if (!$('#faqsMenu').attr('class') || $('#faqsMenu').attr('class').indexOf('active') == -1) {
                $('.chiller-theme .sidebar-wrapper .sidebar-menu ul li').removeClass('active');
                $('#faqsMenu').addClass('active');
            }
        } else if (isScrolledIntoView('#myths')) {
            if (!$('#mythsMenu').attr('class') || $('#mythsMenu').attr('class').indexOf('active') == -1) {
                $('.chiller-theme .sidebar-wrapper .sidebar-menu ul li').removeClass('active');
                $('#mythsMenu').addClass('active');
            }
        } else if (isScrolledIntoView('#dosDonts')) {
            if (!$('#dosDontsMenu').attr('class') || $('#dosDontsMenu').attr('class').indexOf('active') == -1) {
                $('.chiller-theme .sidebar-wrapper .sidebar-menu ul li').removeClass('active');
                $('#dosDontsMenu').addClass('active');
            }
        } else if (isScrolledIntoView('#symptoms')) {
            if (!$('#symptomsMenu').attr('class') || $('#symptomsMenu').attr('class').indexOf('active') == -1) {
                $('.chiller-theme .sidebar-wrapper .sidebar-menu ul li').removeClass('active');
                $('#symptomsMenu').addClass('active');
            }
        } else if (isScrolledIntoView('#statistics')) {
            if (!$('#statisticsMenu').attr('class') || $('#statisticsMenu').attr('class').indexOf('active') == -1) {
                $('.chiller-theme .sidebar-wrapper .sidebar-menu ul li').removeClass('active');
                $('#statisticsMenu').addClass('active');
            }
        }

    });
});

function isScrolledIntoView(elem)
{
    var top_of_element = $(elem).offset().top;
    var bottom_of_element = $(elem).offset().top + $(elem).outerHeight();
    var bottom_of_screen = $(window).scrollTop() + $(window).innerHeight();
    var top_of_screen = $(window).scrollTop();

    return (bottom_of_screen > top_of_element) && (top_of_screen < bottom_of_element);
}
//function isScrolledIntoView(elem)
//{
//    var docViewTop = $(window).scrollTop();
//    var docViewBottom = docViewTop + $(window).height();
//
//    var elemTop = $(elem).offset().top;
//    var elemBottom = elemTop + $(elem).height();
//
//    return ((elemBottom <= docViewBottom) && (elemTop >= docViewTop));
//}
