package practice.basicfeature.datastore.datastruct;


import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

class DataQueTest {

    @Test
    public void testQue() {
        DataQue aaa  = new DataQue();
        aaa.execute();
        ConcurrentLinkedQueue que = aaa.get();
        que.stream().forEach(System.out::println);

        aaa.executeConcurrent();
        ConcurrentLinkedQueue que2 = aaa.get();
        que2.stream().forEach(System.out::println);

    }
}