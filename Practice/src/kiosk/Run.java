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
				System.out.println("�޴��� ������ �Է����ּ���");
				String menu = sc.next();
				if (menu.equals("����")) {
					System.out.println("���α׷��� ���� �մϴ�.");
					break;
				}
				
				int count = sc.nextInt();
				
				//kiosk �ν��Ͻ��� initOrder �޼ҵ带 Order Ÿ������ ��ĳ����
				Order order = k.initOrder(menu, count); //initOrder()�� OrderŸ��
				if (order == null) {
					continue;
				}
				
				int deposit = sc.nextInt(); //�Աݱݾ�
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