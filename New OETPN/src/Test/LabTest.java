package Test;

import Components.*;
import DataObjects.DataFloat;
import DataObjects.DataSubPetriNet;
import DataObjects.DataTransfer;
import DataOnly.SubPetri;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

import java.util.ArrayList;

public class LabTest {
    public static PetriNet PIDController() {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Petri Client";
        pn.NetworkPort = 1080;

        //  Places
        DataFloat p0 = new DataFloat();
        p0.SetName("P0");
        p0.SetValue(1.0f);
        pn.PlaceList.add(p0);

        DataFloat p1 = new DataFloat();
        p1.SetName("P1");
        pn.PlaceList.add(p1);

        DataFloat p2 = new DataFloat();
        p2.SetName("P2");
        pn.PlaceList.add(p2);

        DataFloat p3 = new DataFloat();
        p3.SetName("P3");
        pn.PlaceList.add(p3);

        DataFloat p4 = new DataFloat();
        p4.SetName("P4");
        pn.PlaceList.add(p4);

        DataFloat p5 = new DataFloat();
        p5.SetName("P5");
        pn.PlaceList.add(p5);

        DataFloat p6 = new DataFloat();
        p6.SetName("P6");
        pn.PlaceList.add(p6);

        DataFloat p7 = new DataFloat();
        p7.SetName("P7");
        p7.SetValue(1.0f);
        pn.PlaceList.add(p7);

        DataFloat p8 = new DataFloat();
        p8.SetName("P8");
        pn.PlaceList.add(p8);

        DataFloat p9 = new DataFloat();
        p9.SetName("P9");
        pn.PlaceList.add(p9);

        DataFloat p10 = new DataFloat();
        p10.SetName("P10");
        pn.PlaceList.add(p10);

        DataFloat p11 = new DataFloat();
        p11.SetName("P11");
        pn.PlaceList.add(p11);

        DataFloat p12 = new DataFloat();
        p12.SetName("P12");
        p12.SetValue(1.0f);
        pn.PlaceList.add(p12);

        DataFloat p13 = new DataFloat();
        p13.SetName("P13");
        p13.SetValue(1.0f);
        pn.PlaceList.add(p13);

        // Constant values
        DataFloat subConstantValue1 = new DataFloat();
        subConstantValue1.SetName("subConstantValue1");
        subConstantValue1.SetValue(0.8f);
        pn.ConstantPlaceList.add(subConstantValue1);

        DataFloat subConstantValue2 = new DataFloat();
        subConstantValue2.SetName("subConstantValue2");
        subConstantValue2.SetValue(0.2f);
        pn.ConstantPlaceList.add(subConstantValue2);

        DataFloat subConstantValue3 = new DataFloat();
        subConstantValue3.SetName("subConstantValue3");
        subConstantValue3.SetValue(0.7f);
        pn.ConstantPlaceList.add(subConstantValue3);

        DataFloat subConstantValue4 = new DataFloat();
        subConstantValue4.SetName("subConstantValue4");
        subConstantValue4.SetValue(0.3f);
        pn.ConstantPlaceList.add(subConstantValue4);
        //  T0
        PetriTransition t0 = new PetriTransition(pn);
        t0.TransitionName = "T0";
        t0.InputPlaceName.add("P0");

        Condition T0Ct1 = new Condition(t0, "P0", TransitionCondition.NotNull);

        GuardMapping grdT0 = new GuardMapping();
        grdT0.condition = T0Ct1;

        grdT0.Activations.add(new Activation(t0, "P0", TransitionOperation.Move, "P1"));
        t0.GuardMappingList.add(grdT0);

        t0.Delay = 0;
        pn.Transitions.add(t0);

        //  T1
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "T1";
        t1.InputPlaceName.add("P1");
        t1.InputPlaceName.add("P2");

        Condition T1Ct1 = new Condition(t1, "P1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "P2", TransitionCondition.NotNull);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;

        grdT1.Activations.add(new Activation(t1, "P1", TransitionOperation.Move, "P3"));
        grdT1.Activations.add(new Activation(t1, "P2", TransitionOperation.Move, "P3"));
        t1.GuardMappingList.add(grdT1);

        t1.Delay = 0;
        pn.Transitions.add(t1);

        //  T2
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "T2";
        t2.InputPlaceName.add("P3");
        t2.InputPlaceName.add("P4");

        Condition T2Ct1 = new Condition(t2, "P3", TransitionCondition.NotNull);
        Condition T2Ct2 = new Condition(t2, "P4", TransitionCondition.NotNull);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;

        grdT2.Activations.add(new Activation(t2, "P3", TransitionOperation.Move, "P5"));
        grdT2.Activations.add(new Activation(t2, "P4", TransitionOperation.Move, "P6"));
        t2.GuardMappingList.add(grdT2);

        t2.Delay = 0;
        pn.Transitions.add(t2);

        //  T3
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "T3";
        t3.InputPlaceName.add("P5");
        t3.InputPlaceName.add("P14");

        Condition T3Ct1 = new Condition(t3, "P5", TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t3, "P14", TransitionCondition.NotNull);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("P5");
        list1.add("subConstantValue1");

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("P14");
        list2.add("subConstantValue2");

        grdT3.Activations.add(new Activation(t3, list1, TransitionOperation.Prod, "P8"));
        grdT3.Activations.add(new Activation(t3, list2, TransitionOperation.Prod, "P8"));
        t3.GuardMappingList.add(grdT3);

        t3.Delay = 0;
        pn.Transitions.add(t3);

        //  T4
        PetriTransition t4 = new PetriTransition(pn);
        t4.TransitionName = "T4";
        t4.InputPlaceName.add("P6");

        Condition T4Ct1 = new Condition(t4, "P6", TransitionCondition.NotNull);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;

        grdT4.Activations.add(new Activation(t4, "P6", TransitionOperation.Move, "P7"));
        grdT4.Activations.add(new Activation(t4, "P6", TransitionOperation.Move, "P12"));
        t4.GuardMappingList.add(grdT4);

        t4.Delay = 1;
        pn.Transitions.add(t4);

        //  T8
        PetriTransition t8 = new PetriTransition(pn);
        t8.TransitionName = "T8";
        t8.InputPlaceName.add("P12");

        Condition T8Ct1 = new Condition(t8, "P12", TransitionCondition.NotNull);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;

        grdT8.Activations.add(new Activation(t8, "P12", TransitionOperation.Move, "P13"));
        t8.GuardMappingList.add(grdT8);

        t8.Delay = 1;
        pn.Transitions.add(t8);

        //  T9
        PetriTransition t9 = new PetriTransition(pn);
        t9.TransitionName = "T9";
        t9.InputPlaceName.add("P7");
        t9.InputPlaceName.add("P13");

        Condition T9Ct1 = new Condition(t9, "P7", TransitionCondition.NotNull);
        Condition T9Ct2 = new Condition(t9, "P13", TransitionCondition.NotNull);
        T9Ct1.SetNextCondition(LogicConnector.AND, T9Ct2);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition = T9Ct1;

        ArrayList<String> list3 = new ArrayList<String>();
        list1.add("P7");
        list1.add("subConstantValue1");

        ArrayList<String> list4 = new ArrayList<String>();
        list2.add("P13");
        list2.add("subConstantValue2");

        grdT9.Activations.add(new Activation(t9, list1, TransitionOperation.Prod, "P14"));
        grdT9.Activations.add(new Activation(t9, list2, TransitionOperation.Prod, "P14"));
        t9.GuardMappingList.add(grdT9);

        t9.Delay = 0;
        pn.Transitions.add(t9);

        //  T5
        PetriTransition t5 = new PetriTransition(pn);
        t5.TransitionName = "T5";
        t5.InputPlaceName.add("P8");
        t5.InputPlaceName.add("P11");

        Condition T5Ct1 = new Condition(t5, "P8", TransitionCondition.NotNull);
        Condition T5Ct2 = new Condition(t5, "P11", TransitionCondition.NotNull);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition = T5Ct1;

        ArrayList<String> list5 = new ArrayList<String>();
        list1.add("P8");
        list1.add("subConstantValue3");

        ArrayList<String> list6 = new ArrayList<String>();
        list2.add("P11");
        list2.add("subConstantValue4");

        grdT5.Activations.add(new Activation(t5, list1, TransitionOperation.Prod, "P9"));
        grdT5.Activations.add(new Activation(t5, list2, TransitionOperation.Prod, "P10"));
        t5.GuardMappingList.add(grdT5);

        t5.Delay = 0;
        pn.Transitions.add(t5);

        //  T7
        PetriTransition t7 = new PetriTransition(pn);
        t7.TransitionName = "T7";
        t7.InputPlaceName.add("P7");

        Condition T7Ct1 = new Condition(t7, "P9", TransitionCondition.NotNull);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition = T7Ct1;

        grdT7.Activations.add(new Activation(t7, "P9", TransitionOperation.SendOverNetwork, "P6"));
        t7.GuardMappingList.add(grdT7);

        t7.Delay = 0;
        pn.Transitions.add(t7);

        //  T6
        PetriTransition t6 = new PetriTransition(pn);
        t6.TransitionName = "T6";
        t6.InputPlaceName.add("P10");

        Condition T6Ct1 = new Condition(t6, "P10", TransitionCondition.NotNull);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;

        grdT6.Activations.add(new Activation(t6, "P10", TransitionOperation.Move, "P11"));
        grdT6.Activations.add(new Activation(t6, "P10", TransitionOperation.Move, "P1"));

        t6.GuardMappingList.add(grdT6);

        t6.Delay = 1;
        pn.Transitions.add(t6);

        pn.Delay = 3000;
        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);

        return pn;
    }

    public static PetriNet PN2 () {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "PN2";
        pn.NetworkPort = 1090;

        // ------------------------------------------------------------------------
        DataFloat constValue = new DataFloat();
        constValue.SetName("constValue");
        constValue.SetValue(1.0f);
        pn.ConstantPlaceList.add(constValue);

        DataFloat p21 = new DataFloat();
        p21.SetName("p21");
        p21.SetValue(1.0f);
        pn.PlaceList.add(p21);

        DataSubPetriNet p22 = new DataSubPetriNet();
        p22.SetName("p22");
        pn.PlaceList.add(p22);

        DataSubPetriNet p23 = new DataSubPetriNet();
        p23.SetName("p23");
        pn.PlaceList.add(p23);

        DataSubPetriNet p24 = new DataSubPetriNet();
        p24.SetName("p24");
        pn.PlaceList.add(p24);

        DataFloat p25 = new DataFloat();
        p25.SetName("p25");
        pn.PlaceList.add(p25);



        // T21 ------------------------------------------------
        PetriTransition t21 = new PetriTransition(pn);
        t21.TransitionName = "t21";
        t21.InputPlaceName.add("p21");
        t21.InputPlaceName.add("p22");

        Condition T21Ct1 = new Condition(t21, "p21", TransitionCondition.NotNull);
        Condition T21Ct2 = new Condition(t21, "p22", TransitionCondition.NotNull);
        T21Ct1.SetNextCondition(LogicConnector.AND, T21Ct2);

        GuardMapping grdT21 = new GuardMapping();
        grdT21.condition = T21Ct1;

        grdT21.Activations.add(new Activation(t21, "p22", TransitionOperation.Move, "p23"));

        t21.GuardMappingList.add(grdT21);
        t21.Delay = 0;
        pn.Transitions.add(t21);

        // T22 ------------------------------------------------
        PetriTransition t22 = new PetriTransition(pn);
        t22.TransitionName = "t22";
        t22.InputPlaceName.add("p23");

        Condition T22Ct1 = new Condition(t22, "p23", TransitionCondition.NotNull);

        GuardMapping grdT22 = new GuardMapping();
        grdT22.condition = T22Ct1;

        grdT22.Activations.add(new Activation(t22, "p23", TransitionOperation.Move, "p24"));
        grdT22.Activations.add(new Activation(t22, "p24", TransitionOperation.ActivateSubPetri, ""));
        grdT22.Activations.add(new Activation(t22, "constValue", TransitionOperation.Move, "p25"));

        t22.GuardMappingList.add(grdT22);
        t22.Delay = 0;
        pn.Transitions.add(t22);

        // T23 ------------------------------------------------
        PetriTransition t23 = new PetriTransition(pn);
        t23.TransitionName = "t23";
        t23.InputPlaceName.add("p25");

        Condition T23Ct1 = new Condition(t23, "p25", TransitionCondition.NotNull);

        GuardMapping grdT23 = new GuardMapping();
        grdT23.condition = T23Ct1;

        grdT23.Activations.add(new Activation(t23, "p25", TransitionOperation.Move, "p21"));

        t23.GuardMappingList.add(grdT23);
        t23.Delay = 0;
        pn.Transitions.add(t23);

        System.out.println("Exp2 started \n ------------------------------");
        pn.Delay = 3000;

        return pn;
    }

    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "PN1";
        pn.NetworkPort = 1080;

        // ------------------------------------------------------------------------

        DataSubPetriNet SP = new DataSubPetriNet();
        SP.SetName("PN2");
        SubPetri pn2 = new SubPetri(PN2());
        SP.SetValue(pn2);
        pn.ConstantPlaceList.add(SP);

        DataSubPetriNet SP2 = new DataSubPetriNet();
        SP2.SetName("PIDController");
        SubPetri subPetriNet = new SubPetri(PIDController());
        SP2.SetValue(subPetriNet);
        pn.ConstantPlaceList.add(SP2);

        DataFloat p1 = new DataFloat();
        p1.SetName("p1");
        p1.SetValue(2.0f);
        pn.PlaceList.add(p1);

        DataFloat p2 = new DataFloat();
        p2.SetName("p2");
        p2.SetValue(1.0f); //testing
        pn.PlaceList.add(p2);

        DataSubPetriNet p3 = new DataSubPetriNet();
        p3.SetName("p3");
        pn.PlaceList.add(p3);

        DataTransfer p3Send = new DataTransfer();
        p3Send.SetName("p3Send");
        p3Send.Value = new TransferOperation("localhost", "1090", "p22");
        pn.PlaceList.add(p3Send);

        DataFloat p4 = new DataFloat();
        p4.SetName("p4");
        pn.PlaceList.add(p4);

        DataFloat p5 = new DataFloat();
        p5.SetName("p5");
        pn.PlaceList.add(p5);

        DataTransfer p6 = new DataTransfer();
        p6.SetName("p6");
        pn.PlaceList.add(p6);

        DataFloat p7 = new DataFloat();
        p7.SetName("p7");
        pn.PlaceList.add(p7);

        // Constant Values
        DataFloat constantVal2 = new DataFloat();
        constantVal2.SetName("constantVal2");
        constantVal2.SetValue(2.0f);
        pn.ConstantPlaceList.add(constantVal2);

        // T1 ------------------------------------------------
        PetriTransition t1 = new PetriTransition(pn);
        t1.TransitionName = "t1";
        t1.InputPlaceName.add("p1");
        t1.InputPlaceName.add("p2");

        Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t1, "p2", TransitionCondition.LessThan, "constantVal2");
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition = T1Ct1;

        grdT1.Activations.add(new Activation(t1, "PN3", TransitionOperation.Copy, "p3"));
        grdT1.Activations.add(new Activation(t1, "p1", TransitionOperation.Move, "p4"));
        grdT1.Activations.add(new Activation(t1, "p2", TransitionOperation.Move, "p3-p31"));

        // Second subGuard
        Condition T1Ct3 = new Condition(t1, "p1", TransitionCondition.NotNull);
        Condition T1Ct4 = new Condition(t1, "p2", TransitionCondition.MoreThanOrEqual, "constantVal2");
        T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);

        GuardMapping grd12 = new GuardMapping();
        grd12.condition = T1Ct3;

        // P3 is another subPetriNet
        grd12.Activations.add(new Activation(t1, "anotherSubPetriNet", TransitionOperation.Copy, "p3"));

        t1.GuardMappingList.add(grdT1);
        t1.GuardMappingList.add(grd12);  // Second subGuard to t1
        t1.Delay = 0;
        pn.Transitions.add(t1);

        // T3 Send ------------------------------------------------
        PetriTransition t3Send = new PetriTransition(pn);
        t3Send.TransitionName = "t3Send";
        t3Send.InputPlaceName.add("p3");

        Condition T3SendCt1 = new Condition(t3Send, "p3", TransitionCondition.NotNull);

        GuardMapping grdT3Send = new GuardMapping();
        grdT3Send.condition = T3SendCt1;

        grdT3Send.Activations.add(new Activation(t3Send, "p3", TransitionOperation.Move, "p3Send"));
        grdT3Send.Activations.add(new Activation(t3Send, "p3", TransitionOperation.SendOverNetwork, "p22"));

        t3Send.GuardMappingList.add(grdT3Send);
        t3Send.Delay = 0;
        pn.Transitions.add(t3Send);

        // T2 ------------------------------------------------
        PetriTransition t2 = new PetriTransition(pn);
        t2.TransitionName = "t2";
        t2.InputPlaceName.add("p5");
        t2.InputPlaceName.add("p6");

        Condition T2Ct1 = new Condition(t2, "p5", TransitionCondition.NotNull);
        Condition T2Ct2 = new Condition(t2, "p6", TransitionCondition.NotNull);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;

        grdT2.Activations.add(new Activation(t2, "p5", TransitionOperation.Move, "p1"));
        grdT2.Activations.add(new Activation(t2, "p6", TransitionOperation.Move, "p7"));

        t2.GuardMappingList.add(grdT2);
        t2.Delay = 0;
        pn.Transitions.add(t2);

        // T3 ------------------------------------------------
        PetriTransition t3 = new PetriTransition(pn);
        t3.TransitionName = "t3";
        t3.InputPlaceName.add("p4");

        Condition T3Ct1 = new Condition(t3, "p4", TransitionCondition.NotNull);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition = T3Ct1;

        grdT3.Activations.add(new Activation(t3, "p4", TransitionOperation.Move, "p5"));

        t3.GuardMappingList.add(grdT3);
        t3.Delay = 0;
        pn.Transitions.add(t3);

        System.out.println("Exp3 part 1 started \n ------------------------------");
        pn.Delay = 5000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
