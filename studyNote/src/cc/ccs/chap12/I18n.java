package cc.ccs.chap12;

import java.util.ResourceBundle;

public class I18n {
	public static void main(String args[]){
		ResourceBundle resB = ResourceBundle.getBundle("message");
		System.out.print(resB.getString("cc.ccs.welcome") + "!");
		System.out.println(resB.getString("cc.ccs.name") + "!");
	}

}
