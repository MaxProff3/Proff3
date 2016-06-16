package hw6;

import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ContructorDAO;
import dao.ContructorDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Contructor;
import domain.Order;
import domain.Product;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.ContructorServiceImpl;
import service.OrderServiceImpl;
import service.ProductServiceImpl;
import util.HibernateUtil;

public class StartHW6FX extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("HW6");
		stage.setScene(createScene());
		stage.show();
	}

	private Tab tabStep1;
	private Tab tabStep2;
	private Tab tabStep3;
	private Tab tabStep4;
	private Tab tabStep5;
	
	private Scene createScene() {
		TabPane tabPane = new TabPane();
		
		tabStep1 = new Tab("Step 1 >>");
		tabStep1.setContent(getStep1Box());
		tabPane.getTabs().add(tabStep1);

		tabStep2 = new Tab("Step 2 >>");
		tabStep2.setContent(getStep2Box());
		//tabStep2.setDisable(true);
		tabPane.getTabs().add(tabStep2);

		tabStep3 = new Tab("Step 3 >>");
		tabStep3.setContent(getStep3Box());
		tabPane.getTabs().add(tabStep3);

		tabStep4 = new Tab("Step 4 >>");
		tabStep4.setContent(getStep4Box());
		tabPane.getTabs().add(tabStep4);

		tabStep5 = new Tab("Step 5");
		tabStep5.setContent(new GridPane());
		tabPane.getTabs().add(tabStep5);
		
		return new Scene(tabPane,700,500);
	}
	
	private VBox vboxStep1;
	private Label titleLbl;
	private TextField login;
	private TextField password;
	private Button logInBtn;
	
	public VBox getStep1Box(){
		vboxStep1 = new VBox(30);
		vboxStep1.setAlignment(Pos.CENTER);
		
		titleLbl = new Label("PROFF3");
		titleLbl.setStyle("-fx-font-size:20px;-fx-text-fill:rgb(128, 0, 0)");
		
		login = new TextField();
		login.setPromptText("Login");
		login.setMaxWidth(200);
		
		password = new TextField();
		password.setPromptText("Password");
		password.setMaxWidth(200);
		
		logInBtn = new Button("Log In");
		logInBtn.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		       if(!login.getText().equals("") && !password.getText().equals("")){
		    	   	Locale.setDefault(Locale.ENGLISH);
		    	   	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		   			Session session = null;
		   			try{
		   				session = sessionFactory.openSession();
		   				///////////////
		   				
		   			}catch (HibernateException e1) {
		   				System.out.println("Error!!!");
		   				e1.printStackTrace();
		   			}finally {
		   				if (session != null) {
		   					session.close();
		   				}
		   				if (sessionFactory != null) {
		   					sessionFactory.close();
		   				}
		   				System.out.println("Session is closed!");
		   			}
		       }
		    }
		});
		vboxStep1.getChildren().addAll(titleLbl, login, password, logInBtn);
		
		return vboxStep1;
	}
	
	private HBox vboxStep2;
	private List<Product> productsList;
	private ObservableList<ObservableProduct> productsObservableList;
	private TableView<ObservableProduct> productTable;
	private TableColumn<ObservableProduct, String> productNameColumn;
	private TableColumn<ObservableProduct, Integer> productCodeColumn;
	
	@SuppressWarnings("unchecked")
	public HBox getStep2Box(){
		vboxStep2 = new HBox(20);
		
		Locale.setDefault(Locale.ENGLISH);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		/*Session session = null;*/
		
		try{
			ProductDao pDao = new ProductDaoImpl(sessionFactory);
			ProductServiceImpl pService = new ProductServiceImpl(pDao);
			productsList = pService.getAllProducts();
			System.out.println(">>productsList: "+productsList);
			
		}catch (HibernateException e) {
			System.out.println("Error!!!");
			e.printStackTrace();
		}/*finally {
			if (session != null) session.close();
			if (sessionFactory != null) sessionFactory.close();
			System.out.println("Session is closed!");
		}*/

		productsObservableList = FXCollections.observableArrayList();
		for(int i=0;i<productsList.size();i++){
			productsObservableList.add(new ObservableProduct(productsList.get(i)));
		}
		
		productTable = new TableView<ObservableProduct>();
		productTable.setEditable(true);
		productTable.setPrefWidth(300);
		
		productCodeColumn = new TableColumn<ObservableProduct,Integer>("Code");
		productCodeColumn.setCellValueFactory(new PropertyValueFactory <ObservableProduct,Integer>("code"));
		productCodeColumn.setEditable(true);
		productCodeColumn.setPrefWidth(125);
		
		productNameColumn = new TableColumn<ObservableProduct,String>("Name");
		productNameColumn.setCellValueFactory(new PropertyValueFactory <ObservableProduct,String>("name"));
		productNameColumn.setEditable(true);
		productNameColumn.setPrefWidth(175);
		
		productTable.setItems(productsObservableList);
		productTable.getColumns().addAll(productCodeColumn, productNameColumn);

		vboxStep2.getChildren().addAll(productTable);
		
		return vboxStep2;
	}
	
	private HBox hboxStep3;
	private List<Contructor> contructorsList;
	private ObservableList<ObservableContructor> contructorsObservableList;
	private TableView<ObservableContructor> contructorTable;
	private TableColumn<ObservableContructor, String> contructorNameColumn;
	
	@SuppressWarnings("unchecked")
	public HBox getStep3Box(){
		hboxStep3 = new HBox();
		
		Locale.setDefault(Locale.ENGLISH);
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = null;*/
		
		try{
			ContructorDAO cDao = new ContructorDaoImpl();
			ContructorServiceImpl cService = new ContructorServiceImpl(cDao);
			contructorsList = cService.getAllContructors();
			System.out.println(">>contructorsList: "+contructorsList);
		}catch (HibernateException e) {
			System.out.println("Error!!!");
			e.printStackTrace();
		}/*finally {
			if (session != null) session.close();
			if (sessionFactory != null) sessionFactory.close();
			System.out.println("Session is closed!");
		}*/
		
		contructorsObservableList = FXCollections.observableArrayList();
		for(int i=0;i<contructorsList.size();i++){
			contructorsObservableList.add(new ObservableContructor(contructorsList.get(i)));
		}
		
		System.out.println(">>contructorsObservableList: "+ contructorsObservableList);
		
		contructorTable = new TableView<ObservableContructor>();
		contructorTable.setEditable(true);
		contructorTable.setPrefWidth(200);
		
		contructorNameColumn = new TableColumn<ObservableContructor,String>("Name");
		contructorNameColumn.setCellValueFactory(new PropertyValueFactory <ObservableContructor,String>("name"));
		contructorNameColumn.setEditable(true);
		contructorNameColumn.setMinWidth(200);
		
		contructorTable.setItems(contructorsObservableList);
		contructorTable.getColumns().addAll(contructorNameColumn);

		hboxStep3.getChildren().addAll(contructorTable);
		
		
		return hboxStep3;
	}
	
	private VBox vboxStep4;
	private List<Order> ordersList;
	private ObservableList<ObservableOrder> ordersObservableList;
	private TableView<ObservableOrder> orderTable;
	private TableColumn<ObservableOrder, String> orderNumberColumn;
	private TableColumn<ObservableOrder, String> orderContructorColumn;
	private TableColumn<ObservableOrder, Integer> orderUserIDColumn;
	private TableColumn<ObservableOrder, Integer> orderSummaColumn;
	
	public VBox getStep4Box(){
		vboxStep4 = new VBox(20);
		Locale.setDefault(Locale.ENGLISH);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();	
		Session session = null;
		
		try{
			session = sessionFactory.openSession();
			OrderDao orderDao = new OrderDaoImpl();
			OrderServiceImpl orderService = new OrderServiceImpl(orderDao);
			ordersList = orderService.getAllOrders();
			System.out.println(">>ordersList: "+ordersList);
		}catch (HibernateException e) {
			System.out.println("Error!!!");
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
			System.out.println("Session is closed!");
		}
		
		ordersObservableList = FXCollections.observableArrayList();
		for(int i=0;i<ordersList.size();i++){
			ordersObservableList.add(new ObservableOrder(ordersList.get(i)));
		}
		System.out.println(">>ordersObservableList: "+ ordersObservableList);
		
		orderTable = new TableView<ObservableOrder>();
		orderTable.setEditable(true);
		orderTable.setPrefHeight(200);
		
		orderNumberColumn = new TableColumn<ObservableOrder,String>("Number");
		orderNumberColumn.setCellValueFactory(new PropertyValueFactory <ObservableOrder,String>("number"));
		orderNumberColumn.setEditable(true);
		
		
		orderContructorColumn = new TableColumn<ObservableOrder,String>("Contructor");
		orderContructorColumn.setCellValueFactory(new PropertyValueFactory <ObservableOrder,String>("contructorName"));
		orderContructorColumn.setEditable(true);
		
		
		orderUserIDColumn = new TableColumn<ObservableOrder,Integer>("UserID");
		orderUserIDColumn.setCellValueFactory(new PropertyValueFactory <ObservableOrder,Integer>("userID"));
		orderUserIDColumn.setEditable(true);
		
		
		orderSummaColumn = new TableColumn<ObservableOrder,Integer>("Summa");
		orderSummaColumn.setCellValueFactory(new PropertyValueFactory <ObservableOrder,Integer>("summa"));
		orderSummaColumn.setEditable(true);
		
		
		orderTable.setItems(ordersObservableList);
		orderTable.getColumns().addAll(orderNumberColumn,orderContructorColumn,orderUserIDColumn,orderSummaColumn);

		vboxStep4.getChildren().addAll(orderTable);
		
		return vboxStep4;
	}
}

