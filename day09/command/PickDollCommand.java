package test.day09.command;

import test.day09.history.DollHistoryManager;
import test.day09.popularity.DollPopularityManager;
import test.day09.queue.DollQueueManager;
import test.day09.stack.DollStackManager;

public class PickDollCommand implements Command {
    private DollQueueManager queueManager;
    private DollStackManager stackManager;
    private DollHistoryManager historyManager;
    private DollPopularityManager popularityManager;

    public PickDollCommand(DollQueueManager queueManager, DollStackManager stackManager, DollHistoryManager historyManager, DollPopularityManager popularityManager) {
        this.queueManager = queueManager;
        this.stackManager = stackManager;
        this.historyManager = historyManager;
        this.popularityManager = popularityManager;
    }

    @Override
    public void execute(int choice) {

    }
}
