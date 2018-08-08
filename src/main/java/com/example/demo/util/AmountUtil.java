package com.example.demo.util;

import java.math.BigDecimal;

/**
 * @FileName: AmountUtil.java
 * @Description: 金额转换工具类 
 * @author: huangchuang 
 * @version: v1.0
 * @create at: 2017年11月23日 下午1:19:16
 * @reviewer:
 * @review at:
 *
 * Revision history:
 * date             author      version     content
 * ------------------------------------------------------------
 * 2017年11月23日    huangchuang    v1.0        XXXX
 *
 * Copyright © 2016 Shanghai huifutong Network Technology Co.,Ltd All Rights Reserved
 */
public class AmountUtil
{

	/**
	* @Title: changeF2Y
	* @Description: 将分为单位的转换为元并返回金额格式的字符串 （除100）
	* @param amount
	* @return
	* @throws Exception 参数
	* @return String 返回类型
	* @throws
	*/
	public static String changeF2Y(Long amount)
	{
		try{
			int flag = 0;
			String amString = amount.toString();
			if (amString.charAt(0) == '-')
			{
				flag = 1;
				amString = amString.substring(1);
			}
			StringBuffer result = new StringBuffer();
			if (amString.length() == 1)
			{
				result.append("0.0").append(amString);
			} else if (amString.length() == 2)
			{
				result.append("0.").append(amString);
			} else
			{
				String intString = amString.substring(0, amString.length() - 2);
				for (int i = 1; i <= intString.length(); i++)
				{
					if ((i - 1) % 3 == 0 && i != 1)
					{
						result.append(",");
					}
					result.append(intString.substring(intString.length() - i, intString.length() - i + 1));
				}
				result.reverse().append(".").append(amString.substring(amString.length() - 2));
			}
			if (flag == 1)
			{
				return "-" + result.toString();
			} else
			{
				return result.toString();
			}
		}
		catch (Exception e) {
			return "";
		}
	}

	/**
	* @Title: changeF2Y
	* @Description:将分为单位的转换为元 （除100） 
	* @param amount
	* @return
	* @throws Exception 参数
	* @return String 返回类型
	* @throws
	*/
	public static String changeF2Y(String amount) throws Exception
	{
		return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
	}

	/**
	* @Title: changeY2F
	* @Description:将元为单位的转换为分 （乘100） 
	* @param amount
	* @return 参数
	* @return String 返回类型
	* @throws
	*/
	public static String changeY2F(Long amount)
	{
		return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();
	}

	/**
	* @Title: changeY2F
	* @Description: 将元为单位的转换为分 替换小数点，支持以逗号区分的金额 
	* @param amount
	* @return 参数
	* @return String 返回类型
	* @throws
	*/
	public static String changeY2F(String amount)
	{
		String currency = amount.replaceAll("\\$|\\￥|\\,", ""); // 处理包含, ￥
																// 或者$的金额
		int index = currency.indexOf(".");
		int length = currency.length();
		Long amLong = 0l;
		if (index == -1)
		{
			amLong = Long.valueOf(currency + "00");
		} else if (length - index >= 3)
		{
			amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
		} else if (length - index == 2)
		{
			amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
		} else
		{
			amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
		}
		return amLong.toString();
	}

    /**  
     *   
     * 功能描述：去除字符串首部为"0"字符  
        
     * @param str 传入需要转换的字符串  
     * @return 转换后的字符串  
     */  
    public static String removeZero(String str){     
        char  ch;    
        String result = "";  
        if(str != null && str.trim().length()>0 && !str.trim().equalsIgnoreCase("null")){                  
            try{              
                for(int i=0;i<str.length();i++){  
                    ch = str.charAt(i);  
                    if(ch != '0'){                        
                        result = str.substring(i);  
                        break;  
                    }  
                }  
            }catch(Exception e){  
                result = "";  
            }     
        }else{  
            result = "";  
        }  
        return result;               
    }
	
    /**  
     *   
     * 功能描述：为转成分的金额字串前补0  补足12位
       
     * @param str 传入需要转换的金额字符串  
     * @return 转换后的金额字符串  
     */ 
    public static String  addZero(String str){
    	
    	
		int strlen =str.trim().length();
		
		String result ="";
		
		StringBuilder strx = new StringBuilder();	
		
		if (strlen > 12 ){
			
			result = "";
			
		}else{
			
	        if(str != null && strlen > 0 && !str.trim().equalsIgnoreCase("null")){   
	    		
				for(int i =0;i < 12 - strlen;i++){
					
					strx.append("0");
					
				}
				
				result=strx.append(str).toString();
				
	        }else{
	        	
	        	result = ""; 
	        }
		}				
		
		return result;
    }
    
    
    /**  
     *   
     * 功能描述：金额字符串转换：单位分转成单元  
        
     * @param o 传入需要转换的金额字符串
     * @return 转换后的金额字符串  
     */   
    public static String fenToYuan(Object o) {  
        if(o == null)  
            return "0.00";  
        String s = o.toString();  
        int len = -1;     
        StringBuilder sb = new StringBuilder();  
        if (s != null && s.trim().length()>0 && !s.equalsIgnoreCase("null")){  
            s = removeZero(s);  
            if (s != null && s.trim().length()>0 && !s.equalsIgnoreCase("null")){  
                len = s.length();  
                int tmp = s.indexOf("-");  
                if(tmp>=0){  
                    if(len==2){  
                        sb.append("-0.0").append(s.substring(1));  
                    }else if(len==3){  
                        sb.append("-0.").append(s.substring(1));  
                    }else{  
                        sb.append(s.substring(0, len-2)).append(".").append(s.substring(len-2));                  
                    }                         
                }else{  
                    if(len==1){  
                        sb.append("0.0").append(s);  
                    }else if(len==2){  
                        sb.append("0.").append(s);  
                    }else{  
                        sb.append(s.substring(0, len-2)).append(".").append(s.substring(len-2));                  
                    }                     
                }  
            }else{  
                sb.append("0.00");  
            }  
        }else{  
            sb.append("0.00");  
        }  
        return sb.toString();         
    }  
    
    /**  
     *   
     * 功能描述：金额字符串转换：单位元转成单分  
       
     * @param o 传入需要转换的金额字符串
     * @return 转换后的金额字符串  
     */       
    public static String yuanToFen(Object o) {  
        if(o == null)  
            return "0";  
        String s = o.toString();  
        int posIndex = -1;  
        String str = "";  
        StringBuilder sb = new StringBuilder();  
        if (s != null && s.trim().length()>0 && !s.equalsIgnoreCase("null")){  
            posIndex = s.indexOf(".");  
            if(posIndex>0){  
                int len = s.length();  
                if(len == posIndex+1){  
                    str = s.substring(0,posIndex);  
                    if(str == "0"){  
                        str = "";  
                    }  
                    sb.append(str).append("00");  
                }else if(len == posIndex+2){  
                    str = s.substring(0,posIndex);  
                    if(str == "0"){  
                        str = "";  
                    }  
                    sb.append(str).append(s.substring(posIndex+1,posIndex+2)).append("0");  
                }else if(len == posIndex+3){  
                    str = s.substring(0,posIndex);  
                    if(str == "0"){  
                        str = "";  
                    }  
                    sb.append(str).append(s.substring(posIndex+1,posIndex+3));  
                }else{  
                    str = s.substring(0,posIndex);  
                    if(str == "0"){  
                        str = "";  
                    }  
                    sb.append(str).append(s.substring(posIndex+1,posIndex+3));  
                }  
            }else{  
                sb.append(s).append("00");  
            }  
        }else{  
            sb.append("0");  
        }  
        str = removeZero(sb.toString());  
        if(str != null && str.trim().length()>0 && !str.trim().equalsIgnoreCase("null")){  
            return addZero(str);  
        }else{  
            return "0";  
        }  
    }
	
	public static void main(String[] args)
	{
		System.out.println(AmountUtil.changeY2F("1.33"));
		try
		{
			System.out.println(AmountUtil.changeF2Y("000000002501"));
			System.out.println(AmountUtil.fenToYuan("000000002501"));
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
