# NoLimitsParcool

解除 ParCool 4.0 的技能树限制 + 跑酷动作不消耗体力（Minecraft 1.20.1 Forge 纯客户端 Mixin mod）。

## 功能 / Features

- **解锁 ParCool 全部动作**：跳过 ParCool 4.0 新增技能树的学习要求，滑铲等动作无需花经验学习即可直接使用
- **不消耗体力**：跑酷动作不再扣体力（体力条不动、也不会力竭）

## 使用要求

- Minecraft 1.20.1 + Forge 47.x
- [ParCool](https://modrinth.com/mod/parcool) 4.0.0+（按 4.0.2.0 编写并验证）
- 仅客户端需要：客户端判定起手的动作（滑铲/爬行/快跑等）只由本 mod 所在的客户端放行，服务器不装也能用；
  由服务端判定起手的动作（如受身 Breakfall）需要服务端也安装

## 配置

`config/nolimitsparcool-common.toml`：

| 配置项 | 默认 | 说明 |
|---|---|---|
| `parcool.unlockAllActions` | `true` | 跳过技能树学习要求，直接使用全部动作 |
| `parcool.infiniteStamina` | `true` | 跑酷动作不消耗体力 |

ParCool 自身的 `enable_skill_tree` 与每个动作的 `available` 开关仍然生效。

## 构建

```
gradlew.bat build
```

首次构建会自动把 ParCool（4.0.2.0）与 Cloth Config API 下载到 `libs/`（地址在 `gradle.properties`，也可手动放置）。
产物在 `build/libs/nolimitsparcool-1.0.0.jar`。

## 来源声明 / Attribution

**本 mod 实际是 [TaczHacker](https://github.com/qwaszxopklnmso/TaczHacker) 的部分功能提取**
（取自原项目 ParCool 功能的附属部分：解锁全部动作 + 不消耗体力），独立打包发布。

**本项目仅限娱乐用途。**

This mod is a partial feature extraction of
[TaczHacker](https://github.com/qwaszxopklnmso/TaczHacker) (unlock all ParCool actions +
infinite stamina). For entertainment purposes only.

## License

MIT
