import javax.swing.*;
import java.awt.*;

class ClockView {

    private JLabel label;
    private JCheckBox checkBox;
    private JButton btnMinHours;
    private JButton btnPlusHours;
    private JButton btnMinMinutes;
    private JButton btnPlusMinutes;
    private JButton btnMinSeconds;
    private JButton btnPlusSeconds;
    private JButton btnStart;
    private JButton btnReset;
    private JButton btnStop;

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public JButton getBtnMinHours() {
        return btnMinHours;
    }

    public void setBtnMinHours(JButton btnMinHours) {
        this.btnMinHours = btnMinHours;
    }

    public JButton getBtnPlusHours() {
        return btnPlusHours;
    }

    public void setBtnPlusHours(JButton btnPlusHours) {
        this.btnPlusHours = btnPlusHours;
    }

    public JButton getBtnMinMinutes() {
        return btnMinMinutes;
    }

    public void setBtnMinMinutes(JButton btnMinMinutes) {
        this.btnMinMinutes = btnMinMinutes;
    }

    public JButton getBtnPlusMinutes() {
        return btnPlusMinutes;
    }

    public void setBtnPlusMinutes(JButton btnPlusMinutes) {
        this.btnPlusMinutes = btnPlusMinutes;
    }

    public JButton getBtnMinSeconds() {
        return btnMinSeconds;
    }

    public void setBtnMinSeconds(JButton btnMinSeconds) {
        this.btnMinSeconds = btnMinSeconds;
    }

    public JButton getBtnPlusSeconds() {
        return btnPlusSeconds;
    }

    public void setBtnPlusSeconds(JButton btnPlusSeconds) {
        this.btnPlusSeconds = btnPlusSeconds;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public void setBtnStart(JButton btnStart) {
        this.btnStart = btnStart;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(JButton btnReset) {
        this.btnReset = btnReset;
    }

    public JButton getBtnStop() {
        return btnStop;
    }

    public void setBtnStop(JButton btnStop) {
        this.btnStop = btnStop;
    }

    public void drawTimer(){

        JFrame frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(500, 250));
        frame.setLocation(10, 10);
        frame.setResizable(false);

        JPanel panel = new JPanel();

        JPanel forLabelTimer = new JPanel();
        forLabelTimer.setPreferredSize(new Dimension(500, 50));
        JLabel labelTimer = new JLabel("00:00:00");
        labelTimer.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        panel.add(labelTimer);

        this.label = labelTimer;

        frame.getContentPane().add(forLabelTimer);

        JPanel timerSetter = new JPanel();
        forLabelTimer.setPreferredSize(new Dimension(500, 50));
        JLabel hours = new JLabel("Hours:");
        timerSetter.add(hours);

        JButton btnMinHours = new JButton("-");
        btnMinHours.setPreferredSize(new Dimension(50, 50));
        timerSetter.add(btnMinHours);
        this.btnMinHours = btnMinHours;

        JButton btnPlusHours = new JButton("+");
        btnPlusHours.setPreferredSize(new Dimension(50, 50));
        timerSetter.add(btnPlusHours);
        this.btnPlusHours = btnPlusHours;

        JLabel minutes = new JLabel("Minutes:");
        timerSetter.add(minutes);

        JButton btnMinMinutes = new JButton("-");
        btnMinMinutes.setPreferredSize(new Dimension(50, 50));
        timerSetter.add(btnMinMinutes);
        this.btnMinMinutes = btnMinMinutes;

        JButton btnPlusMinutes = new JButton("+");
        btnPlusMinutes.setPreferredSize(new Dimension(50, 50));
        timerSetter.add(btnPlusMinutes);
        this.btnPlusMinutes = btnPlusMinutes;

        JLabel seconds = new JLabel("Seconds:");
        timerSetter.add(seconds);

        JButton btnMinSeconds = new JButton("-");
        btnMinSeconds.setPreferredSize(new Dimension(50, 50));
        timerSetter.add(btnMinSeconds);
        this.btnMinSeconds = btnMinSeconds;

        JButton btnPlusSeconds = new JButton("+");
        btnPlusSeconds.setPreferredSize(new Dimension(50, 50));
        timerSetter.add(btnPlusSeconds);
        this.btnPlusSeconds = btnPlusSeconds;

        JPanel action = new JPanel();
        action.setPreferredSize(new Dimension(500, 70));

        JButton btnStart = new JButton("START");
        btnStart.setPreferredSize(new Dimension(100, 50));
        action.add(btnStart);
        this.btnStart = btnStart;

        JButton btnReset = new JButton("RESET");
        btnReset.setPreferredSize(new Dimension(100, 50));
        action.add(btnReset);
        this.btnReset = btnReset;

        JButton btnStop = new JButton("STOP");
        btnStop.setPreferredSize(new Dimension(100, 50));
        action.add(btnStop);
        this.btnStop = btnStop;

        JCheckBox checkBox = new JCheckBox();
        action.add(checkBox);

        this.checkBox = checkBox;

        panel.add(timerSetter);
        panel.add(action);
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

}