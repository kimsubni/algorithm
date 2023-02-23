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
    const element = this.values[idx];
    while (idx > 0) {
      let parentIdx = Math.floor(idx / 2) + 1;
      let parent = this.values[parentIdx];
      if (
        Math.abs(element) < Math.abs(parent) ||
        (Math.abs(element) === Math.abs(parent) && element <= parent)
      )
        break;

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
          (Math.abs(element) === Math.abs(leftChild) && element >= leftChild)
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
                element >= rightChild))) ||
          (swap !== null &&
            (Math.abs(rightChild) < Math.abs(leftChild) ||
              (Math.abs(element) === Math.abs(leftChild) &&
                element >= leftChild)))
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
}
