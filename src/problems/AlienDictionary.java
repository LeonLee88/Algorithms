package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by leon on 7/9/17.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Vertex> graph = buildGraph(words);
        StringBuilder res = new StringBuilder();
        for(Vertex v : graph.values()) {
            if(v.state == State.UNVISITED) {
                if(!topologicalOrder(v, res)) {
                    return "";
                }
            }
        }
        // Reverse string to get the final topological order
        return res.reverse().toString();
    }

    boolean topologicalOrder(Vertex vertex, StringBuilder sb) {
        if(vertex.state == State.VISITED) {
            return true;
        }
        if(vertex.state == State.VISITING) {
            // find circle, return false to tell the caller it's invalid.
            return false;
        }
        vertex.state = State.VISITING;
        for(Vertex nei : vertex.neis) {
            if(!topologicalOrder(nei, sb)) {
                return false;
            }
        }
        vertex.state = State.VISITED;
        sb.append(vertex.c);
        return true;
    }

    Map<Character, Vertex> buildGraph(String[] words) {
        Map<Character, Vertex> graph = new HashMap<>();
        // init all vertices
        for(int i=0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                Vertex v = graph.get(words[i].charAt(j));
                if(v == null) {
                    v = new Vertex(words[i].charAt(j));
                }
                graph.put(words[i].charAt(j), v);
            }
        }
        // init all edges
        for(int i=0; i < words.length-1; i++) {
            // compare the character of the same position of  two consecitive words
            for(int j = 0; j < words[i].length() && j < words[i+1].length(); j++) {
                // found one different character from the next word
                if(words[i].charAt(j) != words[i+1].charAt(j)) {
                    char c = words[i].charAt(j);
                    // Add a new neighbour
                    Vertex nei = graph.get(words[i+1].charAt(j));
                    graph.get(c).neis.add(nei);
                    break;
                }
            }
        }
        return graph;
    }
}

class Vertex {
    char c;
    Set<Vertex> neis;
    State state = State.UNVISITED;

    public Vertex (char c) {
        this.c = c;
        neis = new HashSet<>();
    }
}

enum State {
    UNVISITED, VISITING, VISITED;
}