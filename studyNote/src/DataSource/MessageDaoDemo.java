/**
 * 
 */
package DataSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author congyang
 *
 */
public class MessageDaoDemo {
	public static void main(String... agrs) throws FileNotFoundException, IOException, SQLException{
		SimpleConncetionPoolDataSource simDataSource = new SimpleConncetionPoolDataSource("config/DataSourceJdbc.properties");
		MessageDao mesDao = new MessageDao(simDataSource);
		Scanner scanner = new Scanner(System.in,"big5");
		while(true){
			System.out.println("1.add 2.query");
			switch(Integer.parseInt(scanner.nextLine())){
			case 1:
				System.out.println("input name:");
				String name = scanner.nextLine();
				System.out.println("input email");
				String email = scanner.nextLine();
				System.out.println("input msg");
				String msg = scanner.nextLine();
				Message ms = new Message(name,email,msg);
				mesDao.add(ms);
				break;
			case 2:
				for(Message m: mesDao.get()){
					System.out.printf("(%s,%s,%s)%n",m.getName(),m.getEmail(),m.getMsg());
				}
				break;
			}
		}
	}

}
