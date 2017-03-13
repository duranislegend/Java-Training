/**
 * 
 */
package DataSource;

/**
 * @author congyang
 *
 */
public class Message {
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
