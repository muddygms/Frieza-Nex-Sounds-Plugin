package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;

import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import net.runelite.api.ChatMessageType;

import net.runelite.api.events.ChatMessage;



@Slf4j
@PluginDescriptor(
	name = "Frieza Nex Sounds"
)
public class FriezaNexPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private FriezaNexConfig config;

	@Override
	protected void startUp() throws Exception {
		log.debug("Example started!");
	}

	@Override
	protected void shutDown() throws Exception {
		log.debug("Example stopped!");
	}

	@Subscribe

	//Chat detection for the bosses moves and phases
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() != ChatMessageType.NPC_SAY) {
			return;
		}

		String msg = event.getMessage();

		//Starting Phase
		if (msg.contains("Fumus!")) {
			FriezaSoundPlayer.playSound("fumus.wav", config.volume());
		}

		if (msg.contains("Umbra!")) {
			FriezaSoundPlayer.playSound("umbra.wav", config.volume());
		}

		if (msg.contains("Cruor!")) {
			FriezaSoundPlayer.playSound("cruor.wav", config.volume());
		}

		if (msg.contains("Glacies!")) {
			FriezaSoundPlayer.playSound("glacies.wav", config.volume());
		}

		// Smoke Phase (Not Needed)
		//if (msg.contains("Fill my soul with smoke!")) {
			//FriezaSoundPlayer.playSound("smoke.wav", config.volume());
		//}

		// Shadow Phase
		if (msg.contains("Darken my shadow!")) {
			FriezaSoundPlayer.playSound("shadow.wav", config.volume());
		}

		// Blood Phase
		if (msg.contains("Flood my lungs with blood!")) {
			FriezaSoundPlayer.playSound("blood.wav", config.volume());
		}

		// Ice Phase (Not Needed)
		//if (msg.contains("Infuse me with the power of ice!")) {
			//FriezaSoundPlayer.playSound("ice.wav", config.volume());
		//}

		// Zaros Phase
		if (msg.contains("NOW, THE POWER OF ZAROS!")) {
			FriezaSoundPlayer.playSound("zaros.wav", config.volume());
		}

		// Ice Prison (Not Needed)
		//if (msg.contains("Contain this!")) {
			//FriezaSoundPlayer.playSound("prison.wav", config.volume());
		//}

		// Shadow Smash (Not Needed)
		//if (msg.contains("There is... NO ESCAPE!")) {
			//FriezaSoundPlayer.playSound("escape.wav", config.volume());
		//}

		//For the explosion
		if (msg.contains("Taste my wrath!")) {
			FriezaSoundPlayer.playSound("run.wav", config.volume());
		}
	}

		@Provides
    FriezaNexConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(FriezaNexConfig.class);
	}
}
