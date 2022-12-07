package DI;
//점수를 출력하는 클래스
public class NewRecordView {

		// NewRecordview 는 점수르 받기 위해서 NewRecord  가 필요합니다. (찡긋)
	
	private NewRecord record; //포함관계 (복합연관)
	
	public NewRecordView(int kor, int eng,  int math) {
		record = new NewRecord(kor, eng, math);
	}
	
	public void print() {
		System.out.println(record.total() + " / " + record.avg());
	}
}
