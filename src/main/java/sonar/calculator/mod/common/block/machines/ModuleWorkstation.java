package sonar.calculator.mod.common.block.machines;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import sonar.calculator.mod.Calculator;
import sonar.calculator.mod.common.tileentity.machines.TileEntityModuleWorkstation;
import sonar.core.common.block.SonarMachineBlock;
import sonar.core.common.block.SonarMaterials;
import sonar.core.utils.BlockInteraction;
import sonar.core.utils.IGuiTile;

public class ModuleWorkstation extends SonarMachineBlock {

	public ModuleWorkstation() {
		super(SonarMaterials.machine, true, true);
	}

	@Override
	public boolean operateBlock(World world, BlockPos pos, EntityPlayer player, BlockInteraction interact) {
		if (player != null) {
			if (!world.isRemote) {
				FMLNetworkHandler.openGui(player, Calculator.instance, IGuiTile.ID, world, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityModuleWorkstation();
	}

	@Override
	public void addSpecialToolTip(ItemStack stack, EntityPlayer player, List list) {}
}