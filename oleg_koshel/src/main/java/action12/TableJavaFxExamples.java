package action12;

import java.util.List;

import dao.ContructorDaoImpl;
import domain.Contructor;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ContructorServiceImpl;
 

public class TableJavaFxExamples extends Application{
       public static void main(String[] args) {
             launch();
       }
       @Override
       public void start(Stage stage) throws Exception {
             stage.setTitle("Table Example Application");
             stage.setScene(createScene3());
             stage.show();      
       }
 

       public Scene createScene1(){
             Group group = new Group();
            
             TableView table = new TableView();
             table.setEditable(true);
            
             TableColumn firstNameCol = new TableColumn("field 1");
             TableColumn secondNameCol = new TableColumn("field 2");
             TableColumn thirdNameCol = new TableColumn("field 3");
            
             table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
            
             group.getChildren().add(table);
            
            
             return new Scene(group,600,400);
       }
 

 

 

       public Scene createScene2(){
             Group group = new Group();
            
             TableView table = new TableView();
             //table.setEditable(true);
            
             TableColumn firstNameCol = new TableColumn("field 1");
             TableColumn secondNameCol = new TableColumn("field 2");
             TableColumn superNameCol = new TableColumn("super");
             TableColumn super1NameCol = new TableColumn("super1");
             TableColumn super2NameCol = new TableColumn("super2");
            
             superNameCol.getColumns().addAll(super1NameCol,super2NameCol);
             table.getColumns().addAll(firstNameCol,secondNameCol,superNameCol);
            
             group.getChildren().add(table);
            
            
             return new Scene(group,600,400);
       }
       public Scene createScene3(){
             Group group = new Group();
             
             TableView table = new TableView();
             table.setEditable(true);
            
             TableColumn firstNameCol = new TableColumn("id");
             TableColumn secondNameCol = new TableColumn("name");
             TableColumn thirdNameCol = new TableColumn("code");
            
            
             ContructorDaoImpl contructorDaoImpl =new ContructorDaoImpl();  
             ContructorServiceImpl contructorServiceImpl = new ContructorServiceImpl(contructorDaoImpl); 
             
             List<Contructor> contructorArray = contructorServiceImpl.getAllContructors();
             
             /*
              https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
              * */
             ObservableList<Contructor> list = FXCollections.observableArrayList(
//                        new Product1(1, "Рыба", "023"),
//                        new Product1(2, "Колбаса", "184"),
//                        new Product1(3, "Огурец", "741"),
//                        new Product1(4, "Сардельки", "541")
            		 
            		 contructorArray
            		 
                    );
            
             firstNameCol.setCellValueFactory(new PropertyValueFactory<Product1,Integer>("id"));
             secondNameCol.setCellValueFactory(new PropertyValueFactory<Product1,String>("name"));
             thirdNameCol.setCellValueFactory(new PropertyValueFactory<Product1,String>("code"));
            
             table.setItems(list);
            
             table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
            
             group.getChildren().add(table);
            
             return new Scene(group,600,400);
       }     
      
}