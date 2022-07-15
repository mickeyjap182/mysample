package practice.basicfeature.novice.designpetterns.future.adapter;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ReceiveClaimantAdapterTest {
    @Test
    public void test() {
        ReceiveClaimantAdapter r = new ReceiveClaimantAdapter(new Claimant());
        r.apply(50000L);
        assertThat(r.getAmount(), is(0L));

        r.receive();
        assertThat(r.getAmount(), is(50000L));
    }

}