package com.ashlesha.filesorter.controller.service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ashlesha.filesorter.controller.dto.FileBeanDTO;

@Service
@Scope("singleton")

public class FileService {

	@Autowired
	@Qualifier("fileServiceExecutor")
	Callable<TreeMap> callable;

	FileBeanDTO fileBeanDTO;

	public TreeMap fileValidation(FileBeanDTO fileBeanDTO) throws Exception {

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		this.fileBeanDTO = fileBeanDTO;
		Future<TreeMap> future = executorService.submit(new FileServiceExecutor(this));
		return future.get();

	}

	public FileBeanDTO getFileBeanDTO() {
		return fileBeanDTO;
	}

	public void setFileBeanDTO(FileBeanDTO fileBeanDTO) {
		this.fileBeanDTO = fileBeanDTO;
	}

}

@Component
@Scope("singleton")
class FileServiceExecutor implements Callable {
	FileService fileService;

	FileServiceExecutor() {
		super();
		System.out.println();
	}

	FileServiceExecutor(FileService fileService) {
		this.fileService = fileService;
		System.out.println();
	}

	@Override
	public TreeMap call() throws Exception {
		// TODO Auto-generated method stub
		TreeMap<Integer, Object> treeMap = new TreeMap<Integer, Object>();
		List<Integer> list = new LinkedList<Integer>();
		List listMap = new LinkedList();

		MultipartFile file = this.fileService.getFileBeanDTO().getMultipartFile();
		String name = file.getOriginalFilename();
		File fileUpload = new File(name);

		String path = fileUpload.getAbsolutePath();
		fileUpload = new File(path);
		int c = 0;

		StringBuffer sbBufferReader = new StringBuffer();
		StringBuffer stringCheck = new StringBuffer(this.fileService.fileBeanDTO.getFileSerach());
		int position = 0;
		int lastIndex = 0;
		int count = 0, fileLen = 0;
		String line;
		int readLine = 0;
		Optional<String> optional;
		if (fileUpload.createNewFile()) {

			BufferedOutputStream bisTemp = new BufferedOutputStream(new FileOutputStream(fileUpload));
			InputStreamReader bis = new InputStreamReader(file.getInputStream());

			while ((c = bis.read()) != -1) {
				char write = (char) c;
				bisTemp.write(write);
				c++;
			}
			bisTemp.flush();
			bisTemp.close();

			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

			while ((line = bufferedReader.readLine()) != null) {

				Supplier<List> supplierFirst = compute(line, stringCheck);
				/*
				 * listMap = list.stream().map((mapper) -> { return mapper;
				 * }).collect(Collectors.toList()); ++readLine;
				 * 
				 */
				readLine++;
				if (line != "" && !"".equals(line)) {

					treeMap.put(readLine, supplierFirst.get());
				}

			}
			bufferedReader.close();
		} else if (fileUpload.exists()) {

			BufferedOutputStream bisTemp = new BufferedOutputStream(new FileOutputStream(fileUpload));
			InputStreamReader bis = new InputStreamReader(file.getInputStream());

			while ((c = bis.read()) != -1) {
				char write = (char) c;
				bisTemp.write(write);
				c++;
			}
			bisTemp.flush();
			bisTemp.close();

			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

			while ((line = bufferedReader.readLine()) != null) {

				Supplier<List> supplier = compute(line, stringCheck);
				
				readLine++;
				if (line != "" && !"".equals(line)) {
					treeMap.put(readLine, supplier.get());
				}
			}
			bufferedReader.close();
		} else {
			TreeMap<Integer, List<Integer>> treeMapElse = new TreeMap<Integer, List<Integer>>();
			List<Integer> listElse = new LinkedList<Integer>();
			listElse.add(new Integer(404));
			treeMapElse.put(new Integer(0), listElse);
			return treeMapElse;
		}
		return treeMap;
	}

	public Supplier<List> compute(String line, StringBuffer stringCheck) {

		return () -> {
			int lastIndex = 0, position = 0, count = 0,temp=1;
			LinkedList linkedList = new LinkedList<>();
			while (lastIndex != -1 || lastIndex == -1) {
				lastIndex = line.indexOf(stringCheck.toString(), lastIndex);
				position = lastIndex;
				if (lastIndex == -1)
					break;

				if (lastIndex != -1) {// if block added for checking no. of
										// string occurrence on the same
										// line
					count++;
					lastIndex += stringCheck.length();
				}
				linkedList.add(position+temp);

			}
			return linkedList;

		};
	}
}