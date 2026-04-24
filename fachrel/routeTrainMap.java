package fachrel;
import shared.train;

class routeTrainMap{
    entry[] bucket = new entry[10];

    int hash(String key){
        return Math.abs(key.hashCode() % bucket.length);
    }

    void assignTrain(String key, train value){
        int index = hash(key);
        entry current = bucket[index];

         if (current == null){ // bucket kosong
            bucket[index] = new entry(key, new nodeTrain(value));
            return;
         }
         while (current != null){ //bucket gk kosong (lakukan looping)
            if (current.key == key){ //keynya bener (assign)
                nodeTrain now = current.value;

                while (now.next != null){ // kalau bukan paling depan
                    now = now.next;
                }
                now.next = new nodeTrain(value);
                return;
            }
            if (current.next == null){
                current.next = new entry(key, new nodeTrain(value));
                return;
            }
            current = current.next;
         }
    }

    void getTrainOnRoute(String key){
        System.out.println("=== Kereta Rute " + key + " ===");
        int index = hash(key);
        entry current = bucket[index];
        int angka = 1;
        while (current != null){
            if (current.key == key){
                nodeTrain now = current.value;
            while (now != null){
                System.out.print(angka);
                System.out.println(". " + now.value.getName() + " - berangkat " + now.value.getDepartureTime());
                now = now.next;
                angka++;
                
            }
            current = current.next;
        }         
        }
        System.out.println("Key tidak ditemukan");
    }
    void removeRoute(String key){
        int index = hash(key);
        entry current = bucket[index];
        entry prev = null;
        
        while (current != null){ //buat looping ke next
            if (current.key == key){ // cek key pas 
                if (prev == null){ // cek ada diawal tau tidak
                    bucket[index] = current.next;
                    System.out.println("Rute" + key + "Berhasil dihapus");
                    return;
                } else {
                    prev.next = current.next;
                    System.out.println("Rute" + key + "Berhasil dihapus");
                    return;
                }
            }
            prev = current;
            current = current.next;
        }


    }
    void listRoute(){
        System.out.println("=== Daftar Rute ===");
        for (int i= 0; i < bucket.length; i++){
            if(bucket[i] == null){
            } else{
                System.out.println("- " + bucket[i].key);
            }
        }

        
        
    }

}

class entry{
    String key;
    nodeTrain value;
    entry next;

    entry(String key, nodeTrain value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
class nodeTrain{
    train value;
    nodeTrain next;

    nodeTrain(train value){
        this.value = value;
        this.next = null;
    }
}

