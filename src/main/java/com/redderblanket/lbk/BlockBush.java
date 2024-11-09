package com.redderblanket.lbk;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    private Item droppedItem;

    // Block-states tutorial https://docs.fabricmc.net/develop/blocks/blockstates
    public static final BooleanProperty FRUITING = BooleanProperty.of("fruiting");

    public BlockBush() {
        super(
                AbstractBlock.Settings.create()
                        .sounds(BlockSoundGroup.CROP)
                        .ticksRandomly()
                        .nonOpaque()
                        .requiresTool()
                        .strength(0.2f, 0.2f)
        );

        setDefaultState(getDefaultState().with(FRUITING, false));
    }

    protected void updateDroppedItem(Item droppedItem) {
        this.droppedItem = droppedItem;
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

            // pick the bush
            world.setBlockState(pos, state.with(FRUITING, false));

            // play leafy sound
            world.playSound(player, pos, SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);

            // drop 1-3 droppedItem
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(droppedItem, (int) (Math.random() * 3) + 1)));

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

}
