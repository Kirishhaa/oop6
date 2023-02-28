package org.example.structures.range;

public class Range {
    private int start;
    private int end;
    public Range(int start, int end){
        this.start=start;
        this.end=end;
    }
    public boolean contains(int value){
        return (value>=start && value<=end);
    }
}
