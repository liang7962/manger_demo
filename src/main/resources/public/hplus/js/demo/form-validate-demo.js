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
        var chrnum = /^(\+\d+)?1[3458]\d{9}$/;
        return this.optional(element) || (chrnum.test(value));
    }, "手机号格式不正确（格式：支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））");
    
    jQuery.validator.addMethod("compareDate", function(value, element, param) {
        var startDate = jQuery(param).val();
//        var date1 = new Date(Date.parse(startDate.replace("-", "/")));
//        var date2 = new Date(Date.parse(value.replace("-", "/")));
        var date1 = new Date(startDate.replace("-", "/").replace("-", "/"));
        var date2 = new Date(value.replace("-", "/").replace("-", "/"));
        return date1 <= date2;
    }, "结束日期必须大于开始日期");

    $("#commentForm").validate();
    var e = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            firstname: "required",
            lastname: "required",
            username: {
                required: !0,
                minlength: 2
            },
            password: {
                required: !0,
                minlength: 5
            },
            confirm_password: {
                required: !0,
                minlength: 5,
                equalTo: "#password"
            },
            email: {
                required: !0,
                email: !0
            },
            topic: {
                required: "#newsletter:checked",
                minlength: 2
            },
            agree: "required"
        },
        messages: {
            firstname: e + "请输入你的姓",
            lastname: e + "请输入您的名字",
            username: {
                required: e + "请输入您的用户名",
                minlength: e + "用户名必须两个字符以上"
            },
            password: {
                required: e + "请输入您的密码",
                minlength: e + "密码必须5个字符以上"
            },
            confirm_password: {
                required: e + "请再次输入密码",
                minlength: e + "密码必须5个字符以上",
                equalTo: e + "两次输入的密码不一致"
            },
            email: e + "请输入您的E-mail",
            agree: {
                required: e + "必须同意协议后才能注册",
                element: "#agree-error"
            }
        }
    }),
    $("#username").focus(function() {
        var e = $("#firstname").val(),
        r = $("#lastname").val();
        e && r && !this.value && (this.value = e + "." + r)
    });
    //证通认证校验
    $("#authenticateForm").validate({
        rules: {
            usernm: {
                required: true
            },
            certseq: {
                required: true,
                checkIdCard: true
            },
            acctno: {
                required: true
            },
            phoneno: {
                chrMobile: true
            }
        },
        messages: {
            usernm: e + "请输入姓名",
            certseq: {
                required: e + "请输入身份证号",
                checkIdCard: e + "身份证号码格式不正确"
            },
            acctno: {
                required: e + "请输入银行卡号"
            },
            phoneno: {
                chrMobile: e + "手机号格式不正确（格式：支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））"
            }
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
		    },
		    billType: "required"
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
	    	},
	    	billType: e + "至少选择一种账单"
    	}
    });
    $("#order_refund").validate({
    	rules: {
    		remain6: "required"
    	},
    	messages: {
    		remain6: e + "请填写退款原因"
    	}
    });
});