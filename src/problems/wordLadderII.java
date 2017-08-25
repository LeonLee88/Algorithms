package problems;

import java.util.*;

/**
 * Created by leon on 9/17/17.
 */
public class wordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList == null || wordList.size() == 0) {
            return res;
        }
        long startTime = System.currentTimeMillis();
        Map<String, List<String>> graph = buildGraph(wordList, beginWord);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("1:" + totalTime);

        startTime = System.currentTimeMillis();
        Map<String, Set<String>> prevs = bfs(beginWord, endWord, graph);
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("2:" + totalTime);

        if(prevs.containsKey(endWord)) {
            startTime = System.currentTimeMillis();
            buildPaths(prevs, beginWord, endWord, new LinkedList<>(), res);
            endTime   = System.currentTimeMillis();
            totalTime = endTime - startTime;
            System.out.println("3:" + totalTime);
        }

        return res;
    }

    // bfs traverse all the nodes starting from beginWord
    private Map<String, Set<String>> bfs(String beginWord, String endWord, Map<String, List<String>> graph) {
        Map<String, Set<String>> prevs = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);

        List<List<String>> res = new ArrayList<>();
        List<String> path = new LinkedList<>();
        path.add(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();
            Set<String> visiting = new HashSet<>();
            for(int i=0; i<size; i++) { // visited by layer so that we can get all the possible paths of endWord
                String cur = q.poll();
                for(String nei : graph.get(cur)) {
                    if(!visited.contains(nei) || visiting.contains(nei)  || nei.equals(endWord)) {
                        // first time visit
                        if(!visited.contains(nei)){
                            q.offer(nei);
                            visited.add(nei);
                            visiting.add(nei);
                        }
                        // add one previous node
                        Set<String> temp = prevs.get(nei);
                        if(temp == null) {
                            temp = new HashSet<>();
                            prevs.put(nei, temp);
                        }
                        temp.add(cur);
                    }
                }

            }
            if(visiting.contains(endWord)) {
                break;
            }
        }
        return prevs;
    }


    private Map<String, List<String>> buildGraph(List<String> wordList, String beginWord) {
        Set<String> set = new HashSet<>();
        Map<String, List<String>> graph = new HashMap<>();
        for(String word : wordList) {
            if(word.equals(beginWord)) continue;
            set.add(word);
        }
        for(String word : wordList) {
            findNeighbours(word, graph, set);
        }

        findNeighbours(beginWord, graph, set);
        return graph;
    }

    private void findNeighbours(String word, Map<String, List<String>> graph, Set<String> set) {
        graph.put(word, new ArrayList<>());
        char[] c = word.toCharArray();
        for(int i = 0; i < c.length; i++) {
            char c1 = c[i];
            for(int j = 'a'; j <= 'z'; j++) {
                c[i] = (char)j;
                String temp = new String(c);
                if(set.contains(temp)) {
                    graph.get(word).add(temp);
                }
            }
            c[i] = c1;
        }
    }

    // build the paths with dfs + mem
    private void buildPaths(Map<String, Set<String>> prevs, String beginWord, String endWord, Deque<String> cur, List<List<String>> res) {
        cur.offerFirst(endWord);
        if(endWord.equals(beginWord)) {
            res.add(new LinkedList<>(cur));
            cur.pollFirst();
            return;
        }

        Set<String> prevNodes = prevs.get(endWord);
        for(String s : prevNodes) {
            buildPaths(prevs, beginWord, s, cur, res);
        }
        cur.pollFirst();
    }
}
