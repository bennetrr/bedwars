package io.github.bennetrr.bedwarsplugin.utils;

import org.bukkit.Location;

public class LocationRelativizer {
    private final Location oldReferencePoint;
    private final Location newReferencePoint;

    public LocationRelativizer(Location oldReferencePoint, Location newReferencePoint) {
        this.oldReferencePoint = oldReferencePoint;
        this.newReferencePoint = newReferencePoint;
    }

    public Location convert(Location location) {
        double relX = location.getX() - oldReferencePoint.getX();
        double relY = location.getY() - oldReferencePoint.getY();
        double relZ = location.getZ() - oldReferencePoint.getZ();

        Location newLocation = newReferencePoint.clone();
        newLocation.add(relX, relY, relZ);
        return newLocation;
    }

    public Location c(Location a) {
        return convert(a);
    }

    public Location getOldReferencePoint() {
        return oldReferencePoint;
    }

    public Location getNewReferencePoint() {
        return newReferencePoint;
    }
}
