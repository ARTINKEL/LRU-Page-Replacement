import java.util.ArrayList;

public class LRU extends ReplacementAlgorithm {

    private int capacity = Test.page_frames;
    private ArrayList<Integer> a = new ArrayList<>(capacity);

    private ArrayList<Integer> array = new ArrayList<>();

    public LRU(int pageFrameCount) {
        super(pageFrameCount);
    }

    public void algorithmn() {
        int count = 0;
        for (int i : a) {
            if (!a.contains(i)) {
                if (a.size() == capacity) {
                    a.remove(i);
                    a.add(capacity - 1, i);
                } else {
                    a.add(count, i);
                    pageFaultCount++;
                    ++count;
                }
            } else {
                a.remove(i);
                a.add(a.size(), i);
            }
        }
    }

    @Override
    public void insert(int pageNumber) {
        array.add(pageNumber);
    }
}