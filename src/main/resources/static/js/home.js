function limitCount() {
    var ele = document.getElementById('extBox');
    var eleCount = ele.childElementCount;
    $("#limitDiv").text(eleCount + "/200");
}

function setExtCheck(val) {
    var checked = val.getAttribute("value");
    $.ajax({
        url: "/savecheck",
        type: "PATCH",
        data: {
            "checked": checked
        }
    }).done(function(fragment) {
    });
}

function saveExt(inputExt) {
        $.ajax({
            url: "/save",
            type: "POST",
            data: {
                "result": inputExt
            },
        }).done(function(fragment) {
            if (fragment > 0) {
                $("#extBox").append("<div class='elementBox' id=elementBox" + fragment + ">\n" +
                    "                <div class='element'>" + inputExt + "</div>\n" +
                    "                <button class='delBtn\' id=" + fragment + ">X</button></div>");
                limitCount();
                $("#inputext").val('');
            } else if (fragment > -2) {
                alert("중복된 확장자입니다.");
            } else if (fragment > -3) {
                alert("길이 제한입니다.");
            } else if (fragment > -4){
                alert("고정 확장자입니다.");
            } else{
                alert("개수 초과입니다.");
            }
        });
}

function delExt(num) {
    $.ajax({
        url: "/delext",
        type: "DELETE",
        data: {
            "num": num
        },
    }).done(function(fragment) {
        $("#elementBox" + num).remove();
        limitCount();
    });
}

function delAllExt() {
    $.ajax({
        url: "/delallext",
        type: "DELETE",
    }).done(function(fragment) {
        $(".elementBox").remove();
        limitCount();
    });
}