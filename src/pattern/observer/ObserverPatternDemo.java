package pattern.observer;

import java.util.HashSet;
import java.util.Set;

public class ObserverPatternDemo {
    public static void main(String[] args) throws InterruptedException {
        Subject subject = new SubjectImpl();
        Observer observer = new ObserverImpl();
        subject.registerObserver(observer);
        Thread t = new Thread(() -> {
           while (true) {
               ((SubjectImpl) subject).run();
           }
        });
        t.start();
        Thread.sleep(4000);
        subject.unRegisterObserver(observer);
    }
}

interface Observer  {
    void update();
}


interface Subject   {
    void registerObserver(Observer observer);
    void unRegisterObserver(Observer observer);
    void notifyObserver();
}


class ObserverImpl implements Observer  {
    @Override
    public void update() {
        System.out.println("Subject updated");
    }
}


class SubjectImpl implements Subject    {

    Set<Observer> observers = new HashSet<>();
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers)
            observer.update();
    }

    public void run()   {
        notifyObserver();
    }
}





