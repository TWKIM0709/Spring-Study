package com.model;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.Data;
/*
	DB에
	create table photo(
		name >>작성자
		age	  >> 나이
		image >> 업로드한 파일의 이름 >> 1.jpg , 2.png . . .
	);
*/
@Data
public class Photo {
	private String name;
	private int age;
	private String image;
	/////////////////////////여기까지는 DB에서 필요한 컬럼
	//DTO가 이미지 파일도 받았으면 좋겠다...
	//별도의 파일 담기용 객체 생성
	private CommonsMultipartFile file; //업로드한 파일을 받는 객체
}
