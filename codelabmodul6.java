import java.util.*;

public class codelabmodul6 {
    static final int JUMLAH_GUDANG = 5;
    static String[] namaGudang = {"A", "B", "C", "D", "E"};
    static int[][] adjacencyMatrix = new int[JUMLAH_GUDANG][JUMLAH_GUDANG];

    // Menambahkan jalur pengiriman (directed edge)
    public static void tambahJalur(int asal, int tujuan) {
        adjacencyMatrix[asal][tujuan] = 1;
    }

    //adjacency matrix
    public static void tampilkanMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("   ");
        for (String nama : namaGudang) {
            System.out.print(nama + " ");
        }
        System.out.println();
        for (int i = 0; i < JUMLAH_GUDANG; i++) {
            System.out.print(namaGudang[i] + ": ");
            for (int j = 0; j < JUMLAH_GUDANG; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // BFS
    public static void bfs(int start) {
        boolean[] visited = new boolean[JUMLAH_GUDANG];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS dari gudang " + namaGudang[start] + ": ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(namaGudang[current] + " ");

            for (int i = 0; i < JUMLAH_GUDANG; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    // DFS
    public static void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(namaGudang[start] + " ");
        for (int i = 0; i < JUMLAH_GUDANG; i++) {
            if (adjacencyMatrix[start][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        tambahJalur(0, 1); // A -> B
        tambahJalur(0, 2); // A -> C
        tambahJalur(1, 3); // B -> D
        tambahJalur(2, 3); // C -> D
        tambahJalur(3, 4); // D -> E
        tambahJalur(2, 4); // C -> E
        tambahJalur(4, 0); // E -> A

        tampilkanMatrix();

        bfs(0);

        System.out.print("DFS dari gudang A: ");
        boolean[] visited = new boolean[JUMLAH_GUDANG];
        dfs(0, visited);
        System.out.println();
    }
}
