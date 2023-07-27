package com.example.BankStand;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import com.google.inject.Provides;
import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import com.example.EthanApiPlugin.Collections.Inventory;
import com.example.Packets.MousePackets;
import com.example.Packets.WidgetPackets;
import net.runelite.api.ItemID;
import net.runelite.api.events.GameTick;
import net.runelite.api.widgets.Widget;
import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.InteractionApi.BankInteraction;
import com.example.InteractionApi.NPCInteraction;
import com.example.InteractionApi.TileObjectInteraction;
import com.example.EthanApiPlugin.Collections.*;
import java.util.List;
import net.runelite.api.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDependency;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(name = "Bank Stand", description = "", enabledByDefault = false, tags = {"ethan"})
@Slf4j
public class BankStandPlugin extends Plugin {
    public int timeout = 0;
    int timesFailed = 0;
    @Inject
    Client client;
    @Inject
    EthanApiPlugin api;
    @Override
    @SneakyThrows
    public void startUp() {
        timeout = 0;
    }
    @Override
    public void shutDown() {
    }
    @Provides
    public BankStandPluginConfig getConfig(ConfigManager configManager) {
        return configManager.getConfig(BankStandPluginConfig.class);
    }

    private void closeBank() {
        EthanApiPlugin.invoke(-1, -1, 26, -1, -1, "", "", -1, -1);
    }

    @Subscribe
    public void onGameTick(GameTick event) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        if (timeout > 0) {
            timeout--;
            return;
        }

        List<Widget> glass = Inventory.search().withId(ItemID.MOLTEN_GLASS).result();
        if (glass.isEmpty()) {
            Optional<NPC> banker = NPCs.search().withAction("Bank").nearestToPlayer();
            Optional<TileObject> bank = TileObjects.search().withAction("Bank").nearestToPlayer();
            if (banker.isPresent()) {
                NPCInteraction.interact(banker.get(), "Bank");
                BankInteraction.withdrawX(Bank.search().withId(ItemID.MOLTEN_GLASS).first().get(), 27);
            } else if (bank.isPresent()) {
                TileObjectInteraction.interact(bank.get(), "Bank");
                BankInteraction.withdrawX(Bank.search().withId(ItemID.MOLTEN_GLASS).first().get(), 27);
            }
            return;
        }


        Inventory.search().withId(ItemID.GLASSBLOWING_PIPE).first().ifPresent(GLASSBLOWING_PIPE -> {
            MousePackets.queueClickPacket();
            WidgetPackets.queueWidgetOnWidget(GLASSBLOWING_PIPE, glass.get(0));
        });
    }
}


