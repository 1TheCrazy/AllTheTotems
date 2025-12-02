package me.onethecrazy;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllTheTotems implements ModInitializer {
	public static final String MOD_ID = "all-the-totems";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("AllTheTotems is the best mod ever made (https://ko-fi.com/1thecrazy)!");
	}
}