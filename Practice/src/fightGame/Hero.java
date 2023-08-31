package fightGame;

public class Hero {

	private int hp = 30;
 	private String name;
 	
 	
	
 	public Hero(String name) {
		this.name = name;
	}

	//한번 펀치를 때리면 10씩 체력이 낮아짐
	void punch (Hero enemy) {
		enemy.hp -= 10;
		System.out.println("["+name+"]의 펀치!");
		System.out.println(enemy.name+"의 남은 체력은 "+enemy.hp+"/30 입니다.");
		
	}
	
	//배틀 
	public static void battle(Hero a, Hero b) {
		
		Hero attack = a;
		Hero deffender = b;
		
		//두 영웅 모두 체력이 남아있다면 계속 싸움 실행
		while(!(attack.hp<=0||deffender.hp<=0)) {
			//2분의 1 확률로 공수 결정
			attack = a;
			deffender = b;
			if(Math.random()<0.5) {
				attack = b;
				deffender = a;
			}
			//공격
			attack.punch(deffender);
		}
	}
}
