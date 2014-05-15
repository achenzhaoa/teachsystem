<#import "layout.ftl" as layout/>
<@layout.layout>
    <h3 class="text-center">学生主页</h3>

    <form action="/uploadFile.vpage" method="post" enctype="multipart/form-data" style="border: 1px solid #D0D0D0; margin: 0 auto; width: 380px; padding: 20px;">
        <input type="file" name="filedata" style="display: inline-block;"/>
        <input type="submit"/>
    </form>
    <div class="container">
        <div class="row">
            <#list files as file>
                <div class="file-item col-lg-3 text-center">
                    <a class="text-center" href="/files/${file.getFileName()}" target="_blank">
                    <img src="/images/${file.getType()}.png" class="file"/>
                    ${file.getFileName()}</a>
                </div>
            </#list>
        </div>
    </div>
<script type="text/javascript">
    $(function(){
       $('.file-item').hover(function(){
           $(this).append('<a class="playclass" href="'+$(this).find('a:eq(0)').attr('href')+'"><img src="/images/play.png" class="playImg"/></a> ');
       },function(){
            $(this).find('.playclass').remove();
       });
    });
</script>
</@layout.layout>
