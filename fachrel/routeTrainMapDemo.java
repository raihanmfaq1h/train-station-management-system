package fachrel;

import shared.train;

public class routeTrainMapDemo {
    public static void main(String[] args) {
        routeTrainMap map = new routeTrainMap();
        map.assignTrain("JKT-SBY", new train("T001", "Argo Bromo", "Jakarta", "Surabaya","07:00"));
        map.assignTrain("JKT-SBY", new train("T004", "Sembrani", "Jakarta", "Surabaya","20:00"));
        map.assignTrain("JKT-MLG", new train("T002", "Gajayana", "Jakarta", "Malang","08:30"));
        map.listRoute();
        map.getTrainOnRoute("JKT-SBY");
        map.removeRoute("JKT-MLG");
        map.getTrainOnRoute("JKT-MLG");
        

    }
}
