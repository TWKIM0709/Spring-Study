package DI_05_Spring;

public class MyBean {
	public MyBean() {
		System.out.println("Default");
	}
	public MyBean(String name) {
		System.out.println("overloading : " + name);
	}
}
