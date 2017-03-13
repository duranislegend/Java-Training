package lcy.ccdn.note;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertiesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(System.getProperty("user.dir"));
		Properties pro = new Properties();
		//pro.setProperty("user", "1");
		//System.out.println(pro.getProperty("user"));
		//Properties prop = System.getProperties();
		//System.out.println(prop.getProperty("java.version"));
		/*try {
			//FileInputStream in = new FileInputStream(args[0]);
			pro.load(new FileInputStream(args[0]));
			System.out.println(pro.getProperty("user"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			pro.loadFromXML(new FileInputStream(args[0]));
			System.out.println(pro.getProperty("lcy.ccdn.note.user"));
			Iterator it = pro.keySet().iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
			//foreach(pro.values());
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("xx", "1");
		map.put("cc","2");
		foreach(map.values());
	}
	static void foreach(Iterable<String> ir){
		for(String s :ir){
			System.out.println(s);
		}
	}

}
