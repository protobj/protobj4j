package user;

import it.unimi.dsi.fastutil.ints.IntSet;
import person.Person;

//ext Person person = 2 ; 
public class Worker extends Person {

    //set i32 num = 1 ; 
    private IntSet num;

    public void setNum(IntSet num) {
        this.num = num;
    }

    public IntSet getNum() {
        return num;
    }

}
