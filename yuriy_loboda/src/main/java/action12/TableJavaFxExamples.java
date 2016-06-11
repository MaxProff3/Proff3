package action12;

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
            
            
             /*
              https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
              * */
             ObservableList<Product1> list = FXCollections.observableArrayList(
                        new Product1(1, "Р С‹Р±Р°", "023"),
                        new Product1(2, "РљРѕР»Р±Р°СЃР°", "184"),
                        new Product1(3, "РћРіСѓСЂРµС†", "741"),
                        new Product1(4, "РЎР°СЂРґРµР»СЊРєРё", "541")
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
 

 


