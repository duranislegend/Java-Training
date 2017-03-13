/**
 * 
 */
package DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author congyang
 *
 */
public class MessageDao {
	private DataSource ds;
	public MessageDao(DataSource ds){
		this.ds = ds;
	}
	String insetSql = "insert into t_message(name,email,msg) values (?,?,?)";
	String querySql = "select * from t_message";
	public void add(Message ms){
		try(Connection con = ds.getConnection()){
			PreparedStatement pst = con.prepareStatement(insetSql);
			//pst.setInt(0, 11);
			pst.setString(1, ms.getName());
			pst.setString(2, ms.getEmail());
			pst.setString(3, ms.getMsg());
			int count = pst.executeUpdate();
			System.out.println(count);
			
		}catch(SQLException se){
			throw new RuntimeException(se);
		}
	}
	
	public List<Message> get() {
		List<Message> lists = new ArrayList<>();
		try(Connection con = ds.getConnection();
			//System.out.println(ds.getConnection().toString());
			Statement st = con.createStatement()){
			ResultSet rst = st.executeQuery(querySql);
			//System.out.println(con.);
			while(rst.next()){
				
				String name = rst.getString(2);
				String email = rst.getString(3);
				String msg = rst.getString(4);
				Message ms = new Message(name,email,msg);
				lists.add(ms);
			}
			
			
		}catch(SQLException se){
			System.out.println("数据库连接失败");
			se.printStackTrace();
		}
		return lists;
	}

}
