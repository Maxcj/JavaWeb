<%--
  Created by IntelliJ IDEA.
  User: maxcj
  Date: 2020/8/1
  Time: 7:42 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="/statics/css/bootstrap.min.css"/>
    <script src="/statics/js/jquery.min.js"></script>
    <script src="/statics/js/bootstrap.min.js"></script>
    <script src="/statics/js/md5.js"></script>
</head>
<body>
<div class="panel-body">

    <form action="LoginServlet" method="get"
          onsubmit="return validate();">

        <div class="form-group">
            <label>邮&nbsp;箱:</label> <input type="text" class="form-control"
                                            name="email" id="email" value="">
        </div>
        <div class="form-group">
            <label>密&nbsp;码:</label> <input type="password" class="form-control"
                                            name="password" id="password" value="">
        </div>
        <div class="form-group">
							<span> <label class="checkbox-inline"> <input checked="checked"
                                                                          type="checkbox" name="rememberMe"
                                                                          value="true">记住密码？
							</label>
							</span>
        </div>

        <div class="form-group">
            <div class="col-md-4 col-md-offset-3">
                <input type="submit" class="btn btn-primary" name="" value="登录">
            </div>
            <div>
                <input type="reset" class="btn btn-warning" name="" value="重置">
            </div>
        </div>
    </form>
    <div class="form-group">
        <p align="center">
            <a href="adminlogin.jsp">管理员登录</a><br><b>还没有账号？</b><a href="register.jsp">立即注册</a>
        </p>
    </div>
</div>

<script type="text/javascript">
    function validate() {
        var email = document.getElementById("email");
        var password = document.getElementById("password");
        if (email.value == "") {
            alert("邮箱不能为空！");
            email.focus();
            return false;
        }
        if (password.value == "") {
            alert("密码不能为空！");
            password.focus();
            return false;
        }
        document.getElementById("password").value = md5(password);
        return true;
    }
</script>


</body>
</html>
