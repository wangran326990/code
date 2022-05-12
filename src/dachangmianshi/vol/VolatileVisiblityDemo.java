package dachangmianshi.vol;


public class VolatileVisiblityDemo {
    static class AddNumber {
        int num = 0;
        //if you not use volatile thread will never know the num's value got changed by other threads
        // util it called get num again after the value is changed by other thread
        // add volatile can guarantee visibility
        //volatile int num = 0;
        public void add60() {
            num = 60;
        }

        public int getNum() {
            return  num;
        }
    }


    public static void main(String[] args) {
        AddNumber addNumber = new AddNumber();

        new Thread(()-> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addNumber.add60();
        }).start();

        while(addNumber.getNum() == 0) {

        }
        System.out.println("number changed to 60");
    }
}
