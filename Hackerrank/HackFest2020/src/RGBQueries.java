import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RGBQueries {


    public static List<String> mixColors(List<List<Integer>> colors, List<List<Integer>> queries) {

        List<String> l = new ArrayList<>(queries.size());

        Map<Integer, List<List<Integer>>> redMap = new HashMap<>();
        Map<Integer, List<List<Integer>>> greenMap = new HashMap<>();
        Map<Integer, List<List<Integer>>> blueMap = new HashMap<>();

        for (List<Integer> c : colors) {

            int red = c.get(0);
            int blue = c.get(1);
            int green = c.get(2);

            if (redMap.containsKey(red)) {
                redMap.get(red).add(c);
            } else {
                List<List<Integer>> list = new ArrayList<>();
                list.add(c);
                redMap.put(red, list);
            }

            if (blueMap.containsKey(blue)) {
                blueMap.get(blue).add(c);
            } else {
                List<List<Integer>> list = new ArrayList<>();
                list.add(c);
                blueMap.put(blue, list);
            }

            if (greenMap.containsKey(green)) {
                greenMap.get(green).add(c);
            } else {
                List<List<Integer>> list = new ArrayList<>();
                list.add(c);
                greenMap.put(green, list);
            }


        }

        Map<String, String> solvedQueries = new HashMap<>();

        for (List<Integer> q : queries) {

            boolean redMatch = false;
            boolean blueMatch = false;
            boolean greenMatch = false;

            int red = q.get(0);
            int blue = q.get(1);
            int green = q.get(2);

            String queryKey = red + ":" + blue + ":" + green;

            if (solvedQueries.containsKey(queryKey)) {
                l.add(solvedQueries.get(queryKey));
                continue;
            }

            if (!redMap.containsKey(red) || !blueMap.containsKey(blue) || !greenMap.containsKey(green)) {
                l.add("NO");
                solvedQueries.put(queryKey, "NO");
                continue;
            }


            for (List<Integer> redColors : redMap.get(red)) {

                if (redColors.get(1) <= blue && redColors.get(2) <= green) {
                    redMatch = true;
                    blueMatch = redColors.get(1) == blue;
                    greenMatch = redColors.get(2) == green;
                    break;
                }
            }

            if (!redMatch) {
                l.add("NO");
                solvedQueries.put(queryKey, "NO");
                continue;
            } else if (blueMatch && greenMatch) {
                l.add("YES");
                solvedQueries.put(queryKey, "YES");
                continue;
            }

            for (List<Integer> blueColors : blueMap.get(blue)) {

                if (blueColors.get(0) <= red && blueColors.get(2) <= green) {
                    blueMatch = true;
                    greenMatch = greenMatch || blueColors.get(2) == green;
                    break;
                }
            }

            if (!blueMatch) {
                l.add("NO");
                solvedQueries.put(queryKey, "NO");
                continue;
            } else if (greenMatch) {
                l.add("YES");
                solvedQueries.put(queryKey, "YES");
                continue;
            }


            for (List<Integer> greenColors : greenMap.get(green)) {

                if (greenColors.get(0) <= red && greenColors.get(1) <= blue) {
                    greenMatch = true;
                    break;
                }
            }

            if (!greenMatch) {
                l.add("NO");
                solvedQueries.put(queryKey, "NO");
            } else {
                l.add("YES");
                solvedQueries.put(queryKey, "YES");
            }

        }

        return l;
    }

    public static List<String> mixColorsFirstAttempt(List<List<Integer>> colors, List<List<Integer>> queries) {

        colors.sort((o1, o2) -> o1.get(0) - o2.get(0));

        List<String> l = new ArrayList<>(queries.size());


        for (List<Integer> q : queries) {


            boolean redMatch = false;
            boolean greenMatch = false;
            boolean blueMatch = false;

            int red = q.get(0);
            int green = q.get(1);
            int blue = q.get(2);

            for (List<Integer> c : colors) {

                int currRed = c.get(0);
                int currGreen = c.get(1);
                int currBlue = c.get(2);

                if (redMatch && blueMatch && greenMatch) {
                    break;
                }

                if (currRed > red) {
                    break;
                } else if (currGreen <= green && currBlue <= blue) {

                    if (currRed == red)
                        redMatch = true;

                    if (currGreen == green)
                        greenMatch = true;

                    if (currBlue == blue)
                        blueMatch = true;
                }

            }

            if (redMatch && blueMatch && greenMatch) {
                l.add("YES");
            } else {
                l.add("NO");
            }
        }

        return l;
    }
}
