import com.alibaba.fastjson.JSON;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author ahao 2020-10-13
 */
public class hw {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("xiaoli");
        stringList.add("xiaowang");
        Emp emp = new Emp();
        emp.setStrings(stringList);
        System.out.println(JSON.toJSON(emp));
        jsonToObject("{\"strings\":[\"xiaoli\",\"xiaowang\"]}");



    }

    public static Emp jsonToObject(String json) {
        Emp emp = new Emp();
        List<String> stringList = new ArrayList<>();
        String[] s = json.split(":")[1].substring(1,json.split(":")[1].length()-2).split(",");
        Arrays.stream(s).forEach(str ->{
            stringList.add(str.replace("\"",""));
        });
        emp.setStrings(stringList);
        return emp;
    }

}