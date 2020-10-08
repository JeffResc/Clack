package data;

import java.io.*;
import java.util.Objects;

public class FileClackData extends ClackData {

	/**
	 * String representing name of file. Can only be set during class construction
	 * and can be retrieved using the getFileName() method.
	 */
	private String fileName;

	/**
	 * String representing contents of file. Can only be set using the setFileName()
	 * method and retrieved using the getData() method.
	 */
	private String fileContents;

	/**
	 * Constructor that accepts a userName, fileName and type.
	 * 
	 * @param userName userName
	 * @param fileName fileName
	 * @param type     type
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
	 * Reads the file contents does not return anything, uses a buffered reader to
	 * read from the file fileName and adds each line in the file onto fileContents
	 * catches ioexceptions
	 */
	public void readFileContents() throws IOException {
		try {
			BufferedReader myFile = new BufferedReader(new FileReader(fileName));
			String line = "";
			fileContents = "";
			while ((line = myFile.readLine()) != null) {
				fileContents = fileContents + line;
			}
			myFile.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println("File not found");
		} catch (IOException ioe) {
			System.err.println("io exception");
		}
	}

	/**
	 * Reads the file contents does not return anything, uses a buffered reader to
	 * read from the file fileName encrypts it and adds each line in the file onto
	 * fileContents catches ioexceptions
	 */
	public void readFileContents(String key) throws IOException {
		try {
			BufferedReader myFile = new BufferedReader(new FileReader(fileName));
			String line = "";
			fileContents = "";
			while ((line = myFile.readLine()) != null) {
				line = encrypt(line, key);
				fileContents = fileContents + line;
			}
			myFile.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println("File not found");
		} catch (IOException ioe) {
			System.err.println("io exception");
		} catch (NullPointerException npe) {
			System.err.println("null pointer exception");
		}
	}

	/**
	 * Writes the file contents does not return anything, uses a bufferedwriter to
	 * write to the file fileName from fileContents
	 */
	public void writeFileContents() throws IOException {
		try {
			BufferedWriter myfile = new BufferedWriter(new FileWriter(fileName));
			myfile.write(fileContents, 0, fileContents.length());
			myfile.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println("File not found");
		} catch (IOException ioe) {
			System.err.println("io exception");
		} catch (NullPointerException npe) {
			System.err.println("null pointer exception");
		}
	}

	/**
	 * Writes the file contents does not return anything, decrypts fileContents and
	 * uses a bufferedwriter to write to the file fileName from fileContents
	 */
	public void writeFileContents(String key) throws IOException {
		try {
			BufferedWriter myfile = new BufferedWriter(new FileWriter(fileName));
			myfile.write(decrypt(fileContents, key), 0, decrypt(fileContents, key).length());
			myfile.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println("File not found");
		} catch (IOException ioe) {
			System.err.println("io exception");
		} catch (NullPointerException npe) {
			System.err.println("null pointer exception");
		}
	}

	/**
	 * Implements hashCode() functionality for this class and it's superclass'
	 * variables.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(fileContents, fileName, getUserName(), getType(), getDate());
	}

	/**
	 * Implements equals() functionality for this class and it's superclass'
	 * variables.
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
		return Objects.equals(fileContents, other.fileContents) && Objects.equals(fileName, other.fileName)
				&& Objects.equals(getUserName(), other.getUserName()) && Objects.equals(getType(), other.getType())
				&& Objects.equals(getDate(), other.getDate());
	}

	/**
	 * Implements toString() functionality for this class' variables.
	 */
	@Override
	public String toString() {
		return "FileClackData [fileName=" + fileName + ", fileContents=" + fileContents + ", userName=" + getUserName()
				+ ", type=" + getType() + "]";
	}

}
