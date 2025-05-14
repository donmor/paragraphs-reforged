package com.github.donmor.paragraphsreforged.mixin;

import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SharedConstants.class)
public class SharedConstantsMixin {
	/**
	 * @author Morgz
	 * Makes you able to "chat" § etc. (normally "illegal" characters)
	 */
	@Inject(method = "isAllowedChatCharacter", at = @At(value = "HEAD"), cancellable = true)
	private static void isValidChar(char arg0, CallbackInfoReturnable<Boolean> info) {
		if (arg0 == '§') info.setReturnValue(true);
	}
}
