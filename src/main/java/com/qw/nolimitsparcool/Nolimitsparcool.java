package com.qw.nolimitsparcool;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

/**
 * NoLimitsParcool —— 纯客户端 Mixin mod：
 * 解除 ParCool 4.0 技能树学习限制 + 跑酷动作不消耗体力。
 * 全部逻辑在 mixin 包（由 nolimitsparcool.parcool.mixins.json 挂载，
 * 没装 ParCool 时自动跳过）；这里只负责注册配置文件。
 */
@Mod(Nolimitsparcool.MODID)
public class Nolimitsparcool {

    public static final String MODID = "nolimitsparcool";

    public Nolimitsparcool() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
