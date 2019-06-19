<%--
  Created by IntelliJ IDEA.
  User: jack
  Date: 2019/6/13
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>前台登录界面</title>
    <%--<script type="text/javascript" src="${pageContext.request['contextPath']}/jquery-easyui-1.8.1/jquery.easyui.min.js"> </script>--%>
    <script type="text/javascript" src="./jquery-easyui-1.8.1/jquery.min.js"></script>
    <script type="text/javascript" src="./jquery-easyui-1.8.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="./jquery-easyui-1.8.1/easyloader.js"></script>
    <link rel="stylesheet" type="text/css" href="./jquery-easyui-1.8.1/themes/gray/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="./jquery-easyui-1.8.1/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="./jquery-easyui-1.8.1/demo/demo.css"/>
    <link rel="stylesheet" type="text/css" href="./jquery-easyui-1.8.1/themes/default/easyui.css"/>
</head>
<body>
<div class="demo-info">表单</div>
<div class="easyui-panel" title="我的表单" style="width: 400px">
    <div style="padding: 10px 0px 10px 60px">
        <form id="ff" action="form" method="get">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td><input class="easyui-textbox" name="name" data-options="required:true"></td>
                </tr>
            </table>

        </form>
    </div>
    <div style="text-align: center;padding: 5px">
        <a href="./WordDemo/demo/insertList" class="easyui-linkbuton" onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbuton" onclick="clearForm()">重置</a>
    </div>
</div>
</body>
<script type="text/javascript">
    function submitForm() {
      $("#ff").form("submit");
    }
    function  clearForm() {
        $("#ff").form("clear");
    }
</script>
</html>
