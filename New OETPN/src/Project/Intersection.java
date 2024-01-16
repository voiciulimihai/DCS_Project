package Project;

import Components.*;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Intersection {
    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Intersection";
        pn.NetworkPort = 1080;

        DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString full = new DataString();
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);

        // LANE 1

        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost","1081","in1");
        pn.PlaceList.add(OP1);

        DataCar p_a1 = new DataCar();
        p_a1.SetName("p_a1");
        pn.PlaceList.add(p_a1);

        DataCarQueue p_qa12 = new DataCarQueue();
        p_qa12.Value.Size =3;
        p_qa12.SetName("p_qa1");
        pn.PlaceList.add(p_qa12);

        DataString p_tl1 = new DataString();
        p_tl1.SetName("p_tl1");
        pn.PlaceList.add(p_tl1);


        DataCar p_qa11 = new DataCar();
        p_qa11.SetName("p_qa11");
        pn.PlaceList.add(p_qa11);

        //LANE 2

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost","1081","in2");
        pn.PlaceList.add(OP2);

        DataCar p_a2 = new DataCar();
        p_a2.SetName("p_a2");
        pn.PlaceList.add(p_a2);

        DataCarQueue p_qa22 = new DataCarQueue();
        p_qa22.Value.Size =3;
        p_qa22.SetName("p_qa22");
        pn.PlaceList.add(p_qa22);

        DataString p_tl2 = new DataString();
        p_tl2.SetName("p_tl2");
        pn.PlaceList.add(p_tl2);

        DataCar p_qa21 = new DataCar();
        p_qa21.SetName("p_qa21");
        pn.PlaceList.add(p_qa21);


        //LANE 3

        DataTransfer OP3 = new DataTransfer();
        OP3.SetName("OP3");
        OP3.Value = new TransferOperation("localhost","1081","in3");
        pn.PlaceList.add(OP3);

        DataCar p_a3 = new DataCar();
        p_a3.SetName("p_a3");
        pn.PlaceList.add(p_a3);

        DataCarQueue p_qa32= new DataCarQueue();
        p_qa32.Value.Size =3;
        p_qa32.SetName("p_qa32");
        pn.PlaceList.add(p_qa32);

        DataString p_tl3 = new DataString();
        p_tl3.SetName("p_tl3");
        pn.PlaceList.add(p_tl3);

        DataCar p_qa31 = new DataCar();
        p_qa31.SetName("p_qa31");
        pn.PlaceList.add(p_qa31);

        //LANE 4

        DataTransfer OP4 = new DataTransfer();
        OP4.SetName("OP4");
        OP4.Value = new TransferOperation("localhost","1081","in4");
        pn.PlaceList.add(OP4);

        DataCar p_a4 = new DataCar();
        p_a4.SetName("p_a4");
        pn.PlaceList.add(p_a4);

        DataCarQueue p_qa42 = new DataCarQueue();
        p_qa42.Value.Size =3;
        p_qa42.SetName("p_qa42");
        pn.PlaceList.add(p_qa42);

        DataCar p_qa41 = new DataCar();
        p_qa41.SetName("p_qa41");
        pn.PlaceList.add(p_qa41);

        DataString p_tl4 = new DataString();
        p_tl4.SetName("p_tl4");
        pn.PlaceList.add(p_tl4);

        // EXIT LANE 1

        DataCarQueue p_01 = new DataCarQueue();
        p_01.Value.Size = 3;
        p_01.SetName("p_01");
        pn.PlaceList.add(p_01);

        DataCar p_qo11 = new DataCar();
        p_qo11.SetName("p_qo11");
        pn.PlaceList.add(p_qo11);

        // EXIT LANE 2

        DataCarQueue p_02 = new DataCarQueue();
        p_02.Value.Size = 3;
        p_02.SetName("p_02");
        pn.PlaceList.add(p_02);

        DataCar p_qo21 = new DataCar();
        p_qo21.SetName("p_qo21");
        pn.PlaceList.add(p_qo21);

        DataTransfer p_02e = new DataTransfer();
        p_02e.SetName("p_02e");
        p_02e.Value = new TransferOperation("localhost","1081", "P1");
        pn.PlaceList.add(p_02e);

        // EXIT LANE 3

        DataCarQueue p_03 = new DataCarQueue();
        p_03.Value.Size = 3;
        p_03.SetName("p_03");
        pn.PlaceList.add(p_03);

        DataCar p_qo31 = new DataCar();
        p_qo31.SetName("p_qo31");
        pn.PlaceList.add(p_qo31);

        // EXIT LANE 4

        DataCarQueue p_04 = new DataCarQueue();
        p_04.Value.Size = 3;
        p_04.SetName("p_04");
        pn.PlaceList.add(p_04);

        DataCar p_qo41 = new DataCar();
        p_qo41.SetName("p_qo41");
        pn.PlaceList.add(p_qo41);

        // Intersection Lane

        DataCarQueue p_i = new DataCarQueue();
        p_i.Value.Size = 3;
        p_i.SetName("p_i");
        pn.PlaceList.add(p_i);

        //  Transitions for P_a1
        // Ta13

        PetriTransition t_a13 = new PetriTransition(pn);
        t_a13.TransitionName = "t_a13";
        t_a13.InputPlaceName.add("p_a1");
        t_a13.InputPlaceName.add("p_qa12");

        Condition T1Ct1 = new Condition(t_a13,"p_a1",TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t_a13,"p_qa12",TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition T1Ct3 = new Condition(t_a13, "p_a1", TransitionCondition.NotNull);
        Condition T1Ct4 = new Condition(t_a13, "p_qa12", TransitionCondition.CanNotAddCars);
        T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t_a13, "p_a1", TransitionOperation.AddElement, "p_qa12"));
        t_a13.GuardMappingList.add(grdT1);

        GuardMapping grd2T1 = new GuardMapping();
        grd2T1.condition= T1Ct3;
        grd2T1.Activations.add(new Activation(t_a13, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grd2T1.Activations.add(new Activation(t_a13, "p_a1", TransitionOperation.Move, "p_qa12"));
        t_a13.GuardMappingList.add(grd2T1);

        t_a13.Delay = 0;
        pn.Transitions.add(t_a13);

        // T_a12

        PetriTransition t_a12 = new PetriTransition(pn);
        t_a12.TransitionName = "t_a12";
        t_a12.InputPlaceName.add("p_qa12");
        t_a12.InputPlaceName.add("p_tl1");

        Condition T2Ct1 = new Condition(t_a12, "p_tl1", TransitionCondition.Equal,"green");
        Condition T2Ct2 = new Condition(t_a12, "p_qa12", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t_a12, "p_qa12", TransitionOperation.PopElementWithoutTarget, "p_qa11"));
        grdT2.Activations.add(new Activation(t_a12, "p_tl1", TransitionOperation.Move, "p_tl1"));
        t_a12.GuardMappingList.add(grdT2);

        t_a12.Delay = 0;
        pn.Transitions.add(t_a12);

        // Transitions for P_a2
        // T_a23

        PetriTransition t_a23 = new PetriTransition(pn);
        t_a23.TransitionName = "t_a23";
        t_a23.InputPlaceName.add("p_a2");
        t_a23.InputPlaceName.add("p_qa22");

        Condition T3Ct1 = new Condition(t_a23,"p_a2",TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t_a23,"p_qa22",TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition T3Ct3 = new Condition(t_a23, "p_a2", TransitionCondition.NotNull);
        Condition T3Ct4 = new Condition(t_a23, "p_qa22", TransitionCondition.CanNotAddCars);
        T3Ct3.SetNextCondition(LogicConnector.AND, T3Ct4);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3Ct1;
        grdT3.Activations.add(new Activation(t_a23, "p_a2", TransitionOperation.AddElement, "p_qa22"));
        t_a23.GuardMappingList.add(grdT3);

        GuardMapping grd2T3 = new GuardMapping();
        grd2T3.condition= T3Ct3;
        grd2T3.Activations.add(new Activation(t_a23, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grd2T3.Activations.add(new Activation(t_a23, "p_a2", TransitionOperation.Move, "p_qa22"));
        t_a23.GuardMappingList.add(grd2T3);

        t_a23.Delay = 0;
        pn.Transitions.add(t_a23);

        // T_a22

        PetriTransition t_a22 = new PetriTransition(pn);
        t_a22.TransitionName = "t_a22";
        t_a22.InputPlaceName.add("p_qa22");
        t_a22.InputPlaceName.add("p_tl2");


        Condition T4Ct1 = new Condition(t_a22, "p_tl2", TransitionCondition.Equal,"green");
        Condition T4Ct2 = new Condition(t_a22, "p_qa22", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t_a22, "p_qa22", TransitionOperation.PopElementWithoutTarget, "p_qa21"));
        grdT4.Activations.add(new Activation(t_a22, "p_tl2", TransitionOperation.Move, "p_tl2"));
        t_a22.GuardMappingList.add(grdT4);

        t_a22.Delay = 0;
        pn.Transitions.add(t_a22);

        //  Transitions for P_a3
        // T_a33

        PetriTransition t_a33 = new PetriTransition(pn);
        t_a33.TransitionName = "t_a33";
        t_a33.InputPlaceName.add("p_a3");
        t_a33.InputPlaceName.add("p_qa32");

        Condition T5Ct1 = new Condition(t_a33,"p_a3",TransitionCondition.NotNull);
        Condition T5Ct2 = new Condition(t_a33,"p_qa32",TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        Condition T5Ct3 = new Condition(t_a33, "p_a3", TransitionCondition.NotNull);
        Condition T5Ct4 = new Condition(t_a33, "p_qa32", TransitionCondition.CanNotAddCars);
        T5Ct3.SetNextCondition(LogicConnector.AND, T5Ct4);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT5.Activations.add(new Activation(t_a33, "p_a3", TransitionOperation.AddElement, "p_qa32"));
        t_a33.GuardMappingList.add(grdT5);

        GuardMapping grd2T5 = new GuardMapping();
        grd2T5.condition= T5Ct3;
        grd2T5.Activations.add(new Activation(t_a33, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grd2T5.Activations.add(new Activation(t_a33, "p_a3", TransitionOperation.Move, "p_a3"));
        t_a33.GuardMappingList.add(grd2T5);

        t_a33.Delay = 0;
        pn.Transitions.add(t_a33);


        // T_a32

        PetriTransition t_a32 = new PetriTransition(pn);
        t_a32.TransitionName = "t_a32";
        t_a32.InputPlaceName.add("p_qa32");
        t_a32.InputPlaceName.add("p_tl3");


        Condition T6Ct1 = new Condition(t_a32, "p_tl3", TransitionCondition.Equal,"green");
        Condition T6Ct2 = new Condition(t_a32, "p_qa32", TransitionCondition.HaveCar);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t_a32, "p_qa32", TransitionOperation.PopElementWithoutTarget, "p_qa31"));
        grdT6.Activations.add(new Activation(t_a32, "p_tl3", TransitionOperation.Move, "p_tl3"));
        t_a32.GuardMappingList.add(grdT6);

        t_a32.Delay = 0;
        pn.Transitions.add(t_a32);

        //  Transitions for P_a4
        // T_a43
        PetriTransition t_a43 = new PetriTransition(pn);
        t_a43.TransitionName = "t_a43";
        t_a43.InputPlaceName.add("p_a4");
        t_a43.InputPlaceName.add("p_qa42");

        Condition T7Ct1 = new Condition(t_a43,"p_a4",TransitionCondition.NotNull);
        Condition T7Ct2 = new Condition(t_a43,"p_qa42",TransitionCondition.CanAddCars);
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        Condition T7Ct3 = new Condition(t_a43, "p_a4", TransitionCondition.NotNull);
        Condition T7Ct4 = new Condition(t_a43, "p_qa42", TransitionCondition.CanNotAddCars);
        T7Ct3.SetNextCondition(LogicConnector.AND, T7Ct4);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition= T7Ct1;
        grdT7.Activations.add(new Activation(t_a43, "p_a4", TransitionOperation.AddElement, "p_qa42"));
        t_a43.GuardMappingList.add(grdT7);

        GuardMapping grd2T7 = new GuardMapping();
        grd2T7.condition= T7Ct3;
        grd2T7.Activations.add(new Activation(t_a43, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grd2T7.Activations.add(new Activation(t_a43, "p_a4", TransitionOperation.Move, "p_a4"));
        t_a43.GuardMappingList.add(grd2T7);

        t_a43.Delay = 0;
        pn.Transitions.add(t_a43);

        //  T_a42

        PetriTransition t_a42 = new PetriTransition(pn);
        t_a42.TransitionName = "t_a42";
        t_a42.InputPlaceName.add("p_qa42");
        t_a42.InputPlaceName.add("p_tl4");


        Condition T8Ct1 = new Condition(t_a42, "p_tl4", TransitionCondition.Equal,"green");
        Condition T8Ct2 = new Condition(t_a42, "p_qa42", TransitionCondition.HaveCar);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;
        grdT8.Activations.add(new Activation(t_a42, "p_qa42", TransitionOperation.PopElementWithoutTarget, "p_qa41"));
        grdT8.Activations.add(new Activation(t_a42, "p_tl4", TransitionOperation.Move, "p_tl4"));
        t_a42.GuardMappingList.add(grdT8);

        t_a42.Delay = 0;
        pn.Transitions.add(t_a42);

        // T_o12

        PetriTransition t_o12 = new PetriTransition(pn);
        t_o12.TransitionName = "t_o12";
        t_o12.InputPlaceName.add("p_qo11");

        Condition T10Ct1 = new Condition(t_o12,"p_qo11",TransitionCondition.HaveCar);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;
        grdT10.Activations.add(new Activation(t_o12, "p_qo11", TransitionOperation.PopElementWithoutTarget, "p_o1"));
        t_o12.GuardMappingList.add(grdT10);

        t_o12.Delay = 0;
        pn.Transitions.add(t_o12);

        //  Exit transitions
        // T_o22

        PetriTransition t_o22 = new PetriTransition(pn);
        t_o22.TransitionName = "t_o22";
        t_o22.InputPlaceName.add("p_qo21");

        Condition T11Ct1 = new Condition(t_o22,"p_qo21",TransitionCondition.HaveCar);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;
        grdT11.Activations.add(new Activation(t_o22, "p_qo21", TransitionOperation.PopElementWithoutTarget, "p_o2"));
        t_o22.GuardMappingList.add(grdT11);

        t_o22.Delay = 0;
        pn.Transitions.add(t_o22);

        // T_o32

        PetriTransition t_o32 = new PetriTransition(pn);
        t_o32.TransitionName = "t_o32";
        t_o32.InputPlaceName.add("p_qo31");

        Condition T12Ct1 = new Condition(t_o32,"p_qo31",TransitionCondition.HaveCar);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;
        grdT12.Activations.add(new Activation(t_o32, "p_qo31", TransitionOperation.PopElementWithoutTarget, "p_o3"));
        t_o32.GuardMappingList.add(grdT12);

        t_o32.Delay = 0;
        pn.Transitions.add(t_o32);

        // T_o42
        PetriTransition t_o42 = new PetriTransition(pn);
        t_o42.TransitionName = "t_o42";
        t_o42.InputPlaceName.add("p_qo41");

        Condition T13Ct1 = new Condition(t_o42,"p_qo41",TransitionCondition.HaveCar);

        GuardMapping grdT13 = new GuardMapping();
        grdT13.condition = T13Ct1;
        grdT13.Activations.add(new Activation(t_o42, "p_qo41", TransitionOperation.PopElementWithoutTarget, "p_o4"));
        t_o42.GuardMappingList.add(grdT13);

        t_o42.Delay = 0;
        pn.Transitions.add(t_o42);

        // T_o23 -- exit intersection enter roundabout

        PetriTransition t_o23 = new PetriTransition(pn);
        t_o23.TransitionName = "t_o23";
        t_o23.InputPlaceName.add("p_o2");


        Condition T14Ct1 = new Condition(t_o23,"p_o2",TransitionCondition.NotNull);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;
        grdT14.Activations.add(new Activation(t_o23,"p_o2", TransitionOperation.SendOverNetwork,"p_o2e"));
        t_o23.GuardMappingList.add(grdT14);

        t_o23.Delay=0;
        pn.Transitions.add(t_o23);

        // Intersection entrance

        // T_a11
        PetriTransition t_a11 = new PetriTransition(pn);
        t_a11.TransitionName = "t_a11";
        t_a11.InputPlaceName.add("p_i");
        t_a11.InputPlaceName.add("p_qa11");

        Condition T15Ct1 = new Condition(t_a11,"p_qa11",TransitionCondition.NotNull);
        Condition T15Ct2 = new Condition(t_a11,"p_i",TransitionCondition.CanAddCars);
        T15Ct1.SetNextCondition(LogicConnector.AND, T15Ct2);

        GuardMapping grdT15 = new GuardMapping();
        grdT15.condition = T15Ct1;
        grdT15.Activations.add(new Activation(t_a11,"p_qa11",TransitionOperation.AddElement,"p_i"));
        t_a11.GuardMappingList.add(grdT15);

        t_a11.Delay=0;
        pn.Transitions.add(t_a11);

        //  T_a21
        PetriTransition t_a21 = new PetriTransition(pn);
        t_a21.TransitionName = "t_a21";
        t_a21.InputPlaceName.add("p_i");
        t_a21.InputPlaceName.add("p_qa21");

        Condition T16Ct1 = new Condition(t_a21,"p_qa21",TransitionCondition.NotNull);
        Condition T16Ct2 = new Condition(t_a21,"p_i",TransitionCondition.CanAddCars);
        T16Ct1.SetNextCondition(LogicConnector.AND, T16Ct2);

        GuardMapping grdT16 = new GuardMapping();
        grdT16.condition = T16Ct1;
        grdT16.Activations.add(new Activation(t_a21,"p_qa21",TransitionOperation.AddElement,"p_i"));
        t_a21.GuardMappingList.add(grdT16);

        t_a21.Delay=0;
        pn.Transitions.add(t_a21);


        //  T_a31
        PetriTransition t_a31 = new PetriTransition(pn);
        t_a31.TransitionName = "t_a31";
        t_a31.InputPlaceName.add("p_i");
        t_a31.InputPlaceName.add("p_qa31");

        Condition T17Ct1 = new Condition(t_a31,"p_qa31",TransitionCondition.NotNull);
        Condition T17Ct2 = new Condition(t_a31,"p_i",TransitionCondition.CanAddCars);
        T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

        GuardMapping grdT17 = new GuardMapping();
        grdT17.condition = T17Ct1;
        grdT17.Activations.add(new Activation(t_a31,"p_qa31", TransitionOperation.AddElement,"p_i"));
        t_a31.GuardMappingList.add(grdT17);

        t_a31.Delay=0;
        pn.Transitions.add(t_a31);

        //  T_a41
        PetriTransition t_a41 = new PetriTransition(pn);
        t_a41.TransitionName = "t_a41";
        t_a41.InputPlaceName.add("p_i");
        t_a41.InputPlaceName.add("p_qa41");

        Condition T18Ct1 = new Condition(t_a41,"p_qa41", TransitionCondition.NotNull);
        Condition T18Ct2 = new Condition(t_a41,"p_i",TransitionCondition.CanAddCars);
        T18Ct1.SetNextCondition(LogicConnector.AND, T18Ct2);

        GuardMapping grdT18 = new GuardMapping();
        grdT18.condition = T18Ct1;
        grdT18.Activations.add(new Activation(t_a41,"p_qa41",TransitionOperation.AddElement,"p_i"));
        t_a41.GuardMappingList.add(grdT18);

        t_a41.Delay=0;
        pn.Transitions.add(t_a41);

        //  Intersection exits
        //  T_o11
        PetriTransition t_o11=new PetriTransition(pn);
        t_o11.TransitionName="t_o11";
        t_o11.InputPlaceName.add("p_qo11");
        t_o11.InputPlaceName.add("p_i");

        Condition T19Ct1= new Condition(t_o11,"p_qo11",TransitionCondition.CanAddCars);
        Condition T19Ct2= new Condition(t_o11, "p_i", TransitionCondition.HaveCarForMe);
        T19Ct1.SetNextCondition(LogicConnector.AND,T19Ct2);

        GuardMapping grdT19= new GuardMapping();
        grdT19.condition=T19Ct1;
        grdT19.Activations.add(new Activation(t_o11, "p_i", TransitionOperation.PopElementWithTargetToQueue, "p_qo11"));
        t_o11.GuardMappingList.add(grdT19);

        t_o11.Delay = 0;
        pn.Transitions.add(t_o11);

        //  T_o21
        PetriTransition t_g2=new PetriTransition(pn);
        t_g2.TransitionName="t_o21";
        t_g2.InputPlaceName.add("p_qo21");
        t_g2.InputPlaceName.add("p_i");

        Condition T20Ct1= new Condition(t_g2,"p_qo21",TransitionCondition.CanAddCars);
        Condition T20Ct2= new Condition(t_g2, "p_i", TransitionCondition.HaveCarForMe);
        T20Ct1.SetNextCondition(LogicConnector.AND,T20Ct2);

        GuardMapping grdT20= new GuardMapping();
        grdT20.condition=T20Ct1;
        grdT20.Activations.add(new Activation(t_g2, "p_i", TransitionOperation.PopElementWithTargetToQueue, "p_qo21"));
        t_g2.GuardMappingList.add(grdT20);

        t_g2.Delay = 0;
        pn.Transitions.add(t_g2);

        //  T_o31
        PetriTransition t_o31=new PetriTransition(pn);
        t_o31.TransitionName="t_o31";
        t_o31.InputPlaceName.add("p_qo31");
        t_o31.InputPlaceName.add("p_i");

        Condition T21Ct1= new Condition(t_o31,"p_qo31",TransitionCondition.CanAddCars);
        Condition T21Ct2= new Condition(t_o31, "p_i", TransitionCondition.HaveCarForMe);
        T21Ct1.SetNextCondition(LogicConnector.AND,T21Ct2);

        GuardMapping grdT21= new GuardMapping();
        grdT21.condition=T21Ct1;
        grdT21.Activations.add(new Activation(t_o31, "p_i", TransitionOperation.PopElementWithTargetToQueue, "p_qo31"));
        t_o31.GuardMappingList.add(grdT21);

        t_o31.Delay = 0;
        pn.Transitions.add(t_o31);

        //  T_o41
        PetriTransition t_o41=new PetriTransition(pn);
        t_o41.TransitionName="t_o41";
        t_o41.InputPlaceName.add("p_qo41");
        t_o41.InputPlaceName.add("p_i");

        Condition T22Ct1= new Condition(t_o41,"p_qo41",TransitionCondition.CanAddCars);
        Condition T22Ct2= new Condition(t_o41, "p_i", TransitionCondition.HaveCarForMe);
        T22Ct1.SetNextCondition(LogicConnector.AND,T22Ct2);

        GuardMapping grdT22= new GuardMapping();
        grdT22.condition=T22Ct1;
        grdT22.Activations.add(new Activation(t_o41, "p_i", TransitionOperation.PopElementWithTargetToQueue, "p_qo41"));
        t_o41.GuardMappingList.add(grdT22);

        t_o41.Delay = 0;
        pn.Transitions.add(t_o41);

        // Petri Start
        System.out.println("Intersection started");
        pn.Delay = 2000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }

}
