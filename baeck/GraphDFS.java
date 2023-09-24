package baeck;
import java.util.ArrayList;
import java.util.List;

public class GraphDFS {
    private final int vertices; // 노드(정점)의 개수
    private final List<List<Integer>> adjList; // 인접 리스트

    //클래스: DFS를 수행하는 그래프 클래스입니다.
    //GraphDFS 객체를 생성할 때 그래프의 노드 개수를 받아와 초기화하는 역할을 합니다.
    public GraphDFS(int vertices) {
        this.vertices = vertices; //인접 리스트를 초기화할 때 사용됩니다.
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    /*
    List: 자바의 컬렉션 프레임워크 중 하나로, 동적 배열을 구현하는 자료구조입니다.
    크기가 가변적으로 변할 수 있으며, 배열과 유사하지만 더 다양한 기능과 유연성을 제공합니다.
    List<List<Integer>>: 정수 값을 저장하는 동적 배열들의 배열
    */

    // 간선 추가 메서드 (addEdge)
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    // DFS를 시작하는 함수
    public void DFS(int startNode) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(startNode, visited);
    }

    // 재귀적으로 DFS를 수행하는 함수
    private void DFSUtil(int currentNode, boolean[] visited) {
        visited[currentNode] = true;
        System.out.print(currentNode + " "); // 현재 노드를 방문했음을 출력

        // 현재 노드와 인접한 노드들을 방문
        for (int neighbor : adjList.get(currentNode)) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        // 예시 그래프 생성
        GraphDFS graph = new GraphDFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println("DFS 탐색 순서:");
        graph.DFS(0); // 시작 노드를 0으로 설정하여 DFS 실행
    }
}
/*
* 클래스 및 변수 선언
GraphDFS 클래스: DFS를 수행하는 그래프 클래스입니다.
int vertices: 그래프의 노드(정점)의 개수를 저장하는 변수입니다.
List<List<Integer>> adjList: 그래프를 인접 리스트로 표현하기 위한 변수입니다.

* 생성자 (GraphDFS 클래스)
생성자에서는 그래프의 노드 개수를 받아와서 adjList에 빈 리스트를 할당합니다. 이 때, 인접 리스트의 인덱스는 노드 번호를 나타내며, 각 인덱스마다 인접한 노드들의 리스트를 저장할 준비를 합니다.

* 간선 추가 메서드 (addEdge)
addEdge 메서드는 무방향 그래프를 가정하고, 두 노드 사이에 간선을 추가하는 역할을 합니다. 예를 들어 addEdge(0, 1)을 호출하면 0번 노드와 1번 노드 사이에 양방향 간선이 추가됩니다.

* DFS 시작 메서드 (DFS)
DFS 메서드는 탐색을 시작하는 함수로서, 시작 노드를 받아옵니다. 이때, 방문한 노드를 체크하기 위한 visited 배열을 생성합니다.

* 재귀적인 DFS 탐색 (DFSUtil)
DFSUtil 메서드는 재귀적으로 DFS를 수행하는 함수입니다. 이 함수는 currentNode라는 현재 노드와 visited라는 방문 여부를 저장하는 배열을 인자로 받습니다.
currentNode를 방문했음을 표시하고(visited[currentNode] = true), 현재 노드를 출력합니다(System.out.print(currentNode + " ")). 이 부분은 실제로 노드를 방문하고 처리하는 로직을 추가해야 할 부분입니다.
현재 노드와 인접한 노드들 중에서 방문하지 않은 노드를 찾아 재귀적으로 DFSUtil 함수를 호출합니다. 이렇게 함으로써 현재 노드의 인접 노드를 모두 방문하면서 깊이 우선 탐색이 진행됩니다.

* main 메서드
main 메서드에서는 예시 그래프를 생성하고 DFS를 시작하는 코드를 작성합니다.
GraphDFS 객체를 생성하고, addEdge 메서드를 이용하여 간선을 추가합니다.
시작 노드를 0으로 설정하여 DFS 메서드를 호출하여 DFS를 수행합니다.
DFS를 수행하면서 방문한 노드 순서를 출력합니다.
*/

