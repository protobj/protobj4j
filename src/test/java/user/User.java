package user;

import it.unimi.dsi.fastutil.bytes.Byte2ShortMap;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import person.Person;

//引入的其他文件类型
//ext Person person = 1 ; 
public class User extends Person {

    //arr Person personArr = 2 ; 
    private Person[] personArr;

    //arr Person personArrMorphic = 3 [ polymorphic=true ] ; 
    private Person[] personArrMorphic;

    //lst i32 i32List = 4 ; 
    private IntList i32List;

    //arr bool boolArr = 5 ; 
    private boolean[] boolArr;

    //map<string,i32> stringI32Map = 6 ; 
    private Object2IntMap<String> stringI32Map;

    //map<i8,i16> i8i16Map = 7 ; 
    private Byte2ShortMap i8i16Map;

    public void setPersonArr(Person[] personArr) {
        this.personArr = personArr;
    }

    public Person[] getPersonArr() {
        return personArr;
    }

    public void setPersonArrMorphic(Person[] personArrMorphic) {
        this.personArrMorphic = personArrMorphic;
    }

    public Person[] getPersonArrMorphic() {
        return personArrMorphic;
    }

    public void setI32List(IntList i32List) {
        this.i32List = i32List;
    }

    public IntList getI32List() {
        return i32List;
    }

    public void setBoolArr(boolean[] boolArr) {
        this.boolArr = boolArr;
    }

    public boolean[] getBoolArr() {
        return boolArr;
    }

    public void setStringI32Map(Object2IntMap<String> stringI32Map) {
        this.stringI32Map = stringI32Map;
    }

    public Object2IntMap<String> getStringI32Map() {
        return stringI32Map;
    }

    public void setI8i16Map(Byte2ShortMap i8i16Map) {
        this.i8i16Map = i8i16Map;
    }

    public Byte2ShortMap getI8i16Map() {
        return i8i16Map;
    }

}
