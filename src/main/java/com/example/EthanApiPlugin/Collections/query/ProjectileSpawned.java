package com.example.EthanApiPlugin.Collections.query;

import net.runelite.api.Projectile;
import lombok.Data;

/**
 * An event called whenever a {@link Projectile} has spawned.
 */
@Data
public class ProjectileSpawned
{
    /**
     * The spawned projectile.
     */
    private Projectile projectile;
}