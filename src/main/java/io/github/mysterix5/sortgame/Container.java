package io.github.mysterix5.sortgame;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Container {
    private List<Color> colorList = new ArrayList<>();
    private int height = 4;

    public Container(int height){
        this.height = height;
    }

    @Override
    public String toString() {
        return "WaterColorBottle{" +
                "colorList=" + colorList +
                '}';
    }

    public Color getTop(){
        return !isEmpty() ? colorList.get(colorList.size()-1) : null;
    }

    public void addColor(Color color){
        if(isFull()) throw new RuntimeException("cant add another color to this bottle");
        colorList.add(color);
    }

    public boolean isFull(){
        return colorList.size()>=height;
    }
    public boolean isEmpty(){
        return colorList.isEmpty();
    }

    public boolean isFinished(){
        if(!isFull()){
            return false;
        }
        Color color = colorList.get(0);
        for(var c: colorList){
            if(c!=color){
                return false;
            }
        }
        return true;
    }

    public Color pop() {
        return !isEmpty() ? colorList.remove(colorList.size()-1) : null;
    }
}