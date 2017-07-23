package radioshowModel;

import java.util.Comparator;

/**
 * @author Eilidh Southren - 1513195
 * 
 */
public class RuntimeComparator implements Comparator<TimeSlot>{

    @Override
    public int compare(TimeSlot o1, TimeSlot o2) {
        return o2.getRuntime() - o1.getRuntime();
    }
    
}
