
package com.example.modernhouse;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ModernHouse extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ModernHouse plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ModernHouse plugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("modernhouse")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                World world = player.getWorld();

                int x = player.getLocation().getBlockX();
                int y = player.getLocation().getBlockY();
                int z = player.getLocation().getBlockZ();

                buildHouse(world, x, y, z);
                player.sendMessage("§aA modern house has been built!");
                return true;
            } else {
                sender.sendMessage("This command can only be used by a player.");
                return true;
            }
        }
        return false;
    }

    private void buildHouse(World world, int x, int y, int z) {
        // Base floor: 7x7 Quartz
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                world.getBlockAt(x + i, y, z + j).setType(Material.QUARTZ_BLOCK);
            }
        }

        // Hollow interior walls (White Concrete) with Glass windows
        for (int h = 1; h <= 4; h++) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    boolean edge = (i == 0 || i == 6 || j == 0 || j == 6);
                    if (edge) {
                        // doorway gap
                        if ((x + i == x + 3) && (z + j == z) && (h <= 2)) continue;

                        // windows on height 2
                        if (h == 2 && ((i % 3 == 0) || (j % 3 == 0))) {
                            world.getBlockAt(x + i, y + h, z + j).setType(Material.GLASS_PANE);
                        } else {
                            world.getBlockAt(x + i, y + h, z + j).setType(Material.WHITE_CONCRETE);
                        }
                    }
                }
            }
        }

        // Roof: quartz slabs
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                world.getBlockAt(x + i, y + 5, z + j).setType(Material.QUARTZ_SLAB);
            }
        }

        // Add a door (simple placeholder: leave opening; actual door placement can be refined with block data)
        // Place an oak door (requires correct block data for top/bottom; simplest approach: place bottom then top)
        world.getBlockAt(x + 3, y + 1, z).setType(Material.OAK_DOOR);
        world.getBlockAt(x + 3, y + 2, z).setType(Material.OAK_DOOR);
    }
}
