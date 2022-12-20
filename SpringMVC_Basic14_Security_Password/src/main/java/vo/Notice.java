package vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Notice {
	private String seq;
	private String title;
	private String writer;
	private Date regdate;
	private String fileSrc;
	
	private String fileSrc2;
	
	private int hit;
	private String content;
	
	
		
	/*
	
	//파일 (단일 파일 업로드)
	//POINT
    private CommonsMultipartFile file; //업로드한 파일 정보를 담는 변수
    //단 조건 : <input type="file" name="file" ....
    public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	*/
    //
	
	//다중 파일 업로드.....3개 . 4개 파일 추가된는 가정하에 대비하겠다.......
	private List<CommonsMultipartFile> files;
	
    
	public List<CommonsMultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<CommonsMultipartFile> files) {
		this.files = files;
	}
	/////////////////////////////////////////////////////////////
	
	
	public String getFileSrc2() {
		return fileSrc2;
	}
	public void setFileSrc2(String fileSrc2) {
		this.fileSrc2 = fileSrc2;
	}
	
	public String getFileSrc() {
		return fileSrc;
	}
	
	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notice [seq=" + seq + ", title=" + title + ", writer=" + writer + ", regdate=" + regdate + ", fileSrc="
				+ fileSrc + ", hit=" + hit + ", content=" + content + "]";
	}
	
}
