package obj;

import java.util.List;

public class Dictionary {
	private List<KeyValue> keyValues;

	public Dictionary() {
	}

	public Dictionary(List<KeyValue> keyValues) {
		this.keyValues = keyValues;
	}

	public List<KeyValue> getKeyValues() {
		return keyValues;
	}

	public void setKeyValues(List<KeyValue> keyValues) {
		this.keyValues = keyValues;
	}
	
	public Dictionary withKeyValues(List<KeyValue> keyValues) {
		this.keyValues = keyValues;
		return this;
	}
}
