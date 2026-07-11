package com.liamhvet.alchemicraft.common.blocks.archetypes;

import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;


public class BuddingGeode extends Block {

    private final Block smallBud;
    private final Block mediumBud;
    private final Block largeBud;
    private final Block crystal;

    private static final Direction[] DIRECTIONS = Direction.values();
    public BuddingGeode(Properties properties, Block smallBud, Block mediumBud, Block largeBud, Block crystal) {
        super(Properties.of().randomTicks());
        this.smallBud = smallBud;
        this.mediumBud = mediumBud;
        this.largeBud = largeBud;
        this.crystal = crystal;
    }


    //straight up ripped from budding amethyst
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pos.relative(direction);
            BlockState blockstate = level.getBlockState(blockpos);
            Block block = null;
            if (canClusterGrowAtState(blockstate)) {
                block = smallBud;
            } else if (blockstate.is(smallBud) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = mediumBud;
            } else if (blockstate.is(mediumBud) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = largeBud;
            } else if (blockstate.is(largeBud) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = crystal;
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState()
                        .setValue(AmethystClusterBlock.FACING, direction)
                        .setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                level.setBlockAndUpdate(blockpos, blockstate1);
            }
        }
    }

    public static boolean canClusterGrowAtState(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
    }
}
