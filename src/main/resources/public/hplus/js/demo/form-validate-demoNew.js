$.validator.setDefaults({
    highlight: function(e) {
        $(e).closest(".form-group").removeClass("has-success").addClass("has-error")
    },
    success: function(e) {
        e.closest(".form-group").removeClass("has-error").addClass("has-success")
//        e.closest(".form-group").removeClass("has-error") input-group-addon
    },
    errorElement: "span",
    errorPlacement: function(e, r) {
        e.appendTo(r.is(":radio") || r.is(":checkbox") ? r.parent().parent().parent() : r.parent())
    },
    errorClass: "help-block m-b-none",
    validClass: "help-block m-b-none"
}),

$().ready(function() {
    // 字母,数字
    jQuery.validator.addMethod("chrnum", function(value, element) {
        var chrnum = /^([0-9]+)$/;
        return this.optional(element) || (chrnum.test(value));
    }, "只能输入数字(0-9)");
    // 大陆身份证号 数字，最后一位可为字母
    jQuery.validator.addMethod("checkIdCard", function(value, element) {
        var chrnum = /^[1-9]\d{13,16}[a-zA-Z0-9]{1}$/;
        return this.optional(element) || (chrnum.test(value));
    }, "身份证号码格式不正确");

    jQuery.validator.addMethod("chrEmail", function(value, element) {
        var chrnum = /^\w+@\w+\.[a-zA-Z0-9]+(\.[a-zA-Z0-9]+)?$/;
        return this.optional(element) || (chrnum.test(value));
    }, "邮箱格式不正确（格式：zhangsan@sina.com，zhangsan@xxx.com.cn）");

    jQuery.validator.addMethod("chrMobile", function(value, element) {
        var chrnum = /^(\+\d+)?1[34578]\d{9}$/;
//        var chrnum = /^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$/;
        return this.optional(element) || (chrnum.test(value));
    }, "手机号格式不正确（格式：支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））");

    //校验密码：只能输入6-20个字母、数字、下划线  
    jQuery.validator.addMethod("checkPassword", function(value, element) {
    	var chrnum = /^(\w){6,20}$/;
    	return this.optional(element) || (chrnum.test(value));
    }, "只能输入6-20个字母、数字或下划线");
    
    //校验只能输入纯数字
    jQuery.validator.addMethod("checkDigit", function(value, element) {
    	var chrnum = /^[0-9]{1,20}$/;
    	return this.optional(element) || (chrnum.test(value));
    }, "只能输入纯数字");
    
    jQuery.validator.addMethod("specialChar", function(value, element) {
        var chrnum = /^[\u4E00-\u9FA5a-zA-Z0-9_]*$/;
        return this.optional(element) || (chrnum.test(value));
    }, "禁止输入特殊字符（例：*-/.）");
    
    jQuery.validator.addMethod("compareDate", function(value, element, param) {
        var startDate = jQuery(param).val();
        var date1 = new Date(startDate.replace("-", "/").replace("-", "/"));
        var date2 = new Date(value.replace("-", "/").replace("-", "/"));
        return date1 <= date2;
    }, "结束日期必须大于开始日期");
    
    var e = "<i class='fa fa-times-circle'></i> ";
    
    $("#updatePwdForm").validate({
    	rules:{
    		oldPassword:{
    			required:true,
    			checkPassword:true
    		},
    		newPassword:{
    			required:true,
    			checkPassword:true
    		},
    		confirmPassword:{
    			required:true,
    			checkPassword:true,
    			equalTo: "#password"
    		}
    	},
    	messages:{
    		oldPassword:{
    			required: e + "请输入原始密码",
    			checkPassword: e + "只能输入6-20个字母、数字或下划线"
    		},
    		newPassword:{
    			required: e + "请输入新密码",
    			checkPassword: e + "只能输入6-20个字母、数字或下划线"
    		},
    		confirmPassword:{
    			required: e + "请再次输入新密码",
    			checkPassword: e + "只能输入6-20个字母、数字或下划线",
    			equalTo: e + "新密码和确认密码不一致"
    		}
    	},
    	submitHandler:function(form){
    		var $form = $(form);
    		var indexLoad = layer.load(3, {time: 5*60*1000}); //最长等待5分钟	
    		$.ajax({
    				type: form.method || 'POST',
    				url:$form.attr("action"),
    				data:$form.serializeArray(),
    				cache: false,
    				dataType:'json',
    				success: function(json){
    					layer.close(indexLoad);//关闭layer
	    				if(json.statusCode == '300' || json.statusCode == '301') {
	    					//失败、超时
	    					$('#alert-div-error').removeClass().addClass("alert alert-danger").html(json.message + "，3s后跳转至登录页面");
	    					if(json.forwardUrl != null && json.forwardUrl != ''){
	    						var clickTime = new Date().getTime();
	    						var Timer = setInterval(function() {
	    							var nowTime = new Date().getTime();
	    							var second = Math.ceil(3 - (nowTime - clickTime) / 1000);
	    							if (second > 0) {
	    								$('#alert-div-error').html(json.message + "，" + second + "s后跳转至登录页面")
	    							} else {
	    								clearInterval(Timer);
	    								$("#alert-div-error").removeClass().addClass("hide");
	    								window.location.href = json.forwardUrl;
	    							}
	    						},
	    						1000);
	    					}
	    				} else if (json.statusCode == '200'){
	    					//成功
	    					$('#alert-div-error').removeClass().addClass("alert alert-success").html(json.message + "，2s后跳转至首页");
	    					
	    				    var clickTime = new Date().getTime();
	    				    var Timer = setInterval(function() {
	    				        var nowTime = new Date().getTime();
	    				        var second = Math.ceil(2 - (nowTime - clickTime) / 1000);
	    				        if (second > 0) {
	    				            $('#alert-div-error').html(json.message + "，" + second + "s后跳转至首页")
	    				        } else {
	    				            clearInterval(Timer);
	    				            $("#alert-div-error").removeClass().addClass("hide");
	    				            window.location.href="index";
	    				        }
	    				    },
	    				    1000);
	    				}
    				}
    			});
    	}
    });
    
    $("#billForm").validate({
    	rules: {
    		start: {
    			required: true
//    			dateISO: true
    		},
    		end: {
		    	required: true,
//		    	dateISO: true,
		    	compareDate: "#start"
		    }
    	},
    	messages: {
    		start: {
    			required: e + "请输入开始日期",
    			dateISO: e + "请输入有效的开始日期 (YYYY-MM-DD)"
    		},
	    	end: {
	    		required: e + "请输入结束日期",
	    		dateISO: e + "请输入有效的结束日期 (YYYY-MM-DD)",
	    		compareDate: e + "结束日期必须大于或等于开始日期"
	    	}
    	}
    });
    $("#agentOrSalesAdd_form").validate({
    	rules: {
    		addType:{
    			required:true, 
    		},
    		mobileNo: {
    			required:true, 
    			chrMobile:true
    		},
    		agentName: {
    			required:true, 
    			specialChar:true
    		},
    		keyman:{
    			required:true, 
    			specialChar:true
    		},
    		ident:{
    			required:true,
    			maxlength: 18,
    			checkIdCard: true
    		},
    		assisMobileNo: {
    			required:true, 
    			chrMobile:true
    		},
    		assisName:{
    			required:true,
    			specialChar:true
    		}
    	},
    	messages: {
    		addType:{
    			required: e + "请选择添加的类型",
    		},
    		mobileNo: {
    			required: e + "请输入手机号", 
    			chrMobile: e + "手机号码格式不正确"
    		},
    		agentName: {
    			required: e + "请输入服务商名称", 
    			specialChar: e + "服务商名称不能包含特殊字符（例：*-/.）"
    		},
    		keyman: {
    			required: e + "请输入负责人姓名", 
    			specialChar: e + "负责人姓名不能包含特殊字符（例：*-/.）"
    		},
    		ident:{
    			required:e + "请输入身份证号码",
    			maxlength: e + "身份证号码最多为18位",
    			checkIdCard: e + "身份证号码格式不正确"
    		},
    		assisMobileNo: {
    			required: e + "请输入手机号", 
    			chrMobile: e + "手机号码格式不正确"
    		},
    		assisName: {
    			required: e + "请输入业务员姓名", 
    			specialChar: e + "业务员姓名不能包含特殊字符（例：*-/.）"
    		}
    	},
    	submitHandler:function(form){
    		ajaxModalSubmit(form);
    	}
    });
    $("#agentAddForm").validate({
    	rules: {
    		mobileNo: {
    			required:true, 
    			chrMobile:true
    		},
    		agentName: {
    			required:true, 
    			specialChar:true
    		},
    		keyman:{
    			required:true, 
    			specialChar:true
    		},
    		ident:{
    			required:true,
    			maxlength: 18,
    			checkIdCard: true
    		}
    	},
    	messages: {
    		mobileNo: {
    			required: e + "请输入手机号", 
    			chrMobile: e + "手机号码格式不正确"
    		},
    		agentName: {
    			required: e + "请输入服务商名称", 
    			specialChar: e + "服务商名称不能包含特殊字符（例：*-/.）"
    		},
    		keyman: {
    			required: e + "请输入负责人姓名", 
    			specialChar: e + "负责人姓名不能包含特殊字符（例：*-/.）"
    		},
    		ident:{
    			required:e + "请输入身份证号码",
    			maxlength: e + "身份证号码最多为18位",
    			checkIdCard: e + "身份证号码格式不正确"
    		}

    	},
//		invalidHandler: function(form, validator) {
//			layer.alert('表单数据有误，请修改完成再提交！', {title:'系统提示',time: 2000, icon:0});
//		},
    	submitHandler:function(form){
    		ajaxModalSubmit(form);
    	}
    });

    $("#managerAddForm").validate({
        rules: {
            mobileNo: {
                required:true,
                chrMobile:true
            },
            password:{
                required: e + "请输入密码",
                checkPassword: e + "只能输入6-20个字母、数字或下划线"
            }
        },
        messages: {
            mobileNo: {
                required: e + "请输入手机号",
                chrMobile: e + "手机号码格式不正确"
            },
            password: {
                required: e + "请输入密码",
                checkPassword: e + "只能输入6-20个字母、数字或下划线"
            }

        },
//		invalidHandler: function(form, validator) {
//			layer.alert('表单数据有误，请修改完成再提交！', {title:'系统提示',time: 2000, icon:0});
//		},
        submitHandler:function(form){
            ajaxModalSubmit(form);
        }
    });

    $("#assistantAddForm").validate({
    	rules: {
    		mobileNo: {
    			required:true, 
    			chrMobile:true
    		},
    		assisName:{
    			required:true,
    			specialChar:true
    		}
    	},
    	messages: {
    		mobileNo: {
    			required: e + "请输入手机号", 
    			chrMobile: e + "手机号码格式不正确"
    		},
    		assisName: {
    			required: e + "请输入业务员姓名", 
    			specialChar: e + "业务员姓名不能包含特殊字符（例：*-/.）"
    		}
    	},
    	submitHandler:function(form){
    		ajaxModalSubmit(form);
    	}
    });
});