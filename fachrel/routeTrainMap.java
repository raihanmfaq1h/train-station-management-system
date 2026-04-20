
class test{
    public static void main(String[] args) {
        routeTrainMap map = new routeTrainMap();
        map.assignTrain("JKT-SBY", new train("Argo", "T1", "Jakarta", "Surabaya", "08:00"));
        map.assignTrain("JKT-MLG", new train("Arga", "T1", "Jakarta", "Surabaya", "08:00"));
        map.assignTrain("JKT-BDG", new train("Argi", "T1", "Jakarta", "Surabaya", "08:00"));
        map.assignTrain("JKT-BGR", new train("Arge", "T1", "Jakarta", "Surabaya", "08:00"));
        //map.getTrainOnRoute("JKT-SBY");
        //map.removeRoute("JKT-SBY");
        //map.getTrainOnRoute("JKT-SBY");
        map.listRoute();
        System.out.println();

    }
}



class routeTrainMap{
    entry[] bucket = new entry[10];

    int hash(String key){
        return Math.abs(key.hashCode() % bucket.length);
    }

    void assignTrain(String key, train value){
        int index = hash(key);
        bucket[index] = new entry(key, value);
        System.out.println(key + "dimasukkan ke dalam array" + index);
    }

    void getTrainOnRoute(String key){
        int index = hash(key);
        entry current = bucket[index];
        if (current.key == key){
            System.out.println(current.value.name);
        }
    }
    void removeRoute(String key){
        int index = hash(key);
        entry current = bucket[index];
        if (current.key == key){
            current.key = null;
        }

    
    
    }
    void listRoute(){
        for (int i= 0; i < bucket.length; i++){
            if(bucket[i] == null){
                continue;
            } else{
                System.out.println(bucket[i].key);
            }
        }

        
        
    }

}






class entry{
    String key;
    train value;
    entry next;

    entry(String key, train value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
class train{
    String name;
    String id;
    String origin;
    String destination;
    String departureTime;

    train(String name, String id, String origin, String destination, String departureTime){
        this.name = name;
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
    }
}

