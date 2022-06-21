package net.deceivedfx.ornatearmor;

import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import io.wispforest.owo.util.KawaiiUtil;
import net.deceivedfx.ornatearmor.registry.OrnateCommands;
import net.fabricmc.api.ModInitializer;
import net.deceivedfx.ornatearmor.registry.OrnateItems;
import net.minecraft.network.message.MessageType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrnateArmorMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "ornatearmor";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	RegistryKey<MessageType> typeKey = RegistryKey.of(Registry.MESSAGE_TYPE_KEY, new Identifier(OrnateArmorMod.MOD_ID));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		FieldRegistrationHandler.register(OrnateItems.class, MOD_ID, false);
		OrnateCommands.init();
		OrnateCommands.register();
		LOGGER.info(KawaiiUtil.uwuify("ORNATE [ A R M O R Y ] LOADED BOSS"));


	}
}
