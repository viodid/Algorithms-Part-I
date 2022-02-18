/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MyQuickUnionUF {

    public int[] id;

    public MyQuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) id[i] = i;
    }

    private int root(int i) {
        if (id[i] == -1 || id[i] == this.id.length) {
            return id[i];
        }
        while (i != id[i]) {
            // id[i] = id[id[i]];
            i = id[i];
        }
        return id[i];
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        if (i == -1) {
            id[q] = i;
        }

        else if (j == -1) {
            id[p] = j;
        }

        else if (i == this.id.length) {
            id[q] = i;
        }

        else if (j == this.id.length) {
            id[p] = j;
        }

        else {
            id[i] = j;
        }

    }

}
