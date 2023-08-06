package kiosk;

import java.util.Scanner;


public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Ű����ũ Ű �Է�
		System.out.println("Ű����ũ Ű�� �Է����ּ���");
		int key = sc.nextInt();

		//Ű����ũ Ű Ȯ��
		if (Kiosk.key == key) {
			//���� ��� ���� ����
			System.out.println("���� ������� �Է����ּ���");
			int inventory = sc.nextInt();
			
			//Kiosk Ŭ���� �ν��Ͻ� ���� 
			Kiosk k = new Kiosk(inventory);
			while (true) {
				//�ֹ� ��� �Է�
				System.out.println("�ֹ� ��� ��ȣ�� �Է����ּ���. (1. ��� 2. ���� 3. ����)");
				int oNum = sc.nextInt();
				
				System.out.println("�޴��� ������ �Է����ּ���");
				String menu = sc.next();
				
				//"����" �Է� ��, �ݺ����� �������� kiosk ����
				if (menu.equals("����")) {
					System.out.println("���α׷��� ���� �մϴ�.");
					break;
				}
				
				int count = sc.nextInt();
				
				//kiosk �ν��Ͻ��� initOrder �޼ҵ带 Order Ÿ������ ��ĳ����
				Order order = k.initOrder(menu, count,oNum); //initOrder()�� OrderŸ��
				if (order == null) {
					continue;
				}
				
				System.out.print("�Ա� �ݾ�: ");
				int deposit = sc.nextInt(); //�Աݱݾ�
				
				//�ֹ� ��Ŀ� ���� �߰� ���� �Է�
				if(oNum == 1) {
					DeliveryOrder od = (DeliveryOrder) order; //DeliveryOrder�� �ٿ�ĳ����
					System.out.println("��� �ּҸ� �Է����ּ���.");
					String locate = sc.next();
					
					od.setLocate(locate); //��� �ּ� ����
					
				}else if(oNum == 2) {
					TakeOutOrder to = (TakeOutOrder)order; // TakeOutOrder�� �ٿ�ĳ����
					System.out.println("���� �ð��� �Է����ּ���.");
					int time = sc.nextInt();
					
					to.setTime(time); //���� �ð� ����
				}else if(oNum == 3) {
					HereOrder ho = (HereOrder)order; // HereOrder�� �ٿ�ĳ����
					System.out.println("�ֹ���ȣ�� �Է����ּ���.");
					int orderNum = sc.nextInt();
					
					ho.setOrderNum(orderNum); //�ֹ���ȣ ����
				}
				
				if (order.runOrder(deposit)) {
					k.subInventory(count); //����� ���� ����
				}
				
			}
			
		} else {
			System.out.println("Ű����ũ Ű�� ���� �ʽ��ϴ�.");
		}
		
		sc.close();
	}

}