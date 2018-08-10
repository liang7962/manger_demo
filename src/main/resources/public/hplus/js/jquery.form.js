$(document).ready(function() {
	initPlugins();
}); 

/**
 *渲染页面样式,初始化form表单组件
 */
function initPlugins() {
	h_chosen.init();
//	layerDate.init();
	layer_date.init();
}


//* enhanced select elements
h_chosen = {
	init: function(){
		$(".chzn-select").chosen({
			no_results_text: "没有匹配结果",
			allow_single_deselect: true,
			search_contains: true
//			disable_search_threshold: 10 //超过option就显示搜索框
		});
		$(".chzn-select-noSearch").chosen({
			no_results_text: "没有匹配结果",
			allow_single_deselect: true,
			search_contains: true,//匹配任意字符搜索
			disable_search: true //此参数禁用搜索框
		});
	}
};

/**
 * laydate 配置
 *1.type - 控件选择类型(类型：String，默认值：date)
 *type可选值	名称				用途
 *year		年选择器			只提供年列表选择
 *month		年月选择器		只提供年、月选择
 *date		日期选择器		可选择：年、月、日。type默认值，一般可不填
 *time		时间选择器		只提供时、分、秒选择
 *datetime	日期时间选择器	可选择：年、月、日、时、分、秒
 *
 *2.range - 开启左右面板范围选择(类型：Boolean/String，默认值：false。如果设置 true，将默认采用 “ - ” 分割，可自定义分割字符)
 *
 *3.format - 自定义格式(类型：String，默认值：yyyy-MM-dd)
 *格式							示例值
 *yyyy-MM-dd HH:mm:ss			2017-08-18 20:08:08
 *yyyy年MM月dd日 HH时mm分ss秒	2017年08月18日 20时08分08秒
 *yyyyMMdd						20170818
 *dd/MM/yyyy					18/08/2017
 *yyyy年M月						2017年8月
 *M月d日							8月18日
 *北京时间：HH点mm分	北京时间：	20点08分
 *yyyy年的M月某天晚上，大概H点	2017年的8月某天晚上，大概20点
 *
 *4.min/max
 */
/*
layerDate = {
		init:function(){
			console.log("laydate init()...")
			var ins1 = laydate.render({
				elem: '#layerDate',
//				show: true,
//				trigger: 'click', //采用click弹出
				type: 'date',
				range: '&',
				format: 'yyyy-MM-dd',
				min: -365,
				max: 'new Date()',
				theme: 'molv'
				,ready: function(date){
					console.log("laydate 初始化成功")
				    console.log(date); //得到初始的日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
//				    console.log("初始化：" + date); //得到初始的日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
				}
//				,change: function(value, date, endDate){
//				    ins1.hint(value); //在控件上弹出value值
//			    }
			});
		}
};
*/

layer_date = {
		init: function(){
			var input_style = "height:30px; padding: 6px 12px";
			var start_ = '#start';//开始时间input id
			var end_ = '#end';//结束时间input id
			$(start_).attr("style",input_style);
			$(end_).attr("style",input_style);
			var startDate = $(start_).val();//开始日期
			var endDate = $(end_).val();//结束日期
			startDate_min_default = laydate.now(-36500); //开始时间最小默认值
			startDate_max_default = '2099-06-16';//开始时间最大默认值
			endDate_min_default = laydate.now(-36500);//结束时间最小默认值
			endDate_max_default = '2099-06-16';//结束时间最大默认值
			
			//startDate不为空，endDate为空
			if(isNotNull(startDate)){
				endDate_min_default = startDate;
			}
			//endDate不为空，startDate为空
			if(isNotNull(endDate)){
				startDate_max_default = endDate;
			}
			//startDate不为空，endDate也不为空
			if(isNotNull(endDate)){
				startDate_max_default = endDate;
				endDate_min_default = startDate;
			}
			
			var start = {
					  elem: start_,
					  format: 'YYYY-MM-DD',
					  min: startDate_min_default, //设定最小日期为当前日期
					  max: startDate_max_default, //最大日期
					  istime: false, //显示时间 true:显示，false：不显示
					  istoday: false, //显示今日 true:显示，false：不显示,时间断选择，存在bug,建议不显示false
					  festival: false, //显示节日 true:显示，false：不显示
					  issure: true, //是否显示确认
					  choose: function(datas){
					     end.min = datas; //开始日选好后，重置结束日的最小日期
					     end.start = datas //将结束日的初始值设定为开始日
					  }
					};
			var end = {
					  elem: end_,
					  format: 'YYYY-MM-DD',
					  min: endDate_min_default,
					  max: endDate_max_default,
					  istime: false, //显示时间 true:显示，false：不显示
					  istoday: false, //显示今日 true:显示，false：不显示，存在bug,建议不显示false
					  festival: false, //显示节日 true:显示，false：不显示
					  issure: true, //是否显示确认
					  choose: function(datas){
					    start.max = datas; //结束日选好后，重置开始日的最大日期
					  }
					};
			laydate(start);
			laydate(end);
		}
};


function isNotNull(e){
	if(e != null || e != undefined || e != "") {
		return true;
	} else {
		return false;
	}
}