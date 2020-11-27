package prodcon;

public class SimpleMailbox implements Mailbox {

    private int contents;

    @Override
    public int take() {
        printState("take():" + contents);
        return contents;
    }

    @Override
    public void put(int value) {
        printState("put(" + value + ")  ");
        contents = value;
    }

    @Override
    public String toString() {
        return "[ contents = " + contents + " ]";
    }

    public void printState(String operation) {
        System.out.println("SimpleMailbox." + operation + this);
    }
}
