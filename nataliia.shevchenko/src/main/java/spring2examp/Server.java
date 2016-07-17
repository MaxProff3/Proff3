package spring2examp;

import org.springframework.stereotype.Component;

@Component("server")
public class Server implements Start {

	@Override
	public void start() {
		// System.out.println("StartRealisationServer.starting");
		int i = 1;
		System.out.println("Server" + i + " start work and ready to get new connection");
		
	}

}
