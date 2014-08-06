/**
 * Created by Espada on 2014/8/5.
 */
function download_excel(){
    alert("111");
    $.ajax({
        url: "download_excel",
        type: "get",
        data: null,
        success: function (data){
    alert("Download Success");
        }
    })}