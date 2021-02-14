package mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import obj.Dictionary;
import obj.KeyValue;

public class DictionaryMapper {
	private final static String KEY_NOT_FOUND = "ERROR, key not found.";
	private final static String VALUE_NOT_FOUND = "ERROR, value not found.";
	
	public static List<String> mapKeys(Dictionary dictionary) {
		return dictionary.getKeyValues().stream()
				.map(keyValue -> keyValue.getKey())
				.distinct()
				.collect(Collectors.toList());
	}
	
	public static List<String> mapMembers(Dictionary dictionary, String key) {
		return dictionary.getKeyValues().stream()
				.filter(keyValue -> keyValue.getKey().toUpperCase().equals(key.toUpperCase()))
				.map(keyValue -> keyValue.getValue())
				.distinct()
				.collect(Collectors.toList());
	}
	
	public static void mapAdd(Dictionary dictionary, String key, String value) {
		dictionary.getKeyValues().add(new KeyValue(key, value));
	}
	
	public static String mapRemove(Dictionary dictionary, String key, String value) {
		String removeStatus;
		
		KeyValue foundKey = dictionary.getKeyValues().stream()
				.filter(keyValue -> keyValue.getKey().toUpperCase().equals(key.toUpperCase()))
				.findFirst()
				.orElse(null);
				
		KeyValue foundValue = dictionary.getKeyValues().stream()
				.filter(keyValue -> keyValue.getKey().toUpperCase().equals(key.toUpperCase()))
				.filter(keyValue -> keyValue.getValue().toUpperCase().equals(value.toUpperCase()))
				.findFirst()
				.orElse(null);
		
		
		
		if (foundKey == null) {
			removeStatus = KEY_NOT_FOUND;
		} else if (foundValue == null) {
			removeStatus = VALUE_NOT_FOUND;
		} else {
			dictionary.getKeyValues().removeIf(keyValue -> keyValue.getKey().toUpperCase().equals(key.toUpperCase()) 
					&& keyValue.getValue().toUpperCase().equals(value.toUpperCase()));
			removeStatus = "Removed " + key + " " + value;
		}
		
		return removeStatus;
	}
	
	public static String mapRemoveAll(Dictionary dictionary, String key) {
		String removeStatus;
		
		KeyValue foundKey = dictionary.getKeyValues().stream()
				.filter(keyValue -> keyValue.getKey().toUpperCase().equals(key.toUpperCase()))
				.findFirst()
				.orElse(null);
		
		if (foundKey == null) {
			removeStatus = KEY_NOT_FOUND;
		} else {
			dictionary.getKeyValues().removeIf(keyValue -> keyValue.getKey().toUpperCase().equals(key.toUpperCase()));
			removeStatus = "Removed " + key;
		}
		
		return removeStatus;
	}
	
	public static void mapClear(Dictionary dictionary) {
		dictionary.setKeyValues(new ArrayList<>());
	}
	
	public static boolean mapKeyExists(Dictionary dictionary, String key) {
		KeyValue foundKey = dictionary.getKeyValues().stream()
				.filter(keyValue -> keyValue.getKey().toUpperCase().equals(key.toUpperCase()))
				.findFirst()
				.orElse(null);
		
		return foundKey != null;
	}
	
	public static boolean mapValueExists(Dictionary dictionary, String key, String value) {
		KeyValue foundValueForKey = dictionary.getKeyValues().stream()
				.filter(keyValue -> keyValue.getKey().toUpperCase().equals(key.toUpperCase()))
				.filter(keyValue -> keyValue.getValue().toUpperCase().equals(value.toUpperCase()))
				.findFirst()
				.orElse(null);
		
		return foundValueForKey != null;
	}
	
	public static List<String> mapAllMembers(Dictionary dictionary) {
		return dictionary.getKeyValues().stream()
				.map(keyValue -> keyValue.getValue())
				.collect(Collectors.toList());
	}

}
