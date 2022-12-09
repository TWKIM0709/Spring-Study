package kr.or.kosa;

public class Test {
	public void test() {
		System.out.println("test 시작");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("test 끝");
	}
}
