package ar.com.educacionit.web.servlet;

public enum FileTypeEnum {
	CSV, XSL;
	
	/**
	 * XLS, PEPE, JUAN, MP3 
	 * @param ext
	 * @return
	 */
	public static FileTypeEnum getTypeByExt(String ext) {
		
		FileTypeEnum[] values = FileTypeEnum.values();
		
		FileTypeEnum typeValid = null;
		
		for(FileTypeEnum type : values) {
			if(type.name().equalsIgnoreCase(ext)) {
				typeValid = type;
			}
		}
		return typeValid;
	}
}
