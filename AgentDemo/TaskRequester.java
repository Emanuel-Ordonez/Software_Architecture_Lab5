package AgentDemo;
import PoolPattern.ObjectPool;
import static java.lang.Thread.sleep;

public class TaskRequester implements Runnable{
    ObjectPool server;
    
    public TaskRequester(ObjectPool p){
      this.server = p;
    }

    public void run(){
        Agent_IF agent= (Agent_IF)server.waitForObject();
        agent.startTask();
      try {
        sleep(2000);//simulate task processing
      } catch (InterruptedException ex) {
          ex.printStackTrace();
      }
        agent.stopTask();
        server.release(agent);
    }
}
