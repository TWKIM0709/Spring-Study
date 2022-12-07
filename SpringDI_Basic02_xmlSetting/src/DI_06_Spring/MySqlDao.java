package DI_06_Spring;

public class MySqlDao implements ArticleDao {

	@Override
	public void insert(Article article) {
		System.out.println("mysql");
	}
}
