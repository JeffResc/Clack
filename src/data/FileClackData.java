package data;

public class FileClackData extends ClackData {
	
	// FileClackData variables
	private String fileName;
	private String fileContents;
	
	public FileClackData(String userName, String fileName, Integer Type){
		super(userName,Type);
		this.fileName = fileName;
		this.fileContents = null;
	}
	public FileClackData() {
		super();
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Returns fileName
	 * @return
	 */
	public String getFileName() {
		return this.fileName;
	}
	
	/**
	 * Returns fileContents
	 * @return
	 */
	public String getData() {
		return this.fileContents;
	}
	
	/**
	 *  reads the file contents does not return anything, for now it should have no code, just a declaration
	 * @return
	 */
	public void readFileContents() {
		//needs to be set
	}
	
	/**
	 *  writes the file contents does not return anything, for now it should have no code, just a declaration
	 * @return
	 */
	public void writeFileContents() {
		//needs to be set
	}
	
	
	@Override
	public boolean equals (Object other) {
		if ( other == null) return false; // makes sure the other object isnt null
		if ( !(other instanceof FileClackData)) return false; // makes sure that the other object points to an object of the same type
		
		FileClackData otherFileClackData = (FileClackData)other; // creates a circle object and sets it = to the other object
		
		return this.fileName == otherFileClackData.getFileName() && 
				this.fileContents == otherFileClackData.getData();
	}
	
}
