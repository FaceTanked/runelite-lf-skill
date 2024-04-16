package com.facetanked.lfskill;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("lfskill")
public interface LfSkillConfig extends Config
{
	@ConfigItem(
		keyName = "noProfanity",
		name = "No profanity",
		description = "Toggle for profanity in the spec messages"
	)
	default boolean noProfanity()
	{
		return false;
	}
}
