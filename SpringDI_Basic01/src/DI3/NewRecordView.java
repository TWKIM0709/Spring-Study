package DI3;

import java.util.Scanner;

//점수를 출력하는 클래스
public class NewRecordView implements RecordView{

		// NewRecordview 는 점수를 받기 위해서 NewRecord  가 필요합니다. (찡긋)
	
	private NewRecord record; //포함관계 (복합연관)
	
	/*
		1. 생성자를 통해서 필요한 객체를 생성 or 주입 >> DI >> 복합, 집합
		2. 함수(setter)를 통해서 필요한 객체를 주입 >> DI >> 집합연관 >> 필요에 따라(강제성이 떨어짐)
	*/
	//setter 함수를 통해 필요한 객체의 주소를 받기
	// 언젠가 주소가 필요하겠지... (선택 가능)
//	public void setRecode(NewRecord record) {
	public void setRecode(Record record) {
		this.record = (NewRecord)record;
	}
	@Override
	public void print() {
		System.out.println(record.total() + " / " + record.avg());
	}
	@Override
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("kor >>");
		record.setKor(scan.nextInt());
		System.out.print("eng >>");
		record.setEng(scan.nextInt());
		System.out.print("math >>");
		record.setMath(scan.nextInt());
	}
}
