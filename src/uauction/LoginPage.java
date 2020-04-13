/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uauction;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author poomy
 */
public class LoginPage {
    static public void display(){
        Stage loginStage = new Stage();
            loginStage.setTitle("Login & Register");

            GridPane loginGrid = new GridPane();
            loginGrid.setPadding(new Insets(15));
            loginGrid.setVgap(5);
            loginGrid.setHgap(5);
            
            ColumnConstraints cons1 = new ColumnConstraints();
            cons1.setHgrow(Priority.NEVER);
            loginGrid.getColumnConstraints().add(cons1);

            ColumnConstraints cons2 = new ColumnConstraints();
            cons2.setHgrow(Priority.ALWAYS);

            loginGrid.getColumnConstraints().addAll(cons1, cons2);

            RowConstraints rcons1 = new RowConstraints();
            rcons1.setVgrow(Priority.NEVER);

            RowConstraints rcons2 = new RowConstraints();
            rcons2.setVgrow(Priority.NEVER);

            loginGrid.getRowConstraints().addAll(rcons1, rcons2);
            
            
            //Variable
            Label labelLogin = new Label("Please enter your username and password here");
            Label labelUserName = new Label("Username: ");
            Label labelPassword = new Label("Password: ");
            TextField username = new TextField();
            PasswordField password = new PasswordField();
            username.setPromptText("Game hua kuy");
            Button loginBtn = new Button("Login");
            loginBtn.setMaxSize(50, 50);
            
            Label labelRegister = new Label("If you are new, please Registor here");
            Label labelCreateUsername = new Label("Create Username:");
            Label labelCreatePassword = new Label("Create Password:");
            Label labelRepeatPassword = new Label("Repeat your Password:");
            Label labelEmail = new Label("Email:");
            TextField createUsername = new TextField();
            createUsername.setPromptText("Game");
            PasswordField createPassword = new PasswordField();
            PasswordField repeatPassword = new PasswordField();
            TextField email = new TextField();
            email.setPromptText("apple@hotmail.com");
            Line line = new Line(420, 5, 0, 0);
            Button registerBtn = new Button("Register");
            
            
            loginGrid.add(labelLogin, 0, 0, 2, 1);
            loginGrid.add(labelUserName, 0, 1);
            loginGrid.add(labelPassword, 0, 2);
            loginGrid.add(username, 1, 1);
            loginGrid.add(password, 1, 2);
            loginGrid.add(loginBtn, 2, 1, 2, 2);
            
            loginGrid.add(line, 0, 3, 3, 1);
            loginGrid.add(labelRegister, 0, 4, 2, 1);
            loginGrid.add(labelCreateUsername, 0, 5);
            loginGrid.add(labelCreatePassword, 0, 6);
            loginGrid.add(labelRepeatPassword, 0, 7);
            loginGrid.add(labelEmail, 0, 8);
            loginGrid.add(createUsername, 1, 5);
            loginGrid.add(createPassword, 1, 6);
            loginGrid.add(repeatPassword, 1, 7);
            loginGrid.add(email, 1, 8);
            loginGrid.add(registerBtn, 2, 8, 2, 2);
            
            
            Scene loginScene = new Scene(loginGrid, 450, 300);
            loginStage.setScene(loginScene);
            loginStage.showAndWait();
    }
    
    private void save(){
        
    }
    
    
}
