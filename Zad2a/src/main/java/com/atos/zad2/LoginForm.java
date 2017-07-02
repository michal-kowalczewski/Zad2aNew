package com.atos.zad2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class LoginForm extends Application{
	@Override
	public void start(final Stage primaryStage) throws Exception{
		GridPane form = new GridPane();
		form.setPadding(new Insets(0,10,10,10));
		form.setVgap(5);
		form.setHgap(5);
		form.setAlignment(Pos.CENTER);
		Scene scene = new Scene (form, 300, 300);

		Label loginLabel = new Label("Login");
		loginLabel.setMaxWidth(Double.MAX_VALUE);
		loginLabel.setAlignment(Pos.CENTER);
		GridPane.setConstraints(loginLabel, 0, 0);

		final TextField loginTextField = new TextField();
		loginTextField.setPromptText("Enter your login");
		GridPane.setConstraints(loginTextField, 0, 1);

		Label passwordLabel = new Label("Password");
		passwordLabel.setMaxWidth(Double.MAX_VALUE);
		passwordLabel.setAlignment(Pos.CENTER);
		GridPane.setConstraints(passwordLabel, 0, 2);

		final TextField passwordTextField = new TextField();
		passwordTextField.setPromptText("Enter your password");
		GridPane.setConstraints(passwordTextField, 0,3);

		Button loginButton = new Button("Log In");
		loginButton.setMaxWidth(Double.MAX_VALUE);
		loginButton.setAlignment(Pos.CENTER);
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				Alert alert = new Alert(Alert.AlertType.NONE, null);
				alert.getDialogPane().getButtonTypes().add(ButtonType.OK);

				String login, password;
				login = loginTextField.getText();
				password = passwordTextField.getText();

				if(verifyUser(login, password) == true)
				{
					alert.setContentText("HelloWorld");
				}
				else
				{
					alert.setContentText("Wrong Credentials");
				}

				alert.showAndWait();

			}
		});
		GridPane.setConstraints(loginButton, 0,9);


		Button cancelButton = new Button("Cancel");
		cancelButton.setMaxWidth(Double.MAX_VALUE);
		cancelButton.setAlignment(Pos.CENTER);
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				primaryStage.close();
			}
		});
		GridPane.setConstraints(cancelButton, 0,10);

		form.getChildren().addAll(
				loginLabel,
				loginTextField,
				passwordLabel,
				passwordTextField, 
				loginButton,
				cancelButton
				);

		primaryStage.setTitle("Zad 2b");
		primaryStage.setScene(scene);
		primaryStage.show();
		form.requestFocus();
	}	

	private boolean verifyUser(String login, String password)
	{
		File file = new File("..\\Zad2a\\users.xml");
		XmlMapper xmlMapper = new XmlMapper();			

		TypeReference<List<User>> ref = new TypeReference<List<User>>() {};
		try{
			List<User> users = xmlMapper.readValue(file, ref);
			for(int i=0; i<users.size(); i++)
			{
				if(login.equals(users.get(i).getLogin()) && password.equals(users.get(i).getPassword()))
				{
					return true;
				}
			}
		}

		catch(Exception e){
			System.out.println(e);
		}

		return false;
	}


	public static void main(String[] args){
		launch(args);
	}

}
