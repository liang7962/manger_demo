/**
 * 表单提交的tab查询事件
 */
function ajaxTabSearch(form) {
	var $form = $(form);
	//加载层
	var index = layer.load(3, {time: 2*60*1000}); //最长等待2分钟
	$("#pagerForm input[name='pageNum']").val("1");
	$.ajax({
		type: form.method || 'POST',
		url:$form.attr("action"),
		data:$form.serializeArray(),
		dataType:"html",
		cache: false,
		success: function(_html){
			layer.close(index);//关闭layer
			$("#bodycontent").html(_html)
//			window.frameElement.contentDocument.body.innerHTML = _html;
			//渲染插件样式
			initPlugins();
		}
	});
	return false;
}

/**
 * 处理modal弹出层上的查询, 会重新载入当前modal
 * @param {Object} form
 */
function ajaxModalSearch(form){
	var $form = $(form);
	//加载层100001
	var index = layer.load(3, {time: 2*60*1000}); //最长等待2分钟
	$("#pagerModelForm input[name='pageNum']").val("1");
	$.ajax({
		type: form.method || 'POST',
		url:$form.attr("action"),
		data:$form.serializeArray(),
		dataType:"html",
		cache: false,
		success: function(_html){
			layer.close(index);//关闭layer
			$("#bodycontent").html(_html)
			initPlugins();
		}
	});
	return false;
}

/**
 * Tab表单提交的ajax事件
 * @param form
 * @returns {Boolean}
 */
function ajaxTabSubmit(form) {
	var $form = $(form);
//	if (!$form.valid()) {
//		return false;
//	}
	layer.confirm($form.find("[type=submit]").attr("title")||'确定继续操作？', {icon: 3, title:'提示'}, function(index){
		//加载层
		var indexLoad = layer.load(3, {time: 5*60*1000}); //最长等待5分钟	
		$.ajax({
				type: form.method || 'POST',
				url:$form.attr("action"),
				data:$form.serializeArray(),
				cache: false,
				dataType:'json',
				success: function(json){
					layer.close(indexLoad);//关闭layer
					ajaxDone(json);
				}
			});
			layer.close(index);
		});
	return false;
}


/**
 * modal表单提交的ajax事件
 * @param form
 * @returns {Boolean}
 */
function ajaxModalSubmit(form) {
	var $form = $(form);
	var indexLoad = layer.load(3, {time: 5*60*1000}); //最长等待5分钟	
	$.ajax({
			type: form.method || 'POST',
			url: $form.attr("action"),
			data: $form.serializeArray(),
			cache: false,
			dataType:'json',
			success: function(json){
				layer.close(indexLoad);//关闭layer
				ajaxDone(json);
			}
		});
	return false;
}

function ajaxModalSubmitTo(form, refresh_formId) {
	var $form = $(form);
	var indexLoad = layer.load(3, {time: 5*60*1000}); //最长等待5分钟	
	$.ajax({
		type: form.method || 'POST',
		url: $form.attr("action"),
		data: $form.serializeArray(),
		cache: false,
		dataType:'json',
		success: function(json){
			layer.close(indexLoad);//关闭layer
			if(refresh_formId != undefined || refresh_formId != null || refresh_formId != "") {
				ajaxDoneTo(json, refresh_formId);
			}else{
				ajaxDone(json);
			}
		}
	});
	return false;
}

/**
 * 绑定ajax方法-返回页面载入tab
 */
function ajaxTab(_this){
	var $this = $(_this);
	if($this){
		$this.each(function(){
			$(this).click(function(event){
				var $_this = $(this);
				$.ajax({
					type: 'GET',
					url: $_this.attr("href"),
					cache: false,
					dataType:'html',
					success: function(_html){
						$("#main.main_content").html(_html);
						$("#main.main_content").append("<input type='hidden' id='origurl' value='"+$_this.attr("href")+"'/>");
						initTabUI();
						initDataTable();
						initValidation();
						initPlugins();
					}
				});
				event.preventDefault();
			});
		});
	}
}

/**
 * 绑定ajax方法-解析返回数据
 * @param _this
 */
function ajaxTodo(_this){
	var $this = $(_this);
	if($this){
		$this.each(function(){
			$(this).click(function(event){
				var $this_a = $(this);
				layer.confirm($this_a.attr("title")||'确定继续操作？', {icon: 3, title:'提示'}, function(index){
					//加载层
					var indexLoad = layer.load(3, {time: 5*60*1000}); //最长等待5分钟
					$.ajax({
						type: 'GET',
						url: $this_a.attr("href"),
						cache: false,
						dataType:'json',
						success: function(json){
							layer.close(indexLoad);//关闭layer
							ajaxDone(json);
						}
					});
					layer.close(index);
				});
				event.preventDefault();
			});
		});
	}
}

/**
 * 绑定ajax弹出框方法-弹出modal
 */
function ajaxModal(_this){
	var $this = $(_this);
	if($this){
		$this.each(function(){
			$(this).click(function(event){
				$this.attr("data-toggle","modal");
				$this.attr("data-target","#modal");
				$this.attr("data-backdrop","static");
				$this.attr("data-keyboard",true);
				$this.attr("data-title",$this.attr("title")||"Title");
			});
		});
	}
}

/**
 * 重新加载Tab上的url
 */
function ajaxReload(origurl){
	if(null != origurl){
		$.ajax({
			type: 'POST',
			url: origurl,
			cache: false,
			success: function(_html){
				$('#bodycontent').html(_html);
				initPlugins();
			}
		});
	}
}

/**
 * bootstrap的结果提示
 * @param json
 * @param form
 */
function ajaxDone(json){
	if (json.statusCode == undefined && json.message == undefined) {
		//未定义Code
		layer.alert('未知错误！', {title:'系统提示',time: 2000, icon:5});
	} else if(json.statusCode == '300' || json.statusCode == '301') {
		//失败、超时
		layer.alert(json.message, {title:'系统提示',time: 3000, icon:5});
//		layer.open({
//			title: '系统提示',
//			icon: 5,
//			content: json.message,
//			time: 3000
////			,end:function(){
////				layer.closeAll('page');
////				ajaxReload(json.forwardUrl);
////			}
//		});  
	} else if (json.statusCode == '200'){
		//成功
		layer.open({
			title: '系统提示',
			icon: 6,
			content: json.message,
			time: 2000,
			end:function(){
				layer.closeAll('page');
				ajaxReload(json.forwardUrl);
			}
		});  
	}else{
		//未知code
		layer.alert(json.statusCode, {title:'系统提示',time: 2000, icon:5});
	}
}

function ajaxDoneTo(json, refresh_formId ){
	if (json.statusCode == '200'){
		layer.open({
			title: '系统提示',
			icon: 6,
			content: json.message,
			time: 1500,
			end:function(){
				// location.reload()； 是get请求，此处需要提交表单，所以用ajax提交表单
				// model刷新数据
				$.ajax({
					type:'POST',
					url: $("#" + refresh_formId).attr("action"),
					data: $("#" + refresh_formId).serializeArray(),
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
	}else
	{
		layer.alert(json.message, {title:'系统提示',time: 3000, icon:5});
	}
}

/**
 * 带文件上传的ajax表单提交
 * @param {Object} form
 * @param {Object} callback
 */
function iframeCallback(form, callback){
	var $form = $(form), $iframe = $("#callbackframe");
	if(!$form.valid()) {return false;}

	if ($iframe.size() == 0) {
		$iframe = $("<iframe id='callbackframe' name='callbackframe' src='about:blank' style='display:none'></iframe>").appendTo("body");
	}
	if(!form.ajax) {
		$form.append('<input type="hidden" name="ajax" value="1" />');
	}
	form.target = "callbackframe";
	
	_iframeResponse($iframe[0], callback);
}
function _iframeResponse(iframe, callback){
	var $iframe = $(iframe), $document = $(document);
	
	$document.trigger("ajaxStart");
	
	$iframe.bind("load", function(event){
		$iframe.unbind("load");
		$document.trigger("ajaxStop");
		
		if (iframe.src == "javascript:'%3Chtml%3E%3C/html%3E';" || // For Safari
			iframe.src == "javascript:'<html></html>';") { // For FF, IE
			return;
		}

		var doc = iframe.contentDocument || iframe.document;

		// fixing Opera 9.26,10.00
		if (doc.readyState && doc.readyState != 'complete') return; 
		// fixing Opera 9.64
		if (doc.body && doc.body.innerHTML == "false") return;
	   
		var response;
		
		if (doc.XMLDocument) {
			// response is a xml document Internet Explorer property
			response = doc.XMLDocument;
		} else if (doc.body){
			try{
				response = $iframe.contents().find("body").text();
				response = jQuery.parseJSON(response);
			} catch (e){ // response is html document or plain text
				response = doc.body.innerHTML;
			}
		} else {
			// response is a xml document
			response = doc;
		}
		
		callback(response);
	});
}