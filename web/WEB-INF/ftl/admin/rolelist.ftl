<#import "../layout.ftl" as layout/>
<@layout.layout>
<h2 class="text-center">系统角色列表</h2>
<a class="text-center" href="/addrole.vpage">添加角色</a>
<table class="table table-bordered">
    <thead>
    <th>ID</th>
    <th>角色名</th>
    <th>描述</th>
    <th>删除</th>
    </thead>
    <tbody>
    <#list roles as role>
        <tr>
            <td>${role.getId()}</td>
            <td>${role.getName()}</td>
            <td>${role.getDescription()}</td>
            <td><a href="deleteRole.vpage?id={role.getId()}">删除</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@layout.layout>