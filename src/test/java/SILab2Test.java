
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    SILab2 lab = new SILab2();
    public List<Time> createList(Integer... elems){
        List<Integer> newList = new ArrayList<>(Arrays.asList(elems));
        List<Time> timeList = new ArrayList<>();
        for (int i=0;i<newList.size();i=i+3){
            Time time = new Time(newList.get(i),newList.get(i+1),newList.get(i+2));
            timeList.add(time);
        }
        return timeList;
    }
    @Test
    void multipleConditions(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(-1,30,20)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(25,30,20)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(1,-1,20)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(1,60,20)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(5420);
        assertEquals(listInteger,lab.function(createList(1,30,20)));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(1,30,-1)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(1,30,60)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        List<Integer> list = new ArrayList<>();
        list.add(86400);
        assertEquals(list,lab.function(createList(24,0,0)));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(24,30,20)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(24,0,30)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }



    @Test
    void everyBranch(){
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(-1,30,20)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(25,30,20)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(12,-1,20)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(12,30,60)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        List<Integer> list = new ArrayList<>();
        list.add(45020);
        assertEquals(list,lab.function(createList(12,30,20)));
        list.remove(0);
        list.add(86400);

        assertEquals(list,lab.function(createList(24,0,0)));

        ex = assertThrows(RuntimeException.class, () -> lab.function(createList(24,30,20)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }


}
