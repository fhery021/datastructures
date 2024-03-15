import java.util.*;
import java.util.HashMap;

public class Worker {
    private final Map<Integer, TaskResource> taskResources = new HashMap<>();

    public Iterable<TaskResource> getTaskResources() {
        return this.taskResources.values();
    }

    public TaskResource acquireTaskResource(int id) {
        TaskResource w = this.taskResources.getOrDefault(id, null);
        if (w == null) {
            w = new TaskResource(id);
            this.taskResources.put(id, w);
        }

        return w;
    }

    public void releaseTaskResource(int id) {
        TaskResource w = this.taskResources.getOrDefault(id, null);
        if (w == null)
            throw new IllegalArgumentException();

        w.close();
    }

    public class TaskResource implements AutoCloseable {
        private List<String> taskList = new ArrayList<String>();

        private int id;
        private boolean isClosed = false;

        public int getId() {
            return this.id;
        }

        public List<String> getTasks() {
            if (isClosed){
                throw new IllegalStateException(this.getClass().getName() + "Is Closed.");
            }
            return this.taskList;
        }

        public TaskResource(int id) {
            this.id = id;
        }

        public void doTask(String task) {
            if (isClosed){
                throw new IllegalStateException(this.getClass().getName() + "Is Closed.");
            }
            this.taskList.add(task);
        }

        @Override
        public void close() {
            if (!isClosed) {
                taskList.clear();
                isClosed = true;
            }
        }
    }

    public static void main(String[] args) {
        Worker d = new Worker();

        d.acquireTaskResource(1).doTask("Task11");
        d.acquireTaskResource(2).doTask("Task21");
        System.out.println(String.join(", ", d.acquireTaskResource(2).getTasks()));
        d.releaseTaskResource(2);
        d.acquireTaskResource(1).doTask("Task12");
        System.out.println(String.join(", ", d.acquireTaskResource(1).getTasks()));
        d.releaseTaskResource(1);
    }
}
