package com.example.demo.util.excel;

import com.example.demo.util.LoggerUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: ExcelUtil.java
 * @Description: 
 * 
 * ExcelUtil工具类实现功能: 
 * 导出时传入list<T>,即可实现导出为一个excel,其中每个对象Ｔ为Excel中的一条记录. 
 * 导入时读取excel,得到的结果是一个list<T>.T是自己定义的对象. 
 * 需要导出的实体对象只需简单配置注解就能实现灵活导出,通过注解您可以方便实现下面功能: 
 * 1.实体属性配置了注解就能导出到excel中,每个属性都对应一列. 
 * 2.列名称可以通过注解配置. 
 * 3.导出到哪一列可以通过注解配置. 
 * 4.鼠标移动到该列时提示信息可以通过注解配置. 
 * 5.用注解设置只能下拉选择不能随意填写功能. 
 * 6.用注解设置是否只导出标题而不导出内容,这在导出内容作为模板以供用户填写时比较实用. 
 * 
 * @author: huangchuang
 * @version: v1.0
 * @create at: 2017年3月27日 下午6:03:56
 * @reviewer:
 * @review at:
 */
public class ExcelUtil<T> {
	
	private final static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	
	Class<T> clazz;  
	  
    public ExcelUtil(Class<T> clazz) {  
        this.clazz = clazz;  
    }  
  
    public List<T> importExcel(String sheetName, InputStream input) {  
        int maxCol = 0;  
        List<T> list = new ArrayList<T>();  
        try {  
            Workbook workbook = WorkbookFactory.create(input);
            Sheet sheet = workbook.getSheet(sheetName);
            if (!sheetName.trim().equals("")) {  
                sheet = workbook.getSheet(sheetName);// 如果指定sheet名,则取指定sheet中的内容.  
            }  
            if (sheet == null) {  
                sheet = workbook.getSheetAt(0); // 如果传入的sheet名不存在则默认指向第1个sheet.  
            }  
            int rows = sheet.getPhysicalNumberOfRows();  
  
            if (rows > 0) {// 有数据时才处理  
                List<Field> allFields = getMappedFiled(clazz, null);  
  
                Map<Integer, Field> fieldsMap = new HashMap<Integer, Field>();// 定义一个map用于存放列的序号和field.  
                for (Field field : allFields) {  
                    // 将有注解的field存放到map中.  
                    if (field.isAnnotationPresent(ExcelVOAttribute.class)) {  
                        ExcelVOAttribute attr = field.getAnnotation(ExcelVOAttribute.class);  
                        int col = getExcelCol(attr.column());// 获得列号  
                        maxCol = Math.max(col, maxCol);  
                        // System.out.println(col + "====" + field.getName());  
                        field.setAccessible(true);// 设置类的私有字段属性可访问.  
                        fieldsMap.put(col, field);  
                    }  
                }  
                for (int i = 1; i < rows; i++) {// 从第2行开始取数据,默认第一行是表头.  
                    Row row = sheet.getRow(i);
                    if(row == null) continue;
                    // int cellNum = row.getPhysicalNumberOfCells();  
                    // int cellNum = row.getLastCellNum();  
                    int cellNum = maxCol;  
                    T entity = null;  
                    for (int j = 0; j <= cellNum; j++) {  
                        Cell cell = row.getCell(j);
                        if (cell == null) {  
                            continue;  
                        }  
                        int cellType = cell.getCellType();  
                        String c = "";  
                        if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                            c = String.valueOf(cell.getNumericCellValue());  
                        } else if (cellType == HSSFCell.CELL_TYPE_BOOLEAN) {
                            c = String.valueOf(cell.getBooleanCellValue());  
                        } else {  
                            c = cell.getStringCellValue();  
                        }  
                        if (c == null || c.trim().equals("")) {  
                            continue;  
                        }
                        c = c.trim();
                        entity = (entity == null ? clazz.newInstance() : entity);// 如果不存在实例则新建.  
                        // System.out.println(cells[j].getContents());  
                        Field field = fieldsMap.get(j);// 从map中得到对应列的field.  
                        if (field==null) {  
                            continue;  
                        }  
                        // 取得类型,并根据对象类型设置值.  
                        Class<?> fieldType = field.getType();  
                        if (String.class == fieldType) {  
                            //field.set(entity, String.valueOf(c));  
                            this.setFieldValue(entity, field, String.valueOf(c));
                        } else if ((Integer.TYPE == fieldType)  
                                || (Integer.class == fieldType)) {  
                            //field.set(entity, Integer.parseInt(c));  
                            this.setFieldValue(entity, field, Integer.parseInt(c));
                        } else if ((Long.TYPE == fieldType)  
                                || (Long.class == fieldType)) {  
                            //field.set(entity, Long.valueOf(c));  
                            this.setFieldValue(entity, field, Long.valueOf(c));
                        } else if ((Float.TYPE == fieldType)  
                                || (Float.class == fieldType)) {  
                            //field.set(entity, Float.valueOf(c));  
                            this.setFieldValue(entity, field, Float.valueOf(c));
                        } else if ((Short.TYPE == fieldType)  
                                || (Short.class == fieldType)) {  
                            //field.set(entity, Short.valueOf(c));  
                            this.setFieldValue(entity, field, Short.valueOf(c));
                        } else if ((Double.TYPE == fieldType)  
                                || (Double.class == fieldType)) {  
                            //field.set(entity, Double.valueOf(c));  
                            this.setFieldValue(entity, field, Double.valueOf(c));
                        } else if (Character.TYPE == fieldType) {  
                            if ((c != null) && (c.length() > 0)) {  
                                //field.set(entity, Character.valueOf(c.charAt(0)));  
                                this.setFieldValue(entity, field, Character.valueOf(c.charAt(0)));
                            }  
                        }  
  
                    }  
                    if (entity != null) {  
                        list.add(entity);  
                    }  
                }  
            }  
  
        } catch (Exception e) {  
            logger.error("ERROR::", e);
        }
        return list;  
    } 
    
    public void exportExcel(List<T> lists[], String sheetNames[], String fileName,  HttpServletResponse response) throws Exception{
        try {
            LoggerUtils.info(getClass(),"<<<<<111>>>>>");
            response.setContentType("application/vnd.ms-excel; charset=utf-8");
            response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1")+".xls");
            this.exportExcel(lists, sheetNames, response.getOutputStream());
            LoggerUtils.info(getClass(),"<<<<<222>>>>>");
        }
        catch (Exception e) {
            LoggerUtils.error(getClass(), "exportExcel error", e);
        }

    }
    
    public void exportExcel(List<T> list, String sheetName, String fileName, HttpServletResponse response) throws Exception{
    	response.setContentType("application/vnd.ms-excel; charset=utf-8");   
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1")+".xls");
        this.exportExcel(list, sheetName, response.getOutputStream());
    }
  
    /** 
     * 对list数据源将其里面的数据导入到excel表单 
     *  
     * @param sheetName 工作表的名称 
     * @param output java输出流 
     */  
    public boolean exportExcel(List<T> lists[], String sheetNames[],  
            OutputStream output) throws IOException {
        if (lists.length != sheetNames.length) {  
            System.out.println("数组长度不一致");  
            return false;  
        }  
  
        HSSFWorkbook workbook = new HSSFWorkbook();// 产生工作薄对象
  
        for (int ii = 0; ii < lists.length; ii++) {  
            List<T> list = lists[ii];  
            String sheetName = sheetNames[ii];  
            
            Class<? extends Object> ob = list.get(0).getClass(); 
            List<Field> fields = getMappedFiled(ob, null);  
//            List<Field> fields = getMappedFiled(clazz, null);  
  
            HSSFSheet sheet = workbook.createSheet();// 产生工作表对象
  
            workbook.setSheetName(ii, sheetName);  
  
            HSSFRow row;
            HSSFCell cell;// 产生单元格
//            HSSFCellStyle style = workbook.createCellStyle();  
//            style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
//            style.setFillBackgroundColor(HSSFColor.GREY_40_PERCENT.index);
            
            /* *********普通列样式********* */  
            HSSFFont font = workbook.createFont();
            HSSFCellStyle style = workbook.createCellStyle();
            font.setFontName("Arail narrow"); // 字体  
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体宽度
            /* *********标红列样式********* */  
            HSSFFont newFont = workbook.createFont();
            HSSFCellStyle newCellStyle = workbook.createCellStyle();
            newFont.setFontName("Arail narrow"); // 字体  
            newFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体宽度
            
            row = sheet.createRow(0);// 产生一行  
            // 写入各个字段的列头名称  
            for (int i = 0; i < fields.size(); i++) {  
                Field field = fields.get(i);  
                ExcelVOAttribute attr = field.getAnnotation(ExcelVOAttribute.class);  
                int col = getExcelCol(attr.column());// 获得列号  
                cell = row.createCell(col);// 创建列 
                
                //字体颜色
                if (attr.isMark()) {  
                    newFont.setColor(HSSFFont.COLOR_RED); // 红色
                    newCellStyle.setFont(newFont);  
                    cell.setCellStyle(newCellStyle);  
                } else {  
                    font.setColor(HSSFFont.COLOR_NORMAL); // 黑色
                    style.setFont(font);  
                    cell.setCellStyle(style);  
                } 
                //设置列宽
                sheet.setColumnWidth(i, (int) ((attr.name().getBytes().length <= 4 ? 6 : attr.name().getBytes().length) * 1.5 * 256)); 
                // 设置列中写入内容为String类型  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                // 写入列名  
                cell.setCellValue(attr.name());
  
                // 如果设置了提示信息则鼠标放上去提示.  
                if (!attr.prompt().trim().equals("")) {  
                    setHSSFPrompt(sheet, "", attr.prompt(), 1, 100, col, col);// 这里默认设了2-101列提示.  
                }  
                // 如果设置了combo属性则本列只能选择不能输入  
                if (attr.combo().length > 0) {  
                    setHSSFValidation(sheet, attr.combo(), 1, 100, col, col);// 这里默认设了2-101列只能选择不能输入.  
                }
//                cell.setCellStyle(style);  
            }  
  
            int startNo = 0;  
            int endNo = list.size();  
            // 写入各条记录,每条记录对应excel表中的一行  
            for (int i = startNo; i < endNo; i++) {  
                row = sheet.createRow(i + 1 - startNo);  
                T vo = (T) list.get(i); // 得到导出对象.  
//                if (vo != null){
                	for (int j = 0; j < fields.size(); j++) {  
                		Field field = fields.get(j);// 获得field.  
                		field.setAccessible(true);// 设置实体类私有属性可访问  
                		ExcelVOAttribute attr = field.getAnnotation(ExcelVOAttribute.class);  
                		try {  
                			// 根据ExcelVOAttribute中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.  
                			if (attr.isExport()) {  
                				cell = row.createCell(getExcelCol(attr.column()));// 创建cell 
                				if (attr.isMark()) {  
                					newFont.setColor(HSSFFont.COLOR_RED); // 字体颜色
                					newCellStyle.setFont(newFont);  
                					cell.setCellStyle(newCellStyle);  
                				} 
//                            else {  
//                                font.setColor(HSSFFont.COLOR_NORMAL); // 字体颜色  
//                                cellStyle.setFont(font);  
//                                cell.setCellStyle(cellStyle);  
//                            }  
                				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                				Object value = this.getFieldValue(vo, field);
                				cell.setCellValue(value == null ? "" : String.valueOf(value));// 如果数据存在就填入,不存在填入空格.  
                			}  
                		} catch (Exception e) {  
                			logger.error("ERROR::", e);
                		} 
                	}  
//                }
            }
            
            /* *************创建合计列*************** */  
//            HSSFRow lastRow = sheet.createRow((short) (sheet.getLastRowNum() + 1));  
//            for (int i = 0; i < fields.size(); i++) {  
//                Field field = fields.get(i);  
//                ExcelVOAttribute attr = field.getAnnotation(ExcelVOAttribute.class);  
//                if (attr.isSum()) {  
//                    int col = i;  
//                    // 根据指定的顺序获得列号  
//                    if (StringUtils.isNotBlank(attr.column())) {  
//                        col = getExcelCol(attr.column());  
//                    }  
//                    BigDecimal totalNumber = BigDecimal.ZERO;  
//                    for (int j = 1, len = (sheet.getLastRowNum() - 1); j < len; j++) {  
//                        HSSFRow hssfRow = sheet.getRow(j);  
//                        if (hssfRow != null) {  
//                            HSSFCell hssfCell = hssfRow.getCell(col);  
//                            if (hssfCell != null && hssfCell.getCellType() == HSSFCell.CELL_TYPE_STRING && ValidateUtil.isFloat(hssfCell.getStringCellValue())) {  
//                                totalNumber = BigDecimalUtils.getValue(totalNumber, BigDecimal.valueOf(Double.valueOf(hssfCell.getStringCellValue())), CalculateType.Add);  
//                            }  
//                        }  
//                    }  
//                    HSSFCell sumCell = lastRow.createCell(col);  
//                    sumCell.setCellValue(new HSSFRichTextString("合计：" + totalNumber));  
//                }  
//            }
        }  
  
        try {  
            output.flush();  
            workbook.write(output);  
            output.close();  
            return true;  
        } catch (Exception e) {  
        	logger.error("ERROR::", e);
            return false;  
        }  
        finally {
            if(output!=null){
            output.close();
            }
        }
    }  
    
    private Object getFieldValue(T vo, Field field) throws Exception{
    	String getMethodName = "get"+ StringUtils.substring(field.getName(), 0, 1).toUpperCase()+StringUtils.substring(field.getName(), 1, field.getName().length());
    	Method method = vo.getClass().getMethod(getMethodName, new Class<?>[]{});
        return method.invoke(vo, new Object[]{});
    }
    
    private void setFieldValue(T vo, Field field, Object value) throws Exception{
    	String getMethodName = "set"+ StringUtils.substring(field.getName(), 0, 1).toUpperCase()+StringUtils.substring(field.getName(), 1, field.getName().length());
    	Method method = vo.getClass().getMethod(getMethodName, new Class<?>[]{(Class<?>) field.getGenericType()});
        method.invoke(vo, new Object[]{value});
    }
  
    /** 
     * 对list数据源将其里面的数据导入到excel表单 
     *  
     * @param sheetName 工作表的名称 
     * @param sheetSize 每个sheet中数据的行数,此数值必须小于65536 
     * @param output java输出流 
     */  
    @SuppressWarnings("unchecked")
	public boolean exportExcel(List<T> list, String sheetName, OutputStream output) throws IOException {
		List<T>[] lists = new ArrayList[1];  
        lists[0] = list;  
  
        String[] sheetNames = new String[1];  
        sheetNames[0] = sheetName;  
  
        return exportExcel(lists, sheetNames, output);  
    }  
  
    /** 
     * 将EXCEL中A,B,C,D,E列映射成0,1,2,3 
     *  
     * @param col 
     */  
    public static int getExcelCol(String col) {  
        col = col.toUpperCase();  
        // 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。  
        int count = -1;  
        char[] cs = col.toCharArray();  
        for (int i = 0; i < cs.length; i++) {  
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);  
        }  
        return count;  
    }  
  
    /** 
     * 设置单元格上提示 
     *  
     * @param sheet 要设置的sheet. 
     * @param promptTitle 标题 
     * @param promptContent 内容 
     * @param firstRow 开始行 
     * @param endRow 结束行 
     * @param firstCol 开始列 
     * @param endCol 结束列 
     * @return 设置好的sheet. 
     */  
    public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle, String promptContent, int firstRow, int endRow, int firstCol, int endCol) {
        // 构造constraint对象  
        DVConstraint constraint = DVConstraint.createCustomFormulaConstraint("DD1");
        // 四个参数分别是：起始行、终止行、起始列、终止列  
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // 数据有效性对象  
        HSSFDataValidation data_validation_view = new HSSFDataValidation(regions, constraint);
        data_validation_view.createPromptBox(promptTitle, promptContent);  
        sheet.addValidationData(data_validation_view);  
        return sheet;  
    }  
  
    /** 
     * 设置某些列的值只能输入预制的数据,显示下拉框. 
     *  
     * @param sheet 要设置的sheet. 
     * @param textlist 下拉框显示的内容 
     * @param firstRow 开始行 
     * @param endRow 结束行 
     * @param firstCol 开始列 
     * @param endCol 结束列 
     * @return 设置好的sheet. 
     */  
    public static HSSFSheet setHSSFValidation(HSSFSheet sheet, String[] textlist, int firstRow, int endRow, int firstCol, int endCol) {
        // 加载下拉列表内容  
        DVConstraint constraint = DVConstraint.createExplicitListConstraint(textlist);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列  
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // 数据有效性对象  
        HSSFDataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
        sheet.addValidationData(data_validation_list);
        return sheet;  
    }  
  
    /** 
     * 得到实体类所有通过注解映射了数据表的字段 
     *  
     * @param map 
     * @return 
     */  
    @SuppressWarnings("rawtypes")
	private List<Field> getMappedFiled(Class clazz, List<Field> fields) {  
        if (fields == null) {  
            fields = new ArrayList<Field>();  
        }  
  
        Field[] allFields = clazz.getDeclaredFields();// 得到所有定义字段  
        // 得到所有field并存放到一个list中.  
        for (Field field : allFields) {  
            if (field.isAnnotationPresent(ExcelVOAttribute.class)) {  
                fields.add(field);  
            }  
        }  
        if (clazz.getSuperclass() != null && !clazz.getSuperclass().equals(Object.class)) {  
            getMappedFiled(clazz.getSuperclass(), fields);  
        }  
  
        return fields;  
    }

}