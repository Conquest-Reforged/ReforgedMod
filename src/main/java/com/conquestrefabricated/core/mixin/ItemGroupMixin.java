package com.conquestrefabricated.core.mixin;

import com.conquestrefabricated.core.util.log.Log;
import net.minecraft.item.ItemGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemGroup.class)
public class ItemGroupMixin {

    @Inject(method = "<init>", at = @At(value = "TAIL", target = "Lnet/minecraft/item/ItemGroup;<init>(ILjava/lang/String;)V"), cancellable = true)
    public void ItemGroup(int i, String string, CallbackInfo ci) {
        Log.info("TEST");
        ci.cancel();
    }

}
