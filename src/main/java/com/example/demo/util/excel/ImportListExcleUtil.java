package com.example.demo.util.excel;

import com.example.demo.util.LoggerUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportListExcleUtil {

    // 总行数
   private int totalRows = 0;
   // 总条数
   private int totalCells = 0;
   // 错误信息接收器
   private String errorMsg;

     // 构造方法
    public ImportListExcleUtil() {
    }

     // 获取总行数
     public int getTotalRows() {
        return totalRows;
    }

     // 获取总列数
     public int getTotalCells() {
        return totalCells;
    }

     // 获取错误信息
     public String getErrorInfo() {
        return errorMsg;
    }

    /**
      * 读EXCEL文件，获取信息集合
      *
      * @param
      * @return
    */
   public Map<String, List>  getExcelInfo(MultipartFile mFile) {

      String fileName = mFile.getOriginalFilename();// 获取文件名
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                    return null;
                }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                    isExcel2003 = false;
                }
            return createExcel(mFile.getInputStream(), isExcel2003);
        } catch (Exception e) {
            e.printStackTrace();
        }
           return null;
    }

    /**
         * 验证EXCEL文件
         *
         * @param filePath
         * @return
         */
     public boolean validateExcel(String filePath) {
          if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
                  errorMsg = "文件名不是excel格式";
                  return false;
              }
          return true;
      }

    // @描述：是否是2003的excel，返回true是2003
      public static boolean isExcel2003(String filePath) {
              return filePath.matches("^.+\\.(?i)(xls)$");
          }

      // @描述：是否是2007的excel，返回true是2007
      public static boolean isExcel2007(String filePath) {
          return filePath.matches("^.+\\.(?i)(xlsx)$");
      }

    /* 读取Excel里面客户的信息
     *
     * @param wb
     * @return
     */
    private Map<String, List>  readExcelValue(Workbook wb ) {
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if ( this.totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        Map<String, List> map = new HashMap<String, List>();

        // 循环Excel行数
        for (int r = 1; r <  this.totalRows; r++) {
            LoggerUtils.info(getClass(),"r>>>>>>>>>"+r);
            List list=new ArrayList();

            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {

                    if (c == 0) {
                        // 如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String payMethod = String.valueOf(cell.getNumericCellValue());//请求方法
                            list.add(payMethod.substring(0, payMethod.length() - 2 > 0 ? payMethod.length() - 2 : 1));
                        } else {
                            list.add(cell.getStringCellValue());
                        }
                    } else if (c == 1) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String merchantNo = String.valueOf(cell.getNumericCellValue());
                            list.add(merchantNo.substring(0, merchantNo.length() - 2 > 0 ? merchantNo.length() - 2 : 1));// 商户号
                        } else {
                            list.add(cell.getStringCellValue());// 商户号
                        }
                    } else if (c == 2) {
                        if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                            String terminalNo = String.valueOf(cell.getNumericCellValue());
                            list.add(terminalNo.substring(0, terminalNo.length() - 2 > 0 ? terminalNo.length() - 2 : 1));// 终端号
                        } else {
                            list.add(cell.getStringCellValue());// 终端号
                        }
                    }
                }
            }
            // 添加到list
            map.put(String.valueOf(r),list) ;
        }
        return map;
    }



    /**
         * 根据excel里面的内容读取客户信息
         *
         * @param is      输入流
         * @param isExcel2003   excel是2003还是2007版本
         * @return
         * @throws IOException
         */
       public  Map<String, List>  createExcel(InputStream is, boolean isExcel2003) {
         try {
                 Workbook wb = null;
                 if (isExcel2003) {// 当excel是2003时,创建excel2003
                         wb = new HSSFWorkbook(is);
                     } else {// 当excel是2007时,创建excel2007
                         wb = new XSSFWorkbook(is);
                     }
                 return readExcelValue(wb);// 读取Excel里面客户的信息
             } catch (IOException e) {
                 e.printStackTrace();
             }
         return null;
       }

}
