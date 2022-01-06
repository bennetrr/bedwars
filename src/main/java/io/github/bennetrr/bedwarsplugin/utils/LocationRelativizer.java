package io.github.bennetrr.bedwarsplugin.utils;

import org.bukkit.Location;

public class LocationRelativizer {
    private final Location oldReferencePoint;
    private final Location newReferencePoint;

    public LocationRelativizer(Location oldReferencePoint, Location newReferencePoint) {
        this.oldReferencePoint = oldReferencePoint;
        this.newReferencePoint = newReferencePoint;
    }

    public Location convert(Location location, double zAdjustment, double xyAdjustment) {
        double relX = location.getX() - oldReferencePoint.getX();
        double relY = location.getY() - oldReferencePoint.getY();
        double relZ = location.getZ() - oldReferencePoint.getZ();

        Location newLocation = newReferencePoint.clone();
        newLocation.add(relX, relY, relZ);
        newLocation.add(xyAdjustment, zAdjustment, xyAdjustment);
        newLocation.setYaw(location.getYaw());
        newLocation.setPitch(location.getPitch());
        return newLocation;
    }

    public Location c(Location a) {
        return convert(a, 0, .5);
    }

    public Location c(Location a, double z, double xy) {
        return convert(a, z, xy);
    }
}
