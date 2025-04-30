package test.day09.command;

import test.day09.history.DollHistoryManager;

public class ShowUniqueHistoryCommand implements Command {
    private DollHistoryManager historyManager;

    public ShowUniqueHistoryCommand(DollHistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public void execute(int choice) {

    }
}