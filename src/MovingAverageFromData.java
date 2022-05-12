public class MovingAverageFromData {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        movingAverage.next(1);
        movingAverage.next(10);
        movingAverage.next(3);
        movingAverage.next(5);
    }
}

class MovingAverage {
    Queue queue;
    public MovingAverage(int size) {
        this.queue = new Queue(size);
    }

    public double next(int val) {
        queue.enQueue(val);
        return queue.calculate();
    }
    static class Queue {
        int head;
        int tail;
        int size;
        int count;
        int[] queue;

        public Queue(int size) {
            this.queue = new int[size];
            this.tail = -1;
            this.head = 0;
            this.count = 0;
            this.size = size;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == size;
        }

        public boolean enQueue(int val) {
            if(isFull()) deQueue();
            tail = (tail + 1) % size;
            queue[tail] = val;
            count++;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;
            queue[head] = 0;
            head = (head + 1) % size;
            count--;
            return true;
        }

        public double calculate() {
            int count = this.count;
            int head = this.head;
            int sum = 0;
            for(int i = count; i >0; i--) {
                sum += queue[head];
                head = (head + 1) / this.size;
            }

            return sum / count;
        }
    }
}



/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */