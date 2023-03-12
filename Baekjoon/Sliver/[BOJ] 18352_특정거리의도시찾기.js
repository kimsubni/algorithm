/*const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");*/

const input = `4 4 1 1
1 2
1 3
2 3
2 4`
  .trim()
  .split("\n");

const [N, M, K, X] = input[0].split(" ").map(Number);

const graph = {};

for (let i = 1; i < N + 1; ++i) {
  graph[i] = [];
}
for (let i = 0; i < M; ++i) {
  const [A, B] = input[i + 1].split(" ").map(Number);
  graph[A].push(B);
}

class Queue {
  constructor() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }

  enqueue(val) {
    var newNode = new Node(val);
    if (!this.first) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.next = newNode;
      this.last = newNode;
    }
    return ++this.size;
  }

  dequeue() {
    if (!this.first) return null;
    let temp = this.first;
    if (this.first === this.last) {
      this.last = null;
    }
    this.first = this.first.next;
    this.size--;
    return temp.value;
  }
}
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class City {
  constructor(val, distance) {
    this.val = val;
    this.distance = distance;
  }
}

const visited = new Array(N + 1).fill(false);
let answer = [];
const bfs = (start) => {
  const queue = new Queue();
  queue.enqueue(new City(start, 0));
  visited[start] = true;
  while (queue.size > 0) {
    const now = queue.dequeue();
    if (now.distance === K) {
      answer.push(now.val);
      continue;
    }
    if (graph[now.val]) {
      for (const next of graph[now.val]) {
        if (!visited[next]) {
          visited[next] = true;
          queue.enqueue(new City(next, now.distance + 1));
        }
      }
    }
  }
};
bfs(X);

if (answer.length > 0) {
  answer.sort((a, b) => a - b);
  let tmp = "";
  for (let i = 0; i < answer.length; ++i) {
    tmp += answer[i] + "\n";
  }
  console.log(tmp);
} else {
  console.log(-1);
}
