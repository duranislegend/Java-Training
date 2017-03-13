package lcy.ccdn.note;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("one", "1");
		map.put("two", "2");
		foreach(map.entrySet());
		Set s = map.entrySet();
		for(Object o : s){
			Map.Entry entry = (Map.Entry)o;
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			System.out.printf("ket:%s,value:%s\n",key,value);
		}
	}
	static void foreach(Iterable<Map.Entry<String, String>> iterable){
		for(Map.Entry<String, String> e : iterable){
			System.out.printf("(%s,%s)\n",e.getKey(),e.getValue());
			
		}
		Iterator<Map.Entry<String,String>> iterator = iterable.iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> e = iterator.next();
			System.out.printf("(%s,%s)\n",e.getKey(),e.getValue());
			
		}
	}
}
