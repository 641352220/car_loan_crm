$().ready(function() {
    labelName();
	validateRule();
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
		url : "/CarManage/offer/save",
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

var openCarTree = function(){
    layer.open({
        type:2,
        title:"选择汽车",
        area : [ '300px', '600px' ],
        content:"/CarManage/car/carTreeView"
    })
}

function loadCar( carId,carName){
    $("#carId").val(carId);
    $("#carName").val(carName);
}

function labelName(){
    var html = "";
    $.ajax({
        url : '/AppManage/label/labelList',
        data : {type : 4,id : 0},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].labelId + '">' + data[i].name + '</option>'
            }
            $("#labelId").append(html);
            $("#labelId").chosen({
                maxHeight : 200
            });
        }
    });
}