<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/13
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
   <script language="JavaScript">
        //使用ajax发送异步请求获取数据，进行呈现
       $(function(){  //jquery加载事件
           //使用easyui的下拉列表绑定数据
           $("#select").combobox({
               url:'getAllConent',
               valueField:'id',
               textField:'name'
           });


           //给添加按钮添加异步提交表单   easyui提交表单
           $("#button").click(function(){
               $('#form1').form('submit',{
                   url:"addContent",
                   success:function(data){  //data表示的字符串
                       //将返回的json字符串转化为json对象
                       data=$.parseJSON(data);
                       if(data.result==1){
                           $.messager.alert('>>提示','添加成功！','info');  //提示框
                       }else{
                           $.messager.alert('>>提示','添加失败！','error');
                       }
                   }
               });

           });


       });

   </script>
</head>
<body>

<p>添加广告:</p>
<form action="addContent" method="post" enctype="multipart/form-data" name="form1" id="form1">
    <p>类别

        <select name="categoryId" id="select" style="width: 150px;"></select>
    </p>
    <p>标题:
        <input type="text" name="title" id="textfield" />
    </p>
    <p>url:
        <input type="text" name="url" id="textfield2" />
    </p>
    <p>图片:
        <input type="file" name="pfile" id="fileField" />
    </p>
    <p>状态:
        <input type="radio" name="status" id="radio" value="1" />
        启用
        <input type="radio" name="status" id="radio2" value="0" />
        停用 </p>
    <p>顺序:
        <input type="text" name="sortOrder" id="textfield3" />
    </p>
    <p>
        <input type="button" name="button" id="button" value="添加" />
    </p>
    <p>&nbsp;</p>
</form>
</body>
</html>
