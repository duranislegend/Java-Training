/**
 * 
 */
package cc.ccs.chap14;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author congyang
 *
 */
class Message {
	private int id ;
	private String name ;
	private String email;
	private String msg;
	public Message(String name,String email,String msg){
		//this.id = id;
		this.name = name;
		this.email = email;
		this.msg = msg;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getMsg(){
		return msg;
	}
	public void setMsg(String msg){
		this.msg = msg;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
class ParamCfg{
	private static String url;
	private static String user;
	private static String password;
	//private static  String fileName;
	/*******java中首先是静态块先执行，静态方法，最后是构造函数
	 * 
	 * @param fileName
	 */
	/*public CrtConn(String fileName){
		CrtConn.fileName = fileName;
	}*/
	private static Properties pro = new Properties();
	static{
		getParam();
	}
	public static void getParam()   {
		//try(InputStream in = new BufferedInputStream(new FileInputStream("config" + File.separator + fileName))){
		try(InputStream in = new BufferedInputStream(new FileInputStream("config" + File.separator + "ds.properties"))){
				
			pro.clear();
			pro.load(in);
			url = getString("dburl","com.mysql.driver");
			user = getString("dbuser","justin");
			password = getString("dbpassword","123456");
		}catch(FileNotFoundException e){
			//System.out.println(in.toString());
			System.out.println(e.getMessage());
		}catch(IOException  i){
			i.getStackTrace();
		}
		
	}
	 static String getString(String key,String defValue){
		if(pro.containsKey(key)){
			return pro.getProperty(key);
		}else
			return defValue;
	}
	public static String getUrl(){
		return url;
	}
	public static String getUser(){
		return user;
	}
	public static String getPassword(){
		return password;
	}
}
class CrtConn{
	private  String url;
	private  String user;
	private  String password;
	private Connection conn = null;
	CrtConn(String url,String user,String password){
		this.url  = url;
		this.user = user;
		this.password = password;
	}
	public Connection getConn() throws SQLException{
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}
class MessageDao{
	List<Message> messages = new ArrayList<>();
	private Connection con;
	private String updateSql = "insert into t_message values ('";
	private String querySql = "select * from t_message";
	public void add(Message m){
		
		try {
			CrtConn crt = new CrtConn(ParamCfg.getUrl(),ParamCfg.getUser(),ParamCfg.getPassword());
			con = crt.getConn();
			Statement st = con.createStatement();
			int updataCount = st.executeUpdate(updateSql + m.getId() + "','" + m.getName() + "','" + m.getEmail() + "','"
					+ m.getMsg() + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Message> get(){
		
		try {
			CrtConn crt = new CrtConn(ParamCfg.getUrl(),ParamCfg.getUser(),ParamCfg.getPassword());
			con = crt.getConn();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(querySql);
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String msg = rs.getString(4);
				Message m = new Message(name,email,msg);
				messages.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;
	}
}
public class ConnectDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in,"UTF8");
		MessageDao dao = new MessageDao();
		
		while(true){
			System.out.println("(1) 显示留言 ，（2） 新增留言 ");
			switch(Integer.parseInt(scanner.nextLine())){
			case 1:
				for(Message message : dao.get()){
					System.out.printf("%d%s%s%s%n",message.getId(),message.getName(),message.getEmail(),message.getMsg());
				}
				break;
			case 2:
				System.out.println("输入姓名");
				String name = scanner.nextLine();
				System.out.println("输入邮箱");
				String email = scanner.nextLine();
				System.out.println("输入信息");
				String msg = scanner.nextLine();
				dao.add(new Message(name,email,msg));
				
			}
		}
			
		}		
}
