<h1>Heap</h1>

Heap is a complete binary tree structure where each element satifies heap property. 
In a complete binary tree, all levels are full except the last level, i.e, nodes in all levels except the last level will have two children.
The last level will be filled from the left.
Here, each heap node stores a value key, which defines the relative position of that node inside the heap.

<h2>Types of heap</h2>

There are two types of heap data strucutures: max-heap and min-heap

<h3>-> Max-Heap :</h3> All elements in this heap satisfy the property that the key of the parent node is greater than or equal to the keys of its child nodes, i.e.
(key of a node) >= key of its children

The largest key in a max-heap is found at the root

<h3>-> Min-Heap :</h3> All elements in this heap satisfy the property that the key of the parent node is less than or equal to the keys of its child nodes, i.e.
(key of a node) <= key of its children. So moving up from any node, we get a non-increasing sequence of keys.

The smallest key in a min-heap is found at the root.

<h2>Important points</h2>
<ul>
    <li>
        A binary heap is a binary tree that satisfies two properties:
        <ol>
            <li>
                Shape Property -- Complete binary tree
            </li>
            <li>
                Heap Property
            </li>
        </ol>
    </li>
    <li>
        Level order traversal of the heap will give the order in which elements are filled in the array.
    </li>
    <li>
        We define the height of the heap to be the height of the tree. Since a heap of n elements is based on a complete binary tree, its height is O(logn).
    </li>
    <li>
        In the worst case, we shall see that the basic operations on heaps run in time proportional to the tree's height and thus take O(logn) time.
    </li>
</ul>
