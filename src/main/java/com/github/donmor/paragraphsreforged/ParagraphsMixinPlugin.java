package com.github.donmor.paragraphsreforged;

import net.minecraftforge.fml.loading.LoadingModList;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ParagraphsMixinPlugin implements IMixinConfigPlugin {
	@Override
	public void onLoad(String mixinPackage) {
	}

	@Override
	public String getRefMapperConfig() {
		return null;
	}

	@Override
	public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
		// If any mod reported incompatible, detect and disable mixin here
		if ("com.github.donmor.paragraphsreforged.mixin.ServerGamePacketListenerImplMixin".equals(mixinClassName)) {
			return !hasIncompatibleMods();
		}
		return true;
	}

	@Override
	public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
	}

	@Override
	public List<String> getMixins() {
		return null;
	}

	@Override
	public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
	}

	@Override
	public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
	}

	private static boolean hasIncompatibleMods(String... modids) {
		if (modids.length == 0) return false;
		return LoadingModList.get().getMods().stream().anyMatch(i -> Arrays.stream(modids).anyMatch(modid -> modid.equals(i.getModId())));
	}
}
