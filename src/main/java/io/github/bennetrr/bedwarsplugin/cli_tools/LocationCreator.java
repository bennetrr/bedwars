package io.github.bennetrr.bedwarsplugin.cli_tools;

public class LocationCreator {
    private static void print(Object msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        if (args.length < 3 || args[0].equalsIgnoreCase("help")) {
            print("This script prints out a new Location(w, x, y, z, yaw, pitch) for the minecraft x y z yaw pitch form.");
            print("Usage: LocationCreator <x> <y> <z> [yaw] [pitch]");
            return;
        }
        String output = "new Location(w, " + args[0] + ", " + args[1] + ", " + args[2];
        if (args.length > 3) output += ", " + args[3];
        if (args.length > 4) output += ", " + args[4];
        output += ")";

        print(output);
    }
}
