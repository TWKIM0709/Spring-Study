package Thread;
import javax.swing.JOptionPane;

/*
문제
main 함수 제외한 Thread 2개 생성
1. 시간(time) 제어하는 Thread
2. 단어 입력을 처리하는 Thread

main 함수 2개 실행

단 단어를 하나라도 입력해서 확인 버튼을 누르면 시간을 멈추게 하세요
hint) 공유자원 (static)

Thread : 상태정보 

join : 다른 스레드의 종료를 기다림 (휴게실에서)

다양한 계산 작업 ... 각 행성별 거리를 구해서  ... 그 합산한 결과 ...
10 개   ... 1개  ... 합산 

main 스레드에게 join 걸어서 .... 기달려 ... WordInputProcess , WordTimeOut 
*/

class WordInputThread extends Thread{
	@Override
	public void run() {  //main 함수와 같은 역할 (start() > stack생성 > 처음 올라가는 함수)
		String dan="2";
		String inputdata = JOptionPane.showInputDialog(dan + "단 값을 입력하세요");
		if(inputdata != null && !inputdata.equals("")) {
			Ex05_WordGame.inputcheck = true;
		}
		System.out.println("입력한 값은 : " + inputdata);
	}
	
}

class WordTimeOut extends Thread{
	@Override
	public void run() {
		for(int i = 10 ; i > 0 ; i--) {
			
			if(Ex05_WordGame.inputcheck) return; //함수 탈출 .... run 종료
			
			System.out.println("남은 시간 : " + i);
			try {
				  	Thread.sleep(1000);//휴게실가서 1초 쉬고 다시 경합(점유) >> runnable 상태
			} catch (Exception e) {
				   System.out.println(e.getMessage());
			}
		}
	}
}



public class Ex05_WordGame {
	static boolean inputcheck =false;
	public static void main(String[] args) {
		WordInputThread word = new WordInputThread();
		WordTimeOut time = new WordTimeOut();
		
		word.start();
		time.start();
		
		//main thread 는 word , time Thread 가 종료한 후에  ..... 끝 .....
		try {
			  word.join(); // main 에게 내가 끝날때까지 기달려 주 ^^
			  time.join(); // main 에게 내가 끝날때까지 기달려 주 ^^
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("MAIN END "); //항상 제일 나중에 출력된다
		//여기 최종 점수를 확인하거나 .... 다양한 값을 확인
		
		//Thread 4개 
		//Thread (목성거리 )  join ,Thread (달거리 )  join , Thread (금서거리 ) join , Thread (모든 거리 총합 )  >> JOIN
	}

}
