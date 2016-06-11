package HW6;

import java.util.List;

import dao.ContructorDao;
import dao.ContructorDaoImpl;
import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.Order_positionDao;
import dao.Order_positionDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import domain.Contructor;
import domain.Order;
import domain.Order_position;
import domain.Product;
import domain.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import services.ContructorServ;
import services.ContructorServImpl;
import services.OrderServImpl;
import services.Order_positionServ;
import services.Order_positionServImpl;
import services.ProductService;
import services.ProductServiceImpl;

public class HelpClass  {
	public static Group getTab2(){
		
		Group grid = new Group();
		VBox v=new VBox();
		TextField name = new TextField();
		TextField barcode = new TextField();
		Button add = new Button("Добавить");
		Button del = new Button("Удалить");
		Button edit = new Button("Редактировать");
		add.setTranslateX(300);
		add.setTranslateY(5);
		del.setTranslateX(300);
		del.setTranslateY(10);
		edit.setTranslateX(300);
		edit.setTranslateY(15);
		name.setTranslateX(20d);
		name.setTranslateY(10d);
		barcode.setTranslateX(20d);
		barcode.setTranslateY(40d);
		
		
		
		TableView table=new TableView();
		TableColumn firstNameCol = new TableColumn("id");
        TableColumn secondNameCol = new TableColumn("name");
        TableColumn thirdNameCol = new TableColumn("code");
        
        ProductDao pDao=new ProductDaoImpl();
        ProductService pServ= new ProductServiceImpl(pDao);
        
        List<Product> listP = pServ.getAllProducts();
        ObservableList<Product> list=  FXCollections.observableArrayList(listP);
        
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
        secondNameCol.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        thirdNameCol.setCellValueFactory(new PropertyValueFactory<Product,Integer>("barcode"));
        
		table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		table.setItems(list);
		
		add.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				String name1=name.getText();
				int barcode1=Integer.parseInt(barcode.getText());
				Product product = new Product(name1,barcode1);
				pServ.addNewProduct(product);
				list.add(product);
			
				
				}
		});
		
		del.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				Product p =(Product) table.getFocusModel().getFocusedItem();
				pServ.deleteProduct(p);
				list.remove(table.getFocusModel().getFocusedItem());
				}
		});
		
		edit.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {			
				
				Product p =(Product) table.getFocusModel().getFocusedItem();			
				if(!name.getText().equals("")){
					String name1= name.getText();
					p.setName(name1);
				}
				if(!barcode.getText().equals("")){
					String barcode1 =barcode.getText();
					int bar = Integer.parseInt(barcode1);
					p.setBarcode(bar);
				}
			   	pServ.updateProduct(p);
			   
				}
		});
		v.getChildren().add(table);
		v.getChildren().add(name);
		v.getChildren().add(barcode);
		v.getChildren().add(add);
		v.getChildren().add(del);
		v.getChildren().add(edit);
 		grid.getChildren().add(v);
 		
 		return grid;
	}
	public static Group getTab3(){
		Group grid = new Group();
		VBox v=new VBox();
		TextField name = new TextField();
		Button add = new Button("Добавить");
		Button del = new Button("Удалить");
		Button edit = new Button("Редактировать");
		add.setTranslateX(300);
		add.setTranslateY(5);
		del.setTranslateX(300);
		del.setTranslateY(10);
		edit.setTranslateX(300);
		edit.setTranslateY(15);
		name.setTranslateX(20d);
		name.setTranslateY(10d);
		
		
		TableView table=new TableView();
		TableColumn firstNameCol = new TableColumn("id");
        TableColumn secondNameCol = new TableColumn("name");
        
        ContructorDao cd = new ContructorDaoImpl();
        ContructorServ cServ = new ContructorServImpl(cd);
        
        List<Contructor> listC = cServ.getAllContructors();
        ObservableList<Contructor> list=  FXCollections.observableArrayList(listC);
        
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Contructor,Integer>("id"));
        secondNameCol.setCellValueFactory(new PropertyValueFactory<Contructor,String>("name"));
        
        table.getColumns().addAll(firstNameCol,secondNameCol);
        table.setItems(list);
        
        add.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				String name1=name.getText();
				Contructor contructor = new Contructor(name1);
				cServ.addNewContr(contructor);
				list.add(contructor);
			
				
				}
		});
        
        del.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				Contructor c=(Contructor) table.getFocusModel().getFocusedItem();
				cServ.deleteContr(c);
				list.remove(table.getFocusModel().getFocusedItem());
				}
		});
        edit.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {			
				
				Contructor c =(Contructor) table.getFocusModel().getFocusedItem();			
				if(!name.getText().equals("")){
					String name1= name.getText();
					c.setName(name1);
				}
				
			   	cServ.updateContr(c);
			   
				}
		});
        
		
		v.getChildren().add(table);
		v.getChildren().add(name);
		v.getChildren().add(add);
		v.getChildren().add(del);
		v.getChildren().add(edit);
 		grid.getChildren().add(v);
 		return grid;
	}
	
	  public static Group getTab4(){
		  Group grid = new Group();
		  VBox v=new VBox();
		  TextField number = new TextField("number");
		  TextField contructor = new TextField("contructor");
		  TextField user = new TextField("user");
		  TextField summa = new TextField("summa");
		  /*
		  number.setTranslateX(20d);
		  number.setTranslateY(10d);
		  contructor.setTranslateX(20d);
		  contructor.setTranslateY(200d);
		  user.setTranslateX(20d);
		  user.setTranslateY(300d);
		  summa.setTranslateX(20d);
		  summa.setTranslateY(40d);
		  */
		  TableView table = new TableView();
		  
		  
		  
		  TableColumn firstNameCol = new TableColumn("id");
	      TableColumn secondNameCol = new TableColumn("number");
	      TableColumn thirdNameCol = new TableColumn("contructor");
	      TableColumn fourthNameCol = new TableColumn("user");
	      TableColumn fifthNameCol = new TableColumn("summa");
	     
	      ListView list1 =new ListView();
	      list1.setTranslateX(400);
	      list1.setTranslateY(-400);
	      
	      OrderDao od = new OrderDaoImpl(); 
	      OrderServImpl oServ = new OrderServImpl(od);
	      /*
	      Order_positionDao op = new Order_positionDaoImpl();
	      Order_positionServ opServ= new Order_positionServImpl(op);
	      */
	      
	      List<Order> listO= oServ.getAllOrder();
	      ObservableList<Order> list=  FXCollections.observableArrayList(listO);
	        
	        firstNameCol.setCellValueFactory(new PropertyValueFactory<Order,Integer>("id"));
	        secondNameCol.setCellValueFactory(new PropertyValueFactory<Order,String>("number"));
	        thirdNameCol.setCellValueFactory(new PropertyValueFactory<Order,User>("user"));
	        fourthNameCol.setCellValueFactory(new PropertyValueFactory<Order,Contructor>("contructor"));
	        fifthNameCol.setCellValueFactory(new PropertyValueFactory<Order,Integer>("sum"));
	        
	        table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol,fourthNameCol,fifthNameCol);
	        table.setItems(list);
	        
	        
	        table.addEventHandler(MouseEvent.MOUSE_CLICKED,  new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					Order or = (Order) table.getFocusModel().getFocusedItem();
					ObservableList<Order_position> listP=  FXCollections.observableArrayList(or.getOrder_position());
					list1.setItems(listP);
					
					}
			});
	        
	        v.getChildren().add(table);
	        v.getChildren().add(list1);
			v.getChildren().add(number);
			v.getChildren().add(contructor);
			v.getChildren().add(user);
			v.getChildren().add(summa);
	 		grid.getChildren().add(v);
	        
	      return grid;
		  
      }
     
}
