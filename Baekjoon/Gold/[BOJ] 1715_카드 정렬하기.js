const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

/*const input = `4
30
40
50
60`
  .trim()
  .split("\n");*/

const N = Number(input[0]);
const arr = [];

for (let i = 1; i < N + 1; ++i) {
  arr.push(Number(input[i]));
}

class PriorityQueue {
  constructor() {
    this.values = [];
  }
  enqueue(val) {
    this.values.push(val);
    this.bubbleUp();
  }
  bubbleUp() {
    let idx = this.values.length - 1;
    const element = this.values[idx];
    while (idx > 0) {
      let parentIdx = Math.floor((idx - 1) / 2);
      let parent = this.values[parentIdx];
      if (parent < element) {
        break;
      }
      this.values[parentIdx] = element;
      this.values[idx] = parent;
      idx = parentIdx;
    }
  }
  dequeue() {
    const min = this.values[0];
    const end = this.values.pop();
    if (this.values.length > 0) {
      this.values[0] = end;
      this.sinkDown();
    }
    return min;
  }

  sinkDown() {
    let idx = 0;
    const length = this.values.length;
    const element = this.values[0];
    while (true) {
      let leftChildIdx = 2 * idx + 1;
      let rightChildIdx = 2 * idx + 2;
      let leftChild, rightChild;
      let swap = null;
      if (leftChildIdx < length) {
        leftChild = this.values[leftChildIdx];
        if (leftChild < element) {
          swap = leftChildIdx;
        }
      }
      if (rightChildIdx < length) {
        rightChild = this.values[rightChildIdx];
        if (
          (swap === null && element > rightChild) ||
          (swap !== null && rightChild < leftChild)
        ) {
          swap = rightChildIdx;
        }
      }
      if (swap === null) break;
      this.values[idx] = this.values[swap];
      this.values[swap] = element;
      idx = swap;
    }
  }
  isEmpty() {
    return this.values.length === 0;
  }
}

let answer = 0;
let sum = 0;
if (arr.length === 1) {
  answer = 0;
} else {
  const queue = new PriorityQueue();
  for (let i = 0; i < N; ++i) {
    queue.enqueue(arr[i]);
  }
  while (true) {
    let plus = 0;
    if (queue.values.length >= 2) plus = queue.dequeue() + queue.dequeue();
    else plus = queue.dequeue();
    answer += plus;
    if (queue.isEmpty()) {
      break;
    }
    queue.enqueue(plus);
  }
}
console.log(answer);
