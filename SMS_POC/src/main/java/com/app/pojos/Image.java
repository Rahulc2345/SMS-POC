package com.app.pojos;

import org.springframework.web.multipart.MultipartFile;

public class Image {

	private MultipartFile iFile;
	
	public Image() {
		super();
	}
	
	public Image(MultipartFile iFile) {
		super();
		this.iFile = iFile;
	}

	public MultipartFile getiFile() {
		return iFile;
	}

	public void setiFile(MultipartFile iFile) {
		this.iFile = iFile;
	}

	
	
}
