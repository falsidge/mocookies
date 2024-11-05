package com.redderblanket.lbk;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class BlockBush extends Block {

    // Block-states tutorial https://docs.fabricmc.net/develop/blocks/blockstates
    public static final BooleanProperty FRUITING = BooleanProperty.of("fruiting");

    public BlockBush() {
        super(AbstractBlock.Settings.create().sounds(BlockSoundGroup.CROP).ticksRandomly());

        setDefaultState(getDefaultState().with(FRUITING, false));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FRUITING);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        if (!state.get(FRUITING) && random.nextBetween(1, 24) == 1) {

            world.setBlockState(pos, state.with(FRUITING, true));
        }
    }

    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (player.getAbilities().allowModifyWorld && state.get(FRUITING)) {

            world.setBlockState(pos, state.with(FRUITING, false));

            world.playSound(player, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

            // TODO drop fruit item, which should be initialized in constructor

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

}
