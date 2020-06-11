import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyCustomHashMapTest {

  private static final int KEY_1 = 10;
  private static final int KEY_2 = 1100;
  private static final long VALUE_1 = 5;
  private static final long VALUE_2 = 6;
  private static final int SIZE = 2;

  @Test
  public void getValueByKeySuccessTest() {
    MyCustomHashMap hashMap = new MyCustomHashMapImpl(16, 0.75);

    hashMap.put(KEY_1, VALUE_1);
    hashMap.put(KEY_2, VALUE_2);

    assertEquals(VALUE_1, hashMap.get(KEY_1));
    assertEquals(VALUE_2, hashMap.get(KEY_2));
  }

  @Test(expected = IllegalArgumentException.class)
  public void getValueByKeyFailedTest() {
    MyCustomHashMap hashMap = new MyCustomHashMapImpl(16, 0.75);

    hashMap.put(KEY_1, VALUE_1);

    hashMap.get(KEY_2);
  }

  @Test
  public void sizeHashMapSuccessTest() {
    MyCustomHashMap hashMap = new MyCustomHashMapImpl(16, 0.75);

    hashMap.put(KEY_1, VALUE_1);
    hashMap.put(KEY_2, VALUE_2);

    assertEquals(SIZE, hashMap.size());
  }
}
