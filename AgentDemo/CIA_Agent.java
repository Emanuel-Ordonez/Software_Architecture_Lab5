package AgentDemo;

public class CIA_Agent {
    private boolean workingInProgress;
    private String myFootPrint;

    public CIA_Agent(String footprint){
        this.workingInProgress = true;
        this.myFootPrint = footprint;
    }

    public void run(){
        while(true){
            if(workingInProgress){
                sleep(100);
                System.out.println(myFootPrint);
            }
            else{
                sleep(500);
            }
        }
    }

    public void startTask(){workingInProgress=true;}
    public void stopTask(){workingInProgress=false;}
}
