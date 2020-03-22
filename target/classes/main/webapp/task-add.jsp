<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>创建任务</title>
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
    当前位置:任务管理>>创建任务
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="proname">
			<option value="-1">--请选择--</option>
		</select>
		<select id="analysisname">
			<option value="-1">--请选择--</option>
		</select>
		<select id="modeleFk">
            <option value="-1">--请选择--</option>
		</select>
		<select id="function" name="funFk">
            <option value="-1">--请选择--</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="starttime"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="endtime"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
        <select id="emp_fk" name="empFk">
            <option value="-1">--请选择--</option>
        </select>
    </td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
        <select name="level">
            <option value="1">高</option>
            <option value="2">中</option>
            <option value="3">低</option>
            <option value="4">暂缓</option>
        </select></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea name="define" rows=10 cols=130></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<input type="submit" value="保存"/>
</td>
</tr>
</table>

</form>


<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">

    $(function () {

        $.get("${pageContext.request.contextPath}/selectEmpPos",function (data) {
            $(data).each(function (index,ele) {
                $("#emp_fk").append('<option value="'+ele.id+'">'+ele.employee.ename+'---'+ele.position.name+'</option>')
            })

        });


        $.get("${pageContext.request.contextPath}/getProjects",function (data) {
            $(data).each(function (index,ele) {
                $("#proname").append('<option value="'+ele.pid+'">'+ele.pname+'</option>');
            })
        })


        $.get("${pageContext.request.contextPath}/getProjects",function (data) {
            $(data).each(function (index,ele) {
                $("#proname").append('<option value="'+ele.pid+'">'+ele.pname+'</option>');
            })
        })

        $('#proname').change(function () {
            $('#analysis_fk option:gt(0)').remove();
            var proname = $('#proname')[0].selectedOptions[0].innerText;
            $.get("${pageContext.request.contextPath}/getAnalysis?proname="+proname,function (data) {
                //alert(data);
                $(data).each(function (index,ele) {
                    $('#analysisname').append('<option value="'+ele.id+'">'+ele.title+'</option>');
                })
            });

        })

        $('#analysisname').change(function () {
            $('#modeleFk option:gt(0)').remove();
            // var analysisname = $('#analysisname')[0].selectedOptions[0].innerText;
            var analysisFk = $('#analysisname').val();
            $.get("${pageContext.request.contextPath}/getModel?analysisFk="+analysisFk,function (data) {
                //alert(data);
                $(data).each(function (index,ele) {
                    //alert(ele.modname);
                    $('#modeleFk').append('<option value="'+ele.id+'">'+ele.modname+'</option>');
                })
            },'json');

        })
        $('#modeleFk').change(function () {
            $('#function option:gt(0)').remove();
            // var analysisname = $('#analysisname')[0].selectedOptions[0].innerText;
            var modeleFk = $('#modeleFk').val();
            $.get("${pageContext.request.contextPath}/getFunction?modeleFk="+modeleFk,function (data) {
                //alert(data);
                $(data).each(function (index,ele) {
                    //alert(ele.modname);
                    $('#function').append('<option value="'+ele.id+'">'+ele.functionname+'</option>');
                })
            },'json');

        })

        $("#form2").submit(function () {
           // alert("进入添加！");
            var parma = $(this).serialize();
            //alert(parma);
            $.post("${pageContext.request.contextPath}/addTask",parma,function (data) {
                //alert(data.msgCode);
                if(data.msgCode==200){
                    alert(data.msg);
                    location.href="${pageContext.request.contextPath}/task.jsp";
                }else{
                    alert(data.msg);
                }
            },'json');
            return false;
        })

    })

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
        $('input[name="starttime"],input[name="endtime"]').datepicker({
            dateFormat: "yy-mm-dd"
        });
    })

</body>
</html>