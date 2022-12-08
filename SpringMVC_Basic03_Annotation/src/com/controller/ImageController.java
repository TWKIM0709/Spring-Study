package com.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Photo;
@Controller
@RequestMapping("/image/upload.do")
public class ImageController {
	@GetMapping
	public String form() {
		return "image/image";
	}
	@PostMapping
	public String submit(Photo photo, HttpServletRequest request) {
		/*
		 1. Photo DTO 타입으로 데이터 받기
		 1.1 자동화를 위해 >> input name 속성값과 Photo 타입 클래스의 member field 명 동일하게
		 2. public String submit(Photo) 내부적으로
		  		>> Photo photo = new Photo();
		  		 	 photo.setName("가");
		  			 photo.setAge(20);
		  			 photo.setImage() >> 자동주입 안된다. >> 수동으로 1.2 CommonsMultipartFile에서 추출..
		  			 photo.setFile(CommonsMultipartFile file) 자동으로 들어옴
		 */
		CommonsMultipartFile imagefile = photo.getFile();
		System.out.println("imageFileName : " + imagefile.getName());
		System.out.println("imageFileOriginalName : " + imagefile.getOriginalFilename());
		System.out.println("imageFileType : " + imagefile.getContentType());
		System.out.println("imageFileByte : " + imagefile.getBytes().length);
		
		photo.setImage(imagefile.getName());
		
		// 파일 업로드
		//실제 파일 업로드 구현 (upload 업로드)
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload"); //배포된 서버 경로 
		String fpath = path + "\\" + filename;
		System.out.println(fpath);
		
		FileOutputStream fs =null;
		try {
			     fs = new FileOutputStream(fpath);
			     fs.write(imagefile.getBytes());
			     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 try {
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(photo.toString());
		
		//DB작업 .... 파일 업로드 완료
		return "image/image";
	}
}
