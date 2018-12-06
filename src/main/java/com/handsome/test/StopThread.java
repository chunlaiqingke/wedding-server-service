package com.handsome.test;

public class StopThread {
    private static boolean stop = true;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            public void run() {
                try {
                    int i = 0;
                    while(stop){
                        Thread.sleep(10);
                        System.out.println(stop);
                        i++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stop = false;

    }
}
