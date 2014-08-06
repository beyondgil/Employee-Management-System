/**
 * Created by Espada on 2014/8/1.
 */
function getcheck() {

    var department = $("input[name='department']:checked").serialize();

    $.ajax({
        url: "Get_m",
        type: "post",
        data: department,
        success: function (data){

            var resultobj=$("#show_m");
            resultobj.html(data);
        }
    })}


function show_confirm()
{	var info_check=check();
    if(info_check==true){

        var r=confirm("Do you want to change your Information!");
        if (r==true)
        {
            alert("You pressed OK!");
            var form=document.getElementById("form1");
            form.submit();
        }
        else
        {
            return false;
        }
    }
}

function check(){
    return checkEmail();

}

function show_w_img(){
    var w_img= document.getElementById("warning_img");
    w_img.src="images/exclamation-mark-red-md.png";
    w_img.height=30;
    w_img.width=30;
}
function checkEmail(px) {
    px = px || px;
    var div = document.getElementById("div_email");

    div.innerHTML = "";
    var email = document.form1.email.value;
    var sw = email.indexOf("@", 0);
    var sw1 = email.indexOf(".", 0);
    var tt = sw1 - sw;
    if (email.length == 0) {
        show_w_img();
        div.innerHTML = "email cannot empty";
        document.form1.email.focus();
        return false;
    }
    if (email.indexOf("@", 0) == -1) {
        show_w_img();
        div.innerHTML = "format error";
        document.form1.email.select();
        return false;
    }
    if (email.indexOf(".", 0) == -1) {
        show_w_img();
        div.innerHTML = "format error";
        document.form1.email.select();
        return false;
    }
    if (tt == 1) {
        show_w_img();
        div.innerHTML = "format error";
        document.form1.email.select();
        return false;
    }
    if (sw > sw1) {
        show_w_img();
        div.innerHTML = "format error";
        document.form1.email.select();
        return false;
    }
    else {
        var w_img= document.getElementById("warning_img");
        w_img.src="";
        w_img.height=0;
        w_img.width=0;
        return true;
    }

    return true;
}
