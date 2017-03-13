package cc.ccs.chap71;
//import java.util.Scanner;
import java.util.ArrayList;
abstract class CashCardService extends CashCard{
	//Scanner scanner = new Scanner(System.in);
	ArrayList<CashCard> cards = new ArrayList();
	public void save(CashCard cashCard){
		print("number:");
		cashCard.name = nextString();
		print("balance:");
		cashCard.balance = nextInt();
		print("bonus:");
		cashCard.bonus = nextInt();
		cards.add(cashCard);
		
	}
	public CashCard load(String number){
		CashCard x = new CashCard() {
			public void print(String text) {
				// TODO Auto-generated method stub
			}
		};
		for(CashCard card : cards){
			if(card.name.equals(number)){
				x = card;
			}
		}
		return x;
	}
	public abstract void print(String text);
	public abstract String nextString();
	public abstract int nextInt();
}