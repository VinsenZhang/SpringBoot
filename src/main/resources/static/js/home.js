function login() {
    $.ajax({
        type: 'POST',
        url: "/doLogin",
        data: $("#loginForm").serialize(),
        success: function (data) {
            if ("success" == data)
                location.href = "/index";
            else {
                $("#alertInfo").show();
                $("#loginForm")[0].reset();
                $("input[name=loginUsername]").focus();
            }
        },
        dataType: "text"
    });
}

function unamecr(e) {
    if (e.which == 13) { // enter key event
        $("input[name=loginPassword]").focus();
    }
}


function upasscr(e) {
    if (e.which == 13) { // enter key event
        $("#loginBtn").click();
    }
}

$(document).ready(function () {
    $("#loginBtn").click(login);
    $("input[name=loginUsername]").keypress(unamecr);
    $("input[name=loginPassword]").keypress(upasscr);
});