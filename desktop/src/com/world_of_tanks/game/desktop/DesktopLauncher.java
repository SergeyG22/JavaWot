package com.world_of_tanks.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.world_of_tanks.game.Main;



public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "World of tanks";
		config.width = 1280;
		config.height = 1024;
		new LwjglApplication(new Main(), config);
	}
}
