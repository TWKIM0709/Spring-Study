package Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;

class QuizInfo {
    String question;
    int answer;
    String result;
    
    public QuizInfo(String question, int answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }
    
    public String toString() {
        return "문제:"+this.question+" 쓴답:"+this.answer+" 채점:"+this.result;
    }
}

class TimeOut extends Thread{
	@Override
	public void run() {
		for(int i=10; i > 0 ; i--) {
			
			System.out.println("남은 시간: " + i);
			try {
				 Thread.sleep(1000); //대기실에서 1초간 쉬었다 ....
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		Ex06_GuGuDanGame.inputcheck = true; //시간 종료
		System.out.println("시간종료^^");
		//System.exit(0);
		
	}
}

class WordGame extends Thread{
	int answer;
	@Override
	public void run() {
		
		HashMap<String, Integer> gugudan = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < 5 ; i++) {
			int num1 = (int)(Math.random()*9)+1;
			int num2 = (int)(Math.random()*9)+1;
			gugudan.put(num1+"*"+num2, num1*num2);
		}
		Ex06_GuGuDanGame.totalQuizCount = gugudan.size();
		
		
		Set keys = gugudan.keySet();
		Object[] keylist = keys.toArray();
		//int answer=0;
		answer=0;
		for(int i = 0 ; i < keylist.length ; i++) {
			
			answer = Integer.parseInt(JOptionPane.showInputDialog((String)keylist[i]));
			
			if(Ex06_GuGuDanGame.inputcheck) break; 		   
		    if(gugudan.get(keylist[i])==answer) {
		    	System.out.println("당신은 정답");
		    	Ex06_GuGuDanGame.QuizUserInfo.add(new QuizInfo((String)keylist[i], answer, "O"));
		    }else {
		    	System.out.println("당신은 오답");
		    	Ex06_GuGuDanGame.QuizUserInfo.add(new QuizInfo((String)keylist[i], answer, "X"));
		    }
		}
		//System.exit(0);
	}
}


public class Ex06_GuGuDanGame {
	static boolean inputcheck= false;
	static ArrayList<QuizInfo> QuizUserInfo = new ArrayList<QuizInfo>();
	static int totalQuizCount=0;
	public static void main(String[] args) {

		TimeOut timeout = new TimeOut();
		WordGame wordgame = new WordGame();
		
		timeout.start();
		wordgame.start();
		
		try {
		
			timeout.join();
			//if(wordgame.answer == 0) {
			//	wordgame.interrupt();
			//}
			wordgame.join();
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("총문제수 : " + totalQuizCount + "푼문제수 : " + QuizUserInfo.size() );
	
		//for(int i = 0 ; i < QuizUserInfo.size() ; i++) {
		//	System.out.println(QuizUserInfo.get(i).toString());
		//}
		
	}

}
