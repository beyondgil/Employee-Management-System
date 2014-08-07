/**
 * Created by Espada on 2014/8/5.
 */
function download_excel(){
    $.ajax({
        url: "download_excel",
        type: "get",
        data: null,
        success: function (data){
    alert("Download Success");
        }
    })}