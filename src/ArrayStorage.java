public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
                storage[i]=null;
            }



        }


    void save(Resume r) {
        boolean is_exists=false;
        for(int i=0;i<size();i++) {
            if(storage[i].uuid==r.uuid) {
                storage[i]=r;
                is_exists=true;
                System.out.println("r.uuid уже существует. Элемент обновлен");
                break;
            }

       }
        if(is_exists==false) {
            storage[size()]=r;
        }

    }

    Resume get(String uuid) {
        Resume resume=null;
        for (int i = 0; i < size(); i++) {

            if(storage[i].uuid==uuid) {
                resume=storage[i];
                break;
            }

       }
        return resume;
    }


    void delete(String uuid) {
        int counter=size();

        for (int i = 0; i < counter; i++) {

            if(storage[i].uuid==uuid) {
                storage[i]=null;
                storage[i]=storage[counter-1];
                storage[counter-1]=null;
                break;
            }

        }


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int length=size();
        Resume[] smallStorage=new Resume[length];
        for(int i=0;i<length;i++) {
            smallStorage[i]=storage[i];
        }
        return smallStorage;
        }


    int size() {
        int counter=0;
        for(int i=0;i<storage.length;i++) {
            if(storage[i]!=null) {
                counter=i+1;
            }

        }
        return counter;
    }

}
