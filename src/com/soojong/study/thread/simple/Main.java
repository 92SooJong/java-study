package com.soojong.study.thread.simple;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // 티켓시스템 생성
        TicketSystem ticketSystem = new TicketSystem(0);

        // 스탭 쓰레드 1개 생성
        Staff staff = new Staff(ticketSystem);
        staff.start();

        // Customer의 인스턴스를 담을 List
        ThreadGroup customerGroup = new ThreadGroup("customerGroup");
        // 10개 고객 쓰레드 생성과 시작
        for(int i=0; i<10; i++){
            String customerName = "customer".concat( String.valueOf(i)); // 쓰레드 이름 생성
            Customer customer = new Customer(ticketSystem,customerGroup , customerName); // 고객쓰레드 생성
            customer.start();
        }


        // 고객 쓰레드가 모두 종료된 경우 스탭 쓰레드를 종료한다.
        while(true){
            // customerGroup내 활성화된 쓰레드가 0개 인경우
            if(customerGroup.activeCount() == 0){
                staff.setWorkDone(true);
                staff.join();
                break;
            }
        }



    }
}
