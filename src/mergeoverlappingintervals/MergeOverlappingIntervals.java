/*

Given a list of sorted intervals. Merge overlapping intervals.
E.g:
Given: [1,3], [2,6], [8,10], [15,18]
result: [1,6], [8,10], [15,18]
 */
package mergeoverlappingintervals;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ali
 */
public class MergeOverlappingIntervals 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<List<Integer>> unMergedList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        unMergedList.add(list);
        
        list = new ArrayList<>();
        list.add(2);
        list.add(6);
        unMergedList.add(list);
        
        list = new ArrayList<>();
        list.add(5);
        list.add(10);
        unMergedList.add(list);
        
        list = new ArrayList<>();
        list.add(8);
        list.add(18);
        unMergedList.add(list);
        
        List<List<Integer>> mergedLists = mergeIntervals(unMergedList);
        
        for (List<Integer> merged : mergedLists)
        {
            System.out.print("[");
            for (int i=0; i<merged.size(); i++)
            {
                System.out.print(merged.get(i)+",");
            }
            System.out.print("]");
        }
    }
    
    private static List<List<Integer>> mergeIntervals(List<List<Integer>> unMerged)
    {
        if (unMerged.isEmpty())
            return null;
        
        List<List<Integer>> merged = new ArrayList<>();
        List<Integer> prevList = unMerged.get(0);
        
        for (int i=1; i<unMerged.size(); i++)
        {
            List<Integer> subList = unMerged.get(i);
            if (subList.get(0) >= prevList.get(0) && subList.get(0) <= prevList.get(1))
            {
                List<Integer> subMerged = mergeLists(prevList, subList);
                prevList = subMerged;
            }
            else
            {
                merged.add(prevList);
                prevList = subList;
            }
        }
        
        merged.add(prevList);
        
        return merged;
    }
    
    private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2)
    {
        if (list1.size() != 2 || list2.size() != 2)
            return null;
        
        List<Integer> merged = new ArrayList<>();
        if (list1.get(0) <= list2.get(0))
        {
            merged.add(list1.get(0));
            merged.add(list2.get(1));
        }
        else
        {
            merged.add(list2.get(0));
            merged.add(list1.get(1));
        }
        
        return merged;
    }
    
}
