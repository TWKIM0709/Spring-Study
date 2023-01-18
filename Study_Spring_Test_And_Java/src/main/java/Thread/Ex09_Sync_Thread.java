package Thread;
/*
공유자원 .....
동기화 synchronized
Collection (vector , arraylist) 비교
vector 동기화를 보장... >> 동시접근을 막아서 >> 자원보호
arraylist 동기화를 보장하지 않는다 >> 동시접근 허용 >> 자원성능

한강
화장실 (공유자원) : 여러명의 사용자 (쓰레드) 동시에 화장실에 접근
화장실 1개 >> 사용자는 다수

 안전 : 잠금장치 (Lock)
 객체 : Lock
 함수 : Lock (행위) ....
 
 반대
 한강 비비밥 축제
 
 자원을 보호할 필요가 없다 .... 성능 .... Lock 이 필요없다 

*/
class Wroom{
	synchronized void openDoor(String name) {
		System.out.println(name + "님 화장실 입장 ^^");
		for(int i = 0 ; i < 100 ; i++) {
			System.out.println(name + " 사용 :" + i);
			if(i == 10) {
				System.out.println(name + "님 끙 ~~");
			}
		}
		System.out.println("시원하시죠 ^^!");
	}
}

class User extends Thread{
	Wroom wr;
	String who;
	
	User(String name , Wroom w){
		this.who = name;
		this.wr = w;
	}
	@Override
	public void run() {
		wr.openDoor(this.who);
	}
}

public class Ex09_Sync_Thread {

	public static void  main(String[] args) {
		
		//한강둔치
		Wroom w = new Wroom();
		
		//사람들
		User kim = new User("김씨", w);
		User lee = new User("이씨", w);
		User park = new User("박씨", w);
		
		//배가 아파요
		kim.start();
		lee.start();
		park.start();
		
		
		

	}

}

