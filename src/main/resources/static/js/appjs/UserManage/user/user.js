
var prefix = "/UserManage/user"
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
									field : 'nickName', 
									title : '昵称'
								},
																{
									field : 'headPortrait', 
									title : '头像' ,
                                                                    align : 'center',
                                                                    formatter : function(value, row, index) {
																			if(null == value){
																				return '暂无头像';
																			}else{
                                                                                return '<img src="'+value+'" width="50px" height="50px">';
																			}
                                                                    }
								},
																{
									field : 'loginType', 
									title : '登录类型'
								},
																{
									field : 'phone', 
									title : '手机号' 
								},
																{
									field : 'time', 
									title : '注册时间' 
								},
																{
									field : 'loginTime', 
									title : '登录时间' 
								},
																{
									field : 'address', 
									title : '详细地址' 
								},
																{
									field : 'state', 
									title : '状态' ,
                                                                    align : 'center',
                                                                    formatter : function(value, row, index) {
                                                                        if (value == '0') {
                                                                            return '<span class="label label-primary">正常</span>';
                                                                        } else if (value == '1') {
                                                                            return '<span class="label label-danger">停用</span>';
                                                                        }
                                                                    }
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="查看资料" onclick="edit(\''
												+ row.userId
												+ '\')"><i class="fa fa-male"></i></a> ';
                                        var s = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="查看收藏" onclick="uc(\''
                                            + row.userId
                                            + '\')"><i class="fa fa-briefcase"></i></a> ';
                                        var o = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="查看订单" onclick="or(\''
                                            + row.userId
                                            + '\')"><i class="fa fa-eye"></i></a> ';
                                        if(0 == row.state){
                                            var d = '<a class="btn btn-warning btn-sm '+s_edit_h+'" href="#" title="停用"  mce_href="#" onclick="remove(\''
                                                + row.userId
                                                + '\')"><i class="fa fa-remove"></i></a> ';
										}
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.userId
												+ '\')"><i class="fa fa-key"></i></a> ';
                                        if(0 == row.state){
                                            return e + s + o + d ;
                                        }else{
                                            return e + s + o ;
										}

									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function edit(id) {
	layer.open({
		type : 2,
		title : '用户信息',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}

function uc(id) {
    layer.open({
        type : 2,
        title : '收藏记录',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/userCollectionList/' + id // iframe的url
    });
}

function or(id) {
    layer.open({
        type : 2,
        title : '订单列表',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '1200px', '520px' ],
        content : prefix + '/userOrderList/' + id // iframe的url
    });
}

function remove(id) {
	layer.confirm('确定要停用选中的用户？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'userId' : id
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

function resetPwd(id) {
}
