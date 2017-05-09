/**
 * Created by Zephyr on 2017/3/1.
 */
var demo = new Vue({
    el: '#messageType',
    data: {
        selected: '1',
        options: [
            { text: '贴吧', value: '1' },
            { text: '论坛', value: '2' },
            { text: '记录', value: '3' },
            { text: '活动', value: '4' },
            { text: '聊天', value: '5' }
        ]
    }
})
// $(function(){
//     $("#messageType").change(function(){
//         loadSubject($("#messageType option:selected").val());
//     });
//     new Vue({
//         el: '#messageType',
//         data: {
//             selected: 'A',
//             options: [
//                 { text: 'One', value: 'A' },
//                 { text: 'Two', value: 'B' },
//                 { text: 'Three', value: 'C' }
//             ]
//         }
//     })
// });
//
// function loadSubject(select){
//     if(select==1){
//         $.get("http://localhost:8090/loadSubject?select="+select,function(data){
//             $("#subjectLabel").text("主题");
//             for(var i=0;i<data.keys.length;i++){
//                 $("#subjectSelect").append("<option value='"+data["keys"][i]+"'>"+data["values"][i]+"</option>")
//             }
//         });
//     }
// }