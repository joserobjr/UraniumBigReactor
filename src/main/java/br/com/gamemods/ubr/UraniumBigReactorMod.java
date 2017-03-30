package br.com.gamemods.ubr;

import erogenousbeef.bigreactors.api.IHeatEntity;
import erogenousbeef.bigreactors.api.data.SourceProductMapping;
import erogenousbeef.bigreactors.api.registry.Reactants;
import erogenousbeef.bigreactors.api.registry.ReactorConversions;
import erogenousbeef.bigreactors.api.registry.ReactorInterior;
import erogenousbeef.bigreactors.common.data.StandardReactants;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = UraniumBigReactorMod.MODID, version = UraniumBigReactorMod.VERSION, dependencies = "required-after:bigreactors;required-after:IC2")
public final class UraniumBigReactorMod
{
    public static final String MODID = "uraniumbigreactor";
    public static final String VERSION = "uraniumbigreactor";
    public static final String uFuel = "uFuel";
    public static final int fluidColorUranium = 0x46c81a;
    public static SourceProductMapping uraniumFuelMapping;

    @EventHandler
    public void init(FMLPostInitializationEvent event)
    {
        ReactorInterior.registerFluid("ic2coolant", 0.66F, 0.95F, 6F, IHeatEntity.conductivityDiamond);
        ReactorInterior.registerFluid("ic2uu_matter", 0.9F, 0.99F, 18F, IHeatEntity.conductivityDiamond);

        Reactants.registerReactant(uFuel, 0, fluidColorUranium);
        ReactorConversions.register(uFuel, StandardReactants.cyanite);

        uraniumFuelMapping = Reactants.registerSolid("uraniumFuel", uFuel);
        Item uraniumFuel = Item.getByNameOrId("ic2:nuclear");
        if(uraniumFuel != null)
            OreDictionary.registerOre("uraniumFuel", uraniumFuel);

        Fluid fluidUranium = FluidRegistry.getFluid("uraniumfuel");
        if(fluidUranium != null)
            Reactants.registerFluid(fluidUranium, uFuel);
    }
}
