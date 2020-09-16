import java.util.Arrays;

public class Thread {
    Arrays[] instr;
    String state;
    int processID;
    int numThread;

    public Thread(Arrays[] instr, String state, int processID, int numThread) {
        this.instr = instr;
        this.state = state;
        this.processID = processID;
        this.numThread = numThread;
    }
}
