const Deque = (() => {
  class Deque {
    constructor() {
      this.count = 0;
      this.front = null;
      this.rear = null;
    }

    put_front(value) {
      const node = new Node(value);
      if (!this.front) {
        this.front = node;
        this.rear = node;
      } else {
        const next = this.front;
        this.front = node;
        this.front.next = next;
        next.prev = node;
      }
      return ++this.count;
    }

    get_front() {
      if (!this.front) {
        return false;
      }
      const data = this.front.data;
      this.front.prev = null;
      this.front = this.front.next;
      this.count--;
      return data;
    }

    put_rear(value) {
      const node = new Node(value);
      if (!this.front) {
        this.front = node;
        this.rear = node;
      } else {
        node.prev = this.rear;
        this.rear.next = node;
      }
      this.rear = node;
      return ++this.count;
    }

    get_rear() {
      if (!this.front) {
        return false;
      }
      let temp = this.rear;
      temp.prev.next = null;
      this.rear = temp.prev;
      temp = null;
      this.count--;
    }

    front() {
      return this.head && this.head.data;
    }

    rear() {
      return this.rear && this.rear.data;
    }
  }
  class Node {
    constructor(data) {
      this.data = data;
      this.next = null;
      this.prev = null;
    }
  }
  return Deque;
})();
