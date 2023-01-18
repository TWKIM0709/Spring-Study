package Thread;
import javax.swing.JOptionPane;

//2개의 작업이 동시에(경합) >> CPU 점유 할수 있는 상태 >> 실행

class WordTime extends Thread{
	@Override
	public void run() {
		for(int i = 10 ; i > 0 ; i--) {
			try {
				  System.out.println("남은 시간 : " + i);
				  Thread.sleep(1000);//휴게실가서 1초 쉬고 다시 경합(점유) >> runnable 상태
			} catch (Exception e) {
				   System.out.println(e.getMessage());
			}
		}
	}
}

public class Ex04_Multi_Word_Game {

	public static void main(String[] args) {
		WordTime timer = new WordTime();
		timer.start();
		
		String inputdata = JOptionPane.showInputDialog("값을 입력하세요");
		System.out.println("입력값 : " + inputdata);
	}

}
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