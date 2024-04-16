package com.facetanked.lfskill;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class LfSkillPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(LfSkillPlugin.class);
		RuneLite.main(args);
	}
}