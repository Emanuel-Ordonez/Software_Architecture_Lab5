package AgentDemo;
import Java.lang.runnable;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FBI_Agent implements Agent_IF{
    private boolean workingInProgress;
    private String myFootPrint;

    public FBI_Agent(String footprint){
        this.workingInProgress = true;
        this.myFootPrint = footprint;
    }

    public void run(){
        while(true){
            if(workingInProgress){
              try {
                sleep(100);
              } catch (InterruptedException ex) {
                Logger.getLogger(FBI_Agent.class.getName()).log(Level.SEVERE, null, ex);
              }
                System.out.println(myFootPrint);
            }
            else{
              try {
                sleep(500);
              } catch (InterruptedException ex) {
                Logger.getLogger(FBI_Agent.class.getName()).log(Level.SEVERE, null, ex);
              }
                System.out.println("in FBI_Agent > run() > else");
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
