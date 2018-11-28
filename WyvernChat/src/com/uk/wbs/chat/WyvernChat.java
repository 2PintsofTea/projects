package com.uk.wbs.chat;

import com.uk.wbs.chat.logging.ConsoleLogger;
import com.uk.wbs.chat.logging.Logger;
import com.uk.wbs.chat.scene.SceneManager;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class WyvernChat extends Application {

	private static WyvernChat instance;
	private SceneManager sceneManager;
	private Logger consoleLogger;
	
	/**
	 * This is a fallback for older JRE versions which call main() instead of launch() when starting a JavaFX application
	 * Use the start(Stage stage) function for on start functionality
	 * 
	 * @param String[] args				Command line arguments
	 */
	public static void main(String[] args) {
		launch();
	}

	/**
	 * This is our start method, it is called when the application is ran and should be used to initalise all of our managers
	 */
	@Override
	public void start(Stage stage) throws Exception {
		instance = this;
		this.consoleLogger = new ConsoleLogger();
		this.sceneManager = new SceneManager(stage);
	}
	
	/**
	 * Returns the scene management class
	 * 
	 * @return SceneManager				The scene manager
	 */
	public SceneManager getSceneManager() {
		return this.sceneManager;
	}
	
	/**
	 * Returns the console logger
	 * 
	 * @return Logger			The console logger
	 */
	public Logger getConsoleLogger() {
		return this.consoleLogger;
	}
	
	/**
	 * Closes the application
	 */
	public void close() {
		Platform.exit();
	}
	
	/**
	 * Returns the current instance of the application
	 * 
	 * @return WyvernChat				The instance of the application
	 */
	public static WyvernChat getInstance() {
		return instance;
	}

}
