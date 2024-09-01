package cz.filipino04.pianonotestesting.model;

import java.util.ArrayList;
import java.util.Arrays;


public class Constants {
    public static final ArrayList<String> whiteKeys = new ArrayList<>(Arrays.asList("C", "D", "E", "F", "G", "A", "H", "c", "d", "e",
            "f", "g", "a", "h", "c1", "d1", "e1", "f1", "g1", "a1", "h1", "c2", "d2", "e2", "f2", "g2", "a2", "h2"));

    public static final ArrayList<String> blackKeys = new ArrayList<>(Arrays.asList("Cis", "Dis", "Fis", "Gis", "Ais", "cis", "dis", "fis", "gis", "ais", "cis1", "dis1", "fis1", "gis1", "ais1",
            "cis2", "dis2", "fis2", "gis2", "ais2"));

    public static final int HelpWidth = 1400;
    public static final int HelpHeight = 700;

    public static final int MenuWidth = 200;
    public static final int MenuHeight = 200;

    public static final int GameWidth = 2000;
    public static final int GameHeight = 1400;

    public static final int OverDim = 500;
}
