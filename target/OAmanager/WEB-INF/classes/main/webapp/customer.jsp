<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>客户信息管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:客户信息管理>>客户信息
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='customer-add.jsp';" value='添加客户信息' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>
<!--  搜索表单  -->
<!-- <form name='form3' action='' method='get'> -->
<input type='hidden' name='dopost' value='' />
<form id="form1">
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='searchType'>
            <option value='0'>选择类型...</option>
          	<option value='1'>客户所在公司名称</option>
          	<option value='2'>联系人姓名</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='key' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='order'>
            <option value='id'>排序...</option>
            <option value='addtime'>添加时间</option>
            <option value='addtime'>修改时间</option>
      	</select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input id="search" name="imageField" type="submit" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
    <!-- </form> -->
<!--  内容列表   -->

<form id="form2">
	<table id="tb" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
		</tr>
		<tr align="center" bgcolor="#FAFAF1" height="22">
			<td width="4%">选择</td>
			<td width="6%">序号</td>
			<td width="10%">联系人</td>
			<td width="10%">公司名称</td>
			<td width="8%">添加时间</td>
			<td width="8%">联系电话</td>
			<td width="10%">操作</td>
		</tr>
		<!-- 插入的内容 -->
		<tr bgcolor="#FAFAF1">
		<td height="28" colspan="12">
			&nbsp;
			<a id="selectAll" href="javascript:;" class="coolbg">全选</a>
			<a id="selectNone" href="javascript:;" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- <a href="javascript:;" id="del" class="coolbg">&nbsp;删除&nbsp;</a> -->
			<input type="submit" value="删除" class="coolbg" id="del">
			<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
		</td>
		</tr>
		<tr align="right" bgcolor="#EEF4EA">
			<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
		</tr>
	</table>
</form>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
    $(function () {
        customerList('${pageContext.request.contextPath}/customerlist');//初始化页面

        //搜索
        $('#form1').submit(function () {
            var param = $('#form1').serialize();
            var url="${pageContext.request.contextPath}/customerlist?"+param;
            customerList(url);
            return false;
        });

        //全选
        $('#selectAll').click(function () {
            $('input[name="ids"]').prop('checked','checked');
        });
        //反选
        $('#selectNone').click(function () {
            $('input[name="ids"]').each(function (index,ele) {
                $(ele).prop('checked',!$(this).prop('checked'));
            });
        });

        //批量删除
        $('#form2').submit(function () {
            var param = $('#form2').serialize();
            alert(param);
            $.post('${pageContext.request.contextPath}/customerdel',param,function (data) {
               if(data.msgCode==200){
                   customerList('${pageContext.request.contextPath}/customerlist');
               }
            },'json');
            return false;
        });
       /* $('#del').click(function () {
            
        });*/
    });
    
    var customerList=function (url) {
        $('#tb tr:eq(1)').nextUntil("tr:eq(-2)").remove();

        $.get(url,function (data) {
            //alert(data);
            $(data).each(function (index,ele) {
                $('#tb tr:eq(1)').after('<tr align="center" bgcolor="#FAFAF1" height="22">'
                   +' <td width="4%"><input name="ids" value="'+ele.id+'" type="checkbox"></td>'
                   +' <td width="6%">'+ele.id+'</td>'
                   +'<td width="10%">'+ele.companyperson+'</td>'
                   +'<td width="10%">'+ele.comname+'</td>'
                   +'<td width="8%">'+ele.addtime+'</td>'
                   +'<td width="8%">'+ele.comphone+'</td>'
                   +'<td width="10%"><a href="${pageContext.request.contextPath}/customermodifyview?id='+ele.id+'">修改</a><a href="javascript:;" onclick="delids('+ele.id+')">删除</a></td>'
                   +'</tr>');
            })
        },'json');
    }

    var delids=function (ids) {
       $.get('${pageContext.request.contextPath}/customerdel?ids='+ids,function (data) {
           if(data.msgCode==200){
               customerList('${pageContext.request.contextPath}/customerlist');
           }
       },'json');
    }
</script>
</body>
</html>