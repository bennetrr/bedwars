package io.github.bennetrr.bedwarsplugin.cli_tools;

import java.math.BigDecimal;

public class CalculateSpawntimes {
    private static void print(Object msg) {
        System.out.println(msg);
    }

    private static String round(double value) {
        final java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(new BigDecimal(value));
    }

    public static void main(String[] args) {
        if (args.length <= 0 || args[1].equalsIgnoreCase("help")) {
            print("This program calculates the spawntimes for some spawners and prints it as markdown table");
            print("Usage: CalculateSpawntimes 0.5 150 200 300");
            print("");
            print("The first argument says how many items the spawner spawns per second at the default level (100%)");
            print("Each argument after the first is interpreted as a percent number for each level");
            print("eg. the second level should have 50 percent more items than the first, so the second argument is '150'");
            print("and the third level should have 100 percent more items than the first, so the third argument is '200' and so on");
            return;
        }

        print("| Level | Percent | Speed | Time between two spawns |");
        print("|-------|---------|-------|-------------------------|");

        double defaultValue = Double.parseDouble(args[0]);
        int defaultTicksPerItem = (int) Math.round(1 / (defaultValue / 20));
        print("| 0 | 100% | " + round(defaultValue) + " items/s | " + defaultTicksPerItem + " ticks/item |");

        for (int i = 1; i < args.length; i++) {
            int newLevelPercent = Integer.parseInt(args[i]);
            double itemsPerSecond = defaultValue * (newLevelPercent / 100.0);
            int ticksPerItem = (int) Math.round(1 / (itemsPerSecond / 20));
            print("| " + i + " | " + newLevelPercent + "% | " + round(itemsPerSecond) + " items/s | " + ticksPerItem + " ticks/item |");
        }
    }
}
