package homeWork3;
/*
	Задание 1. Создать класс Server, на основе шаблона синглтон. 
 */

public class Server {

	private static Server serv;

	private Server() {
	}

	public static Server getInstance() {
		if (serv == null) {
			serv = new Server();
		}
		return serv;
	}

}
