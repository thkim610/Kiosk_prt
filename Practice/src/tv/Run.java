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
		
		//�پ��� tv ���� ���
		for (Tv tv : tvs) { //for-each���� (Ÿ�� ���� : �ݺ����� ���������ϴ� �ڷᱸ��)
			System.out.println(tv.toString());
		}
		
		//SmartTv �� ����
		System.out.print("������ ���͵帱���.=> ");
		String appName = sc.next();
		//�ٿ�ĳ����
		SmartTv st =(SmartTv) t2;
		st.openApp(appName);
	

	}

}
