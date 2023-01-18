package BuilderTest;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor //final 변수들의 생성자 만들어 주는 애
@Data
public class DataInfo {
	private final StrategyImpl creator;
	private final String name;
	private final String type;
	private final String a;
	private final String b;
	
	public List<String> getData(){
		return creator.getData(this);
	}
}
