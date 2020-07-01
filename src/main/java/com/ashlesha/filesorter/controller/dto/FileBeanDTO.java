package com.ashlesha.filesorter.controller.dto;

import java.io.File;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Lazy
@Scope("singleton")
public class FileBeanDTO {

	private File fileName;
	private MultipartFile multipartFile;

	private static int idFileProcess = 0;
	private String fileSerach;

	private FileBeanDTO() {
		System.out.println("private constructor is accessed in spring..");
		this.fileSerach = fileSerach;
	}

	public String getFileSerach() {
		return fileSerach;
	}

	public void setFileSerach(String fileSerach) {
		
		this.fileSerach = fileSerach;
	}

	public int getIdFileProcess() {
		return ++idFileProcess;
	}

	public File getfileName() {
		return fileName;
	}

	public void setfileName(File fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[FileBeanDTO::"+this.multipartFile+ "]";
	}

}
