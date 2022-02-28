package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private List<Integer> circularList;
    private int currentIndex;

    public CircularListImpl(){
        this.circularList = new LinkedList<>();
        currentIndex = 0;
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> result = Optional.of(this.circularList.get(currentIndex));
        this.currentIndex = this.currentIndex == circularList.size() - 1 ? 0 :  this.currentIndex + 1;
        return result;
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
