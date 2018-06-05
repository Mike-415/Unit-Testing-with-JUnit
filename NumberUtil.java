import java.util.*;

public class NumberUtil {
    
	private static final String EMPTY_LIST_MESSAGE = "EXCEPTION: Empty list";
    private List<Integer> numberList;
    
    public NumberUtil(List<Integer> numberList) {
        this.numberList = numberList;
    }
    
    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }
    
    public int max() {
    	if(numberList != null){
    		return numberList.stream()
    	    		  .max(Integer::compareTo)
    	    		  .get();
    	} else {
    		throw new IllegalArgumentException(EMPTY_LIST_MESSAGE);
    	}
      
    }
    

    public int sum() {
    	if(numberList != null){
	        return numberList.stream()
	        		.mapToInt(Integer::intValue)
	        		.sum();
    	} else {
    		throw new IllegalArgumentException(EMPTY_LIST_MESSAGE);
    	}
    }

}
