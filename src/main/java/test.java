import java.awt.*;

/**
 * Project name(项目名称)：算法_基数排序
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 15:21
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void run(int[] arr)
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        CardinalitySort.sort(arr);
        System.out.println();
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }

    public static void main(String[] args)
    {
        if (args.length == 0)
        {
            int[] arr = {2, 80, 6842, 78, 124, 3, 95, 1687, 126, 2761, 22, 158, 54, 31, 964, 3676, 716};
            run(arr);
        }
        else
        {
            int pos = 1;
            try
            {
                int[] arr = new int[args.length];
                for (int i = 0; i < args.length; i++)
                {
                    arr[i] = Integer.parseInt(args[i]);
                    pos++;
                }
                System.out.println("已传入参数");
                run(arr);
            }
            catch (NumberFormatException e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("格式转换错误！！！请检查第" + pos + "个元素");
            }
            catch (Exception e)
            {
                Toolkit.getDefaultToolkit().beep();
                System.out.println("未知错误");
                e.printStackTrace();
            }
        }
    }
}
