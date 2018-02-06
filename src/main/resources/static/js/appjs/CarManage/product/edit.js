$().ready(function() {
    productCity();
    jumpType();
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
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/CarManage/product/update",
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
				required : icon + "请输入名字"
			}
		}
	})
}


function jumpType(){
    var html = "";
    $.ajax({
        url : '/common/sysDict/list/car_product_jump_type',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if(data[i].value == $("#TjumpType").val()){
                    html += '<option value="' + data[i].value + '" selected>' + data[i].name + '</option>';
                }else{
                    html += '<option value="' + data[i].value + '">' + data[i].name + '</option>';
                }
            }
            $("#jumpType").append(html);
            $("#jumpType").chosen({
                maxHeight : 200
            });
        }
    });
}


function productCity(){
    var html = "";
    var carProductId = $("#carProductId").val();
    $.ajax({
        url : '/AppManage/city/productCity',
        data : {level : 3,id : carProductId},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if(0 == data[i].sf || null == data[i].sf){
                    html += '<option value="' + data[i].cityId + '">' + data[i].name + '</option>'
                }else{
                    html += '<option value="' + data[i].cityId + '" selected>' + data[i].name + '</option>'
				}
            }
            $("#carProductCityIds").append(html);
            $("#carProductCityIds").chosen({
                maxHeight : 200
            });
        }
    });
}