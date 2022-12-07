package DI_08_Spring;

public class JobExecute {
	public JobExecute(String first, int second) {
		System.out.println("String, int");
	}
	public JobExecute(String first, long second) {
		System.out.println("String, long");
	}
	public JobExecute(String first, String second) {
		System.out.println("String, String");
	}
	private ArticleDao articledao;
	
	public ArticleDao getArticledao() {
		return articledao;
	}
	public void setArticledao(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("setArticleDao : " + this.articledao);
	}
	public int data;

	public void setData(int data) {
		this.data = data;
		System.out.println("setDate : " + this.data);
	}
	
}
