package com.liamhvet.alchemicraft;
import com.liamhvet.alchemicraft.common.blocks.OreBlocks;
import com.liamhvet.alchemicraft.common.items.MiscItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.api.distmarker.Dist;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Alchemicraft.MOD_ID)
public class Alchemicraft {
    public static final String MOD_ID = "alchemicraft";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Alchemicraft(IEventBus modEventBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        MiscItems.register(modEventBus);
        OreBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(MiscItems.SULFUR_CHUNK);
            event.accept(MiscItems.CINNABAR_CHUNK);
            event.accept(MiscItems.BLUE_VITRIOL_DUST);
            event.accept(MiscItems.RED_VITRIOL_DUST);
            event.accept(MiscItems.GREEN_VITRIOL_DUST);
            event.accept(MiscItems.BLUE_VITRIOL);
            event.accept(MiscItems.RED_VITRIOL);
            event.accept(MiscItems.GREEN_VITRIOL);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

}
