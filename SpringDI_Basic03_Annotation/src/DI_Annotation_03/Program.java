package DI_Annotation_03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
//		MonitorViewer viewer = new MonitorViewer();
//		Recorder recorder = new Recorder();
//		
//		viewer.setRecorder(recorder);
//		System.out.println(viewer.getRecorder());
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_Annotation_03/DI_03.xml");
		MonitorViewer viewer = context.getBean("monitorViewer",MonitorViewer.class);
		System.out.println(viewer.getRecorder());
	}

}
