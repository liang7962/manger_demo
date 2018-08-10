var pageflag = 0;

//Tab
function toPage(page)
{
	if (pageflag == 0){
		$(this).attr("disabled", true);
		$("#pagerForm input[name='pageNum']").val(page);
		pagerSubmit();
	}else{
		pageflag = 1;
	}
}

function prePage()
{
	if (pageflag == 0){
		var page = $("#pagerForm input[name='pageNum']").val();
		if(1 < page)
		{
			$("#pagerForm input[name='pageNum']").val(page*1 - 1);
			pagerSubmit();
		}
	}else{
		pageflag = 1;
	}
}


function nextPage()
{
	if (pageflag == 0){
		var page = $("#pagerForm input[name='pageNum']").val();
		$("#pagerForm input[name='pageNum']").val(page*1 + 1);
		pagerSubmit();
	}else{
		pageflag = 1;
	}
}


function pagerSubmit()
{
	var bodyContent = window.frameElement.contentDocument.body;
	var $form = $("#pagerForm");
	$.ajax({
		type:'POST',
		url:$form.attr("action"),
		data:$form.serializeArray(),
		dataType:"html",
		cache: false,
		success: function(_html){
			$("#bodycontent").html(_html)
			//渲染插件样式
			initPlugins();
		}
	});
	return false;
}

//modal
function toModalPage(page)
{
	if (pageflag == 0){
		$("#bodycontent #pagerModelForm input[name='pageNum']").val(page);
		pagerModalSubmit();
	}else{
		pageflag = 1;
	}
}

function preModalPage()
{
	if (pageflag == 0){
		var page = $("#bodycontent #pagerModelForm input[name='pageNum']").val();
		if(1 < page)
		{
			$("#bodycontent #pagerModelForm input[name='pageNum']").val(page*1 - 1);
			pagerModalSubmit();
		}
	}else{
		pageflag = 1;
	}
}


function nextModalPage()
{
	if (pageflag == 0){
		var page = $("#bodycontent #pagerModelForm input[name='pageNum']").val();
		$("#bodycontent #pagerModelForm input[name='pageNum']").val(page*1 + 1);
		pagerModalSubmit();
	}else{
		pageflag = 1;
	}
}


function pagerModalSubmit()
{
	var index = layer.load(3, {time: 2*60*1000}); //最长等待2分钟
	$.ajax({
		type:'POST',
		url: $("#pagerModelForm").attr("action"),
		data: $("#pagerModelForm").serializeArray(),
		dataType:"html",
		cache: false,
		success: function(_html){
			layer.close(index);//关闭layer
			$("#bodycontent").html(_html)
			//渲染插件样式
			initPlugins();
		}
	});
//	var $form = $("div.layui-layer-content #pagerForm");
//	var index = layer.load(3, {time: 2*60*1000}); //最长等待2分钟
//	$.ajax({
//		type:'POST',
//		url:$form.attr("action"),
//		data:$form.serializeArray(),
//		dataType:"html",
//		cache: false,
//		success: function(_html){
//			layer.close(index);//关闭layer
//			$("#bodycontent").html(_html)
//			//渲染插件样式
//			initPlugins();
//		}
//	});
	return false;
}