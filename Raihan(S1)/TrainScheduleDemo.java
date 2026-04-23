package Raihan;
import shared.Train;

public class TrainScheduleDemo {
    public static void main(String[] args) {

        TrainSchedule schedule = new TrainSchedule();

        schedule.addTrain(new Train("T001", "Argo Bromo", "Jakarta", "Surabaya", "07:00"));
        schedule.addTrain(new Train("T002", "Gajayana", "Jakarta", "Malang", "08:30"));
        schedule.addTrain(new Train("T003", "Taksaka", "Yogyakarta", "Jakarta", "06:00"));
        schedule.addTrain(new Train("T004", "Sembrani", "Jakarta", "Surabaya", "20:00"));

        schedule.listAll();

        schedule.findById("T002");
        schedule.findById("T099");

        schedule.findByRoute("Jakarta", "Surabaya");
        schedule.findByRoute("Bandung", "Surabaya");

        schedule.removeTrain("T003");
        schedule.removeTrain("T099");

        schedule.listAll();
    }
}
