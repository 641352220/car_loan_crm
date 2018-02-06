
var prefix = "/BusinessManage/information"
$(function() {
	load();
});

function load() {
    $('#exampleTable')
        .bootstrapTreeTable(
            {
                id : 'businessId',
                code : 'businessId',
                parentColumn : 'parentId',
                type : "GET", // 请求数据的ajax类型
                url : prefix + '/list', // 请求数据的ajax的url
                ajaxParams : {}, // 请求数据的ajax的data属性
                expandColumn : '1', // 在哪一列上面显示展开按钮
                striped : true, // 是否各行渐变色
                bordered : true, // 是否显示边框
                expandAll : false, // 是否全部展开
                // toolbar : '#exampleToolbar',
                columns : [
                    {
                        title : '编号',
                        field : 'businessId',
                        visible : false,
                        align : 'center',
                        valign : 'middle',
                        width : '50px'
                    },
                    {
                        field : 'companyName',
                        title : '公司名称'
                    },
                    {
                        field : 'state',
                        title : '状态',
                        align : 'center',
                        formatter : function(item, index) {
                            if (item.state == '0') {
                                return '<span class="label label-primary">正常</span>';
                            } else if (item.state == '1') {
                                return '<span class="label label-danger">禁用</span>';
                            }
                        }
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(item, index) {
                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + item.businessId
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var a = '<a class="btn btn-primary btn-sm ' + s_add_h + '" href="#" title="增加下級"  mce_href="#" onclick="add(\''
                                + item.businessId
                                + '\')"><i class="fa fa-plus"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="禁用"  mce_href="#" onclick="shout(\''
                                + item.businessId
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm＂ href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                + item.deptId
                                + '\')"><i class="fa fa-key"></i></a> ';
                            return e + a + d;
                        }
                    } ]
            });
}
function reLoad() {
	load();
}
function add(pId) {
    layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/add/' + pId
    });
}
function edit(id) {
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/edit/' + id // iframe的url
    });
}
function shout(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix + "/remove",
            type : "post",
            data : {
                'deptId' : id
            },
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}

function resetPwd(id) {
}
