<#import "../layout.ftl" as layout/>
<@layout.layout>
<h2 class="text-center">系统用户列表</h2>
<a class="text-center glyphicon glyphicon-user" href="/adduser.vpage">添加用户</a>
<hr/>
<div class="container">
    <div class="row">
        <#list users as user>
            <div class="col-lg-3 user-item">
                <img src="/images/user.png"/>
                <span class="text-center clearfix">${user.getName()}</span>
                <span class="text-center"><#if user.isActive()==false>
                    <a href="/activeUser.vpage?id=${user.getId()}" class="glyphicon glyphicon-lock">激活</a>
                <#else>
                    <span class="active">已激活</span>
                </#if></span>
                <a href="deleteUser.vpage?id=${user.getId()}" class="glyphicon glyphicon-remove">删除</a>
            </div>
        </#list>
    </div>
</div>
</@layout.layout>