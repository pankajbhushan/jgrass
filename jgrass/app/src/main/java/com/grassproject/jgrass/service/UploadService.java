package com.grassproject.jgrass.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

@Service
public class UploadService {

	private static Logger LOGGER = Logger.getLogger(UploadService.class);

	// Temporary. Need to save in MongoDB
	private static final String DESTINATION = System.getenv("CATALINA_HOME") + "\\temp\\jgrass\\UploadDestination\\";

	List<String> allAttributes = new ArrayList<>();
	List<Field> fieldList = new ArrayList<>();
	List<Method> methodList = new ArrayList<>();

	public List<String> parse(MultipartFile mulFile) {

		try {
			File directory = new File(DESTINATION);
			File file = new File(DESTINATION + mulFile.getOriginalFilename());

			if (!directory.exists()) {
				directory.mkdirs();
			}

			if (file.exists())
				file.delete();

			mulFile.transferTo(file);

			JavaClass javaClass = new ClassParser(file.getAbsolutePath()).parse();
			fieldList = Arrays.asList(javaClass.getFields());
			methodList = Arrays.asList(javaClass.getMethods());

			// Adding fields to Attributes
			fieldList.stream().forEach(field -> allAttributes.add(field.toString()));
			methodList.stream().forEach(method -> allAttributes.add(method.toString()));
		} catch (IOException e) {
			LOGGER.error("Parsing Failed for file: " + mulFile.getOriginalFilename() + "\n" + e.getMessage());
		}

		return allAttributes;
	}

}
