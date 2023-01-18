package BuilderTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Process {
	public static void main(String[] args) {
		
		// Controller에서 파라미터로 DTO List를 넣어 뷰페이지 데이터 받아왔다고 치고... 
		// List 반복문으로 돌리면서 타입별로 빌더 패턴 다르게 실행 한다고 가정
		
		// 1번 컬럼
		// 컬럼 이름 : 나이
		// 타입 : 랜덤 숫자
		// 범위 : 20 ~ 40
		DataInfo info1 = DataInfo.builder()
									.name("나이")
									.type("랜덤숫자")
									.a("20")
									.b("40")
									.creator(new StrategyClassA())
									.build();
		List<String> listA = info1.getData();
		
		// 2번 컬럼
		// 컬럼 이름 : 자동차
		// 타입 : 더미데이터
		// 더미데이터 번호 : 31
		DataInfo info2 = DataInfo.builder()
									.name("자동차")
									.type("더미데이터")
									.b("31")
									.creator(new StrategyClassB())
									.build();
		List<String> listB = info2.getData();
		
		System.out.println("List A : " + listA);
		System.out.println("List B : " + listB);
		
		// 이렇게 컬럼마다 - 더미데이터들 만들고
		Map<String, Object> column1 = new HashMap<String, Object>();
		column1.put("name", info1.getName());
		column1.put("list",listA);
		
		Map<String, Object> column2 = new HashMap<String, Object>();
		column2.put("name", info2.getName());
		column2.put("list",listB);
		
		List<Map> data = new ArrayList<Map>();
		data.add(column1);
		data.add(column2);
		
		// data를 비동기로 JSON return
		/*
			[
				{
					name : 나이,
					list : [32,16]
				},
				{
					name : 자동차,
					list : ["현대","기아"]
				}
			]
		*/
	}
}
