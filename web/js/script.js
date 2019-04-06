var screen = "";

function operatorFunx() {
    var type = null;
    var numbers = [];
    var params = "";
    if (screen.indexOf("+") != -1) {
        numbers = screen.split("+");
        type="sum";
    } else if (screen.indexOf("-") != -1) {
        numbers = screen.split("-");
        type="sub";
    } else if (screen.indexOf("*") != -1) {
        numbers = screen.split("*");
        type = "mpy";
    } else if (screen.indexOf("/") != -1) {
        numbers = screen.split("/");
        type = "div";
    }

    if(type && numbers.length > 0){
        var x = numbers[0];
        var y = numbers[1];
        params = "type="+encodeURIComponent(type)+"&x="+encodeURIComponent(x)+"&y="+encodeURIComponent(y);

        var xhr = new XMLHttpRequest();
        console.log("params",params);
        xhr.open("GET", '/calculate?' + params, true);
        xhr.send();

        xhr.onload = function() {
            if (xhr.status == 200) {
                console.log(xhr.response);
                screen = xhr.response;
                console.log("SCREEN:"+screen);
            } else {
                console.log("Something went wrong!");
            }
            document.getElementById("res").innerHTML = screen;
        };
    }

}

function key(c) {
    //console.log(screen);
    arithmetic_operations = ['+', '-', '*', '/']
    if(arithmetic_operations.indexOf(c) !== -1){
        for(i=0;i<arithmetic_operations.length;i++){
            if(screen.indexOf(arithmetic_operations[i]) !== -1)
                c = "";
        }
    }
    screen += c;
    document.getElementById("res").innerHTML = screen;
}

function cl() {
    screen = "";
    document.getElementById("res").innerHTML = screen;
}