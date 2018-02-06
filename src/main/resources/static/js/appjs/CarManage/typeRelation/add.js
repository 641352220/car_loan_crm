$().ready(function() {
    carTypeId();
    carProductId();
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
		url : "/CarManage/typeRelation/save",
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


function carTypeId(){
    var html = "";
    $.ajax({
        url : '/CarManage/type/nameList',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].carTypeId + '">' + data[i].carTypeName + '</option>'
            }
            $("#carTypeId").append(html);
            $("#carTypeId").chosen({
                maxHeight : 200
            });
        }
    });
}


function carProductId(){
    var html = "";
    $.ajax({
        url : '/CarManage/product/carProductNameList',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].carProductId + '">' + data[i].carProductName + '</option>'
            }
            $("#carProductId").append(html);
            $("#carProductId").chosen({
                maxHeight : 200
            });
        }
    });
}

function carProductInformationIdF (){
    var html = "";
    var carProductId = $("#carProductId").val();
    if(null == carProductId || "" == carProductId){
        return;
    }
    $.ajax({
        url : '/CarManage/productInformation/listByCarProductId',
        data : {carProductId : carProductId},
        success : function(data) {
            html = '<option value="">请选择</option>';
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].carProductInformationId + '">' + data[i].carProductInformationName + '</option>';
            }
            $("#carProductInformationId").find("option").remove();
            $("#carProductInformationId").append(html);
        }
    });
}

var openCarTree = function(){
    var carProductInformationId = $("#carProductInformationId").val();
    if(null == carProductInformationId||""== carProductInformationId){
        alert("请先选择贷款方案");
        return;
    }
    layer.open({
        type:2,
        title:"选择汽车",
        area : [ '300px', '450px' ],
        content:"/CarManage/car/carTreeView/"+carProductInformationId
    })
}

function loadCar( carId,carName){
    $("#carId").val(carId);
    $("#carName").val(carName);
}

function clearCar(){
    $("#carId").val("");
    $("#carName").val("");
}