import java.util.ArrayList;

public class LRU extends ReplacementAlgorithm {

    private int capacity = Test.page_frames;
    private ArrayList<Integer> a = new ArrayList<>(capacity);
    private ArrayList<Integer> array = new ArrayList<>();
    private int page_swaps = 0;

    public LRU(int pageFrameCount) {
        super(pageFrameCount);
    }

    public void algorithm() {
        int count = 0;
        for (int i : array) {
            if (!a.contains(i)) {
                if (a.size() == capacity) {
                    a.remove(0);
                    a.add(capacity - 1, i);
                } else {
                    a.add(count, i);
                    pageFaultCount++;
                    ++count;
                }
            } else {
                a.remove( (Object) i );
                a.add(a.size(), i);
                page_swaps++;
            }
        }
    }

    public int getPageSwaps() {
        return page_swaps;
    }

    @Override
    public void insert(int pageNumber) {
        array.add(pageNumber);
    }
}