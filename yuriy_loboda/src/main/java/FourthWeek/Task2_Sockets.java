package FourthWeek;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;



/*

2. Написать "сервер", который умеет многопоточно выполнять задачи:
 а) Считывать информацию с консоли. 
  Он считывает число и номер клиента.
  После считывания, строка отправляется на клиент с соответсвующим номером.
 b) Умеет "ждать" подключения нового клиента, при новом подключении клиента, 
  сокет соединения помещается в новый поток для "общения сокета клиента и сокета сервера".
 с) Класс потока для общения с клиентом
  (для каждого клиента сервер выделяет новый сокет дял общения)
Также написать класс "клиент", который соединяется с сервером. Задача клиента принять строку, преобразовать ее в число.
И если это клиент1, то вернуть на сервер удвоенное. Клиент2 отправляет на сервер значение умноженное на 10.

*/
public class Task2_Sockets {

	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 3230;
		new Server(port).start();
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//int id = Integer.parseInt(reader.readLine());	
		//new ClientBuilder().setHost("localhost").setPort(port).setId(id).build().connect();
		
	}
}
	 class Server extends Thread{
		private int port;
		private ServerSocket server;
		 private String IP;
		
		 Server(int port){
			this.port=port;
		}
		
		@Override
		public void run(){
			try {
				Client cl1 =new ClientBuilder().setHost("localhost").setPort(port).setId(1).build();
				Client cl2 =new ClientBuilder().setHost("localhost").setPort(port).setId(2).build();
				server=new ServerSocket(port);
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				int id = Integer.parseInt(reader.readLine());	
				if(id==1){
					cl1.start();
				}
				if(id==2){
					cl2.start();
				}
				//Client cl1 =new ClientBuilder().setHost("localhost").setPort(port).setId(id).build();
				//cl1.start();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while (true){
				try {
					 
					
					Socket socket = server.accept();
					new ClientForServer(socket).start();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
					
		}
	
	}
	 
	 
	 class ClientBuilder{
		 private int id;
		 private int port;
		 private String host;
		 private Socket socket;
		 private Client cl;
		 
		 public ClientBuilder setHost(String host){
			 this.host=host;
			 return this;
		 }
		 
		 public ClientBuilder setPort(int port){
			 this.port=port;
			 return this;
		 }
		 public ClientBuilder setId(int id){
			 this.id=id;
			 return this;
		 }
		 
		 public Client build(){
			 cl=Client.getInstance();
			 cl.setHost(host);
			 cl.setPort(port);
			 cl.setId(id);
			 cl.setSocket(socket);
			 return cl;
		 }
		 
	 }
	 
	 
	 class Client extends Thread {
		 private int id;
		 private int port;
		 private String host;
		 private Socket socket;
		 private static Client [] clients = new Client [2];
		 private static int pos;
		
	private Client(){};
	
		 public static Client getInstance(){
			 for(int i=0;i<clients.length;i++){
				 if(clients[i]==null){
					 pos=i;
					 clients[i]=new Client();
					 return clients[i];
				 }
			 }
			 return clients[pos];
		 }
		 
		 
		 
		public long getId(){
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public Socket getSocket() {
			return socket;
		}

		public void setSocket(Socket socket) {
			this.socket = socket;
		}

		public static Client findById(int id){
			 return clients[id-1];
		 }
		 
		 @Override
		 public void run () {
			  try {
				socket = new Socket(host,port);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 while(true){
				 try {
					InputStream is = socket.getInputStream();
					DataInputStream dis= new DataInputStream(is);
					String chisloS=dis.readUTF();
				//	String idS=dis.readUTF();
					
					int chislo = Integer.parseInt(chisloS);
				//	int id = Integer.parseInt(idS);
					System.out.println("Привет из клиента число - "+ chislo);
					System.out.println("Привет из клиента id - "+ id);
					if(id==1){
						chislo*=2;

						System.out.println(this.getId());
					}
					if(id==2){
						chislo*=10;
						System.out.println(this.getId());
						
					}
					OutputStream os = socket.getOutputStream();
					DataOutputStream dos= new DataOutputStream(os);
				
					dos.writeInt(chislo);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
			 
		 }
	 }

	 class ClientForServer extends Thread{
		 private Socket socket;
		
		 
		 ClientForServer(Socket socket){
			 this.socket=socket;
			 
		 }
		 @Override
		  public void run(){
			 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			 try {
				
				String chislo = reader.readLine();
				
			//	String id =reader.readLine();
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos=new DataOutputStream(os);
				dos.writeUTF(chislo);
			//	dos.writeUTF(id);
				
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
			    int chislo_end=	dis.readInt();
				System.out.println("Окончательное число :" +chislo_end);
				
				
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 
	
}

