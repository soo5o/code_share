package test.day09.command;

import test.day09.stack.DollStackManager;

public class ShowStackCommand implements Command {
    private DollStackManager stackManager;

    public ShowStackCommand(DollStackManager stackManager) {
        this.stackManager = stackManager;
    }

    @Override
    public void execute(int choice) {

    }
}
