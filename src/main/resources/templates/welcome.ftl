
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "common/commoncss.ftl">
</head>
<body>
<#include "common/commontop.ftl">
Date: ${time?date}
<br>
Time: ${time?time}
<br>
Message: ${message}


<blockquote class="layui-elem-quote">
    温馨提示：如果最左侧的导航的高度超出了你的屏幕，你可以将鼠标移入导航区域，然后滑动鼠标滚轮即可
</blockquote>

<div class="layui-tab layui-tab-card" lay-filter="demo" style="height: 300px;">
    <ul class="layui-tab-title">
        <li class="layui-this">演示说明</li>
        <li>标题一</li>
        <li>标题二</li>
        <li>标题三</li>
    </ul>
    <div class="layui-tab-content" style="padding: 10px;">
        <div class="layui-tab-item layui-show">
            在这里，你将以最直观的形式体验Layui！在编辑器中可以执行layui相关的一切代码。
            <br>你也可以点击左侧导航针对性地试验我们提供的示例。
            <!--<br><br><a target="_blank" href="https://jq.qq.com/?_wv=1027&k=41lnosl" class="layui-btn">加入Layui开发者交流群</a>（系网友提供）-->
        </div>
        <div class="layui-tab-item">内容1</div>
        <div class="layui-tab-item">内容2</div>
        <div class="layui-tab-item">内容3</div>
    </div>
</div>

<fieldset class="layui-elem-field">
    <legend>字段集</legend>
    <div class="layui-field-box">
        内容区域
    </div>
</fieldset>

<div id="pageDemo"></div>

<div id="app">
    {{ message }}
</div>

<script>
    layui.use(['layer', 'laypage', 'element'], function(){
        var layer = layui.layer
                ,laypage = layui.laypage
                ,element = layui.element();

        //向世界问个好
        layer.msg('Hello World', {
            icon: 6
            ,time: 6*1000 //6s后自动消失
            //,offset: 'b' //从底部弹出
        });

        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.msg('切换了：'+ this.innerHTML);
            console.log(data);
        });

        //分页
        laypage({
            cont: 'pageDemo' //分页容器的id
            ,pages: 100 //总页数
            ,skin: '#5FB878' //自定义选中色值
            ,skip: true //开启跳页
            ,jump: function(obj, first){
                if(!first){
                    layer.msg('第'+ obj.curr +'页');
                }
            }
        });
    });
</script>

<script>
    var app = new Vue({
        el: '#app',
        data: {
            message: 'Hello Vue!'
        }
    })
</script>
<#include "common/commonjs.ftl">
</body>
</html>