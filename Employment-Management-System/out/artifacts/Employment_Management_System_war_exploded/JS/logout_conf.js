/**
 * Created by Espada on 2014/8/5.
 */
function logout_conf(){
    var r=confirm("Do you want to logout!");
    if (r==true)
    {
        var form=document.getElementById("back");
        form.submit();
    }
    else
    {
        return false;
    }
}



