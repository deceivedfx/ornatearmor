package net.deceivedfx.ornatearmor.registry;

/* @author deceivedfx
 * 6/21/2022
 * ornatearmor
 */

import net.deceivedfx.ornatearmor.event.ModPlayerEventCopyFrom;
import net.deceivedfx.ornatearmor.command.ReturnHomeCommand;
import net.deceivedfx.ornatearmor.command.SetHomeCommand;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class OrnateCommands {

    public static void register() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
    }

    public static void init() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }
}
