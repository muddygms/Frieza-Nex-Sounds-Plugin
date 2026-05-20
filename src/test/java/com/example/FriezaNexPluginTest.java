package com.example;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class FriezaNexPluginTest {
	public static void main(String[] args) throws Exception {
		ExternalPluginManager.loadBuiltin(FriezaNexPlugin.class);
		RuneLite.main(args);
	}
}