package Thread;
/*
Thread : 프로세스에서 하나의 최소 실행단위(흐름) >> method >> 실행되는 공간 (stack)
결과 : stack 여러개 생성해서 > thread (여러개) > 동시에 함수를 실행 시켜라

Thread 생성
1. Thread 상속 >> class Test extends Thread  > run 함수 구현
2. Runnable 인터페이스 구현 >> class Test implements Runnable  > run 함수 구현 > Thread th = new Thread(new Test())

*/

class Thread_1 extends Thread {
	@Override
	public void run() {  //함수는  Thread main함수 역할 >> 새로운 stack 처음 올라가서 실행되는 함수
		 for(int i = 0 ; i < 10000 ; i++) {
			 System.out.println("Thread_1 :"+ i + this.getName()); //내부적으로 생성된 이름
		 }
		 System.out.println("Thread_1 run() END()");
	}
}

class Thread_2 implements Runnable{

	@Override
	public void run() {  //함수는  Thread main함수 역할 >> 새로운 stack 처음 올라가서 실행되는 함수
		for(int i = 0 ; i < 10000 ; i++) {
			 System.out.println("Thread_2 :"+ i ); 
		 }
		 System.out.println("Thread_2 run() END()");
		
	}
	
}



public class Ex02_Multi_Thread {

	public static void main(String[] args) {
		
		//1번
		Thread_1 th = new Thread_1();
		th.start(); //POINT > memory에 call stack 을 새로 생성하고 .... Thread가지고 있는 run() 함수를 생성된  stack 올려놓기

		//2번
		//Thread_2 implements Runnable 쓰레드가 아니예요
		/*
		Thread_2 th2 = new Thread_2();
		Thread thread = new Thread(th2);
		thread.start();
		*/
		Thread th2 =  new Thread(new Thread_2());
		th2.start();
		
		
		for(int i = 0 ; i < 10000 ; i++) {
			 System.out.println("main :"+ i ); 
		 }
		 System.out.println("Main END()");
		 

		
	}

}







