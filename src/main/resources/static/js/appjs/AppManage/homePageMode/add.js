$().ready(function() {
    jumpType();
    position();
    brandId();
	validateRule();
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
    $("#img-btn2").click(function(){
        layer.open({
            type: 2,
            title:'图标列表',
            content: '/LogoList2.html',
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
		url : "/AppManage/homePageMode/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
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


function jumpType(){
    var html = "";
    $.ajax({
        url : '/common/sysDict/list/page_mode_jump_type',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#jumpType").append(html);
            $("#jumpType").chosen({
                maxHeight : 200
            });
        }
    });
}

function position(){
    var html = "";
    $.ajax({
        url : '/common/sysDict/list/page_mode_position',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].value + '">' + data[i].name + '</option>'
            }
            $("#position").append(html);
            $("#position").chosen({
                maxHeight : 200
            });
        }
    });
}

function brandId(){
    var html = "";
    $.ajax({
        url : '/CarManage/brand/brandListCarOffer',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].brandId + '">' + data[i].brandName + '</option>'
            }
            $("#brandId").append(html);
            $("#brandId").chosen({
                maxHeight : 200
            });
        }
    });
}