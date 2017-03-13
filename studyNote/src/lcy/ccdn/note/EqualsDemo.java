package lcy.ccdn.note;

/*  实际上equals()方法是Object类定义的方法，其程序代码为
  public boolean equals(Object o){
 		return  this == o;
  }
  如果没有重新定义equals(),使用equals()时效果类似于 == ，所以
  要比较实质相等性，必须重定义equals()*/
/*  举例：如果两只猫名称和生日相同就认为是实质性相同。
  public boolean equals(Object o){
	  if(this == o){
		  //如果比较的两者都指向同一个，认为两者实质性相同
		  return true;
	  }
	  if(!(o instanceof Cat)){
		  //如果比较东西都不是猫，认为两者实质性不同
		  return false;
	  }
	  Cat cat = (Cat)o;
	  if(!getName().equals(cat.getName())){
		  //如果两者名字不同，认为两者实质性不同
		  return false;
	  }
	  if(!getBirthDay().equals(cat.getName())){
		  //如果两者生日不同，认为两者实质性不同
		  return false;
	  }
  }*/
public class EqualsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
