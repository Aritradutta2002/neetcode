/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        Map<Node, Node> newMap = new HashMap<>();
        if(node == null) return null; 
        newMap.put(node, new Node(node.val));
        q.offer(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n : curr.neighbors){
                if(!newMap.containsKey(n)){
                    q.add(n);
                    newMap.put(n, new Node(n.val));
                }
                newMap.get(curr).neighbors.add(newMap.get(n));
            }
        }
        return newMap.get(node);
    }
}