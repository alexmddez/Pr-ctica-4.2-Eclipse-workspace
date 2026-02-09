import java.util.Scanner;

public class Input {
	private static Scanner keyboard = new Scanner(System.in);
	private static final String INT_ERROR = "\nEl valor introducido no es un numero";
	private static final String CONTINUE = "\nPulse 'enter' para continuar";
	
	
	public static int getInt() {
		int number = -1;
		try {
			number = Integer.parseInt(keyboard.nextLine().trim());
		} catch (Exception e) {
			System.out.println(INT_ERROR);
		}
		return number;
	}

	
	public static int getInt(String text) {
		int number = -1;
		System.out.print(text);
		try {
			number = Integer.parseInt(keyboard.nextLine().trim());
		} catch (Exception e) {
			System.out.println(INT_ERROR);
		}
		return number;
	}
	
		public static int getInt(String text, boolean repeat) {
		int number = -1;
		boolean success = false;
		do {
			System.out.print(text);
			try {
				number = Integer.parseInt(keyboard.nextLine().trim());
				success = true;
			} catch (Exception e) {
				System.out.println(INT_ERROR);
				if(!repeat) {
					return -1;
				}
			}
		} while(!success);
		return number;
	}

	
	public static String getString() {
		String value = keyboard.nextLine().trim();
		return value;
	}

	
	public static String getString(String text) {
		System.out.print(text);
		return keyboard.nextLine().trim();
	}

	
	public static void toContinue() {
		System.out.print(CONTINUE);
		try {
			System.in.read();
		} catch (Exception e) {
			
		}
	}
}

