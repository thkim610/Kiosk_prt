package exchange;


public class Run {

	public static void main(String[] args) {


		KRW k = new KRW(1500, "원");
		USD u = new USD(100.50, "달러");
		EUR e = new EUR(260.87, "유로");
		JPY j = new JPY(1400, "엔");
		
		//배열에 자식 클래스 추가
		Exchange[] ec = new Exchange[]{k,u,e,j};
		

		//배열 값 하나씩 꺼내오기
		for(Exchange x: ec) {
			System.out.println(x.toString());
		}

	}

}
