/**
 * Project name(项目名称)：算法_基数排序
 * Package(包名): PACKAGE_NAME
 * Class(类名): CardinalitySort
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/20
 * Time(创建时间)： 15:19
 * Version(版本): 1.0
 * Description(描述)： 基数排序算法适用于对多个整数或者多个字符串进行升序或降序排序，例如：
 * 121, 432, 564, 23, 1, 45, 788
 * "zhangsan"、"lisi"、"wangwu"
 * 一个整数由多个数字组成，例如 123 由 1、2、3 这 3 个数字组成；一个字符串由多个字符组成，
 * 例如 "lisi" 由 "l"、"i"、"s"、"i" 这 4 个字符组成。基数排序算法的实现思路是：对于待排序序列中的各个元素，
 * 依次比较它们包含的各个数字或字符，根据比较结果调整各个元素的位置，最终就可以得到一个有序序列。
 * 对于待排序的整数序列，依次比较各个整数的个位数、十位数、百位数......，数位不够的用 0 表示；对于待排序的字符串序列，
 * 依次比较各个字符串的第一个字符、第二个字符、第三个字符......，位数不够的用 NULL 表示。
 * 依次比较各个元素中的个位数字、十位数字和百位数字，每次根据比较结果对所有元素进行升序排序，最终就可以得到一个升序序列。
 * 基数排序算法的实现细节
 * 仍以对 {121, 432, 564, 23, 1, 45, 788} 进行升序排序为例，基数排序算法的具体实现过程如下：
 * 1) 找到序列中的最大值（如果是字符串序列，找序列中最长的字符串），记录它的位数。通过观察不难判断，整个序列中的最大值为 788，
 * 它由 3 个数字组成。这就意味着，算法中需要依次根据各元素的个位数、十位数和百位数对所有元素进行排序。
 * 2) 找到序列中所有元素的个位数，采用计数排序算法对它们进行排序
 * 根据个位数的大小关系，{121, 432, 564, 23, 1, 45, 788} 进行了重新排序，得到的新序列为 {121, 1, 432, 23, 564, 45, 788}。
 * 3) 找到 {121, 1, 432, 23, 564, 45, 788} 中所有元素的十位数，以同样的方式进行排序，得到的新序列为 {1, 121,. 23, 432, 45, 564, 788}。
 * 4) 找到  {1, 121, 23, 432, 45, 564, 788} 中所有元素的百位数，继续以同样的方法进行排序，得到的新序列为 {1, 23, 45, 121, 432, 564, 788}。
 * 经过以上几个步骤，最终完成了对 {121, 432, 564, 23, 1, 45, 788} 序列的升序排序。
 */

public class CardinalitySort
{

    public static void sort(int[] arr)
    {
        radixSort(arr);
    }

    public static void countingSort(int[] array, int place)
    {
        int size = array.length;
        int[] output = new int[size];
        // 假设第一个元素指定数位上的值最大
        int max = (array[0] / place) % 10;
        // 找到真正数位上值最大的元素
        for (int i = 1; i < size; i++)
        {
            if (((array[i] / place) % 10) > max)
            {
                max = array[i];
            }
        }
        // 创建并初始化 count 数组
        int[] count = new int[max + 1];
        for (int i = 0; i < max; ++i)
        {
            count[i] = 0;
        }
        // 统计各个元素出现的次数
        for (int i = 0; i < size; i++)
        {
            count[(array[i] / place) % 10]++;
        }
        // 累加 count 数组中的出现次数
        for (int i = 1; i < 10; i++)
        {
            count[i] += count[i - 1];
        }
        // 根据 count 数组中的信息，找到各个元素排序后所在位置，存储在 output 数组中
        for (int i = size - 1; i >= 0; i--)
        {
            output[count[(array[i] / place) % 10] - 1] = array[i];
            count[(array[i] / place) % 10]--;
        }
        // 将 output 数组中的数据原封不动地拷贝到 array 数组中
        for (int i = 0; i < size; i++)
        {
            array[i] = output[i];
        }
    }

    // 找到整个序列中的最大值
    public static int getMax(int[] array)
    {
        int size = array.length;
        int max = array[0];
        for (int i = 1; i < size; i++)
        {
            if (array[i] > max)
            {
                max = array[i];
            }
        }
        return max;
    }

    // 基数排序算法
    public static void radixSort(int[] array)
    {
        // 找到序列中的最大值
        int max = getMax(array);
        // 根据最大值具有的位数，从低位依次调用计数排序算法
        for (int place = 1; max / place > 0; place *= 10)
        {
            countingSort(array, place);
            print(array);
        }
    }

    private static void print(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
