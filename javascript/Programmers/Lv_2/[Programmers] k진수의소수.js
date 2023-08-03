function solution(n, k) {
    const str = n.toString(k)
    const regex = /[1-9]*/g;
const arr = str.match(regex).filter(e => e !== '' && e !== '1');
const result = []
arr.forEach(e => {
let isPrime = true;
for(let i=2 ; i<= Math.sqrt(e);i++) {
if(e%i === 0) return isPrime = false;
}
    if(isPrime) {
    result.push(e)
    isPrime = true;
}
})
    return result.length
}