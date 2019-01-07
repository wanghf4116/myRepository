<#include "/common/commoncss.ftl">
<link rel="stylesheet" type="text/css" href="css/common/checkbox.css" />
<link rel="stylesheet" type="text/css" href="/datetimepicker/css/bootstrap-datetimepicker.min.css"/>
<script  type="text/javascript" src="/datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script  type="text/javascript" src="/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>



<style type="text/css">
a {
	color: black;
}

a:hover {
	text-decoration: none;
}

.bgc-w {
	background-color: #fff;
}
</style>
<div class="row" style="padding-top: 10px;">
	<div class="col-md-2">
		<h1 style="font-size: 24px; margin: 0;" class="">看板管理</h1>
	</div>
	<div class="col-md-10 text-right">
		<a href="##"><span class="glyphicon glyphicon-home"></span> 首页</a> > <a
			disabled="disabled">看板管理</a>
	</div>
</div>
<div class="row" style="padding-top: 15px;">
	<div class="col-md-12">
		<!--id="container"-->
		<div class="bgc-w box">
			<!--盒子头-->
			<div class="box-header">
				<h3 class="box-title">
					<a href="javascript:history.back();" class="label label-default"
						style="padding: 5px;"> <i
						class="glyphicon glyphicon-chevron-left"></i> <span>返回</span>
					</a>
				</h3>
			</div>
			<!--盒子身体-->
			<form autocomplete="off" method="post" action="kanbancheck" onsubmit="return check();">
			<div class="box-body no-padding">
				<div class="box-body">
				<div class="alert alert-danger alert-dismissable" role="alert"
							style="display: none;">
							错误信息:<button class="close" type="button">&times;</button>
							<span class="error-mess"></span>
						</div>
					<div class="row">
					<div class="col-md-4 form-group">
									<label class="control-label"><span>作业状态</span></label> 
									<select class="form-control" name="state">
								<#if statename??>
									<option value="${kanban.state}">${statename}</option>
								</#if>
									<#list states as st>
										<option value="${st.state_id}">${st.state_name}</option>
									</#list>
								</select>
						</div>
				
						<div class="col-md-4 form-group">
							<label class="control-label"><span>作業日付</span></label>
							<input class="form-control" name="work_date" value="${(kanban.work_date)!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>班次</span></label>
							<input class="form-control" name="group_next" value="${(kanban.group_next)!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>要員</span></label>
							<input class="form-control" name="group_personnel" value="${(kanban.group_personnel)!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>予定時刻</span></label>
							<input class="form-control" name="scheduled_time" value="${(kanban.scheduled_time)!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>作業ID</span></label>
							<input class="form-control" name="work_id" value="${(kanban.work_id)!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>完了時刻</span></label>
							<input class="form-control" name="completion_time" value="${(kanban.completion_time)!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>結果</span></label>
							<input class="form-control" name="results" value="${(kanban.results)!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>担当者</span></label>
							<input class="form-control" name="personnel" value="${(kanban.personnel)!''}"/>
						</div>
						<div class="col-md-4 form-group">
								<label class="control-label"><span>確認者</span></label> 
							<input class="form-control" name="confirmed_by" value="${(kanban.confirmed_by)!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>開始時刻</span></label>
							<input  id="starTime" class="form_datetime form-control"  name="work_start_time" value="${kanban.work_start_time!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>終了時刻</span></label>
							<input  id="endTime" class="form_datetime form-control" name="work_end_time" value="${kanban.work_end_time!''}"/>
						</div>
						
						<div class="col-md-4 form-group">
							<label class="control-label"><span>納期</span></label>
							<input  id="endTime" class="form_datetime form-control" name="delivery" value="${kanban.delivery!''}"/>
						</div>
						<div class="col-md-4 form-group">
							<label class="control-label"><span>納期遵守率</span></label>
							<input  class="form-control" name="delivery_rate" value="${kanban.delivery_rate!''}"/>
						</div>
						<div class="col-md-6 form-group">
								<label class="control-label"><span>備考</span></label> 
								<textarea class="form-control text" rows="5" cols="20" name="remark">${(kanban.remark)!''}</textarea>
						</div>
						
				</div>
			</div>
		</div>
		
		<!--盒子尾-->
		<div class="box-footer">
			<input class="btn btn-primary" id="save" type="submit" value="保存" />
			<input class="btn btn-default" id="cancel" type="submit" value="取消"
				onclick="window.history.back();" />
		</div>
		</form>
	</div>
</div>
</div>
<#include "/common/modalTip.ftl"> 
<script type="text/javascript">
//表单提交前执行的onsubmit()方法；返回false时，执行相应的提示信息；返回true就提交表单到后台校验与执行
$('.successToUrl').on('click',function(){
	window.location.href='/kanbanmanage';
});
$('.form_datetime').datetimepicker({
	 	language:  'zh-CN',//选择语言类型
        weekStart: 1,//设置起始周
        todayBtn: true ,//打开底部今天按钮,false为关闭
        autoclose: true,//选中日期后自动关闭选择器
        todayHighlight: true,//高亮显示当前日期
        startView: 0,//设置为小时视图 ,1 hour 1 day 2 month 3 year 4 decade(十年)
        minView: 0,//设置最小视图为小时视图
        format: 'yyyy-mm-dd hh:ii:ss',//设置时间展现格式
     	autoclose: 1//选择后自动关闭
});

function check() {
	console.log("开始进入了");
	//提示框可能在提交之前是block状态，所以在这之前要设置成none
	$('.alert-danger').css('display', 'none');
	var isRight = 1;
	$('.form-control').each(function(index) {
		// 如果在这些input框中，判断是否能够为空
		if ($(this).val() == "") {
			// 排除哪些字段是可以为空的，在这里排除
			if (index == 14) {
				return true;
			}
			// 获取到input框的兄弟的文本信息，并对应提醒；
			var brother = $(this).siblings('.control-label').text();
			var errorMess = "[" + brother + "输入框信息不能为空]";
			// 对齐设置错误信息提醒；红色边框
			$(this).parent().addClass("has-error has-feedback");
			$('.alert-danger').css('display', 'block');
			// 提示框的错误信息显示
			$('.error-mess').text(errorMess);
			// 模态框的错误信息显示
			$('.modal-error-mess').text(errorMess);
			 isRight = 0;
			return false; 
		} else {
			// 在这个里面进行其他的判断；不为空的错误信息提醒
			return true;
		}
	});
	if (isRight == 0) {
		//modalShow(0);
		 return false;
	} else if (isRight == 1) {
		//modalShow(1);
		 return true;
	}
//	return false;
}
</script>
