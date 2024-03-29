package dachangmianshi.concurrency.reentrancelock;

class Phone {
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getId() );
        this.sendEmail();
    }
    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getId() + " " + "send email");
    }
}

public class ReentranceLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()-> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()-> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
