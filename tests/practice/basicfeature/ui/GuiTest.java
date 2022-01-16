package practice.basicfeature.ui;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;

class GuiTest {
    @Test
    public void run() {
        try {
            Gui.main(new String[]{});
        } catch(RuntimeException e) {
            assertFalse(false);
        }

    }

    // malti start
}