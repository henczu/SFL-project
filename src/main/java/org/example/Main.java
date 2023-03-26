package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());

        Store store;
        List<Orders> orders;
        try {

            store = mapper.readValue(Paths.get("C:\\Users\\hencz\\IdeaProjects\\SFL-project\\src\\main\\resources\\store.json").toFile(), Store.class);
            orders = Arrays.asList(mapper.readValue(Paths.get("C:\\Users\\hencz\\IdeaProjects\\SFL-project\\src\\main\\resources\\orders.json").toFile(), Orders[].class));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CalculationOrderByCount calculate = new CalculationOrderByCount(store, orders);
        calculate.execute();










//        for (int i = 0; i < store.pickers.size(); i++) {
//            store.pickers.get(i).setActualTime(store.getPickingStartTime());
//        }

//        System.out.println(orders);

//        for (int i = 0; i < orders.size(); i++) {
//            if (i == 0 || i % 2 == 0) {
//                System.out.println(store.pickers.get(0) + " " + orders.get(i).getOrderId() + " " + orders.get(i).getCompleteBy());
//            } else {
//                System.out.println(store.pickers.get(1) + " " + orders.get(i).getOrderId() + " " + orders.get(i).getCompleteBy());
//            }
//        }

// siminowe
//        orders.sort((o1, o2) -> {
//            if (o1.getPickingTime().compareTo(o2.getPickingTime()) == 0)
//                return o1.getCompleteBy().compareTo(o2.getCompleteBy());
//            return o1.getPickingTime().compareTo(o2.getPickingTime());
//
//        });
//        orders.sort((o1, o2) -> {
//            if (o1.getCompleteBy().equals(o2.getCompleteBy()))
//                return o1.getPickingTime().compareTo(o2.getPickingTime());
//            return o1.getCompleteBy().compareTo(o2.getCompleteBy());
//
//        });

//        System.out.println(store);
//        System.out.println(store.getPickers().size());
//        System.out.println();
//        System.out.println(orders);
//
//        System.out.println("Hello world!");
//
//        for (int i = 0; i < store.pickers.size(); i++) {
//            store.pickers.get(i) = new Pickers();
//        }

//        Map<Store, Orders> storeOrdersMap = new HashMap<>();
        //storeOrdersMap.put(store.pickers)
//        for (int i = 0; i < orders.size(); i++) {
//            if (i == 0 || i % 2 == 0) {
//                System.out.println(store.pickers.get(0) + " " + orders.get(i).getOrderId() + " " + orders.get(i).getCompleteBy());
//            } else {
//                System.out.println(store.pickers.get(1) + " " + orders.get(i).getOrderId() + " " + orders.get(i).getCompleteBy());
//            }
//                System.out.print(orders.get(i).getPickingTime());
//                System.out.println(orders.get(i));


//        }

//        private void changingPicker(){
//
//
//        }
//

//        for (int i = 0; i < orders.size(); i++) {
//            if(orders.get(i).getCompleteBy().minus(orders.get(i).getPickingTime()).isAfter(store.pickers.get(0).getActualTime())){
//                System.out.println(store.pickers.get(0).getName() + " " + orders.get(i).getOrderId() + " " + orders.get(i).getCompleteBy());
//            }
//
//
//
//
//
//
//
//
//            }
//        System.out.println((store.getPickingStartTime() + " " + orders.get(0).getCompleteBy()));
//
//        System.out.println(store.getPickingStartTime());
//        System.out.println(store.getPickingStartTime().plus(orders.get(0).getPickingTime()));
//        System.out.println(store.getPickingStartTime());
//        System.out.println(store.getPickingStartTime().plus(orders.get(1).getPickingTime()));

        }


    }


