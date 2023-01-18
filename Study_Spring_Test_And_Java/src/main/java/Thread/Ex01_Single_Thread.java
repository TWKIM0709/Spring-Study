package Thread;
/*
프로그램 >> 실행 >> 프로세스 >> 최소 하나의 쓰레드 (하나의 Stack)
>> JVM 하나의 main Thread (stack) 생성

지금까지 >> 싱글프로세스 >  싱글쓰레드  > main 함수 실행

>>하나의 stack만을 사용 (함수가 10개 있더랃 순차적으로 한번에 1개의 함수 실행)  
*/
public class Ex01_Single_Thread {

	public static void main(String[] args) {
		System.out.println("나 main 일꾼이야");
		
		worker();
		worker2();
		
		System.out.println("main 일꾼 종료");

	}
	static void worker() {
		System.out.println("나 1번 일꾼이야");
	}
	static void worker2() {
		System.out.println("나 2번 일꾼이야");
	}
}
