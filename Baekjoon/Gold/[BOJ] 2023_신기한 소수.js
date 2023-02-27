//const N = Number(require("fs").readFileSync("/dev/stdin").toString().trim());

const N = 4;
class Node {
  constructor(val, count) {
    this.val = val;
    this.count = count;
  }
}
let answer = "";
const dfsStack = (num) => {
  const stack = [];
  stack.push(num);
  while (stack.length) {
    const node = stack.pop();
    if (node.count === N && isPrime(node.val)) {
      answer += `${node.val}\n`;
      continue;
    }
    for (let i = 9; i >= 1; --i) {
      if (i % 2 === 0) continue;
      const now = node.val * 10 + i;
      if (isPrime(now)) {
        stack.push(new Node(now, node.count + 1));
      }
    }
  }
};

const isPrime = (number) => {
  for (let i = 2; i <= number / 2; ++i) {
    if (number % i === 0) {
      return false;
    }
  }
  return true;
};
dfsStack(new Node(2, 1));
dfsStack(new Node(3, 1));
dfsStack(new Node(5, 1));
dfsStack(new Node(7, 1));

console.log(answer);

// 재귀여서 메모리초과가 아니라.. 그냥 이문제는 자바스크립트로는 못푸는 문제.
