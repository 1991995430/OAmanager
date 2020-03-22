<%@ page language="java"  pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>项目信息管理</title>
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
    当前位置:项目管理>>基本信息管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='project-base-add.jsp';" value='添加新项目' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form id='form3'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' >
          <option value='0'>选择类型...</option>
          	<option value='1'>项目名称</option>
          	<option value='2'>项目经理</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:120px'>
            <option value='id'>排序...</option>
            <option value='buildtime'>立项时间</option>
            <option value='endtime'>计划完成时间</option>
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
<!--  内容列表   -->
<form name="form2">

<table id="t1" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;项目信息列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">项目名称</td>
	<td width="10%">客户公司名称</td>
	<td width="10%">客户方负责人</td>
	<td width="5%">项目经理</td>
	<td width="8%">开发人员数</td>
	<td width="6%">立项时间</td>
	<td width="8%">最近更新时间</td>
	<td width="8%">计划完成时间</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="" class="coolbg">全选</a>
	<a href="" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="" class="coolbg">&nbsp;删除&nbsp;</a>
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

        $('#form3').submit(function () {
            var param = $('#form3').serialize();
            var url="${pageContext.request.contextPath}/getProjectListByKeyWord?"+param;
            getProjectListByKey(url);
            return false;
        });
        

            $.get("${pageContext.request.contextPath}/getProjectList",function (data) {
                //alert(data);
                $(data).each(function (index,ele) {
                    //alert(ele.employee.ename);
                    $('#t1 tr:eq(1)').after('<tr align=\'center\' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor=\'#FCFDEE\';" onMouseOut="javascript:this.bgColor=\'#FFFFFF\';" height="22" >'
                        +' <td><input name="id" type="checkbox" id="id" value="101" class="np"></td></td>'
                        +' <td>'+ele.pid+'</td>'
                        +'<td align="left"><a href="#"><u>'+ele.pname+'</u></a></td>'
                        +'<td>'+ele.customer.comname+'</td>'
                        +'<td>'+ele.comper+'</td>'
                        +'<td>'+ele.employee.ename+'</td>'
                        +'<td>'+ele.empcount+'</td>'
                        +'<td>'+ele.starttime+'</td>'
                        +' <td>'+ele.buildtime+'</td>'
                        +' <td>'+ele.endtime+'</td>'
                        +'<td>'+ele.properties.key+'</td>'
                        +'<td><a href="project-base-edit.jsp">编辑</a> | <a href="project-base-look.jsp">查看详情</a></td>'
                        +'</tr>')
                })
            },'json');



    })

function getProjectListByKey(url){
        $('#t1 tr:eq(1)').nextUntil("tr:eq(-2)").remove();
        $.get(url,function (data) {
            //alert(data);
            $(data).each(function (index,ele) {
                //alert(ele.employee.ename);
                $('#t1 tr:eq(1)').after('<tr align=\'center\' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor=\'#FCFDEE\';" onMouseOut="javascript:this.bgColor=\'#FFFFFF\';" height="22" >'
                    +' <td><input name="id" type="checkbox" id="id" value="101" class="np"></td></td>'
                    +' <td>'+ele.pid+'</td>'
                    +'<td align="left"><a href="#"><u>'+ele.pname+'</u></a></td>'
                    +'<td>'+ele.customer.comname+'</td>'
                    +'<td>'+ele.comper+'</td>'
                    +'<td>'+ele.employee.ename+'</td>'
                    +'<td>'+ele.empcount+'</td>'
                    +'<td>'+ele.starttime+'</td>'
                    +' <td>'+ele.buildtime+'</td>'
                    +' <td>'+ele.endtime+'</td>'
                    +'<td>'+ele.properties.key+'</td>'
                    +'<td><a href="project-base-edit.jsp">编辑</a> | <a href="project-base-look.jsp">查看详情</a></td>'
                    +'</tr>')
            })
        },'json');
}

</script>

</body>
</html>