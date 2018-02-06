$().ready(function() {
    login();
    adverPosition()
	validateRule();
    //打开图片列表
    $("#img-btn").click(function(){
        layer.open({
            type: 2,
            title:'图标列表',
            content: '/LogoList.html',
            area: ['480px', '90%'],
            success: function(layero, index){
                //var body = layer.getChildFrame('.ico-list', index);
                //console.log(layero, index);
            }
        });
    });
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/AdverManage/adver/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			alert("失败请求");
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
                alert("成功");
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
                alert("失败:"+data.msg);
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}

function login(){
    var html = "";
    $.ajax({
        url : '/common/sysDict/list/adver_login',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#login").append(html);
            $("#login").chosen({
                maxHeight : 200
            });
            //点击事件
            $('#login').on('change', function(e, params) {
            	console.log(params.selected);
            	var opt = {
            		query : {
            			type : params.selected,
            		}
            	}
            	$('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}

function adverPosition(){
    var html = "";
    $.ajax({
        url : '/common/sysDict/list/adver_adver_position',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#adverPosition").append(html);
            $("#adverPosition").chosen({
                maxHeight : 200
            });
            // //点击事件
            // $('#adverPosition').on('change', function(e, params) {
            // 	console.log(params.selected);
            // 	var opt = {
            // 		query : {
            // 			type : params.selected,
            // 		}
            // 	}
            // 	$('#exampleTable').bootstrapTable('refresh', opt);
            // });
        }
    });
}