package on.focus0147.service;

import on.focus0147.model.Cat;

import java.util.*;

public class CatsService {

    private static final Map<Integer, Cat> cats = new HashMap<>();

    static  {
        cats.put(1, new Cat(1,"Puf"));
        Cat cat1 = new Cat();
        cats.put(cat1.getId(), cat1);
    }

    public static Collection<Cat> getCats() {
        return cats.values();
    }
    public static void addCat(Cat cat) {
        cats.put(cat.getId(), cat);
    }

    public static Cat getCatById(int id){
        return cats.get(id);
    }

}
