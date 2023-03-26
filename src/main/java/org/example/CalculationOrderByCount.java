package org.example;

import java.util.List;

public class CalculationOrderByCount {
    Store store;
    List<Orders> orders;
    int countPicker;
    public CalculationOrderByCount(Store store, List<Orders> orders) {
        this.store=store;
        this.orders=orders;
        countPicker=0;
    }

    public void execute(){
        sortingOrders();
        System.out.println(orders);
        calculateActualTime();
        calculating();

    }
    private void calculating() {
        for (int i = 0; i < orders.size(); i++) {
            if (isPossibleOrder(i)) {
                printingOrder(i);
                picker().setActualTime(picker().getActualTime().plus(orders.get(i).getPickingTime()));
                //System.out.println(picker().getActualTime());
                countPicker++;


                //dodaj pikerowi minuty i zmien pikera
            }
            else continue;


        }
    }






    private Pickers picker(){
        if(countPicker == store.pickers.size()) countPicker=0;
        return store.pickers.get(countPicker);
    }
    
    


    private void printingOrder(int i) {
        System.out.println(picker().getName() + " " + orders.get(i).getOrderId() + " " + picker().getActualTime());
    }

    private boolean isPossibleOrder(int i ) {
        if (orders.get(i).getCompleteBy().minus(orders.get(i).getPickingTime()).isAfter(picker().getActualTime())
            || orders.get(i).getCompleteBy().minus(orders.get(i).getPickingTime()).equals(picker().getActualTime()))
        return true;
        return false;
    }

    private void sortingOrders(){
                orders.sort((o1, o2) -> {
                    if (o1.getCompleteBy().equals(o2.getCompleteBy()))
                        return o1.getPickingTime().compareTo(o2.getPickingTime());
                    return o1.getCompleteBy().compareTo(o2.getCompleteBy());

                });
            }
            private void calculateActualTime(){
            for (int i = 0; i < store.pickers.size(); i++) {
                store.pickers.get(i).setActualTime(store.getPickingStartTime());
            }
    }

}
