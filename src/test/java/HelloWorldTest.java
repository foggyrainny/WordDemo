import com.rainny.utils.TestRight;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void testHello(){
        Boolean b=TestRight.test(Double.valueOf(10.00),Double.valueOf(1.60),Double.valueOf(11.6));
        assertEquals(true,b);
    }

}
