package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        Store store;
        LinkedList<Orders> orders;
        try {

            store = mapper.readValue(Paths.get("src/main/resources/store.json").toFile(), Store.class);
             orders = new LinkedList<> (Arrays.asList(mapper.readValue(Paths.get("src/main/resources/orders.json").toFile(), Orders[].class)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CalculationCountBycomparisons calculationCountBycomparisons = new CalculationCountBycomparisons(store,orders);
        calculationCountBycomparisons.execute();

        // I know the code is a very very ugly, but I was out of time, and I haven't had time to do it
        // if  i got a chance or more time do develop I'd love to do i



        }

    }


