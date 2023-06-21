package lcm.db.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//JDBC结果集转换
public class ResultSetToBeanList {
    // 根据类名将查询结果resultSet封装成对象
    // 属性名必须严格遵守驼峰命名，该类会将属性驼峰转为数据库_ 去与数据库字段进行匹配
    //目前使用这个！
    public static <T> List<T> resultsetToBeanList(ResultSet rs, Class<T> clazz){
        List<T> list = new ArrayList<T>();
        try {
            //获取此 ResultSet 对象的列的编号、类型和属性。
            ResultSetMetaData rsmd = rs.getMetaData();
            //返回此 ResultSet 对象中的列数。
            int count = rsmd.getColumnCount();
            while(rs.next()){
                //创建此 Class对象所表示的类的一个新实例。
                T obj = clazz.newInstance();
                for(int i=1;i<count+1;i++){
                    //获取指定列的名称。
                    String columnName = rsmd.getColumnLabel(i);
                    System.out.println("columnName="+columnName);
                    //将指定列的列名首字母转换成大写
                    columnName = columnName.substring(0, 1).toUpperCase() + columnName.substring(1);
                    //获取该实例中的get方法
                    Method methodGet = clazz.getMethod("get"+columnName, null);
                    //获取该实例中get方法的返回类型
                    Class type = methodGet.getReturnType();
                    //获取该实例中的set方法
                    Method methodSet = clazz.getMethod("set"+columnName, type);
                    //判断并转换该实例中的set方法中参数的类型
                    if(type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)){
                        //将传给该实例的set方法的参数值转换成int类型,然后执行该实例的set方法将数据放入Po类的字段中
                        Integer temp=null;
                        Object obj2=rs.getObject(columnName);
                        if(obj2!=null){
                            temp=(Integer)obj2;
                        }
                        methodSet.invoke(obj,temp);
                    }

                    if(type.isAssignableFrom(String.class)){
                        methodSet.invoke(obj, rs.getString(columnName));
                    }
                    if(type.isAssignableFrom(String[].class)){//返回值为String[]
                        String strHobby=rs.getString(columnName);
                        System.out.println("返回值为String[]"+strHobby);
                        //转换字符串为数组
                        String strHobbyValid=strHobby.substring(1, strHobby.length()-1);
                        //System.out.println("返回值为String[]"+strHobbyValid);
                        String[] hobbyArray=strHobbyValid.split(",");
                        methodSet.invoke(obj, (Object)hobbyArray);//必须转换为Object，让系统理解为一个整体Object
                        System.out.println("返回值为String[]"+strHobbyValid+"@l="+hobbyArray.length);

                    }
                    if(type.isAssignableFrom(double.class) || type.isAssignableFrom(Double.class)){
                        methodSet.invoke(obj, Double.parseDouble(rs.getString(columnName)));
                    }
                    if(type.isAssignableFrom(boolean.class) || type.isAssignableFrom(Boolean.class)){
                        methodSet.invoke(obj, Boolean.parseBoolean(rs.getString(columnName)));
                    }
                    if(type.isAssignableFrom(Date.class)){//dateTime to Date转换
                        //获取结果集datetime字段的值
                        java.sql.Timestamp ts=rs.getTimestamp(columnName);
                        //转换为java.util.Date对象
                        methodSet.invoke(obj, new Date(ts.getTime()));

                    }
                    //处理日期
                }
                list.add(obj);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> T resultToBean(ResultSet rs, Class<T> t) {
        T result = null; // 封装数据完返回的Bean对象
        try {
            // 无参构造 创建bean对象
            result = t.newInstance();
            // 获得bean的属性数组
            Field[] fields = t.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                // 取出属性
                Field field = fields[i];
                // 获取类属性名
                String fieldName = field.getName();
                // 属性名转数据库字段，驼峰转下划线
                Pattern humpPattern = Pattern.compile("[A-Z]");
                Matcher matcher = humpPattern.matcher(fieldName);
                StringBuffer sb = new StringBuffer();
                while (matcher.find()) {
                    matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
                }
                matcher.appendTail(sb);
                String sqlName = sb.toString();
//                System.out.println(sqlName);

                // 用属性名得出set方法，set+将首字母大写
                String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                // 获取字段类型
                String type = field.getType().toString();
//                // 测试
//                System.out.println(setMethodName);
//                System.out.println(type);

                // 通过调用set方法进行属性注入
                if ("class java.lang.Integer".equals(type)) {
                    // 类型匹配 则获取对应属性的set方法    方法名，类型
                    Method method = t.getMethod(setMethodName, Integer.class);
                    // 执行set方法    被执行的对象，需要注入的数据
                    method.invoke(result, rs.getObject(sqlName));
                } else if ("class java.lang.String".equals(type)) {
                    Method method = t.getMethod(setMethodName, String.class);
                    method.invoke(result, rs.getObject(sqlName));
                } else if ("class java.lang.Double".equals(type)) {
                    Method method = t.getMethod(setMethodName, Double.class);
                    method.invoke(result, rs.getObject(sqlName));
                } else if ("class java.sql.Timestamp".equals(type)) {
                    Method method = t.getMethod(setMethodName, Timestamp.class);
                    method.invoke(result, rs.getObject(sqlName));
                } else {
                    throw new RuntimeException("类型异常");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 返回该对象
        return result;
    }
}
