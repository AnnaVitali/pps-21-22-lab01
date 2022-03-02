package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        this.updateIndexNext();
        return result;
    }

    @Override
    public Optional<Integer> previous() {
        this.updateIndexPrevious();
        Optional<Integer> result = Optional.of(this.circularList.get(currentIndex));
        return result;
    }

    @Override
    public void reset() {
        List<Integer> resetList = new LinkedList<>();

        for(int i = 0; i < this.circularList.size(); i++){
            resetList.add(this.next().get());
        }

        this.circularList = resetList;
        this.currentIndex = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        List<Integer> nextElements = this.circularList.subList(this.currentIndex, this.circularList.size());
        this.updateIndexNext();
        return Optional.of(nextElements.stream().filter(strategy::apply).collect(Collectors.toList()).get(0));
    }

    private void updateIndexNext(){
        this.currentIndex = this.currentIndex == circularList.size() - 1 ? 0 :  this.currentIndex + 1;
    }

    private void updateIndexPrevious(){
        this.currentIndex = this.currentIndex == 0 ? this.circularList.size() - 1 : this.currentIndex - 1;
    }
}
