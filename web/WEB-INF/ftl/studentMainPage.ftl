<#import "layout.ftl" as layout/>
<@layout.layout>
    Hello Student
    <form action="/uploadFile.vpage" method="post" enctype="multipart/form-data">
        <input type="file" name="filedata"/>
        <input type="submit"/>
    </form>
    <div class="container">
        <div class="row-fluid">
            <#list files as file>
                <div class="file-item">
                    <div class="file-${file.getType()}"></div>
                    <a class="text-center" href="/files/${file.getFileName()}" target="_blank">${file.getFileName()}</a>
                </div>
            </#list>
        </div>
    </div>
</@layout.layout>
