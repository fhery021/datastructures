enum Side { NONE, LEFT, RIGHT }

public class ChainLink {
    private ChainLink left, right;

    private int leftSize = 0;
    private int rightSize = 0;


    public void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;

        rightPart.rightSize = this.rightSize + 1;
        this.rightSize++;

        ChainLink current = this;
        while (current != null) {
            current.leftSize++;
            current = current.left;
        }
    }

    public Side longerSide() {
        if (leftSize > rightSize) {
            return Side.LEFT;
        }
        if (leftSize < rightSize) {
            return Side.RIGHT;
        } else {
            return Side.NONE;
        }

    }


    public static void main(String[] args) {
        ChainLink left = new ChainLink();
        ChainLink middle = new ChainLink();
        ChainLink right = new ChainLink();
        left.append(middle);
        middle.append(right);
        System.out.println(left.longerSide());
    }
}
