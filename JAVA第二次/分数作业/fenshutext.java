
import java.util.Scanner;

public class fenshutext {
    
    public static void main(String args[])
    {
        fenshu a = new fenshu();
        fenshu b = new fenshu();
        int opp = 0;
        System.out.println("1: + \n2：- \n3: * \n4: / ");
        Scanner input = new Scanner(System.in);
        opp = input.nextInt();
        switch (opp) {
            case 1:
                fenshu.add(a, b);
                System.out.println(a.fenzi + "/" + a.fenmu);
                break;
            case 2:
                fenshu.jian(a, b);
                System.out.println(a.fenzi + "/" + a.fenmu);
                break;
            case 3:
                fenshu.cheng(a, b);
                System.out.println(a.fenzi + "/" + a.fenmu);
                break;
            case 4:
                fenshu.chu(a, b);
                System.out.println(a.fenzi + "/" + a.fenmu);
                break;
            default:
                break;
        }
        return;
    }
}



class fenshu {
    int fenmu;
    int fenzi;


    public fenshu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("输入分子，分母");
        this.fenzi = input.nextInt();
        this.fenmu = input.nextInt();
        return;
    }

    public static void add(fenshu a,fenshu b)
    {
        fenshu.tongfen(a,b);
        a.fenzi += b.fenzi;
        if (a.fenzi == 0 || a.fenmu == 0)
        {
            a.fenzi = 0;
            a.fenmu = 0;
            return;
        }
        a.huajian();
    }

    public static void jian(fenshu a,fenshu b)
    {
        fenshu.tongfen(a,b);
        a.fenzi -= b.fenzi;
        if (a.fenzi == 0 || a.fenmu == 0)
        {
            a.fenzi = 0;
            a.fenmu = 0;
            return;
        }
        a.huajian();
        return;
    }

    public static void cheng(fenshu a,fenshu b)
    {
        a.fenmu *= b.fenmu;
        a.fenzi *= b.fenzi;
        if (a.fenzi == 0 || a.fenmu == 0)
        {
            a.fenzi = 0;
            a.fenmu = 0;
            return;
        }
        a.huajian();
        return;
    }

    
    public static void chu(fenshu a,fenshu b)
    {
        
        b.fenmu = b.fenmu ^ b.fenzi;
        b.fenzi = b.fenmu ^ b.fenzi;
        b.fenmu = b.fenmu ^ b.fenzi;
        cheng(a, b);
        if (a.fenzi == 0 || a.fenmu == 0)
        {
            a.fenzi = 0;
            a.fenmu = 0;
            return;
        }
        return;
    }



    public static void tongfen(fenshu a,fenshu b)
    {
        int z;
        int m;
        m = a.fenmu;
        z = a.fenzi;
        a.fenzi *= b.fenmu;
        a.fenmu *= b.fenmu;
        b.fenzi *= m;
        b.fenmu *= z;
        return;
    }

    public void huajian()
    {
        int t = ZuiDaGongYueShu(Math.abs(this.fenzi), Math.abs(this.fenmu));
        this.fenmu/=t;
        this.fenzi/=t;
        return;
    }

    public static int ZuiDaGongYueShu(int a,int b)
    {
        int e = a;
        int c = 0;
        int d = 0;
        for (int i = 1; i <= e; i++) {
            c = a > b ? a : b;//两个数字的大值
            d = a < b ? a : b;//两个数字的小值
            a = c % d;
            b = d;
            if (a == 0) {
                return d;
            }
        }
        return d;
    }
}
