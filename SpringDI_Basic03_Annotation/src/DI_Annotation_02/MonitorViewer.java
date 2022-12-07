package DI_Annotation_02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}
	/*
	 	어노테이션..
		setter 를 통해서 Recorder 타입의 객체 주소 주입
		
		컨테이너 안에 Recorder 타입의 객체가 존재하면 자동 주입 발생(By type)
	*/
//	@Autowired(required = true) default >> 무조건 injection 하겠다.
//	@Autowired(required = false) 컨테이너 안에 원하는 타입 객체가 없어도 예외 안터지고 null값
	@Autowired
	@Qualifier("recoder_1") //<qualifier value="recoder_1"></qualifier>
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setRecorder " + recorder);
	}
	@Autowired
	@Qualifier("recoder_2")
	public void gMethod(Recorder rec) {
		System.out.println("GMethod(rec) : " + rec);
	}
}
