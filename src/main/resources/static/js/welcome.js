/**
 * Created by Zephyr on 2017/3/1.
 */
$(function(){
    $("#messageType").change(function(){
        loadSubject($("#messageType option:selected").val());
    });
});

function loadSubject(select){
    if(select==1){
        $.get("http://localhost:8090/loadSubject?select="+select,function(data){
            $("#subjectLabel").text("主题");
            for(var i=0;i<data.keys.length;i++){
                $("#subjectSelect").append("<option value='"+data["keys"][i]+"'>"+data["values"][i]+"</option>")
            }
        });
    }
}