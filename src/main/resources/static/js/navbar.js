/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


jQuery(function ($) {

    $(".sidebar-dropdown > a").click(function () {
        $(".sidebar-submenu").slideUp(200);
        if (
                $(this)
                .parent()
                .hasClass("active")
                ) {
            $(".sidebar-dropdown").removeClass("active");
            $(this)
                    .parent()
                    .removeClass("active");
        } else {
            $(".sidebar-dropdown").removeClass("active");
            $(this)
                    .next(".sidebar-submenu")
                    .slideDown(200);
            $(this)
                    .parent()
                    .addClass("active");
        }
    });

    $("#close-sidebar").click(function () {
        $(".page-wrapper").removeClass("toggled");
    });
    $("#show-sidebar").click(function () {
        $(".page-wrapper").addClass("toggled");
    });


    $('.general').click(function () {
        var url = window.location.href;
        if (url.indexOf('covidSelfAssessment') != -1) {
            var user_name = localStorage.getItem('WANDER_COVID_USER');
            if (!user_name) {
                user_name = 'GUEST';
            }
            window.location.href = "loadHome?user=" + window.btoa(user_name);
//            window.location.href = "loadHome/" + window.btoa(user_name);
        }
    });



});
