package Main;

import java.awt.Color;

public class ColorSetting {

    // Light palette link: https://colorhunt.co/palette/effffdb8fff985f4ff42c2ff
    private static Color light0 = new Color(0, 0, 0);
    private static Color light1 = new Color(239, 255, 253);
    private static Color light2 = new Color(184, 255, 249);
    private static Color light3 = new Color(133, 244, 255);
    private static Color light4 = new Color(66, 194, 255);
    private static Color[] lightColors = { light0, light1, light2, light3, light4 };

    // Dark palette link: https://colorhunt.co/palette/2c33332e4f4f0e8388cbe4de
    private static Color dark0 = new Color(255, 255, 255);
    private static Color dark1 = new Color(44, 51, 51);
    private static Color dark2 = new Color(46, 79, 79);
    private static Color dark3 = new Color(14, 131, 136);
    private static Color dark4 = new Color(203, 228, 222);
    private static Color[] darkColors = { dark0, dark1, dark2, dark3, dark4 };

    public static Color[] getWelcomeColors(String c) {
        if (c.equalsIgnoreCase("Dark"))
            return darkColors;
        else
            return lightColors;
    }
}
