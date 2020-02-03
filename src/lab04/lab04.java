package lab04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class lab04 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane main = new GridPane();
        main.setPadding(new Insets(11, 300, 75, 11 ));
        main.setHgap(10);
        main.setVgap(5);

        Label usernameLabel = new Label("Username:");
        main.setConstraints(usernameLabel, 0, 0);
        TextField usernameTextField = new TextField ();
        usernameTextField.setPromptText("Please enter your username:");
        main.setConstraints(usernameTextField, 1, 0);

        Label passwordLabel = new Label("Password:");
        main.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordField = new PasswordField ();
        passwordField.setPromptText("Please enter your password:");
        main.setConstraints(passwordField, 1, 1);

        Label fullnameLabel = new Label("Full Name:");
        main.setConstraints(fullnameLabel, 0, 2);
        TextField fullnameTextField = new TextField ();
        fullnameTextField.setPromptText("Please enter your full name:");
        main.setConstraints(fullnameTextField, 1, 2);

        Label emailLabel = new Label("E-Mail:");
        main.setConstraints(emailLabel, 0, 3);
        TextField emailTextField = new TextField ();
        emailTextField.setPromptText("Please enter your E-Mail: ");
        main.setConstraints(emailTextField, 1, 3);

        Label phonenumLabel = new Label("Phone #:");
        main.setConstraints(phonenumLabel, 0, 5);
        TextField phonenumTextField = new TextField ();
        phonenumTextField.setPromptText("Please enter your phone number: ");
        main.setConstraints(phonenumTextField, 1, 5);

        Label birthdayLabel = new Label("Date of Birth:");
        main.setConstraints(birthdayLabel, 0, 6);
        DatePicker birthdayDatePicker = new DatePicker();
        birthdayDatePicker.setPromptText("Please enter your birthday: ");
        main.setConstraints(birthdayDatePicker, 1, 6);

        Button btReg = new Button("Register");
        main.setConstraints(btReg, 1, 7);
        btReg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Username: " + usernameTextField.getText());
                System.out.println("Password: " + passwordField.getText());
                System.out.println("Full name: " + fullnameTextField.getText());
                System.out.println("Phone number: " + phonenumTextField.getText());
                System.out.println("Birthday: " + birthdayDatePicker.getValue());
            }
        });


        main.getChildren().addAll(usernameLabel, usernameTextField);
        main.getChildren().addAll(passwordLabel, passwordField);
        main.getChildren().addAll(fullnameLabel, fullnameTextField);
        main.getChildren().addAll(emailLabel, emailTextField);
        main.getChildren().addAll(phonenumLabel, phonenumTextField);
        main.getChildren().addAll(birthdayLabel, birthdayDatePicker);
        main.getChildren().add(btReg);

        Scene scene = new Scene(main);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab 04 Solution");
        primaryStage.show();
    }
}
