/*const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");*/

const input = `12 3
1 5 2 3 6 2 3 7 3 5 2 6`
  .trim()
  .split("\n");

class Queue {
  constructor() {
    this.arr = [];
    this.front = null; // 제일 앞 노드
    this.rear = null; // 제일 뒤 노드
  }
  add(data) {
    if (this.size() === 0) {
      // 0번위치에 값을 넣고 포인터는 건드리지 않는다.
      this.arr[0] = data;
    } else {
      this.rear++;
      this.arr[this.rear] = data;
    }
  }
  popleft() {
    let removed;
    if (this.front === this.rear) {
      removed = this.arr[this.front];
      delete this.arr[front];
      this.front = 0;
      this.rear = 0;
    } else {
      removed = this.arr[this.front];
      delete this.arr[this.front];
      this.front += 1;
    }
    return removed;
  }
  size() {
    // rear가 가리키는 값이 없을 때가 아무 데이터가 없는 경우이다
    if (this.storage[rear] === undefined) {
      return 0;
    } else {
      // 그 외의 경우는 앞서 구한 공식으로 크기를 구할 수 있다
      return this.rear - this.front + 1;
    }
  }
}

const [N, L] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

let queue = new Queue();
for (let i = 0; i < N; ++i) {
  let now = arr[i];
  while (queue.arr.length > 0 && queue.rear > now) {
    queue.arr.pop();
  }
  queue.enqueue({ index: i, value: now });
  console.log(queue.arr);
  if (queue.arr[0].index <= i - L) {
    queue.dequeue();
  }
  process.stdout.write(queue.arr[0].value + " ");
}
