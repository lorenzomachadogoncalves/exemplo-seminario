package ufsm.csi.seminario.domain;

import ufsm.csi.seminario.strategy.InterruptStrategy;

public class WaitingIOState implements ProcessState {

    InterruptStrategy interruptStrategy;

    public WaitingIOState(InterruptStrategy interruptStrategy) {
        this.interruptStrategy = interruptStrategy;
    }

    @Override
    public ProcessState prepare() {
        return new ReadyState(interruptStrategy);
    }

    @Override
    public ProcessState execute() {
        return new RunningState(interruptStrategy);
    }

    @Override
    public ProcessState terminate() {
        return new TerminatedState();
    }

    @Override
    public ProcessState interrupt() {
        return new ReadyState(interruptStrategy);
    }

    @Override
    public ProcessState abort() {
        throw new UnsupportedOperationException("Processo abortado.");
    }
}
