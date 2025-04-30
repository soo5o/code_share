package test.day09.command;

import test.day09.queue.DollQueueManager;
import test.day09.util.RandomCustomerProvider;

public class RegisterCustomerCommand implements Command {
    private DollQueueManager queueManager;

    public RegisterCustomerCommand(DollQueueManager queueManager) {
        this.queueManager = queueManager;
    }

    @Override
    public void execute(int choice) {
        String name = RandomCustomerProvider.getRandomCustomer();
        queueManager.registerCustomer(name);
    }
}
