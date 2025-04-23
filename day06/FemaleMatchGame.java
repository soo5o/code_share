package day06;

public class FemaleMatchGame extends MatchGame {

    FemaleMatchGame(Celebrity[] celebrities) {
        this.candidates = new Celebrity[celebrities.length];
        for (int i = 0; i < celebrities.length; i++) {
            this.candidates[i] = celebrities[i];
        }
    }

    @Override
    public void initializeCandidates() {
        Celebrity[] newCandidates = new Celebrity[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            newCandidates[i] = candidates[i];
        }
        this.candidates = newCandidates;
    }

    @Override
    public Celebrity playGame() {
        return super.playGame();
    }

    @Override
    public void printCandidates() {
        System.out.printf("\n[여자 연예인 월드컵 참가자 명단]\n");
        super.printCandidates();
    }

    @Override
    public void shuffle() {
        System.out.println();
        System.out.println("[셔플 된 여자 연예인 참가자 명단]");
        super.shuffle();
    }
}
