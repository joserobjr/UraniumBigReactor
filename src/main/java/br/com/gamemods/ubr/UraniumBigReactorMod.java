package br.com.gamemods.ubr;

import erogenousbeef.bigreactors.api.IHeatEntity;
import erogenousbeef.bigreactors.api.registry.Reactants;
import erogenousbeef.bigreactors.api.registry.ReactorConversions;
import erogenousbeef.bigreactors.api.registry.ReactorInterior;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "uraniumbigreactor", version = "@VERSION@", dependencies = "required-after:bigreactors;required-after:IC2")
public final class UraniumBigReactorMod
{
    @EventHandler
    public void init(FMLPostInitializationEvent event)
    {
        ReactorInterior.registerFluid("ic2coolant", 0.66F, 0.95F, 6F, IHeatEntity.conductivityDiamond);
        ReactorInterior.registerFluid("ic2uu_matter", 0.9F, 0.99F, 18F, IHeatEntity.conductivityDiamond);

        Reactants.registerReactant("uFuel", 0, 0x46c81a);
        Reactants.registerReactant("plutonium", 1, 0xaaaaaa);
        ReactorConversions.register("uFuel", "plutonium");

        Reactants.registerSolid("uraniumFuel", "uFuel");
        Reactants.registerSolid("tinyPlutonium", "plutonium");
        Item uraniumFuel = Item.getByNameOrId("ic2:nuclear");
        if(uraniumFuel != null)
        {
            OreDictionary.registerOre("uraniumFuel", uraniumFuel);
            OreDictionary.registerOre("tinyPlutonium", new ItemStack(uraniumFuel, 1, 7));
        }
        else
        {
            OreDictionary.registerOre("tinyPlutonium", new ItemStack(Item.getByNameOrId("bigreactors:ingotMetals"), 0, 1));
        }

        Fluid fluidUranium = FluidRegistry.getFluid("uraniumfuel");
        if(fluidUranium != null)
            Reactants.registerFluid(fluidUranium, "uFuel");
    }
}
