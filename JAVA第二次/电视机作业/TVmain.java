
import java.util.Random;
import java.util.Scanner;




public class TVmain {

    public static void main(String args[])
    {
        TVtest TV = new TVtest();
        int opp = 0;
        while (opp != -1)
        {
            System.out.println("1:开机\n2：换台\n3:音量\n4:关机");
            Scanner input = new Scanner(System.in);
            opp = input.nextInt();
            switch (opp)
            {
                case 1:
                    TV.open();
                    break;
                case 2:
                    if (!TV.getTVOn())
                    {
                        break;
                    }
                    TV.huan();
                    break;
                case 3:
                    if (!TV.getTVOn())
                    {
                        break;
                    }
                    TV.setvol();
                    break;
                case 4:
                if (!TV.getTVOn())
                {
                    break;
                }
                 TV.close();
                 break;
                default:
                    if (!TV.getTVOn())
                    {
                        break;
                    }
                    System.out.println("无按键");
                    break;
            }
        }



        return;
    }
}



class TVtest {
    private static int tai;
    private static int volum;
    private boolean on ;

    public boolean getTVOn()
    {
        return this.on;
    }
    public TVtest()
    {
        Random r = new Random(1);
        this.tai = r.nextInt(100);
        volum = 50;
        this.on = false;

    }
    public void huan()
    {
        System.out.println("W：前进,S：后退。数字直接换台");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        if(isNumeric(str))
        {
            int num = Integer.parseInt(str);
            huantai(num);
        }
        else {
            huantai(str);
        }

    }
    public void huantai(int a)
    {
        this.tai = a;
        System.out.println("已换台，当前台：" + this.tai + "。");
        return;
    }

    public void huantai(String str)
    {
        switch (str) {
            case "W":
            case "w":
                this.tai++;
                break;
            case "S":
            case "s":
                this.tai--;
                break;
        }
        System.out.println("已换台，当前台：" + this.tai + "。");
    }

    public void setvol()
    {
        System.out.println("W：+ ,S：- 。");
        String str = new String();
        System.out.println("-1退出");
        Scanner input = new Scanner(System.in);
        str = "0";
        while(!str.equals("-1"))
        {
            str = input.nextLine();
            if (str.equals("w") || str.equals("W")) {
                this.volum++;
            } else if (str.equals("s") || str.equals("S")) {
                this.volum--;
            }
            if (this.volum <= 0)
            {
                this.volum = 0;
            }
            else if (this.volum >= 100)
            {
                this.volum = 100;
            }
            System.out.println("当前音量：" + this.volum + "。");            
        }
        return;
    }
    
    public void open()
    {
        this.on = true;
        System.out.println("开机：欢迎使用LED_TV电视机");
        return;
    }
    
    public void close()
    {
        this.on = false;
        return;
    }

    public static boolean isNumeric(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            if(!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
}
