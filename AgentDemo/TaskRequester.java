package AgentDemo;
import PoolPattern.ObjectPool;
import Java.lang.runnable;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskRequester {
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
        Logger.getLogger(TaskRequester.class.getName()).log(Level.SEVERE, null, ex);
      }
        agent.stopTask();
        server.release(agent);
    }
}
