package com.grassproject.jgrass.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grassproject.jgrass.service.UploadService;

@RestController
@RequestMapping(value = "/v1/file")
public class FileResource {
	
	private static Logger LOGGER = Logger.getLogger(FileResource.class);
	@Autowired private UploadService uploadService;
	
	@PostMapping(value = "/upload",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<String> parseFile(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return null;
		}
		return uploadService.parse(file);
	}

	@GetMapping(value = "/detail")
	public void getDetail() {
		LOGGER.info("inside getDetail method call..");
	}
}
