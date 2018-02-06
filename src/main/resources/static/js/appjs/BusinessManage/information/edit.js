$().ready(function() {
    businessCity();
    brandIds();
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
    //打开图片列表
    $("#map-btn").click(function(){
        layer.open({
            type: 2,
            title:'图标列表',
            content: '/map.html',
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
		url : "/BusinessManage/information/update",
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


function loadAdress( longitude,latitude,province,city,area){
    $("#longitude").val(longitude);
    $("#latitude").val(latitude);
    $("#province").val(province);
    $("#city").val(city);
    $("#area").val(area);
    $("#addressString").val(province+" "+city+" "+area);
}


function businessCity(){
    var html = "";
    var businessId = $("#businessId").val();
    $.ajax({
        url : '/AppManage/city/businessCity',
        data : {level : 3,id : businessId},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if(0 == data[i].sf || null == data[i].sf){
                    html += '<option value="' + data[i].cityId + '">' + data[i].name + '</option>'
                }else{
                    html += '<option value="' + data[i].cityId + '" selected>' + data[i].name + '</option>'
                }
            }
            $("#cityIds").append(html);
            $("#cityIds").chosen({
                maxHeight : 200
            });
        }
    });
}

function brandIds(){
    var html = "";
    var businessId = $("#businessId").val();
    $.ajax({
        url : '/CarManage/brand/listByBusinessId',
        data : {id : businessId},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if(0 == data[i].sf || null == data[i].sf){
                    html += '<option value="' + data[i].brandId + '">' + data[i].brandName + '</option>'
                }else{
                    html += '<option value="' + data[i].brandId + '" selected>' + data[i].brandName + '</option>'
                }
            }
            $("#brandIds").append(html);
            $("#brandIds").chosen({
                maxHeight : 200
            });
        }
    });
}