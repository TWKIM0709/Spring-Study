package DI_06_Spring;

//OracleDao, MySqlDao 이 사용하는 공통함수
public interface ArticleDao {
	void insert(Article article);
}
