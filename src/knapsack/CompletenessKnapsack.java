package knapsack;

import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @author macfmc
 * @date 2020/3/3-20:22
 */
public class CompletenessKnapsack {

    /**
     * 4 5
     * 1 2
     * 2 4
     * 3 4
     * 4 5
     * 10
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 1000;
        int n = sc.nextInt(); //商品数
        int m = sc.nextInt(); //体积
        int f[] = new int[N];
        int v[] = new int[N]; //商品重量
        int w[] = new int[N]; //商品价格

        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                for (int k = 0; k * v[i] <= j; k++)
                    if (v[i] <= j) {
                        f[j] = max(f[j], f[j - k * v[i]] + k * w[i]);
                    }

        for (int j = 1; j <= m; j++)
            System.out.print(f[j] + " ");

        System.out.println(f[m]);

        /**
         * 优化
         */
        for (int i = 1; i <= n; i++)
            for (int j = v[i]; j <= m; j++)
                f[j] = max(f[j], f[j - v[i]] + w[i]);
        System.out.println(f[m]);
        System.out.println();

    }
}
