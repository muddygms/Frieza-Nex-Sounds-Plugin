package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("customnexsounds")
public interface FriezaNexConfig extends Config
{
	@Range(
			min = 0,
			max = 100
	)
	@ConfigItem(
			keyName = "volume",
			name = "Volume",
			description = "Custom sound volume percentage"
	)
	default int volume() {
		return 100;
	}
}