package com.github.NGTYT.crazydiff;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;



public class events implements Listener {
	private main plugin;

    public events(main plugin) {
        this.plugin = plugin;
        plugin.getConfig();
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper) event.getEntity();
            creeper.setPowered(true);
        }

        if (event.getEntityType() == EntityType.ZOMBIE) {
            Zombie zombie = (Zombie) event.getEntity();
            zombie.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            zombie.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            zombie.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            zombie.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));

            ItemStack opsword = new ItemStack(Material.NETHERITE_SWORD);
            FileConfiguration config = plugin.getConfig();
            opsword.addUnsafeEnchantment(Enchantment.KNOCKBACK, config.getInt("opsword.KNOCKBACK"));
            opsword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, config.getInt("opsword.FIRE_ASPECT"));
            opsword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, config.getInt("opsword.DAMAGE_ALL"));

            zombie.getEquipment().setItemInMainHand(opsword);
        }

        if (event.getEntityType() == EntityType.SKELETON) {
            Skeleton skeleton = (Skeleton) event.getEntity();
            skeleton.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            skeleton.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            skeleton.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            skeleton.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));

            ItemStack opbow = new ItemStack(Material.BOW);
            FileConfiguration config = plugin.getConfig();
            opbow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, config.getInt("opbow.ARROW_FIRE"));
            opbow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, config.getInt("opbow.ARROW_DAMAGE"));
            opbow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, config.getInt("opbow.ARROW_KNOCKBACK"));

            skeleton.getEquipment().setItemInMainHand(opbow);
        }
    }

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        if (event.getItem().getType().name().toLowerCase().contains("bucket"))
            return;
        if (event.getItem().getType().name().toLowerCase().contains("potion"))
            return;

        event.getPlayer().setHealth(1.5);
        
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 600, 1));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 300 , 1));
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1200, 2));
    }
}