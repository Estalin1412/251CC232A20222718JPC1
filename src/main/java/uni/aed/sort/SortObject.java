package uni.aed.sort;
public class SortObject {    
    private Object[] X;

    public void setX(Object[] X) {
        this.X = X;
    }

    public Object[] getX() {
        return X;
    }
    public void callMergeSort(){
        mergeSort(X);
    }
    private Object[] mergeSort(Object[] X){
        int n=X.length;
        if(n<2) return X;
        int mid=n/2;
        Object[] left=new Object[mid];
        Object[] right=new Object[n-mid];
        for(int i=0;i<mid;i++)
            left[i]=X[i];
        for(int i=mid;i<n;i++)
            right[i-mid]=X[i];
        mergeSort(left);
        mergeSort(right);
        merge(X,left,right);
        return X;
    }
    private void merge(Object[] X,Object[] left,Object[] right){
        int nL=left.length;
        int nR=right.length;
        int i=0,j=0,k=0,result;        
        while(i<nL && j<nR){
            result=((Comparable)left[i]).compareTo(right[j]);
            if(result<=0){
                X[k]=left[i];
                i++;
            }else{
                X[k]=right[j];
                j++;
            }
            k++;    
        }
        while(i<nL){
            X[k]=left[i];
            i++;
            k++;
        }
        while(j<nR){
            X[k]=right[j];
            j++;
            k++;
        }
    }

    @Override
    public String toString() {
        if (X==null) return "";
        StringBuilder str=new StringBuilder();
        for(Object x:X)
            if(str.isEmpty())
                str.append(x.toString());
            else
                str.append("|" + x.toString());
        
        return "{"+str.toString()+"}";   
    }
    
        public void heapSort(Comparable[] array) {
        int n = array.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            Comparable temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            
            heapify(array, i, 0);
        }
    }
    
    
    private void heapify(Comparable[] array, int n, int i) {
        int largest = i;  
        int left = 2 * i + 1;  
        int right = 2 * i + 2;
        
        if (left < n && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }
        
        if (right < n && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }
        
        if (largest != i) {
            Comparable swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            
            heapify(array, n, largest);
        }
    }
    
    
}
