function solution(price, money, count) {
  let answer = 0;
  for (let c = 1; c <= count; ++c) {
    money -= price * c;
  }

  if (money < 0) {
    return money * -1;
  } else {
    return 0;
  }
}
