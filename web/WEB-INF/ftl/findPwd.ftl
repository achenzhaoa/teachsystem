<#import "layout.ftl" as layout/>
<@layout.layout>
<h3 class="text-center">用户找回密码</h3>
<form class="form-horizontal loginForm" role="form" action="/findPwd.vpage" method="post" style="width: 560px;">
    <h6 style="color:red;" class="text-center">${err!''}</h6>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">用户</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" placeholder="用户名" name="name">
        </div>
    </div>
    <h4 class="text-center">您的密码：${pwd!''}</h4>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-primary col-lg-offset-3">找回密码</button>
        </div>
    </div>
</form>
</@layout.layout>