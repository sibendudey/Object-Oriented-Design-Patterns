package pattern.singleton;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * A class can only have a single instance
 * Singleton classes are used for logging, driver objects, caching and thread pool, database connections.
 *
 * Singleton classes should be accessible globally
 *
 */
public class SingletonClient {
    static Map<Singleton, Integer> map = new ConcurrentHashMap<>();
    static Map<Singleton2, Integer> map2 = new ConcurrentHashMap<>();
    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0 ; i < 10000 ; i++) {
            executorService.execute(() -> map.put(Singleton.getInstance(), 1));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }
        assert map.size() == 1 : "Operation is not successfully completed, size is " + map.size();

        executorService = Executors.newFixedThreadPool(100);
        for (int i = 0 ; i < 10000; i++)
            executorService.execute(() -> map2.put(Singleton2.getInstance(), 1));

        executorService.shutdown();
        while (!executorService.isTerminated());

        assert map2.size() == 1 : "Operation is not successfully completed, size is " + map2.size();
    }
}

/**
 * This one uses double locking mechanism to acheive lazy initialization
 * to provide singleton mechanism in a multi threaded environment.
 */
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

    // Prevents creation of object from outside.
    // Though protection from reflection is not yet achieved.
    private Singleton() {

    }
}

class Singleton2    {
    private static class SingletonStatic    {
        static Singleton2 singleton = new Singleton2();
    }

    public static Singleton2 getInstance()  {
        return SingletonStatic.singleton;
    }

    private Singleton2() {

    }
}
