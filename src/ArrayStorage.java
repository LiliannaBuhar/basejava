public class ArrayStorage {
    Resume[] storage = new Resume[2];
    int length = 0;

    void update(Resume resume) {

        for (int i = 0; i < length; i++) {
            if (storage[i].uuid == resume.uuid) {
                storage[i] = resume;
            }
        }

    }

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
                System.out.println("Error save: resume is already existed in storage");
                break;
            }
        }
        if (!isExists) {
            if (length >= storage.length) {
                System.out.println("Error save: error length of the array");
            } else {
                storage[length] = r;
                length++;
                System.out.println("Info save: resume is added in storage");
            }
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
        return length;
    }
}
