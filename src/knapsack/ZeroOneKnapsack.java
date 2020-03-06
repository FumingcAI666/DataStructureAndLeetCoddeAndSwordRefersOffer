package knapsack;

import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @author macfmc
 * @date 2020/3/4-0:06
 */
public class ZeroOneKnapsack {

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

        for(int i=1;i<=n;i++){
            for(int j=m;j>=v[i];j--){
                f[j]=max(f[j],f[j-v[i]]+w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
