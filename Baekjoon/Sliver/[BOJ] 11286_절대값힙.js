/*const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");*/

const input = `18
  1
  -1
  0
  0
  0
  1
  1
  -1
  -1
  2
  -2
  0
  0
  0
  0
  0
  0
  0`
  .trim()
  .split("\n");

const N = Number(input[0]);
class PriorityQueue {
  constructor() {
    this.values = [];
  }

  enqueue(val) {
    this.values.push(val);
    this.bubbleUp();
  }
  // 올라갈거야 하나하나,
  bubbleUp() {
    let idx = this.values.length - 1;
    const now = this.values[idx];
    while (idx > 0) {
      let parentIdx = Math.floor((idx - 1) / 2);
      let parent = this.values[parentIdx];
      if (
        Math.abs(now) > Math.abs(parent) ||
        (Math.abs(now) === Math.abs(parent) && now >= parent)
      )
        break;

      this.values[parentIdx] = now;
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
        if (
          Math.abs(leftChild) < Math.abs(element) ||
          (Math.abs(element) === Math.abs(leftChild) && element > leftChild)
        ) {
          swap = leftChildIdx;
        }
      }
      if (rightChildIdx < length) {
        rightChild = this.values[rightChildIdx];
        if (
          (swap === null &&
            (Math.abs(rightChild) < Math.abs(element) ||
              (Math.abs(element) === Math.abs(rightChild) &&
                element > rightChild))) ||
          (swap !== null &&
            (Math.abs(leftChild) > Math.abs(rightChild) ||
              (Math.abs(rightChild) === Math.abs(leftChild) &&
                rightChild < leftChild)))
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

let ER = new PriorityQueue();
let answer = "";
for (let i = 0; i < N; ++i) {
  const now = Number(input[i + 1]);

  if (now === 0) {
    if (ER.isEmpty()) {
      answer += "0\n";
    } else {
      answer += `${ER.dequeue()}\n`;
    }
  } else {
    ER.enqueue(now);
  }
}

console.log(answer);

// 우선순위를 정해줘야 한다.
