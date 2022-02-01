/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;

public class StaticticsRandomWord {
    public static void main(String[] args) {
        String[] animals = {
                "ant", "bear", "cat", "dog", "emu", "fox", "goat", "horse", "turtle", "python",
                "anaconda", "mamut"
        };
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < 12; i++) {
            dictionary.put(animals[i], 0);
        }

        for (int i = 0; i <= 50000; i++) {
            double ith = 1.0;
            String champ = "No input";
            for (int j = 0; j < 12; j++) {
                String input = animals[j];
                if (StdRandom.bernoulli(1.0 / ith)) {
                    champ = input;
                }
                ith++;
            }
            int counter = dictionary.get(champ);
            counter++;
            dictionary.put(champ, counter);
        }
        for (int i = 0; i < 12; i++) {
            double prePrecentage = (double) dictionary.get(animals[i]) / 50000;
            StdOut.println(
                    animals[i] + ": " + dictionary.get(animals[i]) + " - " + prePrecentage * 100);
        }
    }
}
