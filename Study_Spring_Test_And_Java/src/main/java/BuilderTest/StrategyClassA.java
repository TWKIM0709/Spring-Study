package BuilderTest;

import java.util.ArrayList;
import java.util.List;

public class StrategyClassA implements StrategyImpl {

	@Override
	public List<String> getData(DataInfo info) {
		List<String> list = new ArrayList<String>();
		list.add("ClassA");
		list.add(info.getA()+"에서 " + info.getB() + "사이의 랜덤 숫자");
		return list;
	}

}
