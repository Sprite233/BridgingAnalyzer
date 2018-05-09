package ldcr.BridgingAnalyzer.Utils;

import java.util.HashMap;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import ldcr.Utils.Bukkit.TitleUtils;

public class Util {
    private static HashMap<Player, BukkitTask> tasks = new HashMap<Player, BukkitTask>();

    public static void breakBlock(final Block b) {
	if (!b.getChunk().isLoaded()) {
	    b.getChunk().load(false);
	}
	b.getWorld()
	.playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());
	b.setType(Material.AIR);
    }

    public static void f__kUnknownTitleFadeBug(final Player p,
	    final String title, final String subtitle, final int fadeIn,
	    final int stay, final int fadeOut) {
	TitleUtils.sendTitle(p, title, subtitle, fadeIn, stay, fadeOut);
	/*
		if (tasks.containsKey(p)) {
			tasks.get(p).cancel();
		}
		tasks.put(
				p,
				Bukkit.getScheduler().runTaskLater(BridgingAnalyzer.instance,
						new Runnable() {

					@Override
					public void run() {
						TitleUtils.sendTitle(p, "", "", fadeIn, stay,
								fadeOut);
						tasks.remove(p);
					}
				}, fadeIn + stay + fadeOut));
	 */
    }

    public static double formatDouble(final double d) {
	return (double) Math.round(d * 100) / 100;
    }

    public static void titleFadeBugFix_ClearTask() {
	tasks.clear();
    }
}
