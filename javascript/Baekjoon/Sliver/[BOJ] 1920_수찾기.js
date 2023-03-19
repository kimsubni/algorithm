const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
// const input = `5
// 4 1 5 2 3
// 5
// 1 3 7 9 5`.trim().split("\n");

const N = Number(input[0]);
const arr = input[1].split(" ").map(Number);
const M = Number(input[2]);
const find = input[3].split(" ").map(Number);

let isFind = false;
const binarySearch = (find, left, right) => {
  while(left<=right){
    let mid = Math.floor((left+right)/2);
    if(arr[mid] === find){
      isFind = true;
      break;
    }
    else if (arr[mid] > find){
      right = mid-1;
    }else{
      left = mid+1;
    }
    
  }
}

arr.sort((a,b)=>a-b);
let answer = '';
for(let i = 0; i<M; ++i){
  isFind = false;
  binarySearch(find[i], 0, arr.length-1);
  if(isFind){
    answer += '1\n'
  }else{
    answer += '0\n'
  }
}

console.log(answer)
