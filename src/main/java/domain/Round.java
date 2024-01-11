package domain;

public class Round {

    private Door[] doors;
    private boolean isWon = false;

    public Round() {
        setupGame();
    }

    private void setupGame(){
        doors = new Door[3];

        for (int i = 0; i < 3; i++) {
            doors[i] = new Door(i);
        }

        int randomPrize = (int)Math.floor(Math.random() * (2 + 1));
        doors[randomPrize].setHasPrize(true);
    }

    public Door[] getDoors() {
        return doors;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }
}