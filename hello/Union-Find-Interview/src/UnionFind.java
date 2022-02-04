public class UnionFind {
    private final int[] id;

    public UnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String[] args) {
        UnionFind test = new UnionFind(7);
        test.union(5, 3);
        test.union(4, 6);
        test.union(5, 6);
        test.union(2, 3);
        test.union(4, 1);

        System.out.println(test.connected(1, 6));
    }
}
