import level3_lesson6.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass {
    Main test;

    @Before
    public void before(){
        test = new Main();
    }

    @Test(expected = RuntimeException.class)
    public void testBecomeArray (){
        Assert.assertArrayEquals(new int[] {1,7}, test.becomeArray(new int[]{1,2,4,4,2,3,4,1,7}));
        Assert.assertArrayEquals(new int[] {}, test.becomeArray(new int[]{1,2,4,4}));
        Assert.assertArrayEquals(new int[] {1,7,5,1}, test.becomeArray(new int[]{4,4,2,3,4,1,7,5,1}));
        test.becomeArray(new int[]{7,5,1});
    }

    @Test
    public void testArrayControl (){
        Assert.assertTrue(test.arrayControl(new int[]{1,1,1,4,4,1,4,4}));
        Assert.assertFalse(test.arrayControl(new int[]{1,1,1,1,1,1}));
        Assert.assertFalse(test.arrayControl(new int[]{4,4,4,4}));
        Assert.assertFalse(test.arrayControl(new int[]{1,4,4,1,1,4,3}));
    }
}
