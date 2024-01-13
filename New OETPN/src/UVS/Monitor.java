package UVS;

import Components.*;
import DataObjects.DataString;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Monitor {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Monitor";
        pn.NetworkPort = 1081;

        DataString p0 = new DataString();
        p0.SetName("P0");
        p0.SetValue("signal");
        pn.PlaceList.add(p0);

        DataString in = new DataString();
        in.SetName("in");
        pn.PlaceList.add(in);

        DataString p1 = new DataString();
        p1.SetName("P1");
        pn.PlaceList.add(p1);

        // T0
        PetriTransition t0 = new PetriTransition(pn);
        t0.SetName("T0");
        t0.InputPlaceName.add("in");
        t0.InputPlaceName.add("P0");

        Condition T1Ct1 = new Condition(t0, "in", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t0, "P0", TransitionCondition.NotNull);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;
        grdT1.Activations.add(new Activation(t0, "in", TransitionOperation.Move, "P1"));
        grdT1.Activations.add(new Activation(t0, "P0", TransitionOperation.Move, "P0"));
        t0.GuardMappingList.add(grdT1);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        pn.Delay = 2000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
