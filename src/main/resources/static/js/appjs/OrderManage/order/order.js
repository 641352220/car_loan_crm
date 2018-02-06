
var prefix = "/OrderManage/order"
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset
					           // name:$('#searchName').val(),
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									field : 'carProductName',
									title : '车贷产品'
								},
																{
									field : 'carProductInformationName',
									title : '方案'
								},
																{
									field : 'carName',
									title : '汽车'
								},
																{
									field : 'userId', 
									title : '用户ID' 
								},
																{
									field : 'payments', 
									title : '首付比例' 
								},
																{
									field : 'term', 
									title : '贷款期数' 
								},
																{
									field : 'rate', 
									title : '贷款利率' 
								},
																{
									field : 'carPrice', 
									title : '车价' 
								},
																{
									field : 'channel', 
									title : '申请渠道' 
								},
																{
									field : 'applyTimeString',
									title : '申请时间' 
								},
																{
									field : 'state', 
									title : '状态' ,
                                                                    align : 'center',
                                                                    formatter : function(value, row, index) {
                                                                        if (value == '0') {
                                                                            return '<span class="label label-primary">用户删除</span>';
                                                                        } else if (value == '1') {
                                                                            return '<span class="label label-primary">待审核</span>';
                                                                        }else if (value == '2') {
                                                                            return '<span class="label label-primary">已取消</span>';
                                                                        }else if (value == '3') {
                                                                            return '<span class="label label-primary">审核被拒</span>';
                                                                        }else if (value == '5') {
                                                                            return '<span class="label label-primary">待提车</span>';
                                                                        }else if (value == '6') {
                                                                            return '<span class="label label-primary">待评论</span>';
                                                                        }else if (value == '10') {
                                                                            return '<span class="label label-primary">完成</span>';
                                                                        }
                                                                    }
								},
																{
									field : 'updateTimeString',
									title : '状态更新时间' 
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
                                        var k = '<a class="btn btn-primary btn-sm '+s_show_h+'" href="#" mce_href="#" title="查看资料" onclick="userInfo(\''
                                            + row.userId
                                            + '\')"><i class="fa fa-male"></i></a> ';
										if(1 == row.state){
                                            var d = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" title="通过"  mce_href="#" onclick="pass(\''
                                                + row.orderId
                                                + '\')"><i class="fa fa-check"></i></a> ';
                                            var n = '<a class="btn btn-warning btn-sm '+s_edit_h+'" href="#" title="拒绝"  mce_href="#" onclick="noPass(\''
                                                + row.orderId
                                                + '\')"><i class="fa fa-remove"></i></a> ';
                                            return d + n + k;
										}else if(5 == row.state){
                                            var d = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" title="以提车"  mce_href="#" onclick="pass(\''
                                                + row.orderId
                                                + '\')"><i class="fa fa-check"></i></a> ';
                                            return d + k;
										}
										return k;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}


function userInfo(id) {
    layer.open({
        type : 2,
        title : '用户信息',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : "/UserManage/user/edit/" + id // iframe的url
    });
}

function noPass(id) {
    layer.confirm('确定要拒绝选中的订单？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/noPass",
            type : "post",
            data : {
                'orderId' : id
            },
            success : function(r) {
                if (r.code==0) {
                    layer.msg(r.msg);
                    reLoad();
                }else{
                    layer.msg(r.msg);
                }
            }
        });
    })
}

function pass(id) {
	layer.confirm('确定要通过选中的订单？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/pass",
			type : "post",
			data : {
				'orderId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}
