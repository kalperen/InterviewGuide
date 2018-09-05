# InterviewGuide

### Arrays and Strings

### HashMaps

HashMaps are arrays of fixed size containing data items with unique keys, together with a function called a hash function that maps keys to indexes in the table/arrays. When the java Map interface is used we need to ensure a good hash function is used for the objects that are used as keys in the hash table.

A good hash function is:
1. Easy to compute `O(1)`: it has to be independent of the input and the hashtable size.
2. Repeatable: 2 calls with the same argument should produce the same results.
3. randomly disperses keys evenly throughout table, making sure no two keys map to the same index.

If a key already maps to a value and we try to use the same key to map to another value a collision occurs. Collisions can be resolved in two ways:
- Open addressing: find alternative location for (key, value) pair through linear or quadratic probing.
- Closed addressing: allow multiple (key, value) pairs to be stored in the same location through a linked list.

Declaration: `HashMap<K keyType, V valueType> map = new HashMap<K keyType, V valueType>();`
Methods:
- `V put(K key, V value)` maps key to value in this map, returns previous value of key or null.
- `V get(Object key)` returns value to which the key is mapped or null.
- `V remove(Object key)` removes mapping of key and returns the value of that key or null.
- `Set<K> keySet()` returns the set view of keys contained in the map.
