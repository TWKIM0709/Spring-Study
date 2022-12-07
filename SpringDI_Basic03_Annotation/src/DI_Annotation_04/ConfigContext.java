package DI_Annotation_04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigContext {
	
	//xml >>	<bean id="user" class="DI_Annotation_04.User">
	//java >> 함수로 생성 (@Bean)
	// 			[함수 이름]이 <bean>의 [id] / [return 타입]이 <bean>의 [class]
	
	@Bean
	public User user() {
		return new User();
	}
	@Bean
	public User2 user2() {
		return new User2();
	}
}
