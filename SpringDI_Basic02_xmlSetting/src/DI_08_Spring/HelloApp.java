package DI_08_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[]args) {
		/*
		 * JobExecute jobExecute = new JobExecute("hong", 100); JobExecute jobExecute2 =
		 * new JobExecute("lim", 100L); JobExecute jobExecute3 = new JobExecute("hong",
		 * "lim");
		 * 
		 * ArticleDao articledao = new ArticleDao();
		 * jobExecute.setArticledao(articledao);
		 * 
		 * jobExecute.setData(500);
		 */

		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_08_Spring/DI_08.xml");
		JobExecute jobExecute = context.getBean("jobExecute",JobExecute.class);
	}
}
