package com.tyzoid.jailr.api;

import com.tyzoid.jailr.models.Meta;
import com.tyzoid.jailr.serialization.LocationSerializer;
import org.bukkit.Location;

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
}
