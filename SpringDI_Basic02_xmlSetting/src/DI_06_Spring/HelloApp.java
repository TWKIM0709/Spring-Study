package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//Java 코드...
//		ArticleDao articleDao = new OracleDao();
//		ArticleDao articleDao = new MySqlDao();
//		ArticleService articleService = new ArticleService(articleDao);
//		
//		Article article = new Article();
//		articleService.write(article);
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
		ArticleService articleService = context.getBean("articleservice",ArticleService.class);
		Article article = context.getBean("article",Article.class);
		articleService.write(article);
	}

}
