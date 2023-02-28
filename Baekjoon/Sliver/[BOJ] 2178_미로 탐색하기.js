const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");


const [N, M] = input[0].split(" ").map(Number);
const visited = Array.from(new Array(N + 1), () =>
  new Array(M + 1).fill(false)
);

class Pos {
  constructor(r, c, count) {
    this.r = r;
    this.c = c;
    this.count = count;
  }
}

class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
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

let map = Array.from(new Array(N + 1), () => new Array(M + 1).fill(0));

const dr = [-1, 0, 1, 0];
const dc = [0, -1, 0, 1];

for (let i = 1; i < N + 1; ++i) {
  const now = input[i].split("").map(Number);
  for (let j = 1; j < M + 1; ++j) {
    map[i][j] = now[j - 1];
  }
}
const bfs = (start) => {
  const queue = new Queue();
  queue.enqueue(start);
  visited[start.r][start.c] = true;

  while (queue.size > 0) {
    const now = queue.dequeue();
    if (now.r === N && now.c === M) {
      console.log(now.count);
      return;
    }
    for (let i = 0; i < 4; ++i) {
      const nr = now.r + dr[i];
      const nc = now.c + dc[i];

      if (nr > 0 && nc > 0 && nr < N + 1 && nc < M + 1)
        if (!visited[nr][nc] && map[nr][nc] === 1) {
          queue.enqueue(new Pos(nr, nc, now.count + 1));
          visited[nr][nc] = true;
        }
    }
  }
};

bfs(new Pos(1, 1, 1));
