class Node {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  
  function breadthFirstSearch(root) {
    if (!root) return;
  
    const queue = [];
    queue.push(root);
  
    while (queue.length > 0) {
      const node = queue.shift();
      console.log(node.value);
  
      if (node.left) queue.push(node.left);
      if (node.right) queue.push(node.right);
    }
  }
  
  function dfsTraversal(root) {
    if (!root) return;
  
    console.log(root.value);
    dfsTraversal(root.left);
    dfsTraversal(root.right);
  }
  
  // Create the Binary Search Tree
  const root = new Node(10);
  root.left = new Node(5);
  root.right = new Node(15);
  root.left.left = new Node(2);
  root.left.right = new Node(7);
  root.right.left = new Node(12);
  root.right.right = new Node(20);
  
  console.log("BFS Traversal:");
  breadthFirstSearch(root);
  
  console.log("\nDFS Traversal (Pre-order):");
  dfsTraversal(root);
  