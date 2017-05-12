[可视化算法演示网站](http://zh.visualgo.net)
#####维基百科标准的排序算法写法
- 堆排序
```java

import java.util.Arrays;

public class HeapSort {
    
    private int[] arr;
    
    public HeapSort(int[] arr){
        this.arr = arr;
    }
    
    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sort(){
        /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
        int len = arr.length - 1;
        int beginIndex = (len - 1) >> 1; 
        for(int i = beginIndex; i >= 0; i--){
            maxHeapify(i, len);
        }
        
        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
        for(int i = len; i > 0; i--){
            swap(0, i);
            maxHeapify(0, i - 1);
        }
    }
    
    private void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * 调整索引为 index 处的数据，使其符合堆的特性。
     * 
     * @param index 需要堆化处理的数据的索引
     * @param len 未排序的堆（数组）的长度
     */
    private void maxHeapify(int index,int len){
        int li = (index << 1) + 1; // 左子节点索引
        int ri = li + 1;           // 右子节点索引
        int cMax = li;             // 子节点值最大索引，默认左子节点。
        
        if(li > len) return;       // 左子节点索引超出计算范围，直接返回。
        if(ri <= len && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
            cMax = ri;
        if(arr[cMax] > arr[index]){
            swap(cMax, index);      // 如果父节点被子节点调换，
            maxHeapify(cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
        }
    }
    
    /**
     * 测试用例
     * 
     * 输出：
     * [0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9]
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};        
        new HeapSort(arr).sort();        
        System.out.println(Arrays.toString(arr));
    }
    
}

```


- 选择排序
```
public static void selection_sort(int[] arr) {
	int i, j, min, temp, len = arr.length;
	for (i = 0; i < len - 1; i++) {
		min = i;//未排序序列中最小数据数组下标
		for (j = i + 1; j < len; j++)//在未排序元素中继续寻找最小元素，并保存其下标
			if (arr[min] > arr[j])
				min = j;
		temp = arr[min]; //将最小元素放到已排序序列的末尾
		arr[min] = arr[i];
		arr[i] = temp;
	}
}

```

- 冒泡排序
```
  public static void bubbleSort(int[] arr) {
	int i, j, temp, len = arr.length;
	for (i = 0; i < len - 1; i++)
		for (j = 0; j < len - 1 - i; j++)
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
	}

```

- 快速排序
```java
class quick_sort {
	int[] arr;

	private void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	private void quick_sort_recursive(int start, int end) {
		if (start >= end)
			return;
		int mid = arr[end];
		int left = start, right = end - 1;
		while (left < right) {
			while (arr[left] <= mid && left < right)
				left++;
			while (arr[right] >= mid && left < right)
				right--;
			swap(left, right);
		}
		if (arr[left] >= arr[end])
			swap(left, end);
		else
			left++;
		quick_sort_recursive(start, left - 1);
		quick_sort_recursive(left + 1, end);
	}

	public void sort(int[] arrin) {
		arr = arrin;
		quick_sort_recursive(0, arr.length - 1);
	}
}



```