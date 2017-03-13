package lcy.ccdn.note;
public abstract class AbstractDemo {
	public void go(){
	int number = (int)(Math.random() * 10);
	int guess;
	do{
		print("please input a number:");
		guess = nextInt();
		if(guess == number){
			break;
		}
	}while(guess != number);
	println("ok");
	}
	public abstract int nextInt();
	public abstract void print(String s);
	public abstract void println(String s);
}
