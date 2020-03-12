package AgentDemo;
import static java.lang.Thread.sleep;

public class FBI_Agent implements Agent_IF, Runnable{
    private boolean workingInProgress;
    private String myFootPrint;
    private int id;

    public FBI_Agent(String footprint){
        this.myFootPrint = footprint;
    }

    @Override
    public void run(){
        while(true) {
            if (workingInProgress) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(myFootPrint);
            } else {
                processing();
            }
        }
    }


    public void startTask(){workingInProgress=true;}

    public void stopTask(){workingInProgress=false;}

    public void setTaskID(int id) {
        this.id=id;
    }

    private void processing(){

    }

}
