package oa.bluemoon.com.cn.lib_java;

/**
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-queue
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0622_Design_Circular_Queue {

    class MyCircularQueue {

        private int[] queue;

        private int head, foot;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            queue = new int[k + 2];
            head = 0;
            foot = 1;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is
         * successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) return false;
            queue[foot] = value;
            foot = (foot + 1) % queue.length;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) return false;
            head = (head + 1) % queue.length;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) return -1;
            return queue[(head + 1) % queue.length];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) return -1;
            return queue[(foot - 1+queue.length) % queue.length];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return (head + 1) % queue.length == foot;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return (foot + 1) % queue.length == head;
        }
    }

}
