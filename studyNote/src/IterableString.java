import java.util.Iterator;
public class IterableString implements Iterable<Character>{
	private String str;
	public IterableString(String str){
		this.str = str;
	}
	public Iterator<Character> iterator(){
		return new InnerIterator();
	}
	private class InnerIterator implements Iterator<Character>{
		private int index;
		public boolean hasNext(){
			return index < str.length();
		}
		public Character next(){
			Character c = str.charAt(index);
			index++;
			return c;
		}
	}
	
}