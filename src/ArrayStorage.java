public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int length = size();
        for (int i = 0; i < length; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        boolean isExists = false;
        int length = size();
        for (int i = 0; i < length; i++) {
            if (storage[i].uuid == r.uuid) {
                storage[i] = r;
                isExists = true;
                System.out.println("r.uuid уже существует. Элемент обновлен");
                break;
            }
        }
        if (isExists == false) {
            storage[length] = r;
        }
    }

    Resume get(String uuid) {
        Resume resume = null;
        int length = size();
        for (int i = 0; i < length; i++) {
            if (storage[i].uuid == uuid) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }


    void delete(String uuid) {
        int counter = size();
        for (int i = 0; i < counter; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
                storage[i] = storage[counter - 1];
                storage[counter - 1] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int length = size();
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
