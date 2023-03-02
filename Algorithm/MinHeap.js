class MInHeap{
  constructor(){
    this.heap = [null];
  }
  
  size(){
    return this.heap.length-1;
  }
  getMin(){
    return this.heap[1] ?this.heap[1] :null;
  }
  
}