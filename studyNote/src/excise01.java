import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author congyang
 *
 */
public class excise01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				String dtUrl = "";
				String cfgUrl = "";
				String filePath = "";
		// 从终端获取柜员交易号
				//Scanner scan = new Scanner(System.in);
				//System.out.printf("请输入柜员交易号：");
				//String oldRrno = scan.nextLine().trim();
				//String oldRrno = "  abc  ";
				//System.out.printf("%s",oldRrno);
				//System.out.printf("%s",oldRrno);
				String temp = readConfigFile("./getParam.conf");
				//String temp = readConfigFile("d:/java/abc.txt");
				String[] config = temp.split("\\|");
				dtUrl = config[0];
				cfgUrl = config[1];
				filePath = config[2];
				
				System.out.println(filePath);

	}

	public static String readConfigFile(String fileName){
		StringBuffer  buffer = new StringBuffer();
		BufferedReader reader = null;
		try{
			File file = new File(fileName);
			reader = new BufferedReader(new FileReader(file));
			String temString = "";
			while((temString = reader.readLine()) != null){
				buffer.append(temString.trim() + "|");
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(reader != null){
				try{
					reader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		//String temString = null;
		return buffer.toString();
	}

} 
