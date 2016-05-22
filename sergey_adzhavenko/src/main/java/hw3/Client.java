package hw3;

public class Client {

	private static Client client1;
	private static Client client2;
	private static Client client3;
	
	private Client(){}

	public static Client getInstancer(){
		if(client1==null)return client1=new Client();
		if(client2==null)return client2=new Client();
		if(client3==null)return client3=new Client();
		return anyClient();
	}
	private static Client anyClient(){
		int random = (int)(Math.random()*3);
		if(random==1)return client1;
		else if(random==2)return client2;
		else return client3;
	}
}
