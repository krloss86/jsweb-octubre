package ar.com.educacionit.web.parsers;

import javax.servlet.http.Part;

public abstract class FileParserBase {

	protected String type;
	
	protected String name;
	
	protected Part filePart;
	
	public FileParserBase(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public FileParserBase(String type, Part filePart) {
		this.type = type;
		this.filePart = filePart;
	}
	
}
