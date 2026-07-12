package com.liamhvet.alchemicraft.common.blocks;
import com.liamhvet.alchemicraft.Alchemicraft;
import com.liamhvet.alchemicraft.common.blocks.archetypes.BuddingGeode;
import com.liamhvet.alchemicraft.common.blocks.archetypes.CrystalBuds;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.world.item.Items.*;

public class OreBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Alchemicraft.MOD_ID);

    public static final DeferredBlock<Block> SMALL_BLUE_VITRIOL_CRYSTAL = BLOCKS.register("small_blue_vitriol_bud",
            () -> new CrystalBuds(4, 3, BlockBehaviour.Properties.of().destroyTime(2.0f).lightLevel(state -> 1)));
    public static final DeferredBlock<Block> MEDIUM_BLUE_VITRIOL_CRYSTAL = BLOCKS.register("medium_blue_vitriol_bud",
            () -> new CrystalBuds(8, 3, BlockBehaviour.Properties.of().destroyTime(2.0f).lightLevel(state -> 1)));
    public static final DeferredBlock<Block> LARGE_BLUE_VITRIOL_CRYSTAL = BLOCKS.register("large_blue_vitriol_bud",
            () -> new CrystalBuds(12, 2, BlockBehaviour.Properties.of().destroyTime(2.0f).lightLevel(state -> 1)));
    public static final DeferredBlock<Block> BLUE_VITRIOL_CRYSTAL = BLOCKS.register("blue_vitriol_crystal",
            () -> new CrystalBuds(16, 2, BlockBehaviour.Properties.of().destroyTime(2.0f).lightLevel(state -> 1)));

    //Archetypal Geode + Bud
    public static final DeferredBlock<Block> MAGIC_CRYSTAL = BLOCKS.register("test_tick_less",
            () -> new CrystalBuds(4, 1, BlockBehaviour.Properties.of().destroyTime(2.0f)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = BLOCKS.register("test_tick_les",
            () -> new BuddingGeode(BlockBehaviour.Properties.of().destroyTime(2.0f),
                    OreBlocks.MAGIC_CRYSTAL.get(),
                    OreBlocks.MAGIC_CRYSTAL.get(),
                    OreBlocks.MAGIC_CRYSTAL.get(),OreBlocks.MAGIC_CRYSTAL.get()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
