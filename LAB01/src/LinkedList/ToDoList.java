package LinkedList;

class Node {

    String task;
    boolean isFinished;
    Node next;

    public Node(String task) {
        this.task = task;
        this.isFinished = false;
        this.next = null;
    }
}

public class ToDoList {

    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addTask(String task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
        System.out.println("Added Task: " + task);
    }

    public void markFinished(String task) {
        Node current = head;
        while (current != null) {
            if (current.task.equals(task)) {
                current.isFinished = true;
                System.out.println("Task marked as completed: " + task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found: " + task);
    }

    public void removeTask(String task) {
        Node current = head;
        if (current != null && current.task.equals(task)) {
            head = current.next;
            System.out.println("Task removed: " + task);
            return;
        }
        while (current != null && current.next != null) {
            if (current.next.task.equals(task)) {
                current.next = current.next.next;
                System.out.println("Task removed: " + task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found: " + task);
    }

    public void display() {
        Node current = head;
        System.out.println("TO DO LIST:");
        if (current == null) {
            System.out.println("Todo list is empty.");
            return;
        }
        while (current != null) {
            System.out.println(current.isFinished ? "Completed: " +current.task : "In progress: " + current.task);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        toDoList.addTask("Finish LAB01 CSD201");
        toDoList.addTask("Learn Hiragana");
        toDoList.addTask("Finish LAB02 LAB211");
        toDoList.display();

        toDoList.markFinished("Finish LAB02 LAB211");
        toDoList.display();

        toDoList.removeTask("Learn Hiragana");
        toDoList.display();
    }
}
