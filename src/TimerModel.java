import javax.swing.*;

class TimerModel {
    SetTime setTime = new SetTime();
    TimerThread timerThread = new TimerThread(getLabel());

    private JLabel label;


    public SetTime getSetTime() {
        return setTime;
    }

    public void setSetTime(SetTime setTime) {
        this.setTime = setTime;
    }

    public TimerThread getTimerThread() {
        return timerThread;
    }

    public void setTimerThread(TimerThread timerThread) {
        this.timerThread = timerThread;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public TimerModel(JLabel label) {
        this.label = label;
    }
}
