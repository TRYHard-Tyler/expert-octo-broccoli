package service;

import java.util.List;

import mapper.DictionaryMapper;
import obj.Dictionary;
import obj.KeyValue;

public class DictionaryService {

	private static final String TOO_FEW_PARAMETERS = "You have entered fewer parameters than required for the command. The command will be disregarded.";
	private static final String TOO_MANY_PARAMETERS = "You have entered more parameters than required for the command. The extras will be disregarded.";

	public static void keys(String[] command, Dictionary dictionary) {
		if (command.length > 1) {
			System.out.println(TOO_MANY_PARAMETERS);
		}
		List<String> keys = DictionaryMapper.mapKeys(dictionary);
		
		for(int i = 0; i < keys.size(); i++) {
			System.out.println((i+1) + ".) " + keys.get(i));
		}
	}
	
	public static void members(String[] command, Dictionary dictionary) {
		if (command.length > 2) {
			System.out.println(TOO_MANY_PARAMETERS);
		} else if (command.length < 2) {
			System.out.println(TOO_FEW_PARAMETERS);
			return;
		}
		List<String> members = DictionaryMapper.mapMembers(dictionary, command[1]);
		
		for(int i = 0; i < members.size(); i++) {
			System.out.println((i+1) + ".) " + members.get(i));
		}
		
		if (members.size() == 0) {
			System.out.println("ERROR, key does not exist");
		}
	}

	public static void add(String[] command, Dictionary dictionary) {
		if (command.length > 3) {
			System.out.println(TOO_MANY_PARAMETERS);
		} else if (command.length < 3) {
			System.out.println(TOO_FEW_PARAMETERS);
			return;
		}
		
		if (DictionaryMapper.mapValueExists(dictionary, command[1], command[2])) {
			System.out.println("ERROR, value already exists");
		} else {
			DictionaryMapper.mapAdd(dictionary, command[1], command[2]);
			System.out.println("Added");
		}
	}
	
	public static void remove(String[] command, Dictionary dictionary) {
		if (command.length > 3) {
			System.out.println(TOO_MANY_PARAMETERS);
		} else if (command.length < 3) {
			System.out.println(TOO_FEW_PARAMETERS);
			return;
		}
	
		System.out.println(DictionaryMapper.mapRemove(dictionary, command[1], command[2]));
	}
	
	public static void removeAll(String[] command, Dictionary dictionary) {
		if (command.length > 2) {
			System.out.println(TOO_MANY_PARAMETERS);
		} else if (command.length < 2) {
			System.out.println(TOO_FEW_PARAMETERS);
			return;
		}
	
		System.out.println(DictionaryMapper.mapRemoveAll(dictionary, command[1]));
	}
	
	public static void clear(String[] command, Dictionary dictionary) {
		if (command.length > 1) {
			System.out.println(TOO_MANY_PARAMETERS);
		}
	
		DictionaryMapper.mapClear(dictionary);
		System.out.println("Cleared");
	}
	
	public static void keyExists(String[] command, Dictionary dictionary) {
		if (command.length > 2) {
			System.out.println(TOO_MANY_PARAMETERS);
		} else if (command.length < 2) {
			System.out.println(TOO_FEW_PARAMETERS);
			return;
		}
	
		System.out.println(DictionaryMapper.mapKeyExists(dictionary, command[1]));
	}
	
	public static void valueExists(String[] command, Dictionary dictionary) {
		if (command.length > 3) {
			System.out.println(TOO_MANY_PARAMETERS);
		} else if (command.length < 3) {
			System.out.println(TOO_FEW_PARAMETERS);
			return;
		}
	
		System.out.println(DictionaryMapper.mapValueExists(dictionary, command[1], command[2]));
	}
	
	public static void allMembers(String[] command, Dictionary dictionary) {
		if (command.length > 1) {
			System.out.println(TOO_MANY_PARAMETERS);
		}
	
		List<String> members =  DictionaryMapper.mapAllMembers(dictionary);
		for(int i = 0; i < members.size(); i++) {
			System.out.println((i+1) + ".) " + members.get(i));
		}
	}
	
	public static void items(String[] command, Dictionary dictionary) {
		if (command.length > 1) {
			System.out.println(TOO_MANY_PARAMETERS);
		}
		for (int i = 0; i < dictionary.getKeyValues().size(); i++) {
			KeyValue keyValue = dictionary.getKeyValues().get(i);
			System.out.println((i + 1) + ".) " + keyValue.getKey() + ": " + keyValue.getValue());
		}
	}
}
