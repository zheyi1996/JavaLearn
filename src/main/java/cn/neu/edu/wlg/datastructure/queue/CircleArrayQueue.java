package cn.neu.edu.wlg.datastructure.queue;

public class CircleArrayQueue {
}

class CircleArry {
    private int maxSize; // 数组容量
    private int front; // 队列头
    private int rear; // 队列尾 + 1
    private int [] arr; // 存放队列数据的数组
    private CircleArry(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不可添加");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取队头
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        // 1. 先把front对应的值保存
        // 2. 将front后移
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    // 遍历队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i <= (rear - front + maxSize) % maxSize; ++i) {
            System.out.printf("arr[%d]=%d=\n", i, arr[i]);
        }
    }

    // 显示头元素
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        return arr[front];
    }
}
