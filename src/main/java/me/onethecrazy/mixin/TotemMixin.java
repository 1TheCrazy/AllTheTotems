package me.onethecrazy.mixin;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DeathProtectionComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(Items.class)
public class TotemMixin {
    @Inject(method = "register(Lnet/minecraft/registry/RegistryKey;Ljava/util/function/Function;Lnet/minecraft/item/Item$Settings;)Lnet/minecraft/item/Item;", at = @At("HEAD"), cancellable = true)
    private static void register_override(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings, CallbackInfoReturnable<Item> cir) {
        Item item = factory.apply(settings.component(DataComponentTypes.DEATH_PROTECTION, DeathProtectionComponent.TOTEM_OF_UNDYING).registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        cir.setReturnValue(Registry.register(Registries.ITEM, key, item));
    }
}