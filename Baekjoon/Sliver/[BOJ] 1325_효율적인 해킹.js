// const input = require("fs")
//   .readFileSync("/dev/stdin")
//   .toString()
//   .trim()
//   .split("\n");

const input = `5 4
3 1
3 2
4 3
5 3
`
  .trim()
  .split("\n");

const [N, M] = input[0].split(" ").map(Number);
const graph = {};

for (let i = 1; i < N + 1; ++i) {
  graph[i] = [];
}
for (let i = 0; i < M; ++i) {
  const [A, B] = input[i + 1].split(" ").map(Number);
  graph[B].push(A);
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
class Company {
  constructor(num, depth) {
    this.num = num;
    this.depth = depth;
  }
}
let max = -1;
let answer = "";
const bfs = (start) => {
  const visited = new Array(N + 1).fill(false);
  const queue = new Queue();
  queue.enqueue(new Company(start, 0));
  let cnt = 0;
  visited[start] = true;
  let isFind = false;
  while (queue.size > 0) {
    const now = queue.dequeue();
    if (max < now.depth) {
      max = now.depth;
      answer = start + " ";
      isFind = true;
    } else if (max === now.depth) {
      if (!isFind) {
        answer += start + " ";
        isFind = true;
      }
    }
    if (graph[now.num]) {
      for (const next of graph[now.num]) {
        if (!visited[next]) {
          visited[next] = true;
          queue.enqueue(new Company(next, now.depth + 1));
        }
      }
    }
  }
};

for (let i = 1; i < N + 1; ++i) {
  bfs(i);
}

console.log(answer.trim());
