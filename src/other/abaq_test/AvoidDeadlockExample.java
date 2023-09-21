package other.abaq_test;

import java.util.Objects;

public class AvoidDeadlockExample {
    public static void main(String[] args) throws InterruptedException
    {
        //creating object of the Object class
        User user1 = new User("User1");
        User user2 = new User("User2");
        User user3 = new User("User3");
        //creating constructor of the Thread class and passing SynchroniseThread object as a parameter
        Thread thread1 = new Thread(new SynchroniseThread(user1, user2), "thread1");
        Thread thread2 = new Thread(new SynchroniseThread(user2, user3), "thread2");
        //executing thread1
        thread1.start();
        //the sleep() method suspends the execution of the current thread (thread1) for the specific period
        Thread.sleep(2000);
        //executing thread2
        thread2.start();
        //suspends the execution of the current thread (thread2) for the specific period
        Thread.sleep(2000);
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
class SynchroniseThread implements Runnable
{
    private User user1;
    private User user2;
    public SynchroniseThread(User o1, User o2)
    {
        this.user1 = o1;
        this.user2 = o2;
    }
    //overriding run() method of the Thread class
    @Override
    //it allows two threads are running concurrently
    public void run()
    {
        //getteing the current thread name
        String name = Thread.currentThread().getName();
        System.out.println(name + " trying to acquire lock on " + user1.getName());
        //Synchronized() method is used to lock an object for any shared resource. When a thread invokes the synchronized() method,
        //it automatically acquires the lock for that object and releases it when the thread completes its task.
        synchronized (user1)
        {
            System.out.println(name + " acquired lock on " + user1.getName());
            //calling work() method
            work(name, user1);
        }

        System.out.println(name + " trying to acquire lock on " + user2.getName());
        synchronized (user2)
        {
            System.out.println(name + " acquired lock on " + user2.getName());
            work(name, user2);
        }
//        System.out.println(name + " released lock of " + user2.getName());
        System.out.println(name + " execution is completed.");
    }
    private void work(String name, User user)
    {
        try
        {
            System.out.println("Suspending the thread "+name+" for work");
            //the sleep() method suspends the execution of the current thread for 5 seconds
            Thread.sleep(5000);
            System.out.println(name + " released lock of " + user.getName());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
