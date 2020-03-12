package PoolPattern;

public class ObjectPool implements ObjectPool_IF {

    private static ObjectPool poolInstance;
    private Object lockObject = new Object();
    private int size; //how many free objects
    private int instanceCount; //how many objects have been created
    private int maxInstances; //maximum objects to be created
    private Object[] pool;
    private ObjectCreation_IF creator;


    private ObjectPool(ObjectCreation_IF c, int max){
        size = 0;
        instanceCount = 0;
        creator = c;
        maxInstances = max;
        pool = new Object[maxInstances];
    }

    public static ObjectPool getPoolInstance(ObjectCreation_IF c, int max){
        if (poolInstance==null)
            poolInstance = new ObjectPool(c, max);
        return poolInstance;
    }


    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return pool.length;
    }

    public int getMaxInstances(){
        return maxInstances;
    }

    public int getInstanceCount(){
        return instanceCount;
    }

    public void setCapacity(int newValue){
        if(newValue <= 0){
            String msg = "Capacity must be greater than zero: "+newValue;
            throw new IllegalArgumentException(msg);
        }
        synchronized(lockObject){
            Object[] newPool = new Object[newValue];
            System.arraycopy(pool, 0, newPool, 0, newValue);
            pool = newPool;
        }
    }

    public Object getObject(){
        synchronized(lockObject) {
            if(size > 0)
                return removeObject();
            else if(getInstanceCount() < getMaxInstances())
                return createObject();
            else
                return null;
        }
    }

    @Override
    public Object waitForObject(){
        synchronized(lockObject) {
            if(size > 0)
                return removeObject();
            else if(getInstanceCount() < getMaxInstances())
                return createObject();
            else{
                do{
                    try {
                        lockObject.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }while(size <= 0);
                return removeObject();
            }
        }
    }

    private Object removeObject(){
        size--;
        return pool[size];
    }

    public void release(Object o){
        if(o == null) {
            throw new NullPointerException();
        }
        synchronized (lockObject){
            if(getSize() < getCapacity()){
                pool[size] = o;
                size++;
                lockObject.notify();
            }
        }
    }

    private Object createObject(){
        Object newObject = creator.create();
        instanceCount++;
        return newObject;
    }
}
