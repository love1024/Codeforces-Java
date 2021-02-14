import java.util.Scanner;


public class BooksExchangeHardVersion_1249B2 {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Union Find Data structure
     * https://github.com/love1024/Algorithms-Library-In-Java/blob/master/src/UnionFind/UnionFind.java
     */
    public class UnionFind {
        private int[] parent;
        private int[] sizes;

        public UnionFind(int N) {
            // Set parent of each element to itself
            // (N array accesses)
            parent = new int[N];
            sizes = new int[N];

            for (int i=0; i<N; i++) {
                parent[i] = i;
                sizes[i] = 1;
            }
        }

        int root(int p) {
            // Check parent pointers until reach root
            // (Depth of i array accesses)
            while (parent[p] != p) {

                //PATH COMPRESSION
                //No need to traverse path all time
                //Just make it point to grandparent instead of parent
                //Halving the length to traverse, as we only care about root
                parent[p] = parent[parent[p]];

                p = parent[p];
            }
            return p;
        }

        public boolean connected(int p, int q) {
            // Check if p and q have the same root
            // (Depth of p and q array accesses)
            return this.root(p) == this.root(q);
        }

        public void union(int p, int q) {
            // Change root of p to point to q
            // (Depth of p and q array accesses)
            int p_root = this.root(p);
            int q_root = this.root(q);

            // If they already under same parent, no need to do anything
            if(p_root == q_root) return;

            // If size of p is small, attach it to q, otherwise opposite
            if(sizes[p_root] < sizes[q_root]) {
                this.parent[p_root] = q_root;
                sizes[q_root] += sizes[p_root];
            } else {
                this.parent[q_root] = p_root;
                sizes[p_root] += sizes[q_root];
            }
        }

        // Get size of the root element
        public int getRootSize(int p) {
            int root = this.root(p);
            return this.sizes[root];
        }
    }


    public static void main(String[] args) {
        // Read number of queries
        int q = sc.nextInt();

        // While there are some queries left
        while(q-- > 0) {

            // Read number of kids and store them in an array
            int n = sc.nextInt();

            // Union find data structures to union elements that are cyclic or
            // one element passes through components before reaching to its origin
            UnionFind uf = new BooksExchangeHardVersion_1249B2().new UnionFind(n);
            int[] kids = new int[n];
            for(int i = 0; i < n; i++) {
                kids[i] = sc.nextInt();

                // Union current one and the element it is pointing to
                uf.union(i, kids[i] - 1);
            }

            // Loop over all kids
            for(int i = 0; i < n; i++) {

                // Get size of the connected components with the current element
                int size = uf.getRootSize(kids[i]-1);

                // Print number of days it took to reach the current element again or
                // size of the connected components
                System.out.print(size + (i == n -1 ? "" : " "));
            }
            System.out.println("");
        }
    }

}
