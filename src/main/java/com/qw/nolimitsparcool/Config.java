package com.qw.nolimitsparcool;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Nolimitsparcool.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // ============ ParCool 无限制（照抄自 Tacz_Hacker 的功能7附属） ============

    private static final ForgeConfigSpec.BooleanValue PARCOOL_UNLOCK_ALL_ACTIONS = BUILDER
            .comment("解锁 ParCool 全部动作（跳过 4.0 技能树的学习要求），滑铲等动作无需花经验学习即可直接使用。\n"
                    + "技能树开关本身还在：ParCool 的 enable_skill_tree 与每个动作的 available 仍然生效。\n"
                    + "需要安装 ParCool 4.0+；客户端判定起手的动作（滑铲/爬行/快跑等）只由本 mod 所在的客户端放行。\n"
                    + "Unlock every ParCool action without learning it in the 4.0 skill tree "
                    + "(slide becomes usable directly). Requires ParCool 4.0+.")
            .define("parcool.unlockAllActions", true);

    private static final ForgeConfigSpec.BooleanValue PARCOOL_INFINITE_STAMINA = BUILDER
            .comment("不消耗 ParCool 体力。开启后跑酷动作不再扣体力（体力条不动、也不会力竭）。\n"
                    + "需要安装 ParCool。",
                    "ParCool infinite stamina. While enabled, parkour actions never consume stamina. "
                    + "Requires ParCool.")
            .define("parcool.infiniteStamina", true);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    // ParCool 无限制
    public static boolean unlockAllActions;
    public static boolean infiniteStamina;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        unlockAllActions = PARCOOL_UNLOCK_ALL_ACTIONS.get();
        infiniteStamina = PARCOOL_INFINITE_STAMINA.get();
    }
}
