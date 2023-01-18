package Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

//Quiz �� ���� ���� (���� , �Է��� �� , ��� )
class QuizInfo2 {
    String question;
    int answer;
    String result;
    
    public QuizInfo2(String question, int answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }
    
    public String toString() {
        return "����:"+this.question+" ����:"+this.answer+" ä��:"+this.result;
    }
}


public class Ex06_GuGuDan {

	public static void main(String[] args) {
		//hint_1 : HashMap ������ ����� 
		HashMap<String, Integer> gugudan = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < 5 ; i++) {
			int num1 = (int)(Math.random()*9)+1;
			int num2 = (int)(Math.random()*9)+1;
			gugudan.put(num1+"*"+num2, num1*num2);
		}
		
		for(Map.Entry m : gugudan.entrySet()) {
			System.out.println(m.getKey() + "/" +m.getValue());
		}
		
		//hint_3
		//ó�� ��� (���� , ����ڰ� �Է��� �� , ����) ����
		//class QuizInfo 
		ArrayList<QuizInfo> QuizUserInfo = new ArrayList<QuizInfo>();
		
		
		//hint_2
		//gugudan  ������  �� ���ϱ� (���� .... �䰪 �ޱ�)
		Set keys = gugudan.keySet();
		Object[] keylist = keys.toArray();
		int answer=0;
		for(int i = 0 ; i < keylist.length ; i++) {
		    answer = Integer.parseInt(JOptionPane.showInputDialog((String)keylist[i]));
		    System.out.println(answer);
		    if(gugudan.get(keylist[i])==answer) {
		    	System.out.println("����� ����");
		    	QuizUserInfo.add(new QuizInfo((String)keylist[i], answer, "O"));
		    }else {
		    	System.out.println("����� ����");
		    	QuizUserInfo.add(new QuizInfo((String)keylist[i], answer, "X"));
		    }
		}
		
		for(int i = 0 ; i < QuizUserInfo.size() ; i++) {
			System.out.println(QuizUserInfo.get(i).toString());
		}
		
		
		

	}

}
