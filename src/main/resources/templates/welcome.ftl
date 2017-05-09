
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "common/common.ftl">

</head>
<body>
<#include "common/top.ftl">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
        <h3>发布新内容</h3>
            <div class="row">
                <form id="queryForm" action="#" method="get">
                    <div class="col-md-1">
                        <label>类型</label>
                    </div>
                    <div class="col-md-2">
                        <select id="messageType" class="form-control" v-model="selected">
                            <option v-for="option in options" v-bind:value="option.value">
                                {{option.text}}
                            </option>
                        </select>
                    </div>
                    <div class="col-md-1">
                        <label id="subjectLabel">特定要求1</label>
                    </div>
                    <div class="col-md-2">
                        <select id="subjectSelect" class="form-control">
                        </select>
                    </div>
                    <div class="col-md-1">
                        <label>特定要求2</label>
                    </div>
                    <div class="col-md-2">
                        <input type="text" id="tag" name="tag"/>
                    </div>
                    <div class="col-md-1">
                        <label>特定要求2</label>
                    </div>
                    <div class="col-md-2">
                        <input type="text" id="tag" name="tag"/>
                    </div>
                </form>
            </div>
            <div class="row" style="margin-top:10px;">
                <form id="queryForm" action="#" method="get">
                    <div class="col-md-1">
                        <label>特定要求3</label>
                    </div>
                    <div class="col-md-2">
                        <input type="text" id="tag" name="tag"/>
                    </div>
                    <div class="col-md-1">
                    <label>特定要求4</label>
                    </div>
                    <div class="col-md-2">
                        <input type="text" id="tag" name="tag"/>
                    </div>
                    <div class="col-md-1">
                        <label>发布标签</label>
                    </div>
                    <div class="col-md-2">
                        <input type="text" id="tag" name="tag"/>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-3">
                        <input type="submit" class="btn btn-default" value="查询"/>
                        <input type="submit" class="btn btn-default" value="发表"/>
                        <input type="submit" class="btn btn-default" value="保存"/>
                    </div>
                </form>
            </div>
            <div class="row" style="margin-top:25px;">
                <form id="addForm" action="../addMessage" method="post">
                        <div class="col-md-12">
                            <textarea id="message" name="message" class="form-control" rows="3"></textarea>
                        </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="row" style="margin-top:10px;">贴吧>计算机>Java>Java设计模式</div>
                <div class="row" style="margin-top:10px;">论坛>Java>Solo博客搭建教程</div>
                <div class="row" style="margin-top:10px;">记录>XX需求工作日记>WARNING</div>
                <div class="row" style="margin-top:10px;">活动>古诗三句半</div>
                <div class="row" style="margin-top:10px;">聊天>王者荣耀开黑>一闪一闪亮晶晶</div>
            </div>
            <div class="col-md-9">
                <div class="row">
                <#--<#list welcomeTag as wt>-->
                    <#--<button class="btn btn-default" type="button" onclick="selectTag()">-->
                    <#--${wt.tagName} <span class="badge" style="background-color: #D9534F">${wt.tagCount}</span>-->
                    <#--</button>-->
                <#--</#list>-->
                </div>
                <#--<#list welcomeList as wl>-->
                    <#--<div class="media">-->
                        <#--<div class="media-body">-->
                            <#--<h5 class="media-heading">${wl.message}-->
                                <#--<span class="label label-danger">${wl.tag}</span>-->
                            <#--</h5>-->
                            <#--<p>${wl.creator}</p>-->
                            <#--<p>${wl.createTime?datetime}</p>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</#list>-->
            </div>
        </div>
    </div>
    <script src="js/welcome.js"></script>
</body>
</html>