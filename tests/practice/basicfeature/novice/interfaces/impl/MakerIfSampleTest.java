package practice.basicfeature.novice.interfaces.impl;


import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.interfaces.MarkerInterface;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MakerIfSampleTest {
    @Test
    public void マーカーインターフェーステスト() {
        var m = new MakerIfSample();
        assertTrue(m instanceof MarkerInterface);
    }


}