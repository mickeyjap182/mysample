package practice.basicfeature.datastore.datastruct.basic.struct;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnidirectionalListTest {
    @Test
    public void makeList() {
        UnidirectionalList<List<Object>> aa = new UnidirectionalList<>();
        List<Object> b1 = List.of("apple","lemon","melon","strawberry.");
        List<Object> b2 = List.of();
        List<Object> b3 = List.of("Lion", "cat", "bear");

        List<List<Object>> wrapB1 = List.of(b1, b2, b3);

        assertEquals(3, wrapB1.size());
        List<List<Object>> wrapB1Filtered = wrapB1.stream().filter(CollectionUtils::isNotEmpty).collect(Collectors.toList());
        assertEquals(2, wrapB1Filtered.size());

    }

}