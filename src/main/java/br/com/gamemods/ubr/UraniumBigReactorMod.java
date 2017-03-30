package br.com.gamemods.ubr;

import erogenousbeef.bigreactors.api.IHeatEntity;
import erogenousbeef.bigreactors.api.registry.ReactorInterior;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = UraniumBigReactorMod.MODID, version = UraniumBigReactorMod.VERSION, dependencies = "required-after:bigreactors;required-after:IC2")
public final class UraniumBigReactorMod
{
    public static final String MODID = "uraniumbigreactor";
    public static final String VERSION = "uraniumbigreactor";

    @EventHandler
    public void init(FMLPostInitializationEvent event)
    {
        ReactorInterior.registerFluid("ic2coolant", 0.66F, 0.95F, 6F, IHeatEntity.conductivityDiamond);
        ReactorInterior.registerFluid("ic2uu_matter", 0.9F, 0.99F, 18F, IHeatEntity.conductivityDiamond);
    }
}
