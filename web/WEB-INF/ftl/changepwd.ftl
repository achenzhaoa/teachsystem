<#import "layout.ftl" as layout/>
<@layout.layout>
<h3 class="text-center">用户找回密码</h3>
<form class="form-horizontal loginForm" role="form" action="/changepwd.vpage" method="post" style="width: 560px;">
    <h6 style="color:red;" class="text-center">${err!''}</h6>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">用户</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" placeholder="用户名" name="name">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">原始密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword3" placeholder="原始密码" name="pwd">
        </div>
    </div>

    <div class="form-group">
        <label for="inputPassword4" class="col-sm-2 control-label">新的密码</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword4" placeholder="新的密码" name="newpwd">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-primary col-lg-offset-3">修改密码</button>
        </div>
    </div>
</form>
</@layout.layout>