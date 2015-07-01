package net.poweredbyscience.worldessentials;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by John on 7/1/2015.
 */
public class WorldEssentials extends JavaPlugin {

    public void onEnable() {
        doStart();
    }

    Random generator = new Random();

    public void doStart() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getWorlds().get(0).getLoadedChunks()[generator.nextInt(Bukkit.getWorlds().get(0).getLoadedChunks().length)].unload(true,true);
                //No way to actually delete the chunk, meh.
                throw new Error("hi yes there is error");
            }
        }.runTaskTimer(this,20,20*60*2);
    }
}
