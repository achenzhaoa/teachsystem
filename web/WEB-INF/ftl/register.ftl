<#import "layout.ftl" as layout/>
<@layout.layout>
<link type="text/css" rel="stylesheet" href="/js/lib/jQuery-Validate/style.css"/>
<form action="${actionUrl}" method="post" id="contact-form" class="form-horizontal">
    <fieldset>
        <legend>用户注册</small></legend>
        <div class="control-group">
            <label class="control-label" for="name">用户名</label>
            <div class="controls">
                <input type="text" class="input-xlarge" name="name" id="name">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="pwd">密码</label>
            <div class="controls">
                <input type="password" class="input-xlarge" name="pwd" id="pwd">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="pwd1">确认密码</label>
            <div class="controls">
                <input type="password" class="input-xlarge" name="pwd1" id="pwd1">
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="role">角色</label>
            <div class="controls">
                <select name="role" id="role">
                    <#list roles as role>
                        <option value="${role.getName()}">${role.getDescription()}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="message">个人介绍</label>
            <div class="controls">
                <textarea class="input-xlarge" name="message" id="message" rows="3"></textarea>
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">提交</button>
            <button type="reset" class="btn">取消</button>
        </div>
    </fieldset>
</form>
<script type="text/javascript">
    $(document).ready(function(){
        $('#contact-form').validate(
                {
                    rules: {
                        name: {
                            minlength: 2,
                            required: true
                        },
                        pwd: {
                            minlength: 2,
                            required: true
                        },
                        pwd1: {
                            minlength: 2,
                            required: true,
                            equalTo :"#pwd"
                        },
                        message: {
                            minlength: 2,
                            required: true
                        }
                    },
                    highlight: function(element) {
                        $(element).closest('.control-group').removeClass('success').addClass('error');
                    },
                    success: function(element) {
                        element
                                .text('OK!').addClass('valid')
                                .closest('.control-group').removeClass('error').addClass('success');
                    }
                });
    }); // end document.ready
</script>
</@layout.layout>