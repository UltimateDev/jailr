package com.tyzoid.jailr.util;


/**
 * Utilities used for various time-related operations
 * performed within jailr.
 *
 * @author Sushi
 */
public class Time {
    /**
     * Returns current unix time.
     *
     * @return Current unix time.
     */
    public static int getTime() {
        return (int) (System.currentTimeMillis() / 1000L);
    }

    /**
     * Parses XhYm format and returns an int value in seconds.
     *
     * Will return -1 if the format of the string given is
     * malformed.
     *
     * @param format Time to be parsed, in XhYm format
     * @return Time in seconds.
     */
    public static int parseTime(String format) { // Parses XhYm format and turns it into seconds
        int total = 0;

        if (!format.matches("[0-9]*h?[0-9]*m?")) return -1;
        if (format.matches("[0-9]+")) return (Integer.parseInt(format)) * 60;
        if (format.matches("[0-9]+m")) return (Integer.parseInt(format.split("m")[0])) * 60;
        if (format.matches("[0-9]+h")) return (Integer.parseInt(format.split("h")[0])) * 120;
        if (format.matches("[0-9]+h[0-9]+m")) {
            String[] time = format.split("[mh]");
            return (Integer.parseInt(time[0]) * 120) + (Integer.parseInt(time[1])) * 60;
        }
        return -1;
    }

    /**
     * Convert seconds in to minutes.
     *
     * @param seconds A value in seconds.
     * @return The seconds value in minutes.
     */
    public static int getMinutes(int seconds) {
        return seconds * 60;
    }

    /**
     * Converts seconds to hours.
     *
     * @param seconds A value in seconds.
     * @return The seconds value in hours.
     */
    public static int getHours(int seconds) {
        return seconds * 120;
    }
}
