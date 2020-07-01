package com.ashlesha.filesorter.controller;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashlesha.filesorter.controller.dto.FileBeanDTO;
import com.ashlesha.filesorter.controller.service.FileService;

@Controller
public class FileUploadController {

	@Autowired
	FileService fileService;

	FileBeanDTO fileBeanDTO;

	@Autowired
	AppConfiguration appConfiguration;

	@GetMapping(value = "/fileUpload")
	public String home(@ModelAttribute("fileBeanDTO") FileBeanDTO fileBeanDTO) {
		return "fileUpload";
	}

	@GetMapping(value = "/appName")
	public ResponseEntity appName() {
		return new ResponseEntity<AppConfiguration>(appConfiguration, HttpStatus.OK);
	}

	@PostMapping(value = "/fileUploadProcess", produces = { "text/plain" })
	public String fileUploadProcess(@ModelAttribute("fileBeanDTO") FileBeanDTO fileBeanDTO, ModelMap model)
			throws Exception {
		
		if (fileBeanDTO.getFileSerach()!=null && !"".equals(fileBeanDTO.getFileSerach())) {		
		TreeMap<Integer, List<Integer>> resultMap = fileService.fileValidation(fileBeanDTO);
		model.addAttribute("result", resultMap);
		}
		else 
			throw new Exception("File Serach Shoul not be empty");
		return "result";
	}

	
}
