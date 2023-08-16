package com.example;

import com.example.AutoRifts.AutoRiftsPlugin;
import com.example.AutoTele.AutoTele;
import com.example.Construction.ConstructionPlugin;
import com.example.E3t4g.e3t4g;
import com.example.EthanApiPlugin.EthanApiPlugin;
import com.example.LavaRunecrafter.LavaRunecrafterPlugin;
import com.example.NightmareHelper.NightmareHelperPlugin;
import com.example.NightmareZone.NightmareZonePlugin;
import com.example.PacketUtils.PacketUtilsPlugin;
import com.example.PrayerFlicker.EthanPrayerFlickerPlugin;
import com.example.UpkeepPlugin.UpkeepPlugin;
import com.example.CalvarionHelper.CalvarionHelper;
import com.example.aoewarnings.AoeWarningPlugin;
import com.example.blackjacking.Blackjacking;
import com.example.constru.ConstruPlugin;
import com.example.gauntletFlicker.gauntletFlicker;
import com.example.godwarsticktimers.GodWarsTickTimersPlugin;
import com.example.gwdhelper.GodWarsHelperPlugin;
import com.example.harpoon2ticker.SwordFish2Tick;
import com.example.kotoriutils.KotoriUtils;
import com.example.specBar.SpecBarPlugin;
import com.example.superglass.SuperGlassMakerPlugin;
import com.example.test.testPlugin;
import com.example.RunEnabler.RunEnabler;


import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ExamplePluginTest {
    public static void main(String[] args) throws Exception {
        ExternalPluginManager.loadBuiltin(EthanApiPlugin.class, PacketUtilsPlugin.class, EthanPrayerFlickerPlugin.class,
                gauntletFlicker.class,
                SuperGlassMakerPlugin.class, UpkeepPlugin.class, LavaRunecrafterPlugin.class,
                NightmareHelperPlugin.class, SwordFish2Tick.class
                , e3t4g.class, AutoTele.class,  RunEnabler.class, CalvarionHelper.class, testPlugin.class, ConstructionPlugin.class, GodWarsHelperPlugin.class, KotoriUtils.class,
                GodWarsTickTimersPlugin.class, NightmareZonePlugin.class, AoeWarningPlugin.class,
                Blackjacking.class, ConstruPlugin.class, SpecBarPlugin.class, AutoRiftsPlugin.class);
        RuneLite.main(args);
    }
}