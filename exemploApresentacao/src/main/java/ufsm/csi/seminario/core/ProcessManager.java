package ufsm.csi.seminario.core;

import ufsm.csi.seminario.domain.NewState;
import ufsm.csi.seminario.domain.ProcessState;
import ufsm.csi.seminario.enums.ManagerType;
import ufsm.csi.seminario.strategy.GenericInterruptStrategy;
import ufsm.csi.seminario.strategy.InterruptIOStrategy;
import ufsm.csi.seminario.strategy.InterruptStrategy;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class ProcessManager {

    private ProcessState currentState;
    private final InterruptStrategy interruptStrategy;
    private final List<ProcessState> state = new ArrayList<>();
    private List<Instant> timeStamps = new ArrayList<>();
    private final ManagerType managerType;

    public ProcessManager(ManagerType managerType) {
        this.managerType = managerType;
        Instant time = Instant.now();
        timeStamps.add(time);
        interruptStrategy = this.interruptStrategy();
        currentState = new NewState(interruptStrategy);
        this.state.add(currentState);
    }

    public void givePermission() {
        Instant time = Instant.now();
        timeStamps.add(time);
        this.currentState = currentState.prepare();
    }

    public void execute() {
        Instant time = Instant.now();
        timeStamps.add(time);
        this.currentState = currentState.execute();
    }

    public void interrupt() {
        Instant time = Instant.now();
        timeStamps.add(time);
        this.currentState = currentState.interrupt();
    }

    public void kill() {
        Instant time = Instant.now();
        timeStamps.add(time);
        this.currentState = currentState.terminate();
    }

    public void abort() {
        Instant time = Instant.now();
        timeStamps.add(time);
        this.currentState = currentState.abort();
    }

    public InterruptStrategy interruptStrategy() {
        return managerType == ManagerType.IO_MANAGER ? new InterruptIOStrategy() : new GenericInterruptStrategy();
    }

    public ProcessState getCurrentState() {
        return currentState;
    }

    public List<ProcessState> getState() {
        return state;
    }

    public List<Instant> getTimeStamps() {
        return timeStamps;
    }

    public ManagerType getManagerType() {
        return managerType;
    }
}
