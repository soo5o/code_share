package test.day09.command;

import test.day09.queue.DollQueueManager;

public class ShowRankingCommand implements Command {
    private DollQueueManager queueManager;

    public ShowRankingCommand(DollQueueManager queueManager) {
        this.queueManager = queueManager;
    }

    @Override
    public void execute(int choice) {

    }
}