/**
 * 
 */
package lcy.ccdn.note;

/**
 * @author congyang
 *
 */
public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String regex = "\\[.*\\]";
		//String regex1 = "\\[.*?\\]";
		String paths = "A[2].B.C[5].x";
			String path[] = paths.split("\\.");
			int pots = path.length;
			for(int i = 0; i < pots; i++){
				boolean flag = path[i].contains("]");
				if(flag){
					System.out.println(path[i].replaceAll(regex, ""));
				}
				else
					System.out.println(path[i]);
			}	
			

	}

}
