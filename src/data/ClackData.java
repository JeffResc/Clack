package data;

import java.util.Date;
import java.util.Scanner;

public abstract class ClackData {

	/**
	 * A representative constant meaning the default type for the type variable.
	 */
	public static final int CONSTANT_DEFAULT_TYPE = -1;

	/**
	 * A representative constant meaning "List users" for the type variable.
	 */
	public static final int CONSTANT_LISTUSERS = 0;

	/**
	 * A representative constant meaning "Logout" for the type variable.
	 */
	public static final int CONSTANT_LOGOUT = 1;

	/**
	 * A representative constant meaning "Send message" for the type variable.
	 */
	public static final int CONSTANT_SENDMESSAGE = 2;

	/**
	 * A representative constant meaning "Send file" for the type variable.
	 */
	public static final int CONSTANT_SENDFILE = 3;

	/**
	 * String representing name of client user. Can only be set during class construction and can be retrieved using the getUserName() method.
	 */
	private String userName;
	
	/**
	 * See class constants for additional resources on the type variable. Can only be set during class construction and can be retrieved using the getType() method.
	 */
	private Integer type;
	
	/**
	 *  Date object representing date when ClackData object was created. Can only be set during class construction and can be retrieved using the getDate() method.
	 */
	private Date date;

	/**
	 * Constructor that accepts a userName and type.
	 * 
	 * @param userName userName
	 * @param type type
	 */
	public ClackData(String userName, Integer type) {
		this.userName = userName;
		this.type = type;
		this.date = new Date();
	}

	/**
	 * Constructor that accepts a type.
	 * 
	 * @param type type
	 */
	public ClackData(Integer type) {
		this("Anon", type);
	}

	/**
	 * Default constructor.
	 */
	public ClackData() {
		this(CONSTANT_DEFAULT_TYPE);
	}

	/**
	 * Returns type.
	 * 
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * Returns userName.
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Returns date.
	 * 
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Returns the data contained in ClackData.
	 * 
	 * @return data
	 */
	public abstract String getData();
	
	/**
	 * Returns the decrypted data contained in ClackData.
	 * 
	 * @return data
	 */
	public abstract String getData(String key);
	
	
	private static int smallestAlphabeticInt(int i) {
		while(i < 0)
			i += 26;
		while(i > 26)
			i -= 26;
		if (i == 0)
			i = 26;
		return i;
	}
	
	private static char intToChar(int i) {
		return (char)(i + 96);
	}

	private static int charToInt(char ch) {
		return (int)Character.toLowerCase(ch) - 96;
	}
	
	private static char modifyChar(char inputChar, char keyChar, Boolean encrypt) {
		Boolean capitalize = false;
		if (Character.isUpperCase(inputChar)) {
			capitalize = true;
		}
		final char new_char = encrypt ? intToChar(smallestAlphabeticInt(charToInt(inputChar) + charToInt(keyChar) - 1)) : intToChar(smallestAlphabeticInt(charToInt(inputChar) - charToInt(keyChar) + 1));
		return capitalize ? Character.toUpperCase(new_char) : new_char;
	}
	
	/**
	 * This method takes in an input string to encrypt using a key, and outputs the encrypted string.
	 * @param inputStringToEncrypt
	 * @param key
	 * @return
	 */
	protected static String encrypt(String inputStringToEncrypt, String key) {
		String t = "";
		int key_pos_index = 0;
		for (char ch: inputStringToEncrypt.toCharArray()) {
			Boolean advance_key = false;
			if (Character.isLetter(ch)) {
				advance_key = true;
				t += modifyChar(ch, key.charAt(key_pos_index), true);
			} else {
				t += ch;
			}
			if (advance_key) {
				if (key_pos_index == key.length() - 1) {
					key_pos_index = 0;
				} else {
					key_pos_index++;
				}
			}
		}
		return t;
	}
	
	/**
	 * This method takes in an input string to decrypt using a key, and outputs the decrypted string.
	 * @param inputStringToDecrypt
	 * @param key
	 * @return
	 */
	protected static String decrypt(String inputStringToDecrypt, String key) {
		String t = "";
		int key_pos_index = 0;
		for (char ch: inputStringToDecrypt.toCharArray()) {
			Boolean advance_key = false;
			if (Character.isLetter(ch)) {
				advance_key = true;
				t += modifyChar(ch, key.charAt(key_pos_index), false);
			} else {
				t += ch;
			}
			if (advance_key) {
				if (key_pos_index == key.length() - 1) {
					key_pos_index = 0;
				} else {
					key_pos_index++;
				}
			}
		}
		return t;
	}
	
}
