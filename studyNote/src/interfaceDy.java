public class interfaceDy{
	public static void main(String args[]){
		/*Some s = new SomeOtherImpl();
		s.doSome();
		Other o = (Other)s;
		o.doOther();*/
		SomeOtherImpl s = new SomeOtherImpl(){
			public  void doSome(){
				System.out.println("do some");
			}
			public void does(){
				System.out.println("does");
			}
		};
		s.doSome();
		//s.does();
	}
	
}