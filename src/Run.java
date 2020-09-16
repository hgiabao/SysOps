import java.util.*;
import java.util.concurrent.TimeUnit;

public class Run {

    public static void main(String[] args) {
        List<Process> processList = new ArrayList<>();
        Map<Integer, List<Thread>> threadMap = new HashMap<>();
        int maxProcess = 100;
        int maxThread = 2;
        int ID = 0;
        long endTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(1L, TimeUnit.MINUTES); //Set time
        while (System.nanoTime() < endTime) {
            if (processList.size() < maxProcess && Math.random() >= 0.5) {
                //Create Threads & Process
                int numThread = 0;
                List<Thread> Threads = new ArrayList<Thread>();
                do {
                    Threads.add(new Thread(new Arrays[1], "waiting", ID, numThread));
                    numThread++;
                } while (Math.random() >= 0.5 && numThread < maxThread);
                threadMap.put(ID, Threads);
                Process Process = new Process(new Arrays[1], "waiting", 0, ID, numThread);
                processList.add(Process);
                ID++;
            }

            //Terminate Processes & Threads
            //Select random process in processList then remove it and its threads.
            if (Math.random() >= 0.7) {
                Random rand = new Random();
                if (!processList.isEmpty()) {
                    int processIndex = rand.nextInt(processList.size());
                    Process terminatingProcess = processList.get(processIndex);
                    threadMap.remove(terminatingProcess.processID);
                    processList.remove(processIndex);

                    System.out.println("terminateID: " + terminatingProcess.processID);
                }
            }
        }

        //Console log
        for (Process process : processList) {
            System.out.println(
                    //"Process: " + process.processID + "\t" + process.state + "\t" + "Instructions: " + Arrays.toString(process.instr) + "\t" + process.counter + "\t" + process.numThread
                    "Process: " + process.processID
            );
            if (process.numThread > 0) {
                List<Thread> threadList = threadMap.get(process.processID);
                for (Thread thread : threadList) {
                    System.out.println(
                            //"\t" + "Thread: " + thread.numThread + "\t" + thread.state + "\t" + "Instructions: " + Arrays.toString(process.instr)
                            "\t" + "Thread: " + thread.numThread
                    );
                }
            }
        }

    }


}
