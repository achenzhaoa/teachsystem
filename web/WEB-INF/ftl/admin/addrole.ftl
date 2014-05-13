<#import "../layout.ftl" as layout/>
<@layout.layout>
<h6 class="text-center">添加角色</h6>
<form class="form-horizontal loginForm" role="form" action="/addrole.vpage" method="post">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">角色</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" placeholder="角色名" name="name">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">描述</label>
        <div class="col-sm-10">
            <textarea class="form-control" id="inputPassword3" placeholder="密码" name="desc" rows="3"></textarea>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default btn-primary offset4">登录</button>
        </div>
    </div>
</form>
</@layout.layout>