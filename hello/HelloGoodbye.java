/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


public class HelloGoodbye {
    public static void main(String[] args) {
        int arguments = args.length;
        if (arguments != 2) {
            System.out.println("Incorrect number of arguments");
        }
        else {
            System.out.println("Hello " + args[0] + " and " + args[1]);
            System.out.println("Goodbye " + args[1] + " and " + args[0]);
        }
    }
}
