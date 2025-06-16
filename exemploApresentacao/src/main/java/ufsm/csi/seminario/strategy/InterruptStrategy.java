package ufsm.csi.seminario.strategy;

import ufsm.csi.seminario.domain.ProcessState;

public interface InterruptStrategy {
    ProcessState decideInterrupt();
}
