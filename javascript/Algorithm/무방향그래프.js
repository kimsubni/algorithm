class UndirectedGraph {
  constructor() {
    this.edges = {};
  }

  // 정점 추가하기
  addVertex(vertex) {
    this.edges[vertex] = {};
  }
  // 간선 추가하기
  addEdge(vertex1, vertex2, weigh) {
    if (weigh === undefined) {
      weigh = 0;
    }
    this.edges[vertex1][vertex2] = weigh;
    this.edges[vertex2][vertex1] = weigh;
  }

  // 간선 삭제하기
  removeEdge(vertex1, vertex2) {
    if (this.edges[vertex1] && this.edges[vertex1][vertex2] !== undefined) {
      delete this.edges[vertex1][vertex2];
    }
    if (this.edges[vertex2] && this.edges[vertex2][vertex1] !== undefined) {
      delete this.edges[vertex2][vertex1];
    }
  }

  // 정점 삭제하기
  removeVertex(vertex) {
    for (let adjacentVertex in this.edges[vertex]) {
      this.removeEdge(adjacentVertex, vertex);
    }
    delete this.edges[vertex];
  }
}

const graph1 = new UndirectedGraph();
graph1.addVertex(1);
graph1.addVertex(2);
graph1.addVertex(3);
graph1.addVertex(4);
graph1.addVertex(5);
graph1.addEdge(1, 2, 1);
graph1.addEdge(1, 5, 88);
graph1.addEdge(2, 3, 8);
graph1.addEdge(3, 4, 10);
graph1.addEdge(4, 5, 100);
console.log(graph1.edges);
