package oop.inherit4;

public class File {
	//필드
	private String filename;
	private long filesize;
	
	//setter & getter
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		if(filesize < 0L) return;
		this.filesize = filesize;
	}
	
	//공통 메소드
	public void execute() {
		System.out.println("파일 실행");
	}
}
