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
	public String getFileName() {
		return this.fileName;
	}
	public String getData() {
		return this.fileContents;
	}
	public void readFileContents() {
		//needs to be set
	}
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
