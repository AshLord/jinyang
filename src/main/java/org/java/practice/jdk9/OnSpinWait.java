package org.java.practice.jdk9;

public class OnSpinWait {
    volatile boolean eventNotificationNotReceived = true;

    public void setEventNotificationNotReceived(boolean eventNotificationNotReceived) {
        this.eventNotificationNotReceived = eventNotificationNotReceived;
    }

    public static void main(String[] args) {
        OnSpinWait helloJDK9 = new OnSpinWait();
        new Thread(() -> {
            System.out.println("线程一开始等待线程二的指令");

            while (helloJDK9.eventNotificationNotReceived) {
                Thread.onSpinWait();
            }
            System.out.println("线程一收到线程二的指令");
        }).start();

        new Thread(() -> {
            try {
                System.out.println("线程二等待1秒");
                Thread.sleep(1000);
                helloJDK9.setEventNotificationNotReceived(false);
                System.out.println("线程二发出指令");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
