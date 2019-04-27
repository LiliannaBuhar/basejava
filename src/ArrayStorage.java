public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int length = 0;

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
        if (isExists) {
            storage[length] = r;
            length++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < length; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }


    void delete(String uuid) {
        for (int i = 0; i < length; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = storage[length - 1];
                storage[length - 1] = null;
                length--;
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
