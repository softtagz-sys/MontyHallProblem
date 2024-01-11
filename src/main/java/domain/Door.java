package domain;

public class Door {
    private int id;
    private boolean hasPrize;
    private boolean isChosen;
    private boolean isRemoved;

    public Door(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isHasPrize() {
        return hasPrize;
    }

    public void setHasPrize(boolean hasPrize) {
        this.hasPrize = hasPrize;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
    }

    public boolean isRemoved() {
        return isRemoved;
    }
    public void setRemoved(boolean removed) {
        isRemoved = removed;
    }
}
