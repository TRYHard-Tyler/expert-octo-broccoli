package obj;

public class KeyValue {
	private String key;
	private String value;
	
	public KeyValue() {
	}

	public KeyValue(String key, String value) {
		this.setKey(key);
		this.setValue(value);
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * @return the KeyValue
	 */
	public KeyValue withKey(String key) {
		this.key = key;
		return this;
	}
	
	/**
	 * @return the KeyValue
	 */
	public KeyValue withValue(String value) {
		this.value = value;
		return this;
	}
	
	

}
