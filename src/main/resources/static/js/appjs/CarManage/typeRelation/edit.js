var sfInit = true;
$().ready(function() {
    carTypeId();
    carProductId();
	validateRule();
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
		url : "/CarManage/typeRelation/update",
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

function carTypeId(){
    var html = "";
    $.ajax({
        url : '/CarManage/type/nameList',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
            	if(data[i].carTypeId == $('#TcarTypeId').val()){
                    html += '<option value="' + data[i].carTypeId + '" selected>' + data[i].carTypeName + '</option>';
				}else{
                    html += '<option value="' + data[i].carTypeId + '">' + data[i].carTypeName + '</option>';
				}

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
                if(data[i].carProductId == $("#TcarProductId").val()){
                    html += '<option value="' + data[i].carProductId + '" selected>' + data[i].carProductName + '</option>';
                }else{
                    html += '<option value="' + data[i].carProductId + '">' + data[i].carProductName + '</option>';
                }
            }
            $("#carProductId").append(html);
            $("#carProductId").chosen({
                maxHeight : 200
            });
            carProductInformationIdF ();
        }
    });
}

function carProductInformationIdF (){
    var html = "";
    var carProductId = $("#carProductId").val();
    if(sfInit){
        carProductId = $("#TcarProductId").val();
    }
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
                if(sfInit){
                    if(data[i].carProductInformationId == $("#TcarProductInformationId").val()){
                        html += '<option value="' + data[i].carProductInformationId + '" selected>' + data[i].carProductInformationName + '</option>';
                    }else{
                        html += '<option value="' + data[i].carProductInformationId + '">' + data[i].carProductInformationName + '</option>';
                    }
                    sfInit = false;
                }else{
                    html += '<option value="' + data[i].carProductInformationId + '">' + data[i].carProductInformationName + '</option>';
                }
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
        content:"/CarManage/car/carTreeView"
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