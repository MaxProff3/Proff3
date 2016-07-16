package spring2examp;

import org.springframework.stereotype.Component;

@Component("client")
public class Client implements Start {

	@Override
	public void start() {
		// System.out.println("StartRealisationClient.starting");
	  int i = 1;
	  System.out.println("Client" + i + " start work and ready to get new connection");

	}

}
