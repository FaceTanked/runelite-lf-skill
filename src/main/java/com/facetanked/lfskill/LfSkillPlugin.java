package com.facetanked.lfskill;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.util.List;
import java.util.Map;

@Slf4j
@PluginDescriptor(
	name = "LF Skill"
)
public class LfSkillPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private LfSkillConfig config;

	private final Map<String, String> REPLACE_MESSAGES = Map.of(
			"Chop chop!", "Let's fucking chop!",
			"Here fishy fishies!", "Let's fucking fish!",
			"Smashing!", "Let's fucking mine!"
	);

	private final Map<String, String> SAFE_REPLACE_MESSAGES = Map.of(
			"Chop chop!", "Let's frickin' chop!",
			"Here fishy fishies!", "Let's frickin' fish!",
			"Smashing!", "Let's frickin' mine!"
	);

	@Override
	protected void startUp() throws Exception
	{
		log.info("LF Skill started");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("LF Skill stopped");
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged event) {
		if (!(event.getActor() instanceof Player) || event.getActor().getName() == null) {
			return;
		}

		if (REPLACE_MESSAGES.containsKey(event.getOverheadText())) {
			if (config.noProfanity()) {
				event.getActor().setOverheadText(SAFE_REPLACE_MESSAGES.get(event.getOverheadText()));
			}
			else {
				event.getActor().setOverheadText(REPLACE_MESSAGES.get(event.getOverheadText()));
			}
		}
	}

	@Provides
	LfSkillConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(LfSkillConfig.class);
	}
}
