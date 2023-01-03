import javax.swing.*;

class StopwatchModel {
    private StopwatchThread stopwatchThread = new StopwatchThread(getLabel());

    private JLabel label;

    public StopwatchThread getStopwatchThread() {
        return stopwatchThread;
    }

    public void setStopwatchThread(StopwatchThread stopwatchThread) {
        this.stopwatchThread = stopwatchThread;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public StopwatchModel(JLabel label) {
        this.label = label;
    }
}
