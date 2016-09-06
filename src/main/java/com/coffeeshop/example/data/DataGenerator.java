package com.coffeeshop.example.data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class DataGenerator {

	abstract void generate();
	
	protected String composeFilePath(String fileName) {
		return "/" + fileName;
	}
	
	protected List<String> file2List(String fileName) {
		
		try {
			URL resource = this.getClass().getResource(composeFilePath(fileName));
			return Files.readAllLines(Paths.get(resource.toURI()), StandardCharsets.UTF_8);
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected String file2String(String fileName) {
		
		try {
			URL resource = this.getClass().getResource(composeFilePath(fileName));
			return new String(Files.readAllBytes(Paths.get(resource.toURI())));
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	

}
