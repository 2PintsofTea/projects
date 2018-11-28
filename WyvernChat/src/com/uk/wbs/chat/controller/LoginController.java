package com.uk.wbs.chat.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.uk.wbs.chat.WyvernChat;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginController implements Initializable, Controller {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	@Override
	public String getName() {
		return "LoginController";
	}

	@FXML
	public void login() {
		WyvernChat.getInstance().getSceneManager().setScene(WyvernChat.getInstance().getSceneManager().getScene("app"));
	}
	
	@FXML
	public void close() {
		WyvernChat.getInstance().getConsoleLogger().log("Close button pressed, exiting...");
		WyvernChat.getInstance().close();
	}
	
}
