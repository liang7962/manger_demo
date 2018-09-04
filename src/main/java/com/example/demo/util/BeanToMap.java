package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanToMap
{

    /** 
* 将对象装换为map 
* @return
*/  
	public static Map<String, String> transBean2Map(Object obj) {
		  
		          if(obj == null){
		              return null;
		          }        
		         Map<String, String> map = new HashMap<String, String>();
		         try {
		             BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		             PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		             for (PropertyDescriptor property : propertyDescriptors) {
		                 String key = property.getName();
		                 // 过滤class属性
		                 if (!key.equals("class") ) {
		                     // 得到property对应的getter方法
		                     Method getter = property.getReadMethod();
		                     String value = (String) getter.invoke(obj);
		                     if(StringUtils.isNotBlank(value)){
		                    	 map.put(key, value);
		                     }
		                 }
		 
		             }
		         } catch (Exception e) {
		             System.out.println("transBean2Map Error " + e);
		         }
		 
		         return map;
		 
		     }


    public static void transMap2Bean(Map<String, Object> map, Object obj) {
 
         try {
             BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
             PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
 
             for (PropertyDescriptor property : propertyDescriptors) {
                 String key = property.getName();
 
                 if (map.containsKey(key)) {
                     Object value = map.get(key);
                     // 得到property对应的setter方法
                     Method setter = property.getWriteMethod();
                     setter.invoke(obj, value);
                 }
 
             }
 
         } catch (Exception e) {
             System.out.println("transMap2Bean Error " + e);
         }
 
         return;
 
     }
    
  //Map转换为JavaBean  
    public static <T> T map2bean(Map<String,Object> map,Class<T> clz) throws Exception{  
        //创建JavaBean对象  
        T obj = clz.newInstance();  
        //获取指定类的BeanInfo对象  
        BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);  
        //获取所有的属性描述器  
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();  
        for(PropertyDescriptor pd:pds){  
            Object value = map.get(pd.getName());  
            Method setter = pd.getWriteMethod();  
            setter.invoke(obj, value);  
        }  
          
        return  obj;  
    }
    
}
