<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>附件管理</title>
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
    当前位置:个人报销管理>>报销审批
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='mybaoxiao-add.jsp';" value='添加报销' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>


<!--  内容列表   -->
<form name="form2">

<table id="tb1" width="98%"  cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;附件列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="20%">编号</td>
	<td width="6%">总金额</td>
	<td width="10%">使用时间</td>
	<td width="40%">备注信息</td>
	<td width="10%">审批状态</td>
	<td width="10%">操作</td>
</tr>
<%--插入内容--%>
<%--<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
	<td></td>
	<td></td>
	<td align="center"><a href=''><u>  </u></a></td>
	<td></td>
	<td>未审批</td>
	<td><a href="">编辑</a> </td>
</tr>--%>


<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">

	$.get('${pageContext.request.contextPath}/getBaoxiaoList1',function (data) {
		$(data).each(function (index,ele) {
		    $('#tb1 tr:eq(1)').after('<tr align=\'center\' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor=\'#FCFDEE\';" onMouseOut="javascript:this.bgColor=\'#FFFFFF\';" height="22" >\n' +
                '\t<td><input name="id" type="checkbox" id="id" value="101" class="np"></td>\n' +
                '\t<td>'+ele.bxid+'</td>\n' +
                '\t<td>'+ele.totalmoney+'</td>\n' +
                '\t<td align="center"><a href=\'\'><u>'+ele.bxtime+'</u></a></td>\n' +
                '\t<td>'+ele.bxremark+'</td>\n' +
                '\t<td>'+ele.properties.key+'</td>\n' +
                '\t<td><a href="${pageContext.request.contextPath}/getBaoxiaoOne1?bxid='+ele.bxid+'">查看</a><span>|</span><a href="${pageContext.request.contextPath}/baoxiaosp?bxid='+ele.bxid+'">通过</a><span>|</span><a href="${pageContext.request.contextPath}/baoxiaoback?bxid='+ele.bxid+'">退回</a></td>\n' +
                '</tr>');

        })
    });

</script>

</body>
</html>