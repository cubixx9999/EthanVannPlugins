package com.example.test;

import com.example.EthanApiPlugin.Collections.*;
import com.example.Packets.MousePackets;
import com.example.Packets.WidgetPackets;
import lombok.SneakyThrows;
import net.runelite.api.widgets.Widget;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.events.GameTick;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.HotkeyListener;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;

import java.awt.event.KeyEvent;
import java.util.List;
@Slf4j

@PluginDescriptor(name = "ChocolateGrinder", description = "", enabledByDefault = false, tags = {"ethan"})
public class testPlugin extends Plugin {
    @Inject
    Client client;
    @Inject
    private KeyManager keyManager;
    public int timeout = 0;


    @Subscribe
    public void onGameTick(GameTick e){
        List<Widget> gems = Inventory.search().withId(ItemID.UNCUT_EMERALD).result();
        if(gems.isEmpty()){
            return;
        }
        Inventory.search().withId(ItemID.CHISEL).first().ifPresent(chisel->{
            MousePackets.queueClickPacket();
            WidgetPackets.queueWidgetOnWidget(chisel,gems.get(0));
            MousePackets.queueClickPacket();
            WidgetPackets.queueWidgetAction(client.getWidget(270, 14).getChild(29));
            timeout = 40;
        });
    }
}