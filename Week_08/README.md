# 第8周 第16课 | 位运算

计算机中数字的表示形式和存储形式都是二进制，所以对数字的操作本质上都是对二进制的操作，在代码中使用位运算的效率远远高于使用各种乘除运算符的效率。

<img src="https://user-gold-cdn.xitu.io/2020/7/11/1733b72d23d0c79a?w=861&amp;h=643&amp;f=png&amp;s=943215" style="zoom:50%;" />

|            含义            | 运算符 |         示例         |
| :------------------------: | :----: | :------------------: |
|            左移            |   <<   |     0011 => 0110     |
|            右移            |  \>>   |     0110 => 0011     |
|           按位或           |   \|   | 0011 \| 1011 => 1011 |
|           按位与           |   &    | 0011 & 1011 => 0011  |
| 异或（相同为零，不同为一） |   ~    | 0011 & 1011 => 1000  |
|            取反            |   ^    |    ^ 0011 => 1100    |

常用的位运算技巧：

**（1）XOR - 异或**

- x ^ 0 = x：x 异或 0 等于 x本身
- x ^ 1s = ~x：x 异或 全1，相当于 x 本身取反
- x ^ (~x) = 1s ：x 和 ~x 全部位都不同，异或为全1
- x ^ x = 0：x 和 x 所有位都相同，异或为0

**（2）指定位置的位运算**

- 将 x 最右边的 n 位清零：x & (~0 << n)
- 获取 x 的第 n 位的值（0 或者 1）：(x >> n) & 1
- 获取 x 的 n 次幂的值：x & (1 << n)
- 仅将第 n 位设置为1：x | (1 << n)
- 仅将第 n 位设置为0：x & (~(1 << n))
- 将 x 的最高位至第 n 位清零：x & ((1 << n) - 1)

**（3）实战位运算特点【重要】**

- 判断奇偶：(x & 1) == 1
- x 除以 2：(x >> 1)
- 清除最低位的 1：x = x & (x - 1)
- 得到最低位的1：x & (-x)
- x & ~x = 0

在开发中，如果可以用位运算解决，尽可用位运算，因为位运算带来的效率提升比算术运算符高很多

# 第8周 第17课 | 布隆过滤器

布隆过滤器常用于缓存当中，用于判断某个元素是否**可能**存在于缓存或数据库中。

注意上面的“可能”二字，布隆过滤器并不是精确判断的，可能会出现误判的情况，但是由于几率较低，且代价小，效率高，可接受，所以布隆过滤器的应用仍非常广泛。

传统的 Hash Table 可以保证元素的精确匹配，散列冲突时使用拉链法或者红黑树解决，但是有时候在应用场景中不需要存放所有的数据，只需要判断**某个数据在集合中存不存在**即可。

<img src="https://user-gold-cdn.xitu.io/2020/7/11/1733b80e1e53b67c?w=1692&amp;h=850&amp;f=png&amp;s=740459" style="zoom:40%;" />

布隆过滤器由**一个很长的二进制向量和多个随机散列函数**构成，用于检索某个元素是否存在集合中，不存储元素本身

优点：空间效率和查询时间都远远超过一般算法

缺点：有一定的误识别率

当x，y，z依次给布隆过滤器校验时，它会先经过散列函数得到三个插槽位置，布隆过滤器会判断对应的插槽位置是否都为1

**只要有1个0，就认为该元素不存在于集合（数据库）中**

反之，如果全部都是1，则认为该元素**可能**存在于集合（数据库）中

<img src="https://user-gold-cdn.xitu.io/2020/7/11/1733b8ee86233346?w=1671&amp;h=749&amp;f=png&amp;s=442965" style="zoom:40%;" />

这时候你会发现，w在检索时，映射的位置会与x和y的一部分重叠

如果有一个元素 q，映射到布隆过滤器中的索引位置全部都是1，**不可以证明 q 一定在布隆过滤器中**，因为索引位置可能会产生重叠

总结：如果一个元素A在布隆过滤器中的索引位置存在0，则一定不存在；如果全是1，则可能存在于集合（数据库）中

应用场景：

- 比特币
- 分布式系统（推荐系统，搜索引擎···）
- 防止 Redis 缓存穿透
- 垃圾邮件、评论等过滤

[布隆过滤器(Bloom Filter)的原理和实现](https://www.cnblogs.com/cpselvis/p/6265825.html)

设计一个缓存，需要考虑哪些因素？

- 存储容量
- 元素的淘汰策略（LRU、LFU······）
- 线程安全性

在应用中，淘汰策略多使用LRU（Latest Recently Used），最近最少使用替换算法

<img src="https://user-gold-cdn.xitu.io/2020/7/11/1733ba101af69566?w=1323&amp;h=572&amp;f=png&amp;s=425184" style="zoom:43%;" />

经典的练习题目：[146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/)

在面试中，常被考到这道题，如果可以调用库中的数据结构，那么就不必自己手动维护一个双向链表+HashTable了，在Java语言中有 LinkedHashMap 这一数据结构，它底层就是利用 LRU 淘汰策略的哈希表。

```java
class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```

# 第8周 第18课 | 排序算法

排序算法可分为两类：

- 比较类排序：冒泡排序、插入排序、选择排序、希尔排序、快速排序、归并排序、堆排序
- 非比较类排序：基数排序，计数排序，桶排序

其中比较类排序的前四个被认为是初级排序算法，因为其原理较为简单、较容易实现，而后面三个称为高级排序算法，因为其利用到归并思想，可用递归实现。

而非比较类排序的意思是，元素的排序不是基于元素与元素之间的比较，而是元素自身进行排序，常需要借助外部存储空间。

**冒泡排序：每一轮都选择一个最大值放在数组的最后**

```java
public class BubbleSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
   	public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```

**快速排序**：每一轮排序选定一个 pivot，当前轮次排完序后所有小于 pivot 的元素都处于 pivot 的左边，大于 pivot 的都在其右边

```java
public class QuickSort {
    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return ;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }
    public static int partition(int[] arr, int begin, int end) {
        int count = begin, pivot = end;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[i]; arr[i] = arr[count]; arr[count] = temp;
                count++;
            }
        }
        int temp = arr[count]; arr[count] = arr[pivot]; arr[pivot] = temp;
        return count;
    }
}
```

**归并排序**：先排序好两边的数组，然后两个数组再排序合成一个新的已排好序的数组

```java
import java.util.Arrays;

/**
 * @author Zeng
 * @date 2020/7/11 15:02
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int begin, int end) {
        if (end <= begin) return ;
        int mid = begin + ((end - begin) >> 1);
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }
    public static void merge(int[] arr, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1]; // 中间数组
        int i = begin, j = mid + 1, index = 0;
        while (i <= mid && j <= end) {
            temp[index++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= end) {
            temp[index++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, begin, end - begin + 1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 23, 2, 321, 42, 1412, 421, 412, 412, 412, 4124, 5, 3445, 645, 6455, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
```

# 个人总结

（1）位运算的效率非常高，并且有时候可以用来快速判断某些条件是否成立

- 奇偶判断
- 2的幂次方判断

也可以用于做四则运算操作，最常用的是除2和乘2，相当于右移一位和左移一位

（2）布隆过滤器的特点：能够快速判断某个元素是否可能存在于集合（数据库）中，但是会有少量的误判

- 优点：判断速度快，消耗空间少
- 缺点：一定的误判率

（3）排序算法中，简单的排序算法常考的是冒泡排序的手写，而且要有优化，其次是归并排序、快速排序这两个排序算法在面试中出现频次也很高，其他的排序算法一般要求说出其时间复杂度和空间复杂度，并且解释其原理。注意堆排序，要想到自己的语言里已经实现好的数据结构，在面试时如果可以用则直接用，如果不可以用，也要尽量边讲解，边写出大概的代码，**用数组手动维护一个堆**。

**我是小菠萝，比我优秀的人多了去，但这并不阻止我追梦！**