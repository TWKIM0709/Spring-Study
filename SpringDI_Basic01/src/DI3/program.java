package DI3;

public class program {

	public static void main(String[] args) {
		//생성 후..
		NewRecordView view = new NewRecordView();
		
		//놀다가 ...
		
		//NewRecord 객체가 필요하면..
		NewRecord record = new NewRecord(100,50,50);
		view.setRecode(record); //의존 객체의 주소 삽입(setter 함수를 통해서)
		view.print();
	}

}
