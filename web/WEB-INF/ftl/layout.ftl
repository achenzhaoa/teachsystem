<#macro layout>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Teach System</title>
    <link rel="stylesheet" type="text/css" href="/js/lib/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/css/layout.css"/>
    <script type="text/javascript" src="/js/lib/jQuery-Validate/assets/js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="/js/lib/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="navbar navbar-fixed-top layout-header">
       <div class="container"><img src="/images/logo.png"/></div>
       <div class="container">
           <ul class="nav navbar-nav center-block" style="margin-top: 5px;">
               <li class="active navbar-header"><a href="/portal.vpage">首页</a></li>
               <li class="active navbar-header"><a href="#">课程介绍</a></li>
               <li class="active navbar-header"><a href="#">课件展示</a></li>
               <li class="active navbar-header"><a href="#">师生互动</a></li>
               <li class="active navbar-header"><a href="/index.vpage">管理员系统</a></li>
               <li class="active navbar-header"><a href="/index.vpage">登录系统</a></li>
               <li><a class="glyphicon glyphicon-chevron-right pull-right" href="javascript:history.back();">返回</a></li>
           </ul>
       </div>
   </div>
   <div class="container" style="min-height: 550px;padding: 100px;margin-top: 60px;">
       <#nested>
   </div>
   <div class="panel-footer">
       <h6 class="text-center">@copyright 曾珊珊 2014.1~2014.6</h6>
   </div>
</body>
</html>
</#macro>