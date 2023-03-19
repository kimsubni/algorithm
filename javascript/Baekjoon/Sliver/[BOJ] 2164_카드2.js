const N = Number(require("fs").readFileSync("/dev/stdin").toString().trim());

class NodeQueue {
  constructor(value) {
    this.next = null;
    this.value = value;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  enqueue(value) {
    let nodeQueue = new NodeQueue(value);
    if (this.size === 0) {
      this.head = nodeQueue;
    } else {
      this.tail.next = nodeQueue;
    }
    this.tail = nodeQueue;
    this.size++;
  }

  dequeue() {
    if (this.size === 0) {
      return null;
    }
    let value = this.head.value;
    this.head = this.head.next;
    this.size--;
    if (this.size === 0) {
      this.tail = null;
    }
    return value;
  }
  isEmpty() {
    return this.size === 0;
  }
}

const arr = new Queue();
for (let i = 1; i < N + 1; ++i) {
  arr.enqueue(i);
}

while (arr.size !== 1) {
  arr.dequeue();
  arr.enqueue(arr.dequeue());
}

console.log(arr.head.value);
