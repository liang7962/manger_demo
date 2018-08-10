function commonLayer(code,msg,title)
{
	var icon = 0;
	if(!isNullOrEmpty(code) && code == '200'){
		icon = 1;
	}
	else{
		icon = 2;
	}
	parent.layer.alert(msg, {
		icon:icon,
		title: title,
		skin: 'layui-layer-molv' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，<a target="_balnk" style="color:#00B2E2;" href="http://layer.layui.com/skin.html#publish">去这里查阅</a>
	});
}

/**
 * 判断参数是否为空
 */
function isNullOrEmpty(e){
  if(e==null || e==undefined || e==""){
    return true;
  }
  else{
    return false;
  }
}

/**
 * 二维码链接生成
 */
function qrcodeGenLayer(code,msg,title,downloadUrl,batchNo)
{
	if(!isNullOrEmpty(code) && code == '200'){
		parent.layer.alert(msg, {
			icon:1,
			title: title,
			skin: 'layui-layer-molv' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，<a target="_balnk" style="color:#00B2E2;" href="http://layer.layui.com/skin.html#publish">去这里查阅</a>
		}, function(index){
			parent.layer.close(index);
			var bodyContent = window.frameElement.contentDocument.body;
			var $form = $("#pagerForm");
			$.ajax({
				type:'GET',
				url:downloadUrl,
				dataType:"html",
				cache: false,
				success: function(_html){
					bodyContent.innerHTML= _html;
				}
			});
		});
	}
	else{
		parent.layer.alert(msg, {
			icon:2,
			title: title,
			skin: 'layui-layer-molv' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，<a target="_balnk" style="color:#00B2E2;" href="http://layer.layui.com/skin.html#publish">去这里查阅</a>
		});
	}
}

/**
 * Tab标签页ajaxConfirm提交
 * @param url 待加载页面连接
 * @param content 提示框内容
 * @returns
 */
function ajaxconfirm(url, content){
	ajaxConfirmByFormId(url, content, "pagerForm");
}

/**
 * 弹出层ajaxConfirm提交，刷新id为pagerModelForm的弹出层
 * @param url 待加载页面连接
 * @param content 提示框内容
 * @returns
 */
function ajaxModelConfirm(url, content){
	ajaxConfirmByFormId(url, content, "pagerModelForm");
}

/**
 * layer 提示关闭后刷新顶层页面（post请求，刷新弹出框页面内容）
 * @param url 待加载页面连接
 * @param content 提示框内容
 * @returns
 */
function ajaxConfirmByFormId(url, content, formId){
	layer.confirm(!isNullOrEmpty(content) ? content : '确定继续操作？', {icon: 3, title:'提示'}, function(index){
		var indexLoad = layer.load(3, {time: 5*60*1000}); //最长等待5分钟
		$.ajax({
			type: 'GET',
			url: url,
			cache: false,
			dataType:'json',
			success: function(json){
				layer.close(indexLoad);//关闭layer
				if(json.statusCode == '200'){
					layer.open({
						title: '系统提示',
						icon: 6,
						content: json.message,
						time: 1500,
						end:function(){
							// location.reload()； 是get请求，此处需要提交表单，所以用ajax提交表单
							$.ajax({
								type:'POST',
								url: $("#" + formId).attr("action"),
								data: $("#" + formId).serializeArray(),
								dataType:"html",
								cache: false,
								success: function(_html){
									layer.closeAll();
									$('#bodycontent').html(_html);
									//渲染插件样式
									initPlugins();
								}
							});
						}
					});  
				}else{
					layer.alert(json.message, {title:'系统提示',time: 2000, icon:5});
				}
			}
		});
		layer.close(index);
	});
}

/**
 * layer 弹出层中的弹出层提示框（get请求，刷新弹出框页面内容）
 * @param url 待加载页面连接
 * @param content 提示框内容
 * @returns
 */
function ajaxModelConfirmGET(url, content){
	parent.layer.confirm(!isNullOrEmpty(content) ? content : '确定继续操作？', {icon: 3, title:'提示'}, function(index){
		var indexLoad = parent.layer.load(3, {time: 5*60*1000}); //最长等待5分钟
		$.ajax({
			type: 'GET',
			url: url,
			cache: false,
			dataType:'json',
			success: function(json){
				parent.layer.close(indexLoad);//关闭layer
				if(json.statusCode == '200'){
					parent.layer.open({
						title: '系统提示',
						icon: 6,
						content: json.message,
						time: 1500,
						end:function(){
							// 刷新iframe（get请求）
							location.reload();
						}
					});  
				}else{
					parent.layer.alert(json.message, {title:'系统提示',time: 2000, icon:5});
				}
			}
		});
		parent.layer.close(index);
	});
}

/**
 * layer page弹出层（type: 1）
 * @param url 待加载页面连接
 * @param title 标题
 * @param width 宽度（百分比）
 * @param height 高度（百分比）
 * @param maxmin 是否开启最大化（开启：true/开启：false）
 * @returns
 */
function layerModel(url, title, width, height, maxmin){
	var index_ = layer.load(3, {time: 2*60*1000});
	$.ajax({
		type: "GET",
		url: url,
		cache: false,
		dataType:'html',
		success: function(html_){
			layer.close(index_);//关闭layer
			var index1 = layer.open({
				  type: 1,
				  title: '<i class="fa fa-file-text-o" style="margin-right:5px"></i><B>' + title + '</B>',	//标题
//				  skin: 'layui-layer-rim', //加上边框
				  anim: 0,
				  scrollbar: false,
				  area: [width, height], //宽高
				  maxmin: maxmin,	//开启最大化最小化按钮
				  content: html_
			});
			initPlugins();
		}
	});
}

/**
 * layer iframe弹出层（type: 2）
 * @param url 待加载页面连接
 * @param title 标题
 * @param width 宽度（百分比）
 * @param height 高度（百分比）
 * @param maxmin 是否开启最大化（开启：true/开启：false）
 * @returns
 */
function layerIframeModel(url, title, width, height, maxmin){
	var index = layer.open({
		type: 2,
		title: '<i class="fa fa-file-text-o" style="margin-right:5px"></i><B>' + title + '</B>',	//标题
//		skin: 'layui-layer-rim', //加上边框
		anim: 0,
		scrollbar: false,
		area: [width, height], //宽高
		maxmin: maxmin,	//开启最大化最小化按钮
		content: url
	});
}

//function layerModelCustom(url, title, width, height, maxmin, btnVal, ref_fromId){
//	var index_ = layer.load(3, {time: 2*60*1000});
//	$.ajax({
//		type: "GET",
//		url: url,
//		cache: false,
//		dataType:'html',
//		success: function(data){
//			layer.close(index_);//关闭layer
//			var index = layer.open({
//				type: 1,
//				title: '<i class="fa fa-file-text-o" style="margin-right:5px"></i><B>' + title + '</B>',	//标题
//				//shadeClose: true,
//				shade: 0.1,	//透明度
//				fix: false, //不固定
//				scrollbar: false,	//屏蔽浏览器滚动条
//				maxmin: maxmin,	//开启最大化最小化按钮
//				area: [width, height],
//				content: data,
//				btn: [btnVal, '关闭'],
//				btn1: function(){
//					//按钮【按钮一】的回调
//					alert(ref_fromId);
//					$('#' + ref_fromId).submit();
////					$.ajax({
////						type: form.method || 'POST',
////						url:$form.attr("action"),
////						data:$form.serializeArray(),
////						dataType:"html",
////						cache: false,
////						success: function(_html){
////							layer.close(index);//关闭layer
////							$("#bodycontent").html(_html)
//////							window.frameElement.contentDocument.body.innerHTML = _html;
////							//渲染插件样式
////							initPlugins();
////						}
////					});
//				}
////				,cancel: function(){ 
////				    //右上角关闭回调
////					if(cancel_callback_href != '' && cancel_callback_href != null && cancel_callback_href != undefined){
////						cancelCallbackModal(cancel_callback_href);
////						$.noop();
////					} else {
////						$.noop();
////					}
////			    }
//			});
//			initPlugins();
//		}
//	});
//}
//
////关闭模态回调，跳转到指定Tab
////function cancelCallbackModal(_href){
////	$.ajax({
////		type : 'GET',
////		url : _href,
////		cache : false,
////		dataType : 'html',
////		success : function(_html) {
////			$("#main.main_content").html(_html);
////			$("#main.main_content").append("<input type='hidden' id='origurl' value='" + _href + "'/>");
////			initEnv();
////		}
////	});
////}

function layer_alertTip(message){
	layer.alert(message, {title:'系统提示', icon: 0});
}

function layer_alertError(message){
	layer.alert(message, {title:'系统提示',time: 3000, icon: 5});
}

function layer_alertSuccess(message){
	layer.alert(message, {title:'系统提示',time: 2000, icon: 6});
}


//定义一个函数，验证是否不包含特殊字符（例：*-/.）
function isSpecialChar(s) { 
	var regEn = /[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im,
    regCn = /[·！#￥（——）：；“”‘、，|《。》？、【】[\]]/im;
    var str=s.value;
	if(regEn.test(str) || regCn.test(str)) {
	    alert(s.placeholder+"不能包含特殊字符.");
	    s.value=str.substring(0,str.length-1);
	    return false;
	} 
}
