import javax.swing.*;
import java.awt.Label;

class StopwatchThread extends TimeOperators{

    private JLabel label;

    public JLabel getLabel() {
        return label;
    }

    public JLabel setLabel(JLabel label) {
        this.label = label;
        return label;
    }

    public StopwatchThread(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        super.run();
        int times[] = {getHours(label.getText()), getMinutes(label.getText()), getSeconds(label.getText())};
        while (true) {
            if(checkTime(times[2])) {
                times[2]++;
            } else {
                times[2] = 0;
                if(checkTime(times[1])){
                    times[1]++;
                } else {
                    times[1] = 0;
                    times[0]++;
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }

            label.setText(setTime(times));
        }
    }

    private boolean checkTime(int time) {
        boolean tmp = false;
        if (time < 59)
            tmp = true;
        return tmp;
    }

    public String reset(){
        stop();
        return "00:00:00";
    }

}
