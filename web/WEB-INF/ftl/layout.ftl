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
   <div class="navbar navbar-inverse navbar-fixed-top layout-header">
       <h3 class="text-center" style="color: #ffffff;">C语言教学系统</h3>
   </div>
   <div class="container" style="min-height: 550px;padding: 100px;">
       <a class="glyphicon glyphicon-align-justify" href="/index.vpage">首页</a>
       <a class="glyphicon glyphicon-chevron-left pull-right" href="javascript:history.back();">返回</a>
       <#nested>
   </div>
   <div class="panel-footer">
       <h6 class="text-center">@copyright 曾珊珊 2014.1~2014.6</h6>
   </div>
</body>
</html>
</#macro>