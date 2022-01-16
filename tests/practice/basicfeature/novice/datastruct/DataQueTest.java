package practice.basicfeature.novice.datastruct;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

class DataQueTest {

    @Test
    public void testQue() {
        DataQue aaa  = new DataQue();
        aaa.execute();
        ConcurrentLinkedQueue que = aaa.get();
        que.stream().forEach(System.out::println);
    }
}