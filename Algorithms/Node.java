public class Node {
    int x, y;
    boolean isStart, isEnd, isPath;
    int g, h, f;
    Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isPath() {
        return isPath;
    }

    public void setPath(boolean path) {
        isPath = path;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void reset() {
        isStart = false;
        isEnd = false;
        isPath = false;
        g = 0;
        h = 0;
        f = 0;
        parent = null;
    }
}