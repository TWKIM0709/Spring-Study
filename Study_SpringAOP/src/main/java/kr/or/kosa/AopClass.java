package kr.or.kosa;

public class AopClass {
	
	@TimeCheck
	public void Test() {
		System.out.println("Test 진입");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test 끝");
	}
}
