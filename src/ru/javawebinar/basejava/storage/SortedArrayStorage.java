package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) > 0) {
            System.out.println("Resume! " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {

            if (size==0) {
                storage[size]=r;
             }

            else {
             for (int i=0;i<size;i++)
            {
                if(storage[i].compareTo(r)>0)   {
                    for (int j=size;j>i;j--) {
                        storage[j]=storage[j-1];
                    }
                    storage[i]=r;
                    break;
              }
                else if (i==size-1) {
                    storage[size]=r;
                }
            }
            }
            size++;

        }
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index <0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            for (int i=index;i<size-1;i++)
            storage[i] = storage[i+1];
        }
        storage[size - 1] = null;
        size--;
    }


    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}

