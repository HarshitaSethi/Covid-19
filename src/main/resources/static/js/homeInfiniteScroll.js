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
//    $('#symptoms').html('<img th:src="@{/images/loader.gif}"/>')
//            .load('../covidSymptoms');
//
//    $('#myths').html('<img th:src="@{/images/loader.gif}"/>')
//            .load('../covidMyths');

    var symptomsLoaded = false, mythsLoaded = false, dosDontsLoaded = false, faqsLoaded = false;

    $(window).scroll(function () {
        var mainWrapper = document.getElementById('main-wrapper');
        var contentHeight = mainWrapper.offsetHeight; //gets page height//
        var yOffset = window.pageYOffset; //gets the vertical scroll bar height//
        var y = yOffset + window.innerHeight;
        if (y >= contentHeight) {
            console.log('bottom reached');
            if (!$('#symptoms').html() && !symptomsLoaded) {
                symptomsLoaded = true;
                $('#symptoms').html('<img th:src="@{/images/loader.gif}"/>')
                        .load('../covidSymptoms');
            } else if (!$('#dosDonts').html() && !dosDontsLoaded) {
                dosDontsLoaded = true;
                $('#dosDonts').html('<img th:src="@{/images/loader.gif}"/>')
                        .load('../covidDosAndDonts');
            } else if (!$('#myths').html() && !mythsLoaded) {
                mythsLoaded = true;
                $('#myths').html('<img th:src="@{/images/loader.gif}"/>')
                        .load('../covidMyths');
            } else if (!$('#faqs').html() && !faqsLoaded) {
                faqsLoaded = true;
                $('#faqs').html('<img th:src="@{/images/loader.gif}"/>')
                        .load('../covidFaq');
            }
        }
    });
});
