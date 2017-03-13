

public class test {
	public static <T> void getInstance( final Class<T> type ) {
		if(type.equals(ActionMapper.class)){
			System.out.println("true");
		}
		//constantConfigMap.get("struts.mapper.class")
	}
	public static void main(String... args){
		getInstance(ActionMapper.class);
		
		/*int a = -1;
		System.out.println(a >> 1);
		IterableString is = new IterableString("justin");
		for(Character c : is){
			System.out.println(c);
		}*/
		
	}

}
