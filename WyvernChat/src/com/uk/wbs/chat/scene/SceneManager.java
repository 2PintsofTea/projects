package com.uk.wbs.chat.scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.uk.wbs.chat.WyvernChat;
import com.uk.wbs.chat.controller.AppController;
import com.uk.wbs.chat.controller.Controller;
import com.uk.wbs.chat.controller.LoginController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneManager {
	
	private Map<String, Scene> scenes = new HashMap<>();
	private Map<String, Controller> load = new HashMap<>();
	private Stage stage;

	public SceneManager(Stage stage) throws IOException {
		load.put("login", new LoginController());
		load.put("app", new AppController());
		
		this.loadScenes();
        this.stage = stage;
        stage.setScene(this.getScene("login"));
        stage.setResizable(false);
        stage.setTitle("WyvernChat");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
	}
	
	public Scene getScene(String name) {
		return scenes.get(name);
	}
	
	public void setScene(Scene scene) {
		this.stage.setScene(scene);
		this.stage.centerOnScreen();
	}
	
	private void loadScenes() throws IOException {
		for(String name : load.keySet()) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/assets/fxml/" + name + ".fxml"));
			Controller controller = load.get(name);
			if(controller != null) {
				loader.setController(load.get(name));
			}
			Parent parent = loader.load();
			this.scenes.put(name, new Scene(parent));
			WyvernChat.getInstance().getConsoleLogger().log("Loaded scene " + name + (controller != null ? " with controller " + controller.getName() : "."));
		}
	}
	
	public Stage getStage() {
		return this.stage;
	}

	public void closeStage() {
		stage.close();
	}
	
}
