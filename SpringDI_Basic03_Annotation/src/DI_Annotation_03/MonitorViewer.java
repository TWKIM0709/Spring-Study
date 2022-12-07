package DI_Annotation_03;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	private Recorder recorder;

	public Recorder getRecorder() {
		return recorder;
	}
//	@Autowired by type
	@Resource(name="yy") //같은 타입의 객체가 있을 때 name(id)을 사용해 찾는다.
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
		System.out.println("setRecorder " + recorder);
	}
}
