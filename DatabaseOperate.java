package lcm.db.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//以下为抽象出的数据库通用操作方法(CRUD)
public class DatabaseOperate {
	
	//1.执行（通用）查询语句
	public List<Map<String,Object>> executeQuery(String sqlSelect,Object[] params) {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=JdbcUtil.getConnection();
		try {			
			ps=conn.prepareStatement(sqlSelect);			
			//为语句中的占位符赋值
			if(params!=null){//有参数
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);//注意：第1个占位符的序号为1,第二个为2，依次类�?
				}
			}
			rs=ps.executeQuery();//执⾏语句，得到结果集
			ResultSetMetaData md = rs.getMetaData(); //获得结果集元数据
			int columnCount = md.getColumnCount();   //获得列数
			while (rs.next()) {
				//将一条记录包装为Map
				Map<String,Object> rowData = new HashMap<String,Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnLabel(i), rs.getObject(i));
				}
				list.add(rowData);
			}
			//System.out.println("list============="+list);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JdbcUtil.closeAll(rs,ps,conn );
		}
		return list;
	}	
	//ͨ2.执行非查询语句（通用) Duplicate entry 'user2' for key 'uniqueKey'
	public int executeNonQuery(String sql,Object[] params) throws RuntimeException,SQLException {
		//1.获取连接
		Connection conn=JdbcUtil.getConnection();
		//2.得到PreparedStatement语句	
		PreparedStatement ps=null;
		int affectedRow=-1;

		ps = conn.prepareStatement(sql);
		//3.为语句中的占位符赋值
		if(params!=null){//有参数
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);//注意：第1个占位符的序号为1,第二个为2，依次类�?
			}
		}
		//3.执行语句，返回影响的行数ִ
		affectedRow=ps.executeUpdate();

		JdbcUtil.close(ps,conn);
		
		return affectedRow;
	}
	public int executeNonQuery2(String sql,Object[] params) {
		//1.获取连接
		Connection conn=JdbcUtil.getConnection();
		//2.得到PreparedStatement语句	
		PreparedStatement ps=null;
		int affectedRow=-1;
		try {
			ps = conn.prepareStatement(sql);
			//3.为语句中的占位符赋值
			if(params!=null){//有参数
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);//注意：第1个占位符的序号为1,第二个为2，依次类�?
				}
			}
			//3.执行语句，返回影响的行数ִ
			affectedRow=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally{
			//释放语句资源
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					//new RuntimeException("Duplicate entry:"+e.getMessage());
				}
			}
		}
		
		return affectedRow;
	}
	//3.执行（通用）查询语句
	public <T> List<T> getBeanList(String sqlSelect,Object[] params,Class<T> clazz) {
		List<T> list=null;;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection conn=JdbcUtil.getConnection();
		try {			
			ps=conn.prepareStatement(sqlSelect);
			//为语句中的占位符赋值
			if(params!=null){//有参数
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);//注意：第1个占位符的序号为1,第二个为2，以此类推
				}
			}
			rs=ps.executeQuery();//执⾏语句，得到结果集
			if(rs!=null){
				list= ResultSetToBeanList.resultsetToBeanList(rs, clazz);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			JdbcUtil.closeAll(rs,ps,conn);
		}
		return list;
	}
}
