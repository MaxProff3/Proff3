package ThirdWeek;

public class Client {
	 private static Client [] clients=new Client[3];
	//private  static Client client;
	 private static int pos;
	
	private Client(){	
	};
	private static boolean FindNull(){
		for(int i=0;i<clients.length;i++){
			if(clients[i]==null){
				Client.pos=i;
				return true;
			}
		}
		return   false;
	}
	
	public static Client getInstance(){
		if(Client.FindNull()){
			clients[pos]=new Client();
			//return clients[pos];
		}
	//	return client;
		return clients[pos];
		
}
}