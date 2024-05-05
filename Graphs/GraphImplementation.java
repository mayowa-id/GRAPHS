package com.Graphs;

import java.util.*;

public class GraphImplementation {
  private class  Node{
private String label;

      public Node(String label) {
          this.label = label;
      }

      @Override
      public String toString() {
          return label;
      }
  }
  //A linked List was my initial idea for this but the look up time complexity
  //would be an O(n) because the machine would have to traverse the whole
  //list if what we want to access is at the bottom of the list
  //A Hash Map is more suitable for fast look ups, the key being the String and the  value
  //being the Node
  private Map<String, Node> nodes = new HashMap<>();
  private Map<Node, List<Node>> adjacencyList = new HashMap<>();
  //The AdjacencList Hash Table is used to store a list of all the nodes//paired to individual array lists of connected nodes


  //The method below creates a node and adds it to the nodes Map as the value
  //and the label as the key, so we access the node with the label
  //it then adds the node and a new array list which is going to contain all adjacent/linked
  //nodes, to a Map(adjacencyList)
  public void addNode(String label){
      var node = new Node(label);
      nodes.putIfAbsent(label, node);
      adjacencyList.putIfAbsent(node, new ArrayList<>());
    }
    public void addEdge(String from, String to){
      var fromNode = nodes.get(from);
      if (fromNode == null)
          throw new IllegalArgumentException();

      var toNode = nodes.get(to);
      if (toNode == null)
          throw  new IllegalArgumentException();

adjacencyList.get(fromNode).add(toNode);
    }
    public void print(){
      for (var source: adjacencyList.keySet()){
       var targets = adjacencyList.get(source);
       if(!targets.isEmpty())
           System.out.println(source + " is connected to "+ targets);
      }
    }
    public void removeNode(String label){
    var node = nodes.get(label);
    if (node == null)
    return;
    for(var n : adjacencyList.keySet()){
    adjacencyList.get(n).remove(node);
    }
    adjacencyList.remove(node);
    nodes.remove(node);
    }
    public void removeEdge (String linkFrom, String linkTo){
      var fromNode = nodes.get(linkFrom);
      var toNode = nodes.get(linkTo);
      if(fromNode == null || toNode == null)
          return;

      adjacencyList.get(fromNode).remove(toNode);
    }
    //TRAVERSAL ALGO. - The following methods are for specified traversal
    //over a graph

    //1. Depth-First Traversal
    public void depthFirstTraversal(String rootNode){
      var node = nodes.get(rootNode);
      if(node == null)
          return;
      depthFirstTraversal(nodes.get(rootNode), new HashSet<>());
    }
    private void depthFirstTraversal(Node rootNode, Set<Node> traversed){
        System.out.println(rootNode);
        traversed.add(rootNode);

        for(var node : adjacencyList.get(rootNode))
            if(!traversed.contains(rootNode))
                depthFirstTraversal(rootNode, traversed);
    }

    //2- Breadth First Traversal - This method just demonstrates
    //traversal by printing the graph node we are traversing over.

    public void breadthFirstTraversal(String rootNode){
      var node  = nodes.get(rootNode);
      if(node == null)
          return;

      Set<Node> traversed = new HashSet<>();

      Queue<Node> myQueue = new ArrayDeque<>();
      myQueue.add(node);

      while(!myQueue.isEmpty()){
          var current = myQueue.remove();

          if(traversed.contains(current))
             continue;

          System.out.println(current);
          traversed.add(current);

          for(var neighbour: adjacencyList.get(current))
              if (!traversed.contains(neighbour))
                  myQueue.add(neighbour);
      }

    }
    //TOPOLOGICAL SORTING - The method below shows the implementation
    //osorting topoliogical sorting
    public List<String> topologicalSort(){
      Stack<Node> stack = new Stack<>();
      Set<Node> traversed = new HashSet<>();

      for (var node : nodes.values())
          topologicalSort(node, traversed, stack);

      List<String> sorted = new ArrayList<>();
      while(!stack.empty())
          sorted.add(stack.pop().label);

      return sorted;
    }
    private void topologicalSort(Node node, Set<Node> traversed, Stack<Node> stack){
if(traversed.contains(node))
    return;

traversed.add(node);

for (var neighbour : adjacencyList.get(node))
    topologicalSort(neighbour,traversed, stack);
    }
    //CYCLE DETECTION---
    public boolean cycleDetected(){
      Set<Node> allNodes = new HashSet<>();
      allNodes.addAll(nodes.values());

        Set<Node> visitingNodes = new HashSet<>();
        Set<Node> visitedNodes = new HashSet<>();

        while(!allNodes.isEmpty()){
          var currentNode =  allNodes.toArray(new Node[0])[0];
          //or var current = allNodes.iterator().next();
          if(cycleDetected(currentNode, allNodes, visitingNodes, visitedNodes));
          return true;
        }
        return false;
    }
    private boolean cycleDetected(Node node, Set<Node> allNodes,
                                  Set<Node> visitingNodes,
                                  Set<Node> visitedNodes){
      allNodes.remove(node);
      visitedNodes.add(node);

      for (var neighbour : adjacencyList.get(node)){
          if (visitedNodes.contains(neighbour))
              continue;

          if(visitingNodes.contains(neighbour))
              return true;

       var result =  cycleDetected(neighbour, allNodes, visitingNodes, visitedNodes);
               if(result)
                   return true;
      }
      visitingNodes.remove(node);
      visitedNodes.add(node);

      return false;
    }
}
