<#include "/common/commoncss.ftl">
<script type="text/javascript" src="js/common/tocolor.js"></script>
<link rel="stylesheet" href="css/controlpanel.css" />
<link rel="stylesheet" href="css/common/skintheme.css" />
<!-- <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"> -->
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
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
			<h1 style="font-size: 24px; margin: 0;" class="">看板显示</h1>
		</div>
		<div class="col-md-10 text-right">
			<a href="index"><span class="glyphicon glyphicon-home"></span> 首页</a> >
			<a disabled="disabled">看板显示</a>
		</div>
	</div>

	<div class="row" style="padding-top: 15px;">
		<div class="col-md-12">
			<!--id="container"-->
			<div class="bgc-w box box-primary">
				<!--盒子头-->
				<div class="col-md-4">
					<div class="panel-title" style="display: inline-block;">
							<h4>excel</h4>
						</div>
				</div>
				
				<!--盒子身体-->
				<div class="box-body no-padding thistable">
					<#include "excelshow.ftl">
				</div>
				<!--盒子尾-->
			</div>
		</div>
	</div>
<script>
	$('.baseKeySubmit').on('click',function(){
		var name=$('.baseKey').val();
		$('.thistable').load("kanbantable?name="+name);
	});
</script>