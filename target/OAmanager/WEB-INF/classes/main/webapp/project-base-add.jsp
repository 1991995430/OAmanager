<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java"  pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加项目信息</title>
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
    当前位置:项目管理>>添加项目基本信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form  id="forms" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;添加新项目信息&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >项目名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="pname"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
	<!-- <input type="text" name="cuscompany"/> -->
	<select name="comname" id="comname">
		<option value="-1">----请选择----</option>
	</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="comper"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="empFk1">
		<option value="-1">----请选择----</option>
	</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22" >开发人数：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="empcount"/>人</td>
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="starttime" readonly="readonly"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="buildtime" readonly="readonly"/></td>
	<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="cost"/>万</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select  name="level"><option value=1>紧急</option><option value=2>一般</option><option value=3>暂缓</option></select></td>
	<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" name="endtime"/></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea type="text" rows=15 cols=130  name="remark"></textarea><span id="number"></span>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<input type="submit" value="保存"/>
	<a href="project-base.jsp" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>

<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">

	$(function () {
        //绑定客户公司名称
	    //customerbyproject
		$.get('${pageContext.request.contextPath}/customerbyproject',function (data) {
            $(data).each(function (i,ele) {
                $('select[name="comname"]').append('<option value="'+ele.id+'">'+ele.comname+'</option>');
            });
        },'json');
		//项目经理
        $.get('${pageContext.request.contextPath}/employeebyproject',function (data) {
            $(data).each(function (i,ele) {
                $('select[name="empFk1"]').append('<option value="'+ele.eid+'">'+ele.ename+'</option>');
            });
        },'json');

		//客户方负责人获取
		//捕获下拉列表change事件,获取到下拉列表中绑定的id
		//通过id,查找负责人
       // $('select[name="comname"]').change(function () {
        $('#comname').change(function () {
			var param = $(this).val();
			if(param==-1){
                $('input[name="comper"]').val('');
			}else{
				// alert(param);customerinfobyproject
				$.get("${pageContext.request.contextPath}/customerinfobyproject?id="+param,function (data) {
					$('input[name="comper"]').val(data.companyperson);//将返回的数据填充到输入框中
				});
            }
        });

        //保存
		$('#forms').submit(function () {
			//调用添加操作
			var param = $('#forms').serialize();
			$.post('${pageContext.request.contextPath}/projectadd',param,function (data) {
				alert(data.msg);
                location.href="${pageContext.request.contextPath}/project-base.jsp";
            },'json');
			return false;
        });
    });
</script>


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/datejs/jQuery-Timepicker-Addon/demos.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/datejs/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.css">
<link href="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/datejs/jQuery-Timepicker-Addon/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/datejs/js/jquery.ui.datepicker-zh-CN.js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/datejs/js/jquery-ui-timepicker-zh-CN.js"></script>
 <script type="text/javascript">
 /* name="sdate" */
 $(function(){
	 $('input[name="starttime"],input[name="buildtime"],input[name="endtime"]').datepicker({
         dateFormat: "yy-mm-dd"
     });
 })

 </script>

</body>
</html>