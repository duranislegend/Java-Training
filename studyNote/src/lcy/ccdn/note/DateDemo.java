package lcy.ccdn.note;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Date构造函数
		Date date = new Date();
		System.out.println(date);
		Date date1 = new Date(System.currentTimeMillis());
		System.out.println(date1);
		Date date2 = new Date(1000);
		System.out.println(date2);
		//DateFormat静态函数
		DateFormat df  = null;
		System.out.println("getDateInstance");
		df = DateFormat.getDateInstance(DateFormat.LONG,Locale.CANADA);
		System.out.println(df.format(date));
		System.out.println("getTimeInstance");
		df = DateFormat.getTimeInstance(DateFormat.LONG,Locale.ITALY);
		System.out.println(df.format(date));
		System.out.println("getDateTimeInstance");
		df = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,Locale.CHINA);
		System.out.println(df.format(date));
		//DateFormat的操作类SimpleDateFormat
		DateFormat df2 = new SimpleDateFormat("YYYY-MM-dd-MM-w-W",Locale.CHINA);
		System.out.println(df2.format(date));
		System.out.println(-5%7);
		/*System.out.println("请你输入出生年月日");
		Scanner scanner = new Scanner(System.in);
		DateFormat df3 = new SimpleDateFormat("YYYY-MM-dd");
		try {
			Date df4 = df3.parse(scanner.nextLine());
			Date dt = new Date();
			long time = dt.getTime() - df4.getTime();
			Date df5 = new Date(time);
			//System.out.println("已出生多少天："+df5.getYear());
			System.out.println("已出生多少年：" + time/1000/60/60/24/365);
			System.out.println("已出生多少天：" + time/1000/60/60/24);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.getDisplayName(java.util.Calendar.MONTH, java.util.Calendar.LONG, Locale.CHINA));
		
		
		
		
		
		
		
		
		
		
	

	}

}
