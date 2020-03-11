package AgentDemo;
import PoolPattern.ObjectPool;
import Java.lang.runnable;

public class TaskRequester{
    private ObjectPool server;

    TaskRequester(ObjectPool p){
        server = p;
    }

    public void run(){
        Agent_IF agent= (Agent_IF)server.waitForObject();
        agent.startTask();
        sleep(2000);//simulate task processing
        agent.stopTask();
        server.release(agent);
    }
}
