package cc.ccs.chap6;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ArrayList {
	
	private Object[] list;
	private int next;
	public ArrayList(int capacity){
		list = new Object[capacity];
	}
	public ArrayList(){
		list = new Object[16];
	}
	public void add(Object o){
		if(next == list.length){
			list = Arrays.copyOf(list, list.length * 2);
		}
		list[next++] = o;
	}
	public Object get(int index){
		return list[index];
	}
	public int size(){
		return next;
	}
	
}
