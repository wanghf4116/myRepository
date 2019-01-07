
	<div class="container-fluid"
		style="margin-top: 20px; margin-bottom: 50px;">
		<div class="row ">
		<div class="col-md-4">
			<div  class="table-responsive" ;">
				<table  class="table table-hover table-striped">
					<tr>
					<th  class="lead" scope="col">作業ID</th>
					<th  class="lead" scope="col">完了時刻</th>
					<th  class="lead" scope="col">結果</th>
					<th  class="lead" scope="col">担当者</th>
					<th  class="lead" scope="col">確認者</th>
			<!-- <th scope="col">颜色</th> -->
					</tr>
				<#list AM as kanbanD>
					<tr>
						<td><span  class="lead">${(kanbanD.work_id)!''}</span></td>
						<td><span  class="lead">${(kanbanD.completion_time)!''}</span></td>
						<td><span  class="lead">${(kanbanD.results)!''}</span></td>
						<td><span  class="lead">${(kanbanD.personnel)!''}</span></td>
						<td><span  class="lead">${(kanbanD.confirmed_by)!''}</span></td>
					</tr>
				</#list>
				</table>
			</div>
		</div>

		<div class="col-md-4">
			<div class="table-responsive">
				<table class="table table-hover table-striped ">
					<tr>
						<th  class="lead" scope="col">作業ID</th>
						<th  class="lead" scope="col">完了時刻</th>
						<th  class="lead" scope="col">結果</th>
						<th  class="lead" scope="col">担当者</th>
						<th  class="lead" scope="col">確認者</th>
			<!-- <th scope="col">颜色</th> -->
						</tr>
				<#list PM as kanbanN>
					<tr>
						<td><span  class="lead">${(kanbanN.work_id)!''}</span></td>
						<td><span  class="lead">${(kanbanN.completion_time)!''}</span></td>
						<td><span  class="lead">${(kanbanN.results)!''}</span></td>
						<td><span  class="lead">${(kanbanN.personnel)!''}</span></td>
						<td><span  class="lead">${(kanbanN.confirmed_by)!''}</span></td>
					</tr>
				</#list>
				</table>
			</div>
		</div>
		<div class="col-md-4">
			<div class="table-responsive">
				<table class="table table-hover table-striped ">
					<tr>
						<th  class="lead" scope="col">作業ID</th>
						<th  class="lead" scope="col">完了時刻</th>
						<th  class="lead" scope="col">結果</th>
						<th  class="lead" scope="col">担当者</th>
						<th  class="lead" scope="col">確認者</th>
			<!-- <th scope="col">颜色</th> -->
						</tr>
				<#list PM as kanbanN>
					<tr>
						<td><span  class="lead">${(kanbanN.work_id)!''}</span></td>
						<td><span  class="lead">${(kanbanN.completion_time)!''}</span></td>
						<td><span  class="lead">${(kanbanN.results)!''}</span></td>
						<td><span  class="lead">${(kanbanN.personnel)!''}</span></td>
						<td><span  class="lead">${(kanbanN.confirmed_by)!''}</span></td>
					</tr>
				</#list>
				</table>
			</div>
		</div>
	</div>
</div>
	<div class="container-fluid"
		style="margin-top: 20px; margin-bottom: 50px;">
		<div class="row ">
			<div class="col-md-6 ">
				<!-- 统计 -->
				<div class="panel panel-default box-show green-box">
					<div class="panel-heading box-show-heading"
						style="background: white;">
						<div class="panel-title" style="display: inline-block;">
							<h4>本日邮件数量统计</h4>
						</div>
						<div class="pull-right right-btn-group dropdown"
							style="display: inline-block;">
							<div style="display: inline-block;">
								<button data-toggle="dropdown">
									<span class="glyphicon glyphicon-menu-hamburger"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="morelog">历史记录</a></li>
								</ul>
							</div>
							<a data-toggle="collapse"><button>
									<span class="glyphicon glyphicon-minus shousuo"></span>
								</button></a>
							<button>
								<span class="glyphicon glyphicon-remove"></span>
							</button>
						</div>
					</div>

					<div id="line" class="shrink"
						style="min-width: 100px; height: 280px; border-top: solid 1px #eee; margin: 0 auto">
					</div>
				</div>
			</div>
			<div class="col-md-6 ">
				<div class="panel panel-default box-show green-box">
					<div class="panel-heading box-show-heading"
						style="background: white;">
						<div class="panel-title" style="display: inline-block;">
							<h4>起票数量</h4>
						</div>
						<div class="pull-right right-btn-group btn-color dropdown"
							style="display: inline-block;">
							<div style="display: inline-block;">
								<button data-toggle="dropdown">
									<span class="glyphicon glyphicon-menu-hamburger"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="mytask">我的任务</a></li>
								</ul>
							</div>
							<a href="#column" data-toggle="collapse"><button>
									<span class="glyphicon glyphicon-minus shousuo"></span>
								</button></a>
							<button>
								<span class="glyphicon glyphicon-remove"></span>
							</button>
						</div>
					</div>
					<div id="column" class="shrink"
						style="min-width: 100px; height: 280px; margin: 0 auto; border-top: solid 1px #eee;">
					</div>
				</div>
				
			</div>
		</div>
	</div>

<link rel="stylesheet" href="../../../../../target/classes/static/datetimepicker/sample in bootstrap v2/bootstrap/css/bootstrap.css" />
<script src="js/littlecalendar.js"></script>
<script src="js/highcharts/jquery.js"></script>
<script src="js/highcharts/highcharts.js"></script>
<script src="js/kanban/info.js"></script>