public class Run {
	public static String[] model = new String[10];
	public static int count = 0;
	
	public static void main(String[] args) {
		testRemoveTodo();
	}
	
	/**
	 * Display todo list
	 */
	public static void showTodoList() {
		/**
		 * Display exists data
		 */
		System.out.println("TODO LIST");
		count = 0;
		for (int i = 0; i < model.length; i++) {
			if (model[i] != null) {
				count += 1;
				System.out.println((i + 1) + ". " + model[i]);
			}
		}
	}
	
	public static void testShowTodoList() {
		model[0] = "OOP";
		model[1] = "Java";
		
		showTodoList();
	}
	
	/**
	 * Add data to todo list
	 *
	 * @param todo
	 */
	public static void addTodo(String todo) {
		/**
		 *Check model memory
		 */
		var isFull = true;
		for (int i = 0; i < model.length; i++) {
			if (model[i] == null) {
				isFull = false;
				break;
			}
		}
		
		/**
		 * Increase model memory
		 */
		if (isFull) {
			var temp = model;
			model = new String[model.length * 2];
			
			for (int i = 0; i < temp.length; i++) {
				model[i] = temp[i];
			}
		}
		
		/**
		 * Add data to latest index
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
			addTodo("Java OOP " + (i + 1));
		}
		
		showTodoList();
	}
	
	/**
	 * Remove data from todo list
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
				for (int i = idx; i < count; i++) {
					if (i == count) {
						model[idx] = null;
						return true;
					} else {
						model[i] = model[number];
					}
				}
//				System.out.println("Data " + number + ". " + model[idx] + " has been deleted");
				showTodoList();
				return true;
			}
		} else {
			System.out.println("Data start from 1-" + count);
			return false;
		}
	}
	
	public static void testRemoveTodo() {
		addTodo("Java");
		addTodo("OOP");
		addTodo("Is");
		addTodo("Fun");
		
		showTodoList();
		removeTodo(5);
	}
	
	/**
	 * View menu todo list
	 */
	public static void viewShowTodoList() {
	
	}
	
	/**
	 * View menu for add todo
	 */
	public static void viewAddTodo() {
	
	}
	
	/**
	 * View menu for remove todo
	 */
	public static void removeTodo() {
	
	}
}
