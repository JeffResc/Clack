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
	 * 
	 * @param userName userName
	 * @param fileName fileName
	 * @param type type
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
	 * 
	 * @param fileName fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Returns fileName.
	 * 
	 * @return fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Returns fileContents.
	 * 
	 * @return fileContents
	 */
	public String getData() {
		return fileContents;
	}
	
	/**
	 * Returns decrypted fileContents.
	 * 
	 * @return fileContents
	 */
	public String getData(String key) {
		return decrypt(fileContents, key);
	}

	/**
	 * Reads the file contents does not return anything, for now it should have no
	 * code, just a declaration.
	 */
	public void readFileContents() {
		// needs to be set
	}

	/**
	 * Writes the file contents does not return anything, for now it should have no
	 * code, just a declaration.
	 */
	public void writeFileContents() {
		// needs to be set
	}
	
	/**
	 * Implements hashCode() functionality for this class and it's superclass' variables.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(fileContents, fileName, getUserName(), getType(), getDate());
	}

	/**
	 * Implements equals() functionality for this class and it's superclass' variables.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileClackData other = (FileClackData) obj;
		return Objects.equals(fileContents, other.fileContents) && Objects.equals(fileName, other.fileName) && Objects.equals(getUserName(), other.getUserName()) && Objects.equals(getType(), other.getType()) && Objects.equals(getDate(), other.getDate());
	}

	/**
	 * Implements toString() functionality for this class' variables.
	 */
	@Override
	public String toString() {
		return "FileClackData [fileName=" + fileName + ", fileContents=" + fileContents + ", userName=" + getUserName() + ", type=" + getType() + "]";
	}
	
}
