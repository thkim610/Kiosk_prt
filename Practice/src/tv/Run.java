package tv;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		ArrayList<Tv> tvs = new ArrayList<Tv>();
		
		Tv t = new Fhd("FHD", 1500000);
		Tv t1 = new Uhd("UHD", 2500000);
		Tv t2 = new SmartTv("SmartTv", 3500000);
		
		tvs.add(t);
		tvs.add(t1);
		tvs.add(t2);
		
		//다양한 tv 가격 출력
		for (Tv tv : tvs) { //for-each문은 (타입 변수 : 반복문을 돌리고자하는 자료구조)
			System.out.println(tv.toString());
		}
		
		//SmartTv 앱 실행
		System.out.print("무엇을 도와드릴까요.=> ");
		String appName = sc.next();
		//다운캐스팅
		SmartTv st =(SmartTv) t2;
		st.openApp(appName);
	

	}

}
