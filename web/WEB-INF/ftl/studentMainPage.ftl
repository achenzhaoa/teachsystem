Hello Student
<form action="/uploadFile.vpage" method="post" enctype="multipart/form-data">
    <input type="file" name="filedata"/>
    <input type="submit"/>
</form>
<div class="container">
    <h3 class="text-center">
        <#list files as file>
            <a href="/files/${file.getFilename()}" target="_blank">${file.getFilename()}</a>
        </#list>
    </h3>
</div>