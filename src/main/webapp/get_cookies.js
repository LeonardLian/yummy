/**
 * Created by Leonarda on 2019/3/8.
 */
function getcookie(name) {
    var startIndex=document.cookie.indexOf(name);
    if(startIndex>-1){
        var tempStr=document.cookie.substring(startIndex,document.cookie.length);
        var endIndex=tempStr.indexOf(";");
        if(endIndex>-1) {
            var item = tempStr.substring(0, endIndex);
            return item.split("=")[1];
        }
        else {
            return tempStr.split("=")[1];
        }
    }else {
        return "";
    }
}