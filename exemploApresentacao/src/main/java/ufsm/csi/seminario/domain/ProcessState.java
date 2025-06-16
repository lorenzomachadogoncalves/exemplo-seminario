package ufsm.csi.seminario.domain;

public interface ProcessState {

    ProcessState prepare();
    ProcessState execute();
    ProcessState terminate();
    ProcessState interrupt();
    ProcessState abort();
}
