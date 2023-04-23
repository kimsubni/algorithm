function solution(nums) {
  const set = new Set();
  const N = nums.length;
  for (let i = 0; i < N; ++i) {
    set.add(nums[i]);
    if (set.size == N / 2) break;
  }

  return set.size;
}

// 더 종은 방법!

function solution2(nums) {
  const set = [...new Set(nums)];
  const N = nums.length / 2;
  return set.size > N ? N : set.size;
}
