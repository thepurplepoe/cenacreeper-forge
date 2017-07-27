package cenacreepermod.client.proxy;

import cenacreepermod.client.renderer.RenderCenaCreeper;
import cenacreepermod.common.entity.EntityCenaCreeper;
import cenacreepermod.common.proxy.CommonProxy;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		RenderingRegistry.registerEntityRenderingHandler(EntityCenaCreeper.class, new IRenderFactory<EntityCenaCreeper>() {
			@Override
			public Render<EntityCenaCreeper> createRenderFor(RenderManager manager)
			{
				return new RenderCenaCreeper(manager);
			}
		});
	}
}
