import java.util.Arrays;

public class Process {
    Arrays[] instr;
    String state;
    int counter;
    int processID;
    int numThread;

    public Process(Arrays[] instr, String state, int counter, int processID, int numThread) {
        this.instr = instr;
        this.state = state;
        this.counter = counter;
        this.processID = processID;
        this.numThread = numThread;
    }
}
