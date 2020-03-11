package AgentDemo;
import Java.lang.runnable;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.lang.Thread.sleep;

public class CIA_Agent implements Agent_IF{
    private boolean workingInProgress;
    private String myFootPrint;

    public CIA_Agent(String footprint){
        this.workingInProgress = true;
        this.myFootPrint = footprint;
    }

    public void run(){
        while(true){
            if(workingInProgress){
              try {
                sleep(100);
              } catch (InterruptedException ex) {
                Logger.getLogger(CIA_Agent.class.getName()).log(Level.SEVERE, null, ex);
              }
                System.out.println(myFootPrint);
            }
            else{
                System.out.println("in: CIA_Agent.java");
              try {
                sleep(500);
              } catch (InterruptedException ex) {
                Logger.getLogger(CIA_Agent.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
        }
    }

    public void startTask(){workingInProgress=true;}
    public void stopTask(){workingInProgress=false;}

  @Override
  public void setTaskID(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
