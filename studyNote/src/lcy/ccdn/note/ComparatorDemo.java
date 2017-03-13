package lcy.ccdn.note;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

class Amount implements Comparable{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Amount.class);

	int id;
	String name;
	double balance;
	Amount(int id,String name,double balance){
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	@Override
	public String toString(){
		return String.format("(%d,%s,%f)", id,name,balance);
	}
	@Override
	public int compareTo(Object o){
		Amount a = (Amount)o;
		return this.id - a.id;
	}
}
class ComparatorImpl implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Amount a = (Amount)o1;
		Amount b = (Amount)o2;
		return -(int)(a.balance - b.balance);
	}
	
}
public class ComparatorDemo {
	/**
	 * Logger for this class
	 */
	public static void main(String...  args){
	final Logger logger = Logger.getLogger(ComparatorDemo.class);
	List<Amount> lists = Arrays.asList(new Amount(1,"a",100),new Amount(3,"c",300),new Amount(2,"b",200));
	Collections.sort(lists);
	System.out.println(lists);
	Collections.sort(lists, new ComparatorImpl());
	System.out.println(lists);
	}

}
