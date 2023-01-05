const dx = [0, 1, 0, -1];
const dy = [-1, 0, 1, 0];

function solution(map) {
  let needVisited = [[0, 0, 1]];
  const n = map.length - 1;
  const m = map[0].length - 1;
  map[0][0] = 0;
  while (needVisited.length !== 0) {
    const [x, y, sum] = needVisited.shift();
    if (x === n && y === m) {
      return sum;
    }
    for (let i = 0; i < 4; ++i) {
      const nx = dx[i] + x;
      const ny = dy[i] + y;
      if (!(nx >= 0 && ny >= 0 && nx <= n && ny <= m)) {
        continue;
      }
      if (map[nx][ny] === 1) {
        map[nx][ny] = 0;
        needVisited.push([nx, ny, sum + 1]);
      }
    }
  }
  return -1;
}

console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 0],
    [0, 0, 0, 0, 1],
  ])
);
