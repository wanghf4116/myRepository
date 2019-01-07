<div class="table-responsive">
	<table class="table table-hover">
		<tr>
			<th scope="col">作業日付</th>
		
			<th scope="col">要員</th>
	
			<th scope="col">作業ID</th>
			<th scope="col">完了時刻</th>
			<th scope="col">結果</th>
			<th scope="col">担当者</th>
			<th scope="col">確認者</th>
			<th scope="col">開始時刻</th>
			<th scope="col">終了時刻</th>
			<th scope="col">納期</th>
			<th scope="col">納期遵守率</th>
			<th scope="col">備考</th>
			<th scope="col">操作</th>
			<!-- <th scope="col">颜色</th> -->
		</tr>
		<#list today as today >
		<tr>
			<td><span>${(today.work_date)!''}</span></td>
			
			<td><span>${(today.group_personnel)!''}</span></td>
		
			<td><span>${(today.work_id)!''}</span></td>
			<td><span>${(today.completion_time)!''}</span></td>
			<td><span>${(today.results)!''}</span></td>
			<td><span>${(today.personnel)!''}</span></td>
			<td><span>${(today.confirmed_by)!''}</span></td>
			<td><span>${(today.work_start_time)!''}</span></td>
			<td><span>${(today.work_end_time)!''}</span></td>
			<td><span>${(today.delivery)!''}</span></td>
			<td><span>${(today.delivery_rate)!''}</span></td>
			<td><span>${(today.remark)!''}</span></td>
			<td><a href="kanbanedit?kanbanid=${today.kanbanid}"
				class="label xiugai"><span class="glyphicon glyphicon-edit"></span>
					修改</a> <a title="查看详细信息" href="##" class="label xiugai"><span
					class="glyphicon glyphicon-search"></span> 查看</a> <a
				onclick="{return confirm('删除该记录将不能恢复，确定删除吗？');};"
				href="deletekanban?kanbanid=${today.kanbanid}" class="label shanchu"><span
					class="glyphicon glyphicon-remove"></span> 删除</a></td>
		</tr>
		</#list>
	</table>
</div>
