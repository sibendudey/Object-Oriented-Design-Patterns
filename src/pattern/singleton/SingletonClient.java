package pattern.singleton;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonClient {
    static Map<Singleton, Integer> map = new ConcurrentHashMap<>();
    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0 ; i < 10000 ; i++) {
            executorService.execute(() -> map.put(Singleton.getInstance(), 1));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        assert map.size() == 1 : "Operation is not successfully completed, size is " + map.size();
    }
}

class Singleton {
    private volatile static Singleton singleton;
    public static Singleton getInstance()   {
        if (singleton == null)  {
            synchronized (Singleton.class)  {
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }


}
