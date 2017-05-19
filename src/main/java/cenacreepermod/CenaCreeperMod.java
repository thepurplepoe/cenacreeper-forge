package cenacreepermod;

import cenacreepermod.common.CCSoundHandler;
import cenacreepermod.common.entity.EntityCenaCreeper;
import cenacreepermod.common.proxy.CommonProxy;
import cenacreepermod.util.CCReference;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = CCReference.modID, name = CCReference.modName, version = CCReference.modVersion, acceptedMinecraftVersions = CCReference.modMinecraftVersion)
public class CenaCreeperMod {
	
	@Instance(CCReference.modID)
	public static CenaCreeperMod instance;
	
	@SidedProxy(clientSide = "cenacreepermod.client.proxy.ClientProxy", serverSide = "cenacreepermod.common.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		EntityRegistry.registerModEntity(EntityCenaCreeper.class, "ModCreeper", 3, this, 64, 5, true);
		EntityRegistry.registerEgg(EntityCenaCreeper.class, 1, 1);
		
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		for(Biome biome : BiomeProvider.allowedBiomes) 
		{
			EntityRegistry.addSpawn(EntityCenaCreeper.class, 45, 2, 2, EnumCreatureType.MONSTER, biome);
			EntityRegistry.addSpawn(EntityCenaCreeper.class, 45, 1, 1, EnumCreatureType.CREATURE, biome);
		}
		
		CCSoundHandler.init();
	}
	
	@EventHandler 
	public void postinit(FMLPostInitializationEvent event) {
		
	}
}
