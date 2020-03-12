package AgentDemo;
import static java.lang.Thread.sleep;

public class CIA_Agent implements Agent_IF, Runnable{
    private boolean workingInProgress = false;
    private String myFootPrint;
    private int CIA_ID;

    public CIA_Agent(String footprint){
        this.myFootPrint = footprint;
    }

    @Override
    public void run(){
        while(true){
            if(workingInProgress){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(myFootPrint);
            }
            else{
                /*try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                processing();
            }
        }
    }

    public void startTask(){workingInProgress=true;}

    public void stopTask(){workingInProgress=false;}

    public void setTaskID(int id) {
        this.CIA_ID = id;
    }

    private void processing(){}
}
