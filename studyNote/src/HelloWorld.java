import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//import java.io.FileInputStream;
class Student 
//Student cannot be cast to java.lang.Comparable
	implements Comparable
{
	private String number;
	private String name;
	int score;
	Student(String number,String name,int score){
		this.number = number;
		this.name = name;
		this.score = score;
		
	}
	@Override
	public int compareTo(Object o){
		Student other = (Student)o;
		
		return this.score - other.score;
	}
}
class Teacher 
{
	private String number;
	private String name;
	int score;
	Teacher(String number,String name,int score){
		this.number = number;
		this.name = name;
		this.score = score;
		
	}
}
class comparatorImpl implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		Student stu1 = (Student)arg0;
		Student stu2 = (Student)arg1;
		return -stu1.compareTo(stu2);
		//return stu1.compareTo(stu2);
	}
	
}
public class HelloWorld {
	public static void main(String[] args){
		/*Set<Student> students = new TreeSet<Student>(new comparatorImpl());
		students.add(new Student("01","Jordon",91));
		students.add(new Student("03","Chen",90));
		students.add(new Student("02","Michan",92));
		foreach(students);*/
		/*Set<Teacher> teachers = new HashSet<Teacher>();
		teachers.add(new Teacher("01","Jordon",91));
		teachers.add(new Teacher("03","Chen",90));
		teachers.add(new Teacher("02","Michan",92));
		System.out.println(teachers.size());*/
		/*Set<Integer> numbers = new TreeSet<Integer>();
		//Set<Object> numbers = new TreeSet<Object>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(1);
		numbers.add(3);
		for(Integer number : numbers){
			System.out.println(number);
		}*/
		Map<String,String> messages = new HashMap<String,String>();
		messages.put("jordon","hihi");
		messages.put("mate", "hello");
		foreach(messages.keySet());
		
	}
	/*private static void foreach(Iterable<Integer> iterable){
		for(Integer number : iterable){
			System.out.println(number);
		}
	}*/
	private static void foreach(Set<String> values){
		for(String value : values){
			System.out.println(value);
		}
	}
/*	public static String readFile(String name) throws FileNotFoundException
	//Error
	{
		FileInputStream input = new FileInputStream(name);
		return "ss";
	}
	public static void main(String args[])
	{
		//System.out.println("Hello World!");
		try{
			//int number = Integer.parseInt(args[0]);
			//System.out.print(number++);
			//object[] o = {"java","7"};
			//int number = (Integer)o[1];
			//System.out.println(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			System.out.print("error");
		}
	}*/
}
