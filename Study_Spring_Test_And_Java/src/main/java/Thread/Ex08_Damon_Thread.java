package Thread;
/*

한글작업 >> 글쓰기(메인) >> 3초 간격으로 자동 저장(보조:Daemon)
한글 글쓰기 작업 끝나면 >> 보조 종료(Daemon)

주thread , 보조thread >> 보조thread 주thread 와 생명을 같이 한다
*/

public class Ex08_Damon_Thread  implements Runnable{
	static boolean autosave = false;
	
	public static void main(String[] args) { // main 함수 주 스레드 
		// TODO Auto-generated method stub
		//보조 쓰레드
		Thread daemonthread = new Thread(new Ex08_Damon_Thread());
		//daemonthread 는 main 스레드의 보조 
		daemonthread.setDaemon(true); // 나는  main 함수 쓰레드와 생명을 같이 하겠다 (당신의 종이 되겠습니다)
		daemonthread.start();
		
		
		//main 함수 의 주작업 내용
		for(int i = 0 ; i <= 30 ; i++) {
			try {
				  Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Main Thread 한글 작업 진행 : " + i);
			if(i == 5) { //5가 되는 시점부터
				System.out.println("i : " + i);
				autosave = true;
			}
		}
	}

	public void autoSave() {
		System.out.println("한글 작업이 3초 간격으로 자동 저장 되고 있어요");
	}
	
	
	//보조 쓰레드가 실행하는 함수 (Daemon)
	@Override
	public void run() {
		while(true) {
			try {
				   Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(autosave) {  //static boolean autosave = false;
				autoSave();
			}
		}		
	}

}
