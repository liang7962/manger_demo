/*常量*/
var CONSTANT = {
        DATA_TABLES : {
            DEFAULT_OPTION : { //DataTables初始化选项
        		serverSide: true,//分页，取数据等等的都放到服务端去
        	    processing: true,//载入数据的时候是否显示“载入中”
        	    pageLength: 10,  //首次加载的数据条数
        	    ordering: false, //排序操作在服务端进行，所以可以关了。
        	    pagingType: "full_numbers",
        	    autoWidth: false,
        	    stateSave: true,//保持翻页状态，和comTable.fnDraw(false);结合使用
        	    searching: false,//禁用datatables搜索
        	    lengthChange:false,//禁用选择每页显示多少条记录的下拉框
//         	    autoWidth: true,//自动宽度,开启后（true）设置的宽度会失效
        	    scrollX:true//允许水平滚动
            },
            COLUMN: {
                CHECKBOX: { //复选框单元格
                    className: "td-checkbox",
                    orderable: false,
                    width: "30px",
                    data: null,
                    render: function (data, type, row, meta) {
                        return '<input type="checkbox" class="iCheck">';
                    }
                }
            },
            RENDER: {   //常用render可以抽取出来，如日期时间、头像等
                ELLIPSIS: function (data, type, row, meta) {
                    data = data||"";
                    return '<span title="' + data + '">' + data + '</span>';
                }
            }
        }
};