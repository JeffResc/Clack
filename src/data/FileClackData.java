package data;

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileContents == null) ? 0 : fileContents.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		return result;
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
		if (fileContents == null) {
			if (other.fileContents != null)
				return false;
		} else if (!fileContents.equals(other.fileContents))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "This is a FileClackData with fileName = " + getFileName() + " and fileContents = " + getData();
	}
	
}
