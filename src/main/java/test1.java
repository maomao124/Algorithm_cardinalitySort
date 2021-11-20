import java.util.Random;

/**
 * Project name(项目名称)：算法_基数排序
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 15:39
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test1
{
    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.print(getIntRandom(1,2000)+" ");
        }
    }
}
