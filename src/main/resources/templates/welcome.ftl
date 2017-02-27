
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "common/commoncss.ftl">
    <style>
        #editorInput{
            width:500px;
            resize: none;
        }
        #editorArea{
            text-align: center;
        }
    </style>
</head>
<body>
<#include "common/top.ftl">

<div class="container theme-showcase" role="main">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <h3>发布新内容</h3>
        <div class="row">
            <form action="../addMessage" method="post">
                <div class="col-md-10">
                    <textarea id="message" name="message" class="form-control" rows="5"></textarea>
                </div>
                <div class="col-md-2">
                    <input type="submit" class="btn btn-lg btn-default" value="发表"/>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <button class="btn btn-default" type="button">
              Java <span class="badge">3</span>
        </button>
        <button class="btn btn-default" type="button">
              Golang <span class="badge">7</span>
        </button>
        <button class="btn btn-default" type="button">
              设计模式 <span class="badge">8</span>
        </button>
        <button class="btn btn-default" type="button">
              数据结构与算法 <span class="badge">1</span>
        </button>
        <button class="btn btn-default" type="button">
              Spring <span class="badge">5</span>
        </button>
        <button class="btn btn-default" type="button">
              Github <span class="badge">1</span>
        </button>
    </div>
    <#list messageLibList as message>
        <div class="media">
            <div class="media-left media-middle">
                <a href="#"> <img alt="64x64" class="media-object" data-src="holder.js/64x64" style="width: 64px; height: 64px;" src="http://oj7231hub.bkt.clouddn.com/e6d676b76ec14fd2b9709f13379c0f1c.jpeg" data-holder-rendered="true"> </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">Middle aligned media
                    <span class="label label-danger">Label1</span>
                    <span class="label label-info">Label2</span>
                    <span class="label label-success">Label3</span>
                </h4>
                <p>${message.content}</p>
                <p>${message.creator}</p>
                <p>${message.createTime?datetime}</p>
            </div>
        </div>
    </#list>

    <script type="text/javascript">
        function githubLogin(){

        }
    </script>
</body>
</html>