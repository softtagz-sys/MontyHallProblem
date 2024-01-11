package domain;

public class RoundResult {
    private final int wonRoundsSwitch;
    private final int wonRoundsNoSwitch;

    public RoundResult(int wonRoundsSwitch, int wonRoundsNoSwitch) {
        this.wonRoundsSwitch = wonRoundsSwitch;
        this.wonRoundsNoSwitch = wonRoundsNoSwitch;
    }

    public int getWonRoundsSwitch() {
        return wonRoundsSwitch;
    }

    public int getWonRoundsNoSwitch() {
        return wonRoundsNoSwitch;
    }
}