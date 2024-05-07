# GRAPHS
Implementation of Graphs, Topological Sorting, Cycle Detection &amp; Others


A Graph is a non-linear data structure consisting of vertices and edges. 
The vertices are sometimes also referred to as nodes and the edges are lines or arcs that connect any two nodes in the graph.

In a way a Graph can be compared to a Tree because of the connected nodes or elements in the individual data structures, In Graphs 
there is no parent node (also known as root node), all nodes are connected to related nodes in the Graph

Below are the basic operations in a graph as they are implemented in this Code Base:

addNode() and addEdge() - Insertion of Nodes/Edges in the graph 
removeNode() - Deletion of Nodes/Edges in the graph 
depyhFirstTraversal() -  Traversal of Graphs 

Graphs are useful in real life in the following ways:

Commonly used to represent social networks, such as networks of friends on social media.
Graphs can be used to represent the topology of computer networks, such as the connections between routers and switches.
Graphs are used to represent the connections between different places in a transportation network, such as roads and airports.
Graphs are used in Neural Networks where vertices represent neurons and edges represent the synapses between them.

In this code base there is also a method for detecting if there is a cycle in the Graph, it returns a boolean value. 
cycleDetected(). 

Topological Sort is used for Directed Acyclic graphs, it is applied in situations in which a bunch of tasks connected 
in  Graph are to be completed in a particular order.
