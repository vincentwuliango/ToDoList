import java.util.Scanner;

public class Run {
	public static String[] model = new String[10];
	public static int count = 0;
	
	public static void main(String[] args) {
		viewShowTodoList();
	}
	
	/**
	 * Display todo list
	 */
	public static void showTodoList() {
		count = 0;
		System.out.println("TODO LIST");
		for (int i = 0; i < model.length; i++) {
			/**
			 * Only display non-null model
			 */
			if (model[i] != null) {
				count += 1;
				System.out.println(i + 1 + ". " + model[i]);
			}
		}
	}
	
	public static void testShowTodoList() {
		model[0] = "OOP";
		model[1] = "Todo";
		
		showTodoList();
	}
	
	/**
	 * Add todo
	 *
	 * @param todo
	 */
	public static void addTodo(String todo) {
		/**
		 * Check model memory size left
		 */
		var isFull = true;
		for (int i = 0; i < model.length; i++) {
			if (model[i] == null) {
				isFull = false;
				break;
			}
		}
		
		/**
		 * if full, add memory size
		 */
		if (isFull) {
			var temp = model;
			model = new String[model.length * 2];
			
			for (int i = 0; i < temp.length; i++) {
				model[i] = temp[i];
			}
		}
		
		/**
		 * Add data to latest model index
		 */
		for (int i = 0; i < model.length; i++) {
			if (model[i] == null) {
				model[i] = todo;
				break;
			}
		}
	}
	
	public static void testAddTodo() {
		for (int i = 0; i < 25; i++) {
			addTodo("Todo");
		}
		
		showTodoList();
	}
	
	/**
	 * remove todo
	 *
	 * @param number
	 */
	public static boolean removeTodo(Integer number) {
		if (number > 0) {
			var idx = number - 1;
			if (model[idx] == null) {
				System.out.println("No data found");
				return false;
			} else {
				for (int i = idx; i < model.length; i++) {
					if (i == count) {
						model[idx] = null;
						return true;
					} else {
						model[i] = model[number];
					}
				}
				System.out.println("Data " + number + ". " + model[idx] + " has been deleted");
				showTodoList();
				return true;
			}
		} else {
			System.out.println("Data start from 1-" + count);
			return false;
		}
	}
	
	public static void testRemoveTodo() {
		addTodo("One");
		addTodo("Two");
		addTodo("Three");
		addTodo("Four");
		addTodo("Five");
		addTodo("Six");
		
		showTodoList();
		removeTodo(1);
		removeTodo(5);
	}
	
	public static String input(String info) {
		System.out.print(info + " : ");
		Scanner scan = new Scanner(System.in);
		String data = scan.nextLine();
		return data;
	}
	
	public static void testInput() {
		System.out.println("Hi " + input("Name"));
	}
	
	public static void viewShowTodoList() {
		var choice = true;
		
		while (choice) {
			showTodoList();
			
			System.out.println("Menu");
			System.out.println("1. Add");
			System.out.println("2. Remove");
			System.out.println("x. Exit");
			
			var input = input("Input: ");
			
			switch (input) {
				case "1":
					viewAddTodo();
					break;
				case "2":
					viewRemoveTodo();
					break;
				case "x":
					choice = false;
					System.out.println("Close program...");
					break;
				default:
					System.out.println("Wrong input");
			}
		}
	}
	
	public static void testViewTodoList() {
		addTodo("One");
		addTodo("Two");
		addTodo("Three");
		addTodo("Four");
		
		viewShowTodoList();
	}
	
	public static void viewAddTodo() {
		System.out.println("ADD TODO");
		var todo = input("Todo (x to exit): ");
		
		if (todo.equals("x")) {
			System.out.println("Back to main menu");
		} else {
			addTodo(todo);
		}
	}
	
	public static void testViewAddTodo() {
		addTodo("One");
		
		viewAddTodo();
		showTodoList();
	}
	
	public static void viewRemoveTodo() {
		System.out.println("REMOVE TODO");
		
		if (count <= 0) {
			System.out.println("No data");
			return;
		}
		
		var number = input("Choose " + "[1-" + count + "]" + " (x to exit)");
		
		if (number.equals("x")) {
			System.out.println("Back to main menu");
		} else {
			boolean success = removeTodo(Integer.valueOf(number));
			if (!success) {
				System.out.println("Remove todo failed, " + number);
			} else {
				System.out.println("Delete success");
			}
		}
	}
	
	public static void testViewRemoveTodo() {
		addTodo("One");
		addTodo("Two");
		addTodo("Three");
		
		showTodoList();
		viewRemoveTodo();
		showTodoList();
	}
}
