package com.tyzoid.jailr.api;

import org.bukkit.Location;

import com.tyzoid.jailr.models.Meta;

public class JailrAPI {
	
	public static void setJailPoint(Location loc) {
		String loc2 = loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ() + "," + loc.getYaw() + "," + loc.getPitch();
		Meta.removeWhere("key=jailPoint");
		Meta jailPoint = new Meta("jailPoint", loc2);
		jailPoint.save();
	}
	
	public static void setUnjailPoint(Location loc) {
		String loc2 = loc.getWorld().getName() + "," + loc.getX() + "," + loc.getY() + "," + loc.getZ() + "," + loc.getYaw() + "," + loc.getPitch();
		Meta.removeWhere("key=unJailPoint");
		Meta unJailPoint = new Meta("unJailPoint", loc2);
		unJailPoint.save();
	}
}
