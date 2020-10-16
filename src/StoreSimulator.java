import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


public class StoreSimulator {

    public Random generator;

    public StoreSimulator() {
        generator = new Random();
    }


    class Task {
        int arrivalTime;
        int duration;

        Task(int a, int d) {
            arrivalTime = a;
            duration = d;
        }
        public String toString() {
            return "[" + Integer.toString(arrivalTime) + " " + Integer.toString(duration) + "]";
        }
    }

    /* return between 0 and n new arrivals. Currently n=3 */
    /* currently each task has duration 5 */
    public List<Task> getNewArrivals(int currentTime) {
        int nArrivals = generator.nextInt(3);
        ArrayList<Task> returnTasks = new ArrayList<>();
        for (int i = 0; i < nArrivals; i++) {
            returnTasks.add(new Task(currentTime, 5));
        }
        return returnTasks;
    }


    public void simulate(int nIterations) {
        Queue<Task> q = new LinkedList<>();
        int nArrivals = 0;
        int duration = 5;
        Random gen = new Random();
        List<Task> newArrivals;

        for (int i = 0; i < nIterations; i++) {

            /* get the new customers and add them to the queue */
            newArrivals = getNewArrivals(i);
            for (Task t : newArrivals) {
                q.add(t);
            }

            /* check to see if the person at the front of the queue is done */
            if (!q.isEmpty() && q.peek().arrivalTime + q.peek().duration < i) {
                Task done = q.remove();
                System.out.println("Waiting time:" + (i - done.arrivalTime));
            }
        }
    }


    public static void main(String[] args) {
        StoreSimulator st = new StoreSimulator();
        st.simulate(500);

    }
}


