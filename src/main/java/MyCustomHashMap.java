public interface MyCustomHashMap {

  /**
   * Adds object with key and value to the hash map.
   *
   * @param key key
   * @param value value
   */
  void put(int key, long value);

  /**
   * Returns value by key.
   *
   * @param key key
   * @return long value
   */
  long get(int key);

  /**
   * Returns size of the hash map.
   *
   * @return int size
   */
  int size();
}
