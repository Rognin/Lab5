package commands;

import main.Main;

public class Help extends Command {

	String keyWord;

	public void onCall(String args) {
		getArgs(args);
		if (keyWord.equals("")) {
			System.out.println("	help : вывести справку по доступным командам\n" +
					"    info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
					"    show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
					"    add {element} : добавить новый элемент в коллекцию\n" +
					"    update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
					"    remove_by_id id : удалить элемент из коллекции по его id\n" +
					"    clear : очистить коллекцию\n" +
					"    save : сохранить коллекцию в файл\n" +
					"    execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
					"    exit : завершить программу (без сохранения в файл)\n" +
					"    add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
					"    remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
					"    history : вывести последние 6 команд (без их аргументов)\n" +
					"    max_by_id : вывести любой объект из коллекции, значение поля id которого является максимальным\n" +
					"    filter_less_than_description description : вывести элементы, значение поля description которых меньше заданного\n" +
					"    filter_greater_than_description description : вывести элементы, значение поля description которых больше заданного");
		}else{
			System.out.println(Main.commands.get(keyWord).getHelp());
		}
	}

	@Override
	public String getHelp() {
		return super.getHelp();
	}

	@Override
	public void getArgs(String args) {
		keyWord = args;
	}
}
