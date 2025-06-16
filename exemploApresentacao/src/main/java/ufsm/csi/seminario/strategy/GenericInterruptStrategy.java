package ufsm.csi.seminario.strategy;

import ufsm.csi.seminario.domain.ProcessState;
import ufsm.csi.seminario.domain.ReadyState;

public class GenericInterruptStrategy implements InterruptStrategy {
    @Override
    public ProcessState decideInterrupt() {
        return new ReadyState(this);
    }
}
