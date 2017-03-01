
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
                        <select id="messageType" class="form-control">
                            <option value="1">贴吧</option>
                            <option value="2">论坛</option>
                            <option value="3">记录</option>
                            <option value="4">活动</option>
                            <option value="5">聊天</option>
                        </select>
                    </div>
                    <div class="col-md-1">
                        <label>特定要求1</label>
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

                </form>
            </div>
            <div class="row" style="margin-top:10px;">
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
                <div class="col-md-1"></div>
                <div class="col-md-2">
                    <input type="submit" class="btn btn-default" value="查询"/>
                    <input type="submit" class="btn btn-default" value="发表"/>
                </div>
            </div>
            <div class="row" style="margin-top:25px;">
                <form id="addForm" action="../addMessage" method="post">
                        <div class="col-md-9">
                            <textarea id="message" name="message" class="form-control" rows="3"></textarea>
                        </div>
                </form>
            </div>
        </div>
    </div>
    <div class="container">
    <div class="row">
        <#list welcomeTag as wt>
            <button class="btn btn-default" type="button">
                ${wt.tagName} <span class="badge" style="background-color: #D9534F">${wt.tagCount}</span>
            </button>
        </#list>
        <#--<button class="btn btn-default" type="button">-->
              <#--Java <span class="badge">3</span>-->
        <#--</button>-->
        <#--<button class="btn btn-default" type="button">-->
              <#--Golang <span class="badge">7</span>-->
        <#--</button>-->
        <#--<button class="btn btn-default" type="button">-->
              <#--设计模式 <span class="badge">8</span>-->
        <#--</button>-->
        <#--<button class="btn btn-default" type="button">-->
              <#--数据结构与算法 <span class="badge">1</span>-->
        <#--</button>-->
        <#--<button class="btn btn-default" type="button">-->
              <#--Spring <span class="badge">5</span>-->
        <#--</button>-->
        <#--<button class="btn btn-default" type="button">-->
              <#--Github <span class="badge">1</span>-->
        <#--</button>-->
    </div>
    <#list welcomeList as wl>
        <div class="media">
            <#--<div class="media-left media-middle">-->
                <#--<a href="#"> ${wl.tag} </a>-->
            <#--</div>-->
            <div class="media-body">
                <h5 class="media-heading">${wl.message}
                    <span class="label label-danger">${wl.tag}</span>
                    <#--<span class="label label-info">Label2</span>-->
                    <#--<span class="label label-success">Label3</span>-->
                </h5>
                <p>${wl.creator}</p>
                <p>${wl.createTime?datetime}</p>
            </div>
        </div>
    </#list>
    </div>
    <#--<script type="text/javascript">-->
        <#--function githubLogin(){-->

        <#--}-->
    <#--</script>-->
    <script src="js/welcome.js"></script>
</body>
</html>