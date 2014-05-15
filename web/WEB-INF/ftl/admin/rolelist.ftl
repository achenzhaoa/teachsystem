<#import "../layout.ftl" as layout/>
<@layout.layout>
<h2 class="text-center">系统角色列表</h2>
<a class="text-center glyphicon glyphicon-user" href="/addrole.vpage">添加角色</a>
<hr/>
<div class="container">
    <div class="row">
        <#list roles as role>
            <div class="col-lg-3 text-center">
                <img src="/images/role.png"/>
                <span class="text-center clearfix">${role.getDescription()}</span>
                <a href="deleteRole.vpage?id=${role.getId()}" class="glyphicon glyphicon-remove">删除</a>
            </div>
        </#list>
    </div>
</div>
</@layout.layout>