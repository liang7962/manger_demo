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
    return this.optional(element) || (chrnum.test(value));
}, "手机号格式不正确（格式：支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））");

jQuery.validator.addMethod("compareDate", function(value, element, param) {
    var startDate = jQuery(param).val();
    var date1 = new Date(startDate.replace("-", "/").replace("-", "/"));
    var date2 = new Date(value.replace("-", "/").replace("-", "/"));
    return date1 <= date2;
}, "结束日期必须大于开始日期");

jQuery.validator.addMethod("specialChar", function(value, element) {
    var chrnum = /^[\u4E00-\u9FA5a-zA-Z0-9_]*$/;
    return this.optional(element) || (chrnum.test(value));
}, "禁止输入特殊字符（例：*-/.）");

jQuery.validator.addMethod("checkDigit", function(value, element) {
	var chrnum = /^[0-9]{1,20}$/;
	return this.optional(element) || (chrnum.test(value));
}, "只能输入纯数字");
//校验密码：只能输入6-20个字母、数字、下划线  
jQuery.validator.addMethod("checkPassword", function(value, element) {
	var chrnum = /^(\w){6,20}$/;
	return this.optional(element) || (chrnum.test(value));
}, "只能输入6-20个字母、数字或下划线");

$().ready(function() {


    var e = "<i class='fa fa-times-circle'></i> ";
    
    $("#agentAddForm").validate({
    	rules: {
    		agentName: {
    			required: true,
    			maxlength: 64,
    			specialChar: true
    		},
    		agentAbbr: {
    			required: true,
    			maxlength: 16,
				specialChar: true
    		}
    	},
    	messages: {
    		agentName: {
    			required: e + "请输入代理商名称",
    			maxlength: e + "代理商名称最多为64个字符",
    			specialChar: e + "代理商名称不能包含特殊字符（例：*-/.）"
    		},
    		agentAbbr: {
    			required: e + "请输入代理商简称",
    			maxlength: e + "代理商简称最多为16个字符",
    			specialChar: e + "代理商简称不能包含特殊字符（例：*-/.）"
    		}
    	},
    	submitHandler:function(form){
    		// 注意使用ajaxModalSubmit(form); ajax请求完成后返回的json数据中必须有json.forwardUrl
    		// Tab标签页 可以用ajaxModalSubmit(form); 或 ajaxModalSubmitTo(form, "pagerForm");
    		ajaxModalSubmitTo(form, "pagerForm");
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
        submitHandler:function(form){
            // 注意使用ajaxModalSubmit(form); ajax请求完成后返回的json数据中必须有json.forwardUrl
            // Tab标签页 可以用ajaxModalSubmit(form); 或 ajaxModalSubmitTo(form, "pagerForm");
            ajaxModalSubmitTo(form, "pagerForm");
        }
    });
    
    
    $("#agentAcctAddForm").validate({
    	rules: {
    		mobileNo: {
    			required: true,
    			chrMobile: true
    			}
    	},
    	messages: {
    		mobileNo: {
    			required: e + "请输入手机号",
    			chrMobile: e + "手机号格式错"
    		}
    	},
    	submitHandler:function(form){
    		// model页面的弹出层数据提交，必须指定需要刷新的model页面formId
    		ajaxModalSubmitTo(form, "pagerModelForm");
    	}
    });

    $("#accountForm").validate({
    	rules: {
            accId: {
    			required: true
    			},
            mobileNo: {
    			required: true,
    			chrMobile: true
    			},
            role: {
    			required: true,
                maxlength:1
    			},
            email: {
    			required: true,
                email: true
    			},
            wechatOpenId: {
    			required: true,
    			},
            wechatUnionId: {
    			required: true,
    			}
    	},
    	messages: {
            accId: {
    			required: e + "请输入accId",
    		},
            mobileNo: {
                required:  e + "请输入手机号",
                chrMobile: e + "手机号格式错"
            },
            role: {
                required:  e + "请输入角色",
                maxlength:e + "角色长度输入有误"
            },
            email: {
                required:  e + "请输入邮箱",
                email: e + "邮箱格式错"
            },
            wechatOpenId: {
                required:  e + "请输入wechatOpenId",
            },
            wechatUnionId: {
                required:  e + "请输入wechatUnionId",
            }
    	},
    	submitHandler:function(form){
    		// model页面的弹出层数据提交，必须指定需要刷新的model页面formId
    		ajaxModalSubmitTo(form, "pagerModelForm");
    	}
    });
    
    
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
	    					$('#alert-div-error').removeClass().addClass("alert alert-danger").html(json.message );
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
	    					$('#alert-div-error').removeClass().addClass("alert alert-success").html(json.message + "，2s后重新登录");
	    					
	    				    var clickTime = new Date().getTime();
	    				    var Timer = setInterval(function() {
	    				        var nowTime = new Date().getTime();
	    				        var second = Math.ceil(2 - (nowTime - clickTime) / 1000);
	    				        if (second > 0) {
	    				            $('#alert-div-error').html(json.message + "，" + second + "s后重新登录")
	    				        } else {
	    				            clearInterval(Timer);
	    				            $("#alert-div-error").removeClass().addClass("hide");
	    				            window.location.href=json.forwardUrl;
	    				        }
	    				    },
	    				    1000);
	    				}
    				}
    			});
    	}
    });
    
});