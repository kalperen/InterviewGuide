# InterviewGuide

## Concepts

This is my review of Algorithms and Data Structures for interview prep.
Credit to [Kevin](https://github.com/kdn251/interviews) for a lot of the inspiration.

### Arrays

An array is a data structure that holds a fixed number of values (data points) of the same type. Each item, or value, in an array is called an element, and each element is accessed by its integer index. When we initialize an array, we get to choose what type of data it can hold and how many elements it can hold.

Declaration: `Type[] = new Type[length];`

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

You can easily implement a Counter in java with the following:

```java
class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}
```

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

A sample implementation of Linked List can be found [here](DataStructures/LinkedList.java)

### Queues

Queues are structures in which elements are added to one end and removed from the other end following the first in first out structure.
An array based implementation of queues needs to keep track of both the front and end of the queue.
A reference based (Linked List) implementation needs to keep a tail-like reference. Adding new elements at the tail and removing elements from the head.

Declaration: `Queue<E elementType> queue = new Queue<E elementType>();`
Methods:
- `boolean add(E elemet)` inserts element into queue.
- `E peek()` retrieves but does not remove head, returns null if empty.
- `boolean offer(E element)` inserts element into queue.
- `E remove()` retrieves and removes head.

### Trees  

Trees are structures in which each node can have multiple successors such that there is a unique path from the root to every other node in the tree. Any node can be viewed as the root of its own subtree.

Definitions:
- Children / Descendants: successors of a node.
- Parent / Ascendants: predecessors of a node.
- Siblings: node that share same parent nodes.
- Leaf / External nodes: Nodes that don't have any children.
- Non-leaf / Internal nodes: Nodes that do have one or more children.
- Path: An edge formed by a pair of nodes.
- Level: Distance from the root to a node, root being at 0.
- Depth of tree: Level of deepest node.
- Depth of node: number of ascendants of that node in a tree.
- Height: Calculated from leaves up to root with leaf height being 0.
- Binary Tree: Tree where each node can have at most 2 children. The shortest Binary Tree has log2(N+1) and the tallest has N-1 levels.
- Full: Each node has exactly 0 or 2 children. OR Each level has maximal possible number of nodes (depends on definition used).
- Complete: a binary tree with L levels such that the levels 0 <= l <= L have the max number of nodes (2^l) and the nodes at level L are placed as far left as poossible.

Java does not come with a Binary Tree data structure, you must implement your own as can be found [here](DataStructures/BST.java)

#### [Traversals](https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/):

**Preorder Traversal:**
```Java
void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }
```

**Postorder Traversal:**
```Java
void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }
```

**Inorder Traversal:**
```Java
void printInorder(Node node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }
```

### Priority Queues and Heaps

A Max/Min heap maintains:
1. Shape property: the heap has to be a complete binary tree.
2. Order property: each node has a value greater/smaller than or equal to  the values of both of its children.

Enqueue: Add elements in bottom row of tree then heapify.
Dequeue: Remove root, pick right most bottom node place at top, heapify by moving it down.

Heaps are usually implemented as arrays:
- Root of a tree is at index 0.
- If an element is not root, its parent is at position (index - 1) / 2
- If an element has a left child the child is at position index * 2 + 1
- If an element has a right child the child is at position index * 2 + 2

Declaration:
- MinHeap:
```Java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
```
- MaxHeap:
```Java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
```

Methods:
- `boolean offer(E e)` Inserts the specified element into this priority queue.
- `E peek()` Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
- `E poll()` Retrieves and removes the head of this queue, or returns null if this queue is empty.
- `boolean contains(Object o)` Returns true if this queue contains the specified element.


### Graphs:

```Java
public void dfsORbfs(Node start){
  //Choose the data structure
  Stack<Node> stack = new Stack(); //For DFS
  Queue<Node> queue = new LinkedList(); For BFS
  Set<Node> seen = new HashSet();

  stack.push(start);
  queue.add(start);

  //change stack to queue for bfs
  while(!stack.isEmpty()) {
    // Pull a node to process
    Node curr = stack.pop();
    //Node curr = queu.poll();
    // Process if not seen
    if (!seen.contains(cur)) {
      seen.add(curr);
      System.out.println(curr);
    }
    // Add unseen children
    for (Node adjacent: curr.adjacents){
      if (!seen.contains(adjacent)) {
        stack.push(adjacent);
        //queue.add(adjacent);
      }
    }
  }
}
```

#### Topological Sort:

```Java
public int[] findOrder(int numNodes, int[][] edges) {
    int[][] matrix = new int[numNodes][numNodes]; // i -> j
    int[] indegree = new int[numNodes];

    for (int i = 0; i < edges.length; i++) {
        int cur = edges[i][0];
        int pre = edges[i][1];
        if (matrix[pre][cur] == 0){
            indegree[cur]++;
        }
        matrix[pre][cur] = 1;
    }

    Queue<Integer> order = new LinkedList();
    Queue<Integer> processNext = new LinkedList();
    for (int i=0; i<indegree.length; i++) {
        if (indegree[i] == 0){
            processNext.offer(i);
        }
    }
    while (!processNext.isEmpty()) {
        int node = processNext.poll();
        for (int i=0; i < numNodes; i++) {
            if (matrix[node][i] != 0) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    processNext.offer(i);
                }
            }
        }
        order.offer(node);
    }

    int[] output = new int[order.size()];
    int index = 0;
    while (!order.isEmpty()){
        output[index] = order.poll();
        index++;
    }
    return output.length == numNodes ? output: new int[0];
}
```


#### Dijkstra's Algorithm

For a given source node in the graph, the algorithm finds the shortest path between that node and every other. It can also be used for finding the shortest paths from a single node to a single destination node by stopping the algorithm once the shortest path to the destination node has been determined

```java
public int networkDelayTime(int[][] matrix, int N, int S) {
        // Construct the graph in the form of a hashmap
        // Matrix's elements are  in the form [source, destination,weight]
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: matrix) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, S});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        // Let's return the value of the longest path
        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }
```

### Binary Search:

If you need to return index during search:
```java
while lo <= hi:
  mid = (lo+hi)/2
  if nums[mid] == target:
    return mid
  if nums[mid] > target:
    hi = mid-1
  else:
    lo = mid+1
return -1
```

Searching lowest element satisfy function(i) == True (the array should satisfy function(x) == False for 0 to i-1, and function(x) == True for i to n-1, and it is up to the question to define the function, like in the find peak element problem, function(x) can be nums[x] < nums[x+1])
```java
while lo <= hi:
  mid = (lo+hi)/2
  if function(mid):
    hi = mid-1
  else:
    lo = mid+1
return lo
```


### Merge Sort:

The algorithm for merge sort is as follows:
1. split the array in half
2. sort the left half
3. sort the right half
4. merge two sorted half-arrays into a single sorted array

An implementation can be found [here](Algorithms/MergeSort.java)

### Quick Sort:

The algorithm for quick sort is as follows:
1. pick a pivot
2. partition the array into two parts:
- left - containing all values less than the pivot
- right - containing all values grater than the pivot
3. apply quick sort to the left part
4. apply quick sort to the right part

Selecting a good pivot is necessary for guaranteeing a good performance. Imagine that we always pick the smallest or the largest element to be the pivot. In this scenario we end up with one of the parts containing all but one element from the original array and the other part empty. You may guess that this is not very desirable.
Picking the pivot also has to be quick.

There are several ways pivots are picked. All of them have their advantages and disadvanteges. Here are just a few ideas of how we can select a pivot:
1. always pick the first element from the given array (or sub-array)
2. pick a middle element in the array
3. pick a random element from the array
4. select three elements from the array and use their median as the pivot; the three elements could be
- first three elements in the array
- first, middle and last elements in the array
- random three elements in the array

An implementation can be found [here](Algorithms/QuickSort.java)

## Tips and tricks

### Time:

In java given a string representing the time such as "23:11", the natural way ti represent the time is an integer t in the range 0 <= t < 24 * 60. Then the hours are t / 60, the mintues are t % 60, and each digit of the hours and minutes can be found by hours / 10, hours % 10 etc...
This yields the following format:
`int[] digits = new int[]{t / 60 / 10, t / 60 % 10, t % 60 / 10, t % 60 % 10}`
