package io.github.seabassthefish03.forgottencreatures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.seabassthefish03.forgottencreatures.common.entities.WendigoEntity;
import io.github.seabassthefish03.forgottencreatures.core.init.EntityTypeInit;
import io.github.seabassthefish03.forgottencreatures.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ForgottenCreatures.MODID)
@Mod.EventBusSubscriber(modid=ForgottenCreatures.MODID)
public class ForgottenCreatures
{
	public static final String MODID = "forgottencreatures";
    private static final Logger LOGGER = LogManager.getLogger();
    
    @SuppressWarnings("deprecation")
	public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public ForgottenCreatures() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::enqueueIMC);
        modEventBus.addListener(this::doClientStuff);
        
        GeckoLib.initialize();
        
        EntityTypeInit.ENTITY_TYPES.register(modEventBus);
        ItemInit.ITEMS.register(modEventBus);
        
        PROXY.init();
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        event.enqueueWork(this::defineAttributes);
    }

    @SuppressWarnings("resource")
	private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("forgottencreatures", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

   
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
    
    public void setupClient(FMLClientSetupEvent event) {
    	PROXY.clientInit();
    }
    
    public void defineAttributes() {
    	GlobalEntityTypeAttributes.put(EntityTypeInit.WENDIGO.get(), WendigoEntity.createAttributes());
    }
}
