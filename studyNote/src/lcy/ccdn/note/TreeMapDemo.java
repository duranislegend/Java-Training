package lcy.ccdn.note;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import static java.lang.System.out;
class SimpleComparator implements Comparator{
	@Override
	public int compare(Object a,Object b){
		String stra = (String)a;
		String strb = (String)b;
		return -stra.compareTo(strb);
	}
	
}
class Student implements Comparable{
	private int id;
	private String name;
	private double score;
	Student(int id,String name,double score){
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public int getId(){
		return id;
	}
	@Override
	public int compareTo(Object a){
		Student sa = (Student)a;
		
		return this.getId() - sa.getId();
	}
	@Override
	public String toString(){
		return String.format("(%d,%s,%f)", id,name,score);
	}
	
}
public class TreeMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> treeMap = new TreeMap<>(new SimpleComparator()); 
		treeMap.put("Monica", "six");
		treeMap.put("Duran", "one");
		treeMap.put("Xixi", "eigth");
		out.println(treeMap);
		Map<Student,String> studentMap = new TreeMap<>();
		studentMap.put(new Student(1,"xx",3.14), "a");
		studentMap.put(new Student(3,"bb",2.18), "value");
		studentMap.put(new Student(2, null, 0), "");
		out.println(studentMap);
		
	}

}
