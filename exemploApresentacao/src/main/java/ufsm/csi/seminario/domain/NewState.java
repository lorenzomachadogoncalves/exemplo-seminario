package ufsm.csi.seminario.domain;

import ufsm.csi.seminario.strategy.InterruptStrategy;

public class NewState implements ProcessState {

    private InterruptStrategy interruptStrategy;

    public NewState(InterruptStrategy interruptStrategy) {
        this.interruptStrategy = interruptStrategy;
    }

    @Override
    public ProcessState prepare() {
        return new ReadyState(interruptStrategy);
    }

    @Override
    public ProcessState execute() {
        throw new UnsupportedOperationException("Processo sem permissão de execução.");
    }

    @Override
    public ProcessState terminate() {
        throw new UnsupportedOperationException("Processo sem permissão de execução.");
    }

    @Override
    public ProcessState interrupt() {
        throw new UnsupportedOperationException("Processo sem permissão de execução.");
    }

    @Override
    public ProcessState abort() {
        throw new UnsupportedOperationException("Processo abortado.");
    }
}
