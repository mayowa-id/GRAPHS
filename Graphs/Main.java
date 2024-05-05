package com.Graphs;

public class Main {
    public static void main (String [] args){
//Testing our implementation
        var graph = new GraphImplementation();
        graph.addNode("BedFrame");
        graph.addNode("Mattress");
        graph.addNode("Pillows");
        graph.addEdge("BedFrame","Mattress");
        graph.addEdge("BedFrame", "Pillows");
        graph.print();
    }
}
