// const input = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split("\n");

const input = `12 3
1 5 2 3 6 2 3 7 3 5 2 6`
  .trim()
  .split("\n");

class Deque {
  constructor() {
    this.count = 0;
    this.front = null;
    this.rear = null;
  }

  put_front(value) {
    const node = new Node(value);
    if (this.isEmpty()) {
      this.front = node;
      this.rear = node;
    } else {
      this.front.prev = node;
      node.next = this.front;
      node.prev = null;
      this.front = node;
    }
    this.count += 1;
  }

  pop_front() {
    if (this.isEmpty()) {
      return false;
    } else {
      const data = this.front.data;
      if (this.front.next === null) {
        this.front = null;
        this.rear = null;
      } else {
        this.front = this.front.next;
        this.front.prev = null;
      }
      this.count -= 1;
      return data;
    }
  }

  put_rear(value) {
    const node = new Node(value);
    if (this.isEmpty()) {
      this.front = node;
      this.rear = node;
    } else {
      this.rear.next = node;
      node.next = null;
      node.prev = this.rear;
      this.rear = node;
    }
    this.count += 1;
  }

  pop_rear() {
    if (this.isEmpty()) {
      return false;
    } else {
      const data = this.rear.data;
      if (this.rear.prev === null) {
        this.rear = null;
        this.front = null;
      } else {
        this.rear = this.rear.prev;
        this.rear.next = null;
      }
      this.count -= 1;
      return data;
    }
  }

  get_front() {
    if (this.isEmpty()) {
      return false;
    } else {
      return this.front.data;
    }
  }
  get_rear() {
    if (this.isEmpty()) {
      return false;
    } else {
      return this.rear.data;
    }
  }

  isEmpty() {
    return this.count === 0;
  }
}
class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

const [N, L] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);
let answer = "";
let deque = new Deque();
for (let i = 0; i < N; ++i) {
  let now = arr[i];
  while (!deque.isEmpty() && deque.get_rear().value > now) {
    deque.pop_rear();
  }
  deque.put_rear({ index: i, value: now });
  if (deque.get_front().index <= i - L) {
    deque.pop_front();
  }
  answer += deque.get_front().value + " ";
  if (i % 10000 === 0) {
    process.stdout.write(answer);
    answer = "";
  }
}

console.log(answer.trimEnd());
