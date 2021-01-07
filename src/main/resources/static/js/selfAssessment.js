/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function assessSymptoms(form) {

    console.log('in function');
    var values = $(form).serializeArray();
    console.log(values);
    var list = {"LESS_COMMON": 0, "MOST_COMMON": 0, "SERIOUS": 0};

    for (var i = 0; i < values.length; i++) {

        if (values[i].value == 'YES') {
            if (values[i].name.startsWith("Less common")) {
                list.LESS_COMMON++;
            }
            if (values[i].name.startsWith("Most common")) {
                list.MOST_COMMON++;
            }
            if (values[i].name.startsWith("Serious")) {
                list.SERIOUS++;
            }
        }
        // console.log();
    }
    console.log("list" + list);
    console.log("list" + JSON.stringify(list));

    var result = "";

    if (list.SERIOUS) {
        result = '<div class="alert alert-danger" role="alert">\n\
            <h4 class="alert-heading"><i class="fa fa-warning mr-3"></i>Self-assessment result</h4>\n\
            <p>Please call 104 or 97456-97456 Immediately</p>              \n\
                  </div>';

    } else if (list.LESS_COMMON || list.MOST_COMMON) {
        result = '<div class="alert alert-warning" role="alert">\n\
            <h4 class="alert-heading"><i class="fa fa-info-circle mr-3"></i>Self-assessment result</h4>\n\
            <p>You have some common symptoms. It is less likely you have COVID-19 </p>              \n\
                  </div>\n\
            <p>   Practice social distancing in order to decrease risk of COVID-19 transmission. </p> \n\
             <p><strong>You should also      self-isolate if you:</strong></p>\n\
             <ul> \n\
              <li>are over 60</li> \n\
              <li>are immunocompromised (for example if you have Diabetes, BP, HIV/AIDS, are receiving immunosuppression therapy \n\
                or treatment for cancer or have had a transplant)</li>\n\
               <li>have returned to India from travel in the last 30 days</li> \n\
              <li>have come into contact with someone with respiratory symptoms (SARI)</li> </ul>\n\n\
            <div class="alert alert-warning" role="alert">\n\
            <h4 class="alert-heading"><i class="fa fa-warning mr-3"></i>For Emergency</h4>\n\
            <p>Call 104 or 97456-97456 if at all you experience any symptoms like severe cough, fever or breathlessness.</p>              \n\
                  </div>\n';
    } else {
        result = '<div class="alert alert-success" role="alert">\n\
            <h4 class="alert-heading"><i class="fa fa-info-circle mr-3"></i>Self-assessment result</h4>\n\
            <p>It is unlikely that you have COVID-19.</p>              \n\
                  </div>';
    }

    $('#assessmentResult').html(result);
    return false;
}


$(document).ready(function () {
    $('#covidMenu').addClass('active');
    $('#selfAssessmentMenu').addClass('active');
});