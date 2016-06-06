package goldenapple.omnitools;

import goldenapple.omnitools.init.ModItems;
import goldenapple.omnitools.proxy.Proxy;
import goldenapple.omnitools.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = OmniTools.MOD_NAME, modid = OmniTools.MOD_ID, version = OmniTools.VERSION, dependencies = Reference.DEPENDENCIES)
public class OmniTools {
    public static final String MOD_NAME = "Omni Power Tools";
    public static final String MOD_ID = "omnitools";
    public static final String VERSION = "0.1";

    @SidedProxy(clientSide = "goldenapple.omnitools.proxy.ClientProxy", serverSide = "goldenapple.omnitools.proxy.ServerProxy")
    public static Proxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit();
        ModItems.register();
        proxy.registerRenders();
    }

    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit();
    }
}