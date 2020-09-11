package data;

import java.util.Objects;

public class FileClackData extends ClackData {

	/**
	 * String representing name of file. Can only be set during class construction and can be retrieved using the getFileName() method.
	 */
	private String fileName;
	
	/**
	 * String representing contents of file. Can only be set using the setFileName() method and retrieved using the getData() method.
	 */
	private String fileContents;

	/**
	 * Constructor that accepts a userName, fileName and type.
	 */
	public FileClackData(String userName, String fileName, Integer type) {
		super(userName, type);
		this.fileName = fileName;
		this.fileContents = null;
	}

	/**
	 * Default constructor.
	 */
	public FileClackData() {
		super();
	}

	/**
	 * Sets fileName.
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Returns fileName.
	 * 
	 * @return
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Returns fileContents.
	 * 
	 * @return
	 */
	public String getData() {
		return this.fileContents;
	}

	/**
	 * Reads the file contents does not return anything, for now it should have no
	 * code, just a declaration.
	 * 
	 * @return
	 */
	public void readFileContents() {
		// needs to be set
	}

	/**
	 * Writes the file contents does not return anything, for now it should have no
	 * code, just a declaration.
	 * 
	 * @return
	 */
	public void writeFileContents() {
		// needs to be set
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileContents, fileName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileClackData other = (FileClackData) obj;
		return Objects.equals(fileContents, other.fileContents) && Objects.equals(fileName, other.fileName);
	}

	@Override
	public String toString() {
		return "FileClackData [fileName=" + fileName + ", fileContents=" + fileContents + "]";
	}
	
}
