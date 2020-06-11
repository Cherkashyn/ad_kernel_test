import java.util.Arrays;
import java.util.Objects;

/**
 * Test for AdKernel.
 * According to the test task, there are only realization of put, get and size methods.
 * Realization of hash map resizing is omitted.
 * Please, see task in the task.txt file.
 */
public class MyCustomHashMapImpl implements MyCustomHashMap {

  private int size;
  private MyCustomEntry[] hashMap;

  public MyCustomHashMapImpl(int size, double loadFactor) {
    if (size <= 0) {
      throw new IllegalArgumentException("Size of the hash map should be greater than 0");
    }
    if (loadFactor <= 0 || loadFactor > 1) {
      throw new IllegalArgumentException("Load factor should be in range from 0 to 1");
    }

    hashMap = new MyCustomEntry[size];
    this.size = size;
  }

  @Override
  public void put(int key, long value) {
    int counter = 0;

    while (counter < size) {
      int hash = hash(key, counter);

      if (hashMap[hash] == null) {
        hashMap[hash] = new MyCustomEntry(key, value);
        return;
      }

      counter++;
    }
  }

  @Override
  public long get(int key) {
    int counter = 0;
    int hash = hash(key, counter);

    if (hashMap[hash] == null) {
      throw new IllegalArgumentException("Key has no value");
    }

    while (counter < size) {

      if (hashMap[hash].getKey() == key) {
        return hashMap[hash].getValue();
      }
      counter++;
      hash = hash(key, counter);

    }
    throw new IllegalArgumentException("Invalid key");
  }

  @Override
  public int size() {
    return (int) Arrays.stream(hashMap).filter(Objects::nonNull).count();
  }

  private int hash(int key, int index) {
    return Objects.hash(key + index) % size;
  }
}
