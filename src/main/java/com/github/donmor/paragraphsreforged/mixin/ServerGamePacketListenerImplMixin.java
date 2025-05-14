package com.github.donmor.paragraphsreforged.mixin;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Function;
import java.util.stream.Stream;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {
	@Redirect(method = "handleSignUpdate",
			at = @At(value = "INVOKE",
					target = "Ljava/util/stream/Stream;map(Ljava/util/function/Function;)Ljava/util/stream/Stream;"))
	private Stream<String> nothing(
			Stream<String> instance, Function<String, String> function
	) {
		// function === ChatFormatting::stripFormatting.
		// Strip formatting only if sign text formatting is disabled.
		return instance;
	}
}
