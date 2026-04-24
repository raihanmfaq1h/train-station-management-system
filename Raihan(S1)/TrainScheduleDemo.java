package Raihan(1);

import shared.Train;

public class TrainScheduleDemo {
    public static void main(String[] args) {

        TrainSchedule schedule = new TrainSchedule();

        schedule.addTrain(new train("T001", "Argo Bromo", "Jakarta", "Surabaya"));
        schedule.addTrain(new train("T002", "Gajayana", "Jakarta", "Malang"));
        schedule.addTrain(new train("T003", "Taksaka", "Yogyakarta", "Jakarta"));
        schedule.addTrain(new train("T004", "Sembrani", "Jakarta", "Surabaya"));

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
