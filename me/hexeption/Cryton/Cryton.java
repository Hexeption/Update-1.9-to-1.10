package me.hexeption.Cryton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import me.hexeption.Cryton.events.EventKeyBoard;
import me.hexeption.Cryton.module.Module;
import me.hexeption.Cryton.module.ModuleManager;
import me.hexeption.Cryton.wrapper.Wrapper;

public class Cryton {
	
	private final String clientName = "Cryton";
	private final double clientVersion = 2.0;
	private final String clientCreator = "Hexeption";
	
	private static Cryton theClient = new Cryton();
	
	private static ModuleManager moduleManager = null;
	public static Logger logger = LogManager.getLogger();
	
	public static Cryton getInstance(){
		return theClient;
	}
	
	public void initClient(){
		EventManager.register(this);
		moduleManager = new ModuleManager();
		moduleManager.AddModules();
		
		if(Wrapper.getInstance().getWorld() != null){
			moduleManager.setModuleState("Hud", false);
		}else{
			moduleManager.setModuleState("Hud", true);
		}
		
	}
	
	@EventTarget
	public void onKeyboard(EventKeyBoard event){
		for(Module m : getModuleManager().activeModules){
			if(Keyboard.getEventKey() == m.getBind()){
				m.toggleModule();
			}
		}
	}

	public String getClientName() {
		return clientName;
	}

	public double getClientVersion() {
		return clientVersion;
	}

	public String getClientCreator() {
		return clientCreator;
	}

	public static ModuleManager getModuleManager() {
		return moduleManager;
	}

	public static Logger getLogger() {
		return logger;
	}
	
	
	
	
	
}
