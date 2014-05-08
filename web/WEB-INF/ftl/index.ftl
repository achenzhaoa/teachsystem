<#import "layout.ftl" as layout/>
<@layout.layout>
<h3 class="text-center">用户登录</h3>
<form class="form-horizontal loginForm" role="form" action="/login" method="post">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">用户</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" id="inputEmail3" placeholder="用户名" name="name">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword3" placeholder="密码" name="pwd">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-primary col-lg-offset-4">登录</button>
        </div>
    </div>
</form>
</@layout.layout>