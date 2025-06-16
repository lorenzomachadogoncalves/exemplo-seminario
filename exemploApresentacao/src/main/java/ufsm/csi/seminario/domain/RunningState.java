package ufsm.csi.seminario.domain;

import ufsm.csi.seminario.strategy.InterruptStrategy;

public class RunningState implements ProcessState {

    private final InterruptStrategy interruptStrategy;

    public RunningState(InterruptStrategy interruptStrategy) {
        this.interruptStrategy = interruptStrategy;
    }

    @Override
    public ProcessState prepare() {
        return this;
    }

    @Override
    public ProcessState execute() {
        return this;
    }

    @Override
    public ProcessState terminate() {
        return new TerminatedState();
    }

    @Override
    public ProcessState interrupt() {
        return interruptStrategy.decideInterrupt();
    }

    @Override
    public ProcessState abort() {
        throw new UnsupportedOperationException("Processo abortado.");
    }
}
