package ufsm.csi.seminario.domain;

public class TerminatedState implements ProcessState {


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
        return this;
    }

    @Override
    public ProcessState interrupt() {
        return this;
    }

    @Override
    public ProcessState abort() {
        return this;
    }
}
