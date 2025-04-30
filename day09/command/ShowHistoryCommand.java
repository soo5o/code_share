package test.day09.command;

import test.day09.history.DollHistoryManager;

public class ShowHistoryCommand implements Command {
    private DollHistoryManager historyManager;

    public ShowHistoryCommand(DollHistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public void execute(int choice) {

    }
}