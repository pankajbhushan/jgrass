package com.grassproject.jgrass.web.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
	private static Logger LOGGER = Logger.getLogger(HomeController.class);

	@PostMapping(value = "/uploadFile")
	public void uploadFile(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			System.out.println("name of the file :" + name);
			System.out.println("size of the file :" + file.getSize());
		}

	}

	@GetMapping(value = "/detail")
	public void getDetail() {
		LOGGER.info("inside getDetail method call..");
	}
}
