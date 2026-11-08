package com.qw.nolimitsparcool.mixin;

import com.alrex.parcool.api.action.Action;
import com.alrex.parcool.api.action.StaminaConsumption;
import com.qw.nolimitsparcool.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 不消耗 ParCool 体力 —— 照抄自 Tacz_Hacker（ParCool 4.0.1.0；
 * 4.0.2.0 已用 javap 核实 Action#takeCost(StaminaConsumption$Type) 签名未变）
 *
 * ParCool 4.0 把体力重写成 api.stamina.AbstractLocalStamina 体系，
 * 有 ParCoolStamina / HungerStamina / NoneStamina / EpicFightStamina / FeathersStamina 多个实现，
 * 逐个注入太脆。改为拦所有扣体力的唯一入口：
 *   Action#takeCost(StaminaConsumption.Type)
 * 全项目只有这里会调 stamina.consume(...)（START / WORKING / FINISH 三种时机都走它），
 * 而且 ChargeJump 覆写 takeCost 时也是调 super.takeCost，所以一处注入全覆盖。
 *
 * 此 Mixin 只在安装了 ParCool 4.0+ 时应用（nolimitsparcool.parcool.mixins.json，
 * required=false、defaultRequire=0），ParCool 不存在时不会加载本类，也不会崩溃。
 */
@Mixin(value = Action.class, remap = false)
public class ParCoolStaminaMixin {

    @Inject(
            method = "takeCost",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private void nolimitsparcool$infiniteStamina(StaminaConsumption.Type type, CallbackInfo ci) {
        if (Config.infiniteStamina) {
            ci.cancel();
        }
    }
}
