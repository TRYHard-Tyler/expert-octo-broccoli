package ui;

import java.util.ArrayList;
import java.util.Scanner;

import obj.Command;
import obj.Dictionary;
import service.DictionaryService;

public class DictionaryUi {

	public static void run(Scanner scanner) {
		Dictionary dictionary = new Dictionary().withKeyValues(new ArrayList<>());
		while (true) {
			System.out.print("\nEnter a command:> ");
			String[] command = scanner.nextLine().replaceAll("\\s+", " ").split(" ");
			try { 
				if (command.length >= 1) {
					switch (Command.valueOf(command[0].toUpperCase())) {
						case KEYS:
							DictionaryService.keys(command, dictionary);
							break;
						case ADD:
							DictionaryService.add(command, dictionary);
							break;
						case ALLMEMBERS:
							DictionaryService.allMembers(command, dictionary);
							break;
						case CLEAR:
							DictionaryService.clear(command, dictionary);
							break;
						case ITEMS:
							DictionaryService.items(command, dictionary);
							break;
						case KEYEXISTS:
							DictionaryService.keyExists(command, dictionary);
							break;
						case MEMBERS:
							DictionaryService.members(command, dictionary);
							break;
						case REMOVE:
							DictionaryService.remove(command, dictionary);
							break;
						case REMOVEALL:
							DictionaryService.removeAll(command, dictionary);
							break;
						case VALUEEXISTS:
							DictionaryService.valueExists(command, dictionary);
							break;
						default:
							break;
					
					}
				}
			} catch (IllegalArgumentException ex) {
				System.out.println("You have entered an invalid command. Please try again.\n\n");
			}
			
			
		}
	}
}
