/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Randomword {
    public static void main(String[] args) {
        double ith = 1.0;
        String champ = "No input";
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / ith)) {
                champ = input;
            }
            ith++;
        }
        StdOut.println(champ);
    }
}
