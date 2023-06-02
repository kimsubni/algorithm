import java.util.*;

public class Programmers_표병합  {
    static int[] parent = new int[2501];
    static String[] table = new String[2501];

    static public int getParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    static public void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static public int convertPos(int r, int c) {
        int result = (r - 1) * 50;
        return result + c;
    }

    public String[] solution(String[] commands) {
        for (int i = 1; i <= 2500; ++i) {
            parent[i] = i;
            table[i] = "";
        }
        List<String> result = new ArrayList<>();
        for (String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            String order = st.nextToken();
            if ("UPDATE".equals(order)) {
                if (st.countTokens() == 2) {
                    String val1 = st.nextToken();
                    String val2 = st.nextToken();
                    for (int i = 1; i <= 2500; ++i) {
                        if (val1.equals(table[i])) {
                            table[i] = val2;
                        }
                    }
                } else {
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    String val = st.nextToken();
                    int num = convertPos(r, c);
                    table[getParent(num)] = val;
                }
            } else if ("MERGE".equals(order)) {
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int num1 = convertPos(r1, c1);
                int num2 = convertPos(r2, c2);
                int root1 = getParent(num1);
                int root2 = getParent(num2);
                if (root1 == root2)
                    continue;
                String rootStr = table[root1].isBlank() ? table[root2] : table[root1];
                table[root1] = "";
                table[root2] = "";
                union(root1, root2);
                table[root1] = rootStr;
            } else if ("UNMERGE".equals(order)) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int num = convertPos(r, c); // 이 좌표에서
                int root = getParent(num);
                String rootStr = table[root];
                table[root] = "";
                table[num] = rootStr;
                for (int i = 1; i <= 2500; ++i) {
                    if (root == getParent(i)) {
                        parent[i] = i;
                    }
                }

            } else if ("PRINT".equals(order)) {
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int num = convertPos(r, c);
                int root = getParent(num);

                if (table[root].isBlank()) {
                    result.add("EMPTY");
                } else {
                    result.add(table[root]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}