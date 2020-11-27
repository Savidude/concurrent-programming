package prodcon;

public interface Mailbox {

    public int take();

    public void put(int value);
}
