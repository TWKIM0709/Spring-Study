package Thread;
// 여러개의 Thread  있을때 
//기본적으로 우선순위 : 5 기본값 (공정한 경쟁) 점유율(cpu)

//Min(1)  ~ Max (5)

class pth extends Thread{
	@Override
	public void run() {
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("---------------------");
		}
	}
}

class pth2 extends Thread{
	@Override
	public void run() {
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||");
		}
	}
}

class pth3 extends Thread{
	@Override
	public void run() {
		for(int i = 0 ; i < 1000 ; i++) {
			System.out.println("***************************");
		}
	}
}
public class Ex07_Priority {

	public static void main(String[] args) {
		pth pth = new pth();
		pth2 pth2 = new pth2();
		pth3 pth3 = new pth3();
		
		pth.setPriority(10);
		pth2.setPriority(1);
		pth3.setPriority(1);
		
		System.out.println(pth.getPriority());
		System.out.println(pth2.getPriority());
		System.out.println(pth3.getPriority());

		pth.start();  //----  10  cpu 점유 확률은 높인것 먼저 끝나야 ....
		
		pth2.start(); //||||||||
		
		pth3.start();  //******
	}

}





