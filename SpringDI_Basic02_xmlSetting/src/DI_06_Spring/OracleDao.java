package DI_06_Spring;

import DI_02.MessageBean;

public class OracleDao implements ArticleDao {

	@Override
	public void insert(Article article) {
		System.out.println("oracle");
	}
}
