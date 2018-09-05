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

### Stacks
Stacks are structures in which elements are always added and removed from the same end. Stacks are last in first out (LIFO) structures.

Declaration: `Stack<E elementType> stack = new Stack<E elementType>();`
Methods:
- `boolean empty()` returns true if the stack is empty.
- `E peek()` retrieves but does not remove head, returns null if empty.
- `E push(E element)` inserts element into the top of the stack.
- `E pop()` retrieves and removes the top of the stack.
- `int search(E element)` Returns the 1-based position where an object is on this stack..

### Linked Lists

In Java when a variable of a primitive data type is allocated the memory location associated with that variable contains the value assigned to that variable.
For example `int x = 5;` results in a 32-bit block of memory associated with the variable x. The bits are used to represent the value of 5.
On the other hand, with reference type variables the memory allocation is different, they do not have room for storing data, they only contain enough memory to store a reference or an address of memory location at which the actual data is stored.
The idea of creating linked structures is based on the reference variables. Linked structures are composed of individual objects that are linked to one another in some way.
Therefore, a linked list can be simply thought of as a reference to the first node of a linked structure: from there we can follow the ”links” to get to every other node.

Declaration: `LinkedList<E elementType> linkedList = new LinkedList<E elementType>();`

A sample implementation of Linked List can be found [here](LinkedList.java)

### Queues

Queues are structures in which elements are added to one end and removed from the other end following the first in first out structure.
An array based implementation of queues needs to keep track of both the front and end of the queue.
A reference based (Linked List) implementation needs to keep a tail-like reference. Adding new elements at the tail and removing elements from the head.

Declaration: `Queue<E elementType> queue = new Queue<E elementType>();`
Methods:
- `boolean add(E elemet)` inserts element into queue.
- `E peek()` retrieves but does not remove head, returns null if empty.
- `boolean offer(E element)` inserts element into queue.
- `E remove()` retrieves and removes head
