public class  TrainHistoryStackDemo {
    public static void main(String[] args) {
        TrainHistoryStack stack = new TrainHistoryStack();

        stack.push(new Train("T001", "Bandung", "Jakarta"));
        stack.push(new Train("T002", "Bogor", "Depok"));
        stack.push(new Train("T003", "Cirebon", "Bekasi"));

        stack.displayHistory();

        System.out.println("Terakhir: " + stack.peek().getName());

        stack.pop();
        stack.displayHistory();

        stack.pop();
        stack.pop();
        stack.pop(); // error
    }
