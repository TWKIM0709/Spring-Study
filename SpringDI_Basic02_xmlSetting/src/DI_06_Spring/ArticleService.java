package DI_06_Spring;

public class ArticleService {
	//ArticleService 는 ArticleDao에 의존한다.
	
	private ArticleDao articleDao;
	public ArticleService(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	//글쓰기 서비스
	public void write(Article article) {
		this.articleDao.insert(article);
	}
}
