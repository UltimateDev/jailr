package com.tyzoid.jailr.api;

import java.util.ArrayList;
import java.util.List;

import com.tyzoid.jailr.models.Meta;
import com.tyzoid.jailr.serialization.LocationSerializer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class JailAPI {
    public static void setJailPoint(Location jailPoint) {
        LocationSerializer locationSerializer = new LocationSerializer(jailPoint);

        Meta.removeWhere("key='jailPoint'");
        Meta jailPointModel = new Meta("jailPoint", locationSerializer.getString());
        jailPointModel.save();
    }

    public static void setUnJailPoint(Location unJailPoint) {
        LocationSerializer locationSerializer = new LocationSerializer(unJailPoint);

        Meta.removeWhere("key='unJailPoint'");
        Meta unJailPointModel = new Meta("unJailPoint", locationSerializer.getString());
        unJailPointModel.save();
    }

    public static Location getJailPoint() {
        List<Meta> matches = Meta.selectWhere("key='jailPoint'");
        if (matches.size() < 1) {
            return null; // If there are no matches the jailPoint is not set
        }

        return (new LocationSerializer(Meta.selectWhere("key='jailPoint'").get(0).getValue())).getLocation();
    }

    public static Location getUnJailPoint() {
        List<Meta> matches = Meta.selectWhere("key='unJailPoint'");
        if (matches.size() < 1) {
            return null; // If there are no matches the unJailPoint is not set
        }

        return (new LocationSerializer(Meta.selectWhere("key='unJailPoint'").get(0).getValue())).getLocation();
    }
    
    //TODO Implement jailPlayer | this is called after isJailed() is called and it is returned false | This jails a player
    public static void jailPlayer() {
    	
    }
    
    //TODO Implement unjailPlayer | this is called after isJailed() is called and it is returned true | This unjails a player
    public static void unjailPlayer() {
    	
    }
    
    //TODO Implement isJailed | Returns a boolean if the player is jailed
    public static boolean isJailed(Player player) {
    	
    	return false;
    }
    
    // TODO Implement getRemainingJailTime | this is called after isJailed() is called and it is returned true |void needs to be changed to appropriate variable
    public static void getRemainingJailTime() {
    	
    }
    
    //TODO Implement getJailMates | Returns a list of all jailed players by name to list them on comamnd
    public static ArrayList<String> getJailMates() {
    	
    	return null;
    }
}
