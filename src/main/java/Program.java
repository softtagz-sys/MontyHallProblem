import domain.Door;
import domain.Round;
import domain.RoundResult;

public class Program {
    private static final int AMOUNT_OF_ROUNDS = 1000;

    public static void main(String[] args) {
        RoundResult result = playRounds();

        System.out.println("Rounds played with switch: " + AMOUNT_OF_ROUNDS);
        System.out.println("Amount of rounds won: " + result.wonRoundsSwitch());
        System.out.println("Amount of rounds lost: " + (AMOUNT_OF_ROUNDS - result.wonRoundsSwitch()));
        System.out.println("Percentage of rounds won: " + (double)result.wonRoundsSwitch() / AMOUNT_OF_ROUNDS * 100 + "%");

        System.out.println("\nRounds played without switch: " + AMOUNT_OF_ROUNDS);
        System.out.println("Amount of rounds won: " + result.wonRoundsNoSwitch());
        System.out.println("Amount of rounds lost: " + (AMOUNT_OF_ROUNDS - result.wonRoundsNoSwitch()));
        System.out.println("Percentage of rounds won: " + (double)result.wonRoundsNoSwitch() / AMOUNT_OF_ROUNDS * 100 + "%");
    }

    private static RoundResult playRounds() {
        int wonRoundsSwitch = 0;
        int wonRoundsNoSwitch = 0;

        for (int i = 0; i < AMOUNT_OF_ROUNDS; i++) {
            // Play a round where the player switches doors
            Round roundSwitch = new Round();
            Door[] doorsSwitch = roundSwitch.getDoors();

            int initialChoiceSwitch = chooseRandomDoor(doorsSwitch);
            removeNonPrizeDoor(doorsSwitch);
            switchDoor(doorsSwitch, initialChoiceSwitch);

            if (checkWin(doorsSwitch)) {
                roundSwitch.setWon(true);
                wonRoundsSwitch++;
            }

            // Play a round where the player does not switch doors
            Round roundNoSwitch = new Round();
            Door[] doorsNoSwitch = roundNoSwitch.getDoors();

            int initialChoiceNoSwitch = chooseRandomDoor(doorsNoSwitch);
            removeNonPrizeDoor(doorsNoSwitch);

            if (checkWin(doorsNoSwitch)) {
                roundNoSwitch.setWon(true);
                wonRoundsNoSwitch++;
            }
        }

        return new RoundResult(wonRoundsSwitch, wonRoundsNoSwitch);
    }

    private static int chooseRandomDoor(Door[] doors) {
        int randomChoice = (int)Math.floor(Math.random() * (2 + 1));
        doors[randomChoice].setChosen(true);
        return randomChoice;
    }

    private static void removeNonPrizeDoor(Door[] doors) {
        for (Door door : doors) {
            if (!door.isChosen() && !door.isHasPrize()) {
                door.setRemoved(true);
            }
        }
    }

    private static void switchDoor(Door[] doors, int initialChoice) {
        for (Door door : doors) {
            door.setChosen(false);
        }

        for (Door door : doors) {
            if (door != doors[initialChoice] && !door.isRemoved()) {
                door.setChosen(true);
                break;
            }
        }
    }

    private static boolean checkWin(Door[] doors) {
        for (Door door : doors) {
            if (door.isChosen() && door.isHasPrize()) {
                return true;
            }
        }
        return false;
    }
}