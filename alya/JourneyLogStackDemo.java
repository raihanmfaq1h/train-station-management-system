import shared.train;

public class JourneyLogStackDemo {
    public static void main(String[] args){
        JourneyLogStack Stack = new JourneyLogStack();

        Stack.push(new train("T001", "Bandung", "Jakarta"));
        Stack.push(new train("T002", "Bogor", "Depok"));
        Stack.push(new train("T003", "Cirebon", "Bekasi"));

        Stack.displayHistory();

        System.out.println("Terakhir: " + Stack.peek().getName());
        
        Stack.pop();
        Stack.displayHistory();
        
        Stack.pop();
        Stack.pop();
        Stack.pop(); // eror
    }
}
