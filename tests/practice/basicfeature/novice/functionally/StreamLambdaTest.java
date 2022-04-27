package practice.basicfeature.novice.functionally;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamLambdaTest {
    @Test
    public void doMain() {
        StreamLambda mySelf = new StreamLambda();
        mySelf.numberStream();
        mySelf.stringStream();
        mySelf.castStream();

        mySelf.easyMethod01();
        mySelf.tutorial01();
        mySelf.tutorial02();
        // https://stackoverflow.com/questions/32206092/java8-method-reference-used-as-function-object-to-combine-functions

//        List<Integer> rangeList = boxedStream.collect(Collectors.toList());


//        System.out.println(String.format("3. (Integer 100 == int 256): %b",sum(rangeList, 3));
        StreamLambda.predicts();
        mySelf.tutorial03();
        mySelf.ListMapStreams();
        assertTrue(true);
    }


}