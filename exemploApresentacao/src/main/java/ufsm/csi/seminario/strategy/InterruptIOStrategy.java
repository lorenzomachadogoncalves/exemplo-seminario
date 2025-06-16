package ufsm.csi.seminario.strategy;

import ufsm.csi.seminario.domain.ProcessState;
import ufsm.csi.seminario.domain.WaitingIOState;

public class InterruptIOStrategy implements InterruptStrategy {
    @Override
    public ProcessState decideInterrupt() {
        return new WaitingIOState(this);
    }
}
