class Task {
    String Desc;
    Boolean Status;

    public Task(String Desc) {
        this.Desc = Desc;
        this.Status = false;
    }
}

class Nodes {
    Task T1;
    Nodes nextNodes;

    public Nodes(Task T1) {
        this.T1 = T1;
        this.nextNodes = null;
    }
}

class Todo {
    Nodes head;

    public void addItems(String desc) {
        Task T1 = new Task(desc);
        Nodes newNodes = new Nodes(T1);

        if (head == null) {
            this.head = newNodes;
        } else {
            newNodes.nextNodes = head;
            this.head = newNodes;
        }
    }

    public void statusChange(String description) {
        Nodes current = head;
        while (current != null) {
            if (current.T1.Desc.equals(description)) {
                current.T1.Status = true;
                break;
            }
            current = current.nextNodes;
        }
    }

    public void remove(String description) {
        if (head == null) {
            return;
        }
        if (head.T1.Desc.equals(description)) {
            head = head.nextNodes;
            return;
        }
        Nodes prev = null;
        Nodes current = head;

        while (current != null) {
            if (current.T1.Desc.equals(description)) {
                prev.nextNodes = current.nextNodes;
                break;
            }
            prev = current;
            current = current.nextNodes;
        }
    }

    public void printTasks() {
        Nodes current = head;
        while (current != null) {
            System.out.println(
                    "Task: " + current.T1.Desc + " | Status: " + (current.T1.Status ? "Completed" : "Not Completed"));
            current = current.nextNodes;
        }
    }
}

public class todoList {
    public static void main(String[] args) {
        Todo todoList = new Todo();

        // Adding tasks
        todoList.addItems("Buy groceries");
        todoList.addItems("Finish homework");
        todoList.addItems("Go for a run");

        // Changing task status
        todoList.statusChange("Finish homework");

        // Removing a task
        todoList.remove("Buy groceries");

        // Print the tasks and their statuses
        todoList.printTasks();
    }
}
