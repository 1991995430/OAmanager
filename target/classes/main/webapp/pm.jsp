<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>用户管理</title>
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/docs.min.js"></script>
    <script src="${pageContext.request.contextPath}/layer/layer.js"></script>
    <script type="text/javascript" src="zTree/js/jquery.ztree.core.js"></script>
    <script src="${pageContext.request.contextPath}/zTree/jquery.ztree.all-3.5.min.js"></script>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript">
        $(function(){
            var setting = {
                async: {
                    enable: true,
                    url:"${pageContext.request.contextPath}/getRootSources",
                    autoParam:["id", "name=n", "level=lv"]
                },
                view: {
                    addHoverDom: function(treeId, treeNode){
                        console.info(treeNode.name+":"+treeNode.id+":"+treeNode.url);
                        var aObj = $("#" + treeNode.tId + "_a"); // tId = permissionTree_1, ==> $("#permissionTree_1_a")
                        aObj.attr("href", "javascript:;");
                        if (treeNode.editNameFlag || $("#btnGroup"+treeNode.tId).length>0) return;
                        var s = '<span id="btnGroup'+treeNode.tId+'">';
                        if ( treeNode.level == 0 ) {
                            s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="addNode('+treeNode.id+')" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg "></i></a>';
                        } else if ( treeNode.level == 1 ) {
                            s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  onclick="editNode('+treeNode.id+')" href="#" title="修改权限信息">&nbsp;&nbsp;<i class="fa fa-fw fa-edit rbg "></i></a>';
                            if (treeNode.children.length == 0) {
                                s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="deleteNode('+treeNode.id+')" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-times rbg "></i></a>';
                            }
                            s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="addNode('+treeNode.id+')" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg "></i></a>';
                        } else if ( treeNode.level == 2 ) {
                            s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  onclick="editNode('+treeNode.id+')" href="#" title="修改权限信息">&nbsp;&nbsp;<i class="fa fa-fw fa-edit rbg "></i></a>';
                            s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" onclick="deleteNode('+treeNode.id+')" href="#">&nbsp;&nbsp;<i class="fa fa-fw fa-times rbg "></i></a>';
                        }
                        s += '</span>';
                        aObj.after(s);
                    },
                    removeHoverDom: function(treeId, treeNode){
                        $("#btnGroup"+treeNode.tId).remove();
                    }
                }
            };
            $.fn.zTree.init($("#permissionTree"), setting);

        });
        //添加节点
        function addNode(id){
            //点击添加连接,跳转到我们的添加页面
            window.location.href = "${pageContext.request.contextPath}/toAddpage?id="+id;
        }


        //编辑节点 更新节点
        function editNode(id) {
            // 跳转到了一个控制器方法,控制方法查询出我们当前这个数据,展示到我们的页面
            window.location.href = "${pageContext.request.contextPath}/sourceEditorView?id="+id;
        }



        //删除节点
        function deleteNode(id){
            layer.confirm("删除资源信息, 是否继续",  {icon: 3, title:'提示'}, function(cindex){
                // 删除选择的用户信息
                $.ajax({
                    type : "POST",
                    url  : "${pageContext.request.contextPath}/deleteInfo",
                    data : {id : id},
                    success : function(result) {
                        if (result.flag) {
                            // 刷新数据 获取树对象
                            var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
                            //刷新我们的树
                            treeObj.reAsyncChildNodes(null, "refresh");
                        } else {
                            layer.msg("资源信息删除失败", {time:2000, icon:5, shift:6}, function(){
                            });
                        }
                    }
                });
                layer.close(cindex);
            },function(cindex){
                layer.close(cindex);
            });
        }

    </script>

</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td >
                        当前位置:权限管理>>权限维护
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>


<!--  内容列表   -->
<form name="form2">
    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;权限列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td>
                <div class="panel-body">
                    <ul id="permissionTree" class="ztree"></ul>
                </div>
            </td>
        </tr>

    </table>

</form>


</body>
</html>