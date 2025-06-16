package ufsm.csi.seminario.domain;

import ufsm.csi.seminario.strategy.InterruptStrategy;

public class ReadyState implements ProcessState {

    InterruptStrategy interruptStrategy;

    public ReadyState(InterruptStrategy interruptStrategy) {
        this.interruptStrategy = interruptStrategy;
    }

    @Override
    public ProcessState prepare() {
        return this;
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
        throw new UnsupportedOperationException("Processo não está em execução.");
    }

    @Override
    public ProcessState abort() {
        throw new UnsupportedOperationException("Processo abortado.");
    }
}
