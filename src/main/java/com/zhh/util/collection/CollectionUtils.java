package com.zhh.util.collection;


import com.zhh.util.object.ObjectUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @author zhh.yin
 * @version v.1.0.0
 * @description This's Collection of related tool classes
 * @date 2018/12/22 17:29
 */
public class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean contains(Iterator<?> iterator, Object element) {
        if (iterator != null) {
            while (iterator.hasNext()) {
                Object candidate = iterator.next();
                if (ObjectUtils.safeEquals(candidate, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsInstance(Collection<?> collection, Object element) {
        if (collection != null) {
            for (Object candidate : collection) {
                if (candidate == element) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void sort(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];
        while (end > start) {
            /*从后往前比较*/
            while (end > start && a[end] >= key) {
                /*如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较*/
                end--;
            }
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            /*从前往后比较*/
            while (end > start && a[start] <= key) {
                /*如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置*/
                start++;
            }
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            /*此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用*/
        }
        /*递归*/
        if (start > low) {
            /*左边序列。第一个索引位置到关键值索引-1*/
            sort(a, low, start - 1);
        }
        if (end < high) {
            /*右边序列。从关键值索引+1到最后一个*/
            sort(a, end + 1, high);
        }
    }

    public static void quickSort(int[] arr) {
        CollectionUtils.sort(arr, 0, arr.length - 1);
    }

    public static String arrayToString(int[] arr) {
        if (arr == null) {
            return null;
        }
        int leng = arr.length;
        if (leng == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leng; i++) {
            if (i != leng - 1) {
                sb.append(arr[i]).append(",");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        System.out.println(CollectionUtils.arrayToString(arr));
        quickSort(arr);
        System.out.println(CollectionUtils.arrayToString(arr));
    }
}
