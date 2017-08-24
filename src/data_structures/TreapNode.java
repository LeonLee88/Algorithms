package data_structures;

/**
 * Created by leon on 7/6/17.
 */
public class TreapNode {
    int key;
    int priority; // smaller value means higher priority
    TreapNode left;
    TreapNode right;

    public TreapNode(int key) {
        this.key = key;
        this.priority = (int) (Math.random() * 100);
    }
}

