package ThirdWeek;



//Class as likeas singleton
public class Server {
	private static Server serv;
	private  String pass="111";
	
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	private Server(){
		this.pass=pass;
	}
	
	public static  Server getInstance(){
		if(serv==null){
			serv=new Server();
		}
		return serv;
	}

}

