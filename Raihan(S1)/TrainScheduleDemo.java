public class TrainScheduleDemo {

    public static void main(String[] args) {

        TrainSchedule schedule = new TrainSchedule();

        System.out.println("== ADD ==");
        schedule.addTrain(new TrainSchedule.Train("T001", "Argo Bromo",  "Jakarta",    "Surabaya", "07:00"));
        schedule.addTrain(new TrainSchedule.Train("T002", "Gajayana",    "Jakarta",    "Malang",   "08:30"));
        schedule.addTrain(new TrainSchedule.Train("T003", "Taksaka",     "Yogyakarta", "Jakarta",  "06:00"));
        schedule.addTrain(new TrainSchedule.Train("T004", "Sembrani",    "Jakarta",    "Surabaya", "20:00"));

    
        System.out.println("\n== SIZE & ISEMPTY ==");
        System.out.println("Total: " + schedule.size());
        System.out.println("Kosong? " + schedule.isEmpty());

        System.out.println("\n== LIST ALL ==");
        schedule.listAll();

        System.out.println("\n== FIND BY ID ==");
        schedule.findById("T002");         
        schedule.findById("T099");         

        System.out.println("\n== FIND BY ROUTE ==");
        schedule.findByRoute("Jakarta", "Surabaya");  
        schedule.findByRoute("Bandung",  "Surabaya");  

        System.out.println("\n== REMOVE ==");
        schedule.removeTrain("T003");      
        schedule.removeTrain("T099");    

        System.out.println("\n== LIST ALL (setelah hapus T003) ==");
        schedule.listAll();
    
    }
}