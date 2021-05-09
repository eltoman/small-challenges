package kcsit.ExerciseThree;

public abstract class FilteringLineChain {
    private FilteringLineChain next;

    public FilteringLineChain linkWith(FilteringLineChain next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(LineDetail lineDetail);

    protected boolean checkNext(LineDetail lineDetail) {
        if (next == null) {
            return true;
        }
        return next.check(lineDetail);
    }
}
