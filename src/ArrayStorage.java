import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int length = 0;


    void update(Resume resume) {

        int index=getIndex(resume.getUuid());
        if(index==-1) {
            System.out.println("Resume"+resume.getUuid()+" not exist");
        }
        else {
            storage[index] = resume;
            length++;
        }

    }

    void clear() {
        Arrays.fill(storage, 0, length - 1, null);
        length = 0;
    }

    void save(Resume r) {

        if(getIndex(r.getUuid()) !=-1) {
            System.out.println("Resume "+r.getUuid()+" already exist");
        }
        else if (length>=storage.length) {
            System.out.println("Storage overflow");
        }
        else {
            storage[length] = r;
            length++;
        }
    }

    Resume get(String uuid) {
        int index=getIndex(uuid);
        if(index==-1) {
            System.out.println("Resume "+uuid+" not exist");
            return null;
        }
        return storage[index];
    }


    void delete(String uuid) {
        int index=getIndex(uuid);
        if (index==-1) {
            System.out.println("Error");
        }
        else {
            storage[index] = storage[length - 1];
            storage[length - 1] = null;
            length--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] smallStorage = new Resume[length];
        smallStorage = Arrays.copyOfRange(storage, 0, length);
        return smallStorage;
    }

    int size() {
        return length;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
