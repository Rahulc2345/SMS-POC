package com.app.pojos;

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {

	private MultipartFile file;
	private String descriptor;
	public FileBucket() {
		super();
	}
	public FileBucket(MultipartFile file, String descriptor) {
		super();
		this.file = file;
		this.descriptor = descriptor;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getDescriptor() {
		return descriptor;
	}
	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}
	
	
}
