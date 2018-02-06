var carIds = new Array();
var modelIds = new Array();
var brandIds = new Array();
$(function() {
    carProductId();
    downPaymentsList();
    termsList();
    programmeLabel();
    discountLabel();
    validateRule();
    getCarTreeData();
});

$.validator.setDefaults({
	submitHandler : function() {
        getAllSelectNodes();
		update();
	}
});
function update() {
    $('#carIds').val(carIds);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/CarManage/productInformation/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : true,
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
        }
    });
}


function downPaymentsList(){
    var html = "";
    var id = $('#carProductInformationId').val();
    $.ajax({
        url : '/AppManage/loanConfig/loanConfigList',
        data : {type : 1,carProductInformationId : id},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if(0 == data[i].sf || null == data[i].sf) {
                    html += '<label class="radio-inline"> <input type="checkbox" name="downPayments" value="'+data[i].loanConfigId+'" />' +
                        + data[i].configValue+'</label>';
                }else{
                    html += '<label class="radio-inline"> <input type="checkbox" name="downPayments" value="'+data[i].loanConfigId+'" checked/>' +
                        + data[i].configValue+'</label>';
				}
            }
            $("#downPayment").append(html);
        }
    });
}


function termsList(){
    var html = "";
    var id = $('#carProductInformationId').val();
    $.ajax({
        url : '/AppManage/loanConfig/loanConfigList',
        data : {type : 2,carProductInformationId : id},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if(0 == data[i].sf || null == data[i].sf) {
                    html += '<label class="radio-inline"> <input type="checkbox" name="terms" value="'+data[i].loanConfigId+'" />' +
                        + data[i].configValue + ' <input type="text" name="'+data[i].loanConfigId+'" style="width: 50px"/></label>';
                }else{
                    html += '<label class="radio-inline"> <input type="checkbox" name="terms" value="'+data[i].loanConfigId+'" checked/>' +
                        + data[i].configValue + ' <input type="text" name="'+data[i].loanConfigId+'" style="width: 50px" value="'+data[i].rate+'"/></label>';
                }
            }
            $("#term").append(html);
        }
    });
}


function programmeLabel(){
    var html = "";
    var id = $('#carProductInformationId').val();
    $.ajax({
        url : '/AppManage/label/labelList',
        data : {type : 1,id : id},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if(0 == data[i].sf || null == data[i].sf){
                    html += '<option value="' + data[i].labelId + '">' + data[i].name + '</option>'
                }else{
                    html += '<option value="' + data[i].labelId + '" selected>' + data[i].name + '</option>'
				}
            }
            $("#programmeLabel").append(html);
            $("#programmeLabel").chosen({
                maxHeight : 200
            });
        }
    });
}

function discountLabel(){
    var html = "";
    var id = $('#carProductInformationId').val();
    $.ajax({
        url : '/AppManage/label/labelList',
        data : {type : 3,id : id},
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                if(0 == data[i].sf || null == data[i].sf){
                    html += '<option value="' + data[i].labelId + '">' + data[i].name + '</option>'
                }else{
                    html += '<option value="' + data[i].labelId + '" selected>' + data[i].name + '</option>'
                }
            }
            $("#discountLabel").append(html);
            $("#discountLabel").chosen({
                maxHeight : 200
            });
        }
    });
}


function getAllSelectNodes() {
    var ref = $('#carTree').jstree(true); // 获得整个树

    carIds = ref.get_selected(); // 获得所有选中节点的，返回值为数组

    $("#carTree").find(".jstree-undetermined").each(function(i, element) {
        carIds.push($(element).closest('.jstree-node').attr("id"));
    });
}


function getCarTreeData() {
    var id = $('#carProductInformationId').val();
    $.ajax({
        type : "GET",
        url : "/CarManage/car/treeInit",
        data : {id : id},
        success : function(data) {
            if(null == data.brandIds){

            }else{
                brandIds = data.brandIds;
            }
            if(null == data.modelIds){

            }else{
                modelIds = data.modelIds;
            }
            carMenuTree(data.tree);
        }
    });
}
function carMenuTree(carTree) {
    $('#carTree').jstree({
        'core' : {
            'check_callback':true,
            'data' : carTree,
        },
        "checkbox" : {
            "three_state" : true,
        },
        "plugins" : [ "wholerow", "checkbox" ],
        // "plugins" : [ "search" ]
    });
    $('#carTree').jstree("open_all");
}

function getCarTreeDataTwo(id) {
    $.ajax({
        type : "GET",
        url : "/CarManage/car/treeTwoByFA",
        data : {id : id },
        success : function(data) {
            if(data.children.length == 0){
                    $("#carTree").jstree("create_node", id,  data, "last", false, true);
            }else{
                for(var i = 0;i<data.children.length;i++){
                    $("#carTree").jstree("create_node", id,  data.children[i], "last", false, false);
                }
            }
        }
    });
}

function getCarTreeDataThree(id) {
    $.ajax({
        type : "GET",
        url : "/CarManage/car/treeThreeByFA",
        data : {id : id },
        success : function(data) {
            if(data.children.length == 0){
                $("#carTree").jstree("create_node", id,  data, "last", false, true);
            }else{
                for(var i = 0;i<data.children.length;i++){
                    $("#carTree").jstree("create_node", id,  data.children[i], "last", false, false);
                }
            }
        }
    });
}



$('#carTree').on("changed.jstree", function(e, data) {

    if(null == data.node){
        return;
    }

    var carNmae = data.instance.get_path(data.node.id,"/",0);
    var sf = carNmae.split("/");
    var sflength = sf.length;
    if(sf[0] == '顶级节点'){

    }else{
        sflength = sflength+1;
    }
    if(sflength == 2){//选中的市品牌
        if(sfHave(brandIds,data.node.id)){
            brandIds.push(data.node.id);
            getCarTreeDataTwo(data.node.id);
        }
    }else if(sflength == 3){
        if(sfHave(modelIds,data.node.id)){
            modelIds.push(data.node.id);
            getCarTreeDataThree(data.node.id);
        }
    }
});

function sfHave(arr, obj) {
    var i = arr.length;
    while (i--) {
        if (arr[i] === obj) {
            return false;
        }
    }
    return true;
}