package lab05;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class lab05 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        TableView table = new TableView();

        TableColumn<String, StudentRecord> col1 = new TableColumn<>("Student ID");
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Double, StudentRecord> col2 = new TableColumn<>("Assignment");
        col2.setCellValueFactory(new PropertyValueFactory<>("Assignment"));

        TableColumn<Double, StudentRecord> col3 = new TableColumn<>("Midterm");
        col3.setCellValueFactory(new PropertyValueFactory<>("Midterm"));

        TableColumn<Double, StudentRecord> col4 = new TableColumn<>("Final Exam");
        col4.setCellValueFactory(new PropertyValueFactory<>("finalexam"));

        TableColumn<Double, StudentRecord> col5 = new TableColumn<>("Final Mark");
        col5.setCellValueFactory(new PropertyValueFactory<>("finalmark"));

        TableColumn<String, StudentRecord> col6 = new TableColumn<>("Letter Grade");
        col6.setCellValueFactory(new PropertyValueFactory<>("grade"));


        table.getColumns().add(col1);
        table.getColumns().add(col2);
        table.getColumns().add(col3);
        table.getColumns().add(col4);
        table.getColumns().add(col5);
        table.getColumns().add(col6);

        ObservableList list = new DataSource().getAllMarks();

        for(int i = 0; i < list.size(); i++){
            table.getItems().add(list.get(i));
        }

        VBox vbox  = new VBox(table);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class DataSource {
    public static ObservableList<StudentRecord> getAllMarks() {
        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        // Student ID, Assignments, Midterm, Final exam
         marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
         marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
         marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
         marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
         marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
         marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
         marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
         marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
         marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
         marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));
         return marks;
    }
}
