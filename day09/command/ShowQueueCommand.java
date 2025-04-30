package test.day09.command;

import test.day09.queue.DollQueueManager;

public class ShowQueueCommand implements Command {
    private DollQueueManager queueManager;

    public ShowQueueCommand(DollQueueManager queueManager) {
        this.queueManager = queueManager;
    }

    @Override
    public void execute(int choice) {

    }
}
