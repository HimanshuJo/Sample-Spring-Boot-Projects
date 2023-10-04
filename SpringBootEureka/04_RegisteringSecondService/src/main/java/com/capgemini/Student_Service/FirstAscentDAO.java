package com.capgemini.Student_Service;

import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component
public class FirstAscentDAO {

    private static Map<Long, String>ascent=new HashMap<Long, String>();
    {
        ascent.put(1L, "1950");
        ascent.put(2L, "1950");
        ascent.put(3L, "1950");
    }

    public String get(Long key){
        return ascent.get(key);
    }
    
}
