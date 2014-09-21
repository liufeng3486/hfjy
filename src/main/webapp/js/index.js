var sysTopicTypes;

$(function(){
    $.get("ajaxTopicType",function(data){
        sysTopicTypes = eval("(" + data + ")");
        renderTopicTypeList()
    });
});

function renderTopicTypeList(){
    var obj = $("#topicTypeList").empty();

    $(sysTopicTypes).map(function() {
        var link = $("<a></a>").attr({
            "href": "javascript:void(0);"
        }).html(this.typename).appendTo(obj);
    });
}
