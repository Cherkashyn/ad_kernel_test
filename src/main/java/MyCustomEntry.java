public class MyCustomEntry {

  private int key;
  private long value;

  public MyCustomEntry() {
  }

  public MyCustomEntry(int key, long value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public void setValue(long value) {
    this.value = value;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public long getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MyCustomEntry)) return false;

    MyCustomEntry that = (MyCustomEntry) o;

    if (key != that.key) return false;
    return value == that.value;
  }

  @Override
  public int hashCode() {
    int result = key;
    result = 31 * result + (int) (value ^ (value >>> 32));
    return result;
  }
}
