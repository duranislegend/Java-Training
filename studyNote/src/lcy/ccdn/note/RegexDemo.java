package lcy.ccdn.note;

import java.util.regex.*;

public class RegexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] regex = { ".?foo", ".*foo", "a*+foo" };
		for (String s : regex) {
			Pattern pattern = Pattern.compile(s);
			System.out.printf("%s find ",pattern.pattern());
			Matcher matcher = pattern.matcher("xfooxxxxxfoo");
			while(matcher.find()){
				System.out.printf(" %s ",matcher.group());
			}
			System.out.println(" in xfooxxxxxfoo");
		}
		

	}

}
