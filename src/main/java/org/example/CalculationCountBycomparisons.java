package org.example;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class CalculationCountBycomparisons {

        Store store;
        List<Orders> orders;
        int countPicker;
        private LocalTime actualTime;
        private Duration pickingTime;
        private LocalTime completeBy;

        public CalculationCountBycomparisons(Store store, List<Orders> orders) {
            this.store=store;
            this.orders=orders;
            countPicker=0;
        }
        public void execute(){
            sortingOrders();
            calculateActualTime();
            if(store.pickers.size()>1){
                calculating();
            }
            else calculatingOne(0);

        }
        private void calculating() {
            for (int i = 0; i < orders.size(); i++) {
                    if(orders.size()>5 && i<5) {
                        lookingForNext(i);
                        i=4;
                    }
                    else {
                        calculatingOne(i);
                        return;
                    }
                }
        }
    private void calculatingOne(int s) {
        for (int i = s; i < orders.size(); i++) {
            if (isPossibleOrder(i)) {
                printingOrder(i);
                picker().setActualTime(picker().getActualTime().plus(orders.get(i).getPickingTime()));
                countPicker++;
            }}
    }
        private void lookingForNext(int s){

            int i=0,j=0,k=0,m=0;

            double max = 0.0;
            if(calculateEffectivity(0+s,1+s,2+s,3+s) > max) {
                max=calculateEffectivity(0+s,1+s,2+s,3+s);
                i=0+s; j=1+s; k=2+s; m=3+s;
            };
            if(calculateEffectivity(0+s,2+s,1+s,3+s) > max) {
                max=calculateEffectivity(0+s,2+s,1+s,3+s);
                i=0+s;j=2+s;k=1+s;m=3+s;
            };
            if(calculateEffectivity(0+s,3+s,1+s,2+s) > max) {
                max=calculateEffectivity(0+s,3+s,1+s,2+s);
                i=0+s;j=3+s;k=1+s;m=2+s;
            };
            if(calculateEffectivity(0+s, 4+s, 1+s, 3+s) > max) {
                max=calculateEffectivity(0+s, 4+s, 1+s, 3+s);
                i=0+s;j=4+s;k=1+s;m=3+s;
            };
            if(calculateEffectivity(0+s, 4+s, 2+s, 3+s) > max) {
                max=calculateEffectivity(0+s, 4+s, 2+s, 3+s);
                i=0+s;j=4+s;k=2+s;m=3+s;
            };
            if(calculateEffectivity(0+s, 1+s, 3+s, 4+s) > max) {
                max=calculateEffectivity(0+s, 1+s, 3+s, 4+s);
                i=0+s;j=1+s;k=3+s;m=4+s;
            };
            if(calculateEffectivity(0+s, 2+s, 1+s, 4+s) > max) {
                max=calculateEffectivity(0+s, 2+s, 1+s, 4+s);
                i=0+s;j=2+s;k=1+s;m=4+s;
            };
            if(calculateEffectivity(0+s, 3+s, 1+s, 4+s) > max) {
                max=calculateEffectivity(0+s, 3+s, 1+s, 4+s);
                i=0+s;j=3+s;k=1+s;m=4+s;
            };
            if(calculateEffectivity(0+s, 1+s, 2+s, 4+s) > max) {
                max=calculateEffectivity(0+s, 1+s, 2+s, 4+s);
                i=0+s;j=1+s;k=2+s;m=4+s;
            };
            if(calculateEffectivity(0+s, 1+s, 3+s, 4+s) > max) {
                max=calculateEffectivity(0+s, 1+s, 3+s, 4+s);
                i=0+s;j=1+s;k=3+s;m=4+s;
            };
            printingOrder(i);
            picker().setActualTime(picker().getActualTime().plus(orders.get(i).getPickingTime()));
            printingOrder(j);
            picker().setActualTime(picker().getActualTime().plus(orders.get(j).getPickingTime()));
            countPicker++;
            printingOrder(k);
            picker().setActualTime(picker().getActualTime().plus(orders.get(k).getPickingTime()));
            printingOrder(m);
            picker().setActualTime(picker().getActualTime().plus(orders.get(m).getPickingTime()));
            countPicker++;
        }

        private double calculateEffectivity(int i, int j, int k, int m){
            if(!(isPossibleOrder(i))) return 0;
            if(!(isPossibleOrder(i, j))) return 0;
            countPicker++;
            if(!(isPossibleOrder(k))) return 0;
            if(!(isPossibleOrder(k, m))) return 0;
            countPicker--;
            Duration score;

            score = orders.get(i).getPickingTime().plus(orders.get(j).getPickingTime()).plus(orders.get(k).getPickingTime().plus(orders.get(m).getPickingTime()));
            return  score.getSeconds();
        }
        private Pickers picker(){
            if(countPicker == store.pickers.size()) countPicker=0;
            return store.pickers.get(countPicker);
        }
        private void printingOrder(int i) {
            System.out.println(picker().getName() + " " + orders.get(i).getOrderId() + " " + picker().getActualTime());
        }
    private boolean isPossibleOrder(int i , int j) {

        if ((orders.get(j).getCompleteBy().minus(orders.get(j).getPickingTime())).isAfter(picker().getActualTime().plus(orders.get(i).getPickingTime()))
                || (orders.get(j).getCompleteBy().minus(orders.get(j).getPickingTime())).equals(picker().getActualTime().plus(orders.get(i).getPickingTime())))
            return true;
        return false;
    }

        private boolean isPossibleOrder(int i ) {

            if ((orders.get(i).getCompleteBy().minus(orders.get(i).getPickingTime())).isAfter(picker().getActualTime())
                    || (orders.get(i).getCompleteBy().minus(orders.get(i).getPickingTime())).equals(picker().getActualTime()))
                return true;
            return false;
        }

        private void sortingOrders(){
            orders.sort((o1, o2) -> {
                if (o1.getPickingTime().equals(o2.getPickingTime()))
                    return o1.getCompleteBy().compareTo(o2.getCompleteBy());
                return o1.getPickingTime().compareTo(o2.getPickingTime());

            });
        }
        private void calculateActualTime(){
            for (int i = 0; i < store.pickers.size(); i++) {
                store.pickers.get(i).setActualTime(store.getPickingStartTime());
            }
        }

    }


