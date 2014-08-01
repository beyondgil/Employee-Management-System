/**
 * Created by Espada on 2014/8/1.
 */
function disagree1(){
    alert("get in to verify.js")
    $.get("RequestDisgree",null,f_process);


}
function f_process(data){
    alert("cannot change");

}