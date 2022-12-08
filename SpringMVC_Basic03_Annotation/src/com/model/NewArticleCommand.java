package com.model;

import lombok.Data;

//DB에 Article 테이블이 있다고 가정 > 1대1 매핑
@Data
public class NewArticleCommand {
	private int parentId;
	private String title;
	private String content;
}
