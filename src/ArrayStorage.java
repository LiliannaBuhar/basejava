public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int length = size();

    void clear() {
        for (int i = 0; i < length; i++) {
            storage[i] = null;
        }
        length = 0;
    }

    void save(Resume r) {
        boolean isExists = false;
        for (int i = 0; i < length; i++) {
            if (storage[i].uuid == r.uuid) {
                isExists = true;
                break;
            }
        }
        if (isExists == false) {
            storage[length] = r;
            length = length + 1;
        }
    }

    Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < length; i++) {
            if (storage[i].uuid == uuid) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }


    void delete(String uuid) {
        for (int i = 0; i < length; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = storage[length - 1];
                storage[length - 1] = null;
                length = length - 1;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] smallStorage = new Resume[length];
        for (int i = 0; i < length; i++) {
            smallStorage[i] = storage[i];
        }
        return smallStorage;
    }

    int size() {
        int counter = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                counter = i + 1;
            }
        }
        return counter;
    }
}
