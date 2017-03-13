package lcy.ccdn.note;

import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle res = ResourceBundle.getBundle("message");
		System.out.println(res.getString("hello"));

	}

}
