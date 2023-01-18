package BuilderTest;

import java.util.ArrayList;
import java.util.List;

public class StrategyClassB implements StrategyImpl {

	@Override
	public List<String> getData(DataInfo info) {
		List<String> list = new ArrayList<String>();
		list.add("ClassB");
		list.add(info.getB() + "번 더미데이터에 들어 있는 데이터들");
		return list;
	}

}
