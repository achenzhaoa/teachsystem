<#import "../layout.ftl" as layout/>
<@layout.layout>
<h2 class="text-center">系统用户列表</h2>
<a class="text-center" href="/adduser.vpage">添加用户</a>
<table class="table table-bordered">
    <thead>
    <th>ID</th>
    <th>用户名</th>
    <th>密码</th>
    <th>角色</th>
    <th>激活状态</th>
    <th>删除</th>
    </thead>
    <tbody>
        <#list users as user>
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getPwd()}</td>
            <td>${user.getRole()}</td>
            <td>
                <#if user.isActive()==false>
                    <a href="/activeUser.vpage?id=${user.getId()}">激活</a>
                <#else>
                    已激活
                </#if>
            </td>
            <td><a href="deleteUser.vpage?id=${user.getId()}">删除</a></td>
        </tr>
        </#list>
    </tbody>
</table>
</@layout.layout>