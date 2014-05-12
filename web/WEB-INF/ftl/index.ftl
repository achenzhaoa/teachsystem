<#import "layout.ftl" as layout/>
<@layout.layout>
<h3 class="text-center">用户登录</h3>
<form class="form-horizontal loginForm" role="form" action="/login.vpage" method="post">
    <h6 style="color:red;" class="text-center">${err!''}</h6>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">用户</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" placeholder="用户名" name="name">
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
            <button type="submit" class="btn btn-default btn-primary col-lg-offset-3">登录</button>
            <a class="changeLink" href="/changepwdIndex.vpage" target="_blank">修改密码</a>
            <a class="findLink" href="/findpwd.vpage" target="_blank">找回密码</a>
        </div>
    </div>
</form>
</@layout.layout>