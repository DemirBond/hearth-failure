package com.szg_tech.hearthfailure.rest.requests.mappings;

import android.util.Pair;

import com.szg_tech.hearthfailure.core.ConfigurationParams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ahmetkucuk on 4/4/17.
 *
 * This class is created in order to map radio buttons
 * to the integer values.
 *
 * This class is a patch to current systems. It would be
 * better to have a solution embedded inside the EvaluationItems
 */

public class RadioButtonMapper {

    private final String key;
    private final List<Pair<String, Integer>> radioButtonKeys;
    private final boolean shouldSetDefault;
    private final int defaultValue;

    private static final RadioButtonMapper ageMapper = new RadioButtonMapper(ConfigurationParams.GENDER,
            new ArrayList<Pair<String, Integer>>(){
                {
                    add(new Pair<String, Integer>(ConfigurationParams.MALE, 1));
                    add(new Pair<String, Integer>(ConfigurationParams.FEMALE, 2));
                }
            }, true, 1);

    private static final RadioButtonMapper anginaIndexMapper = new RadioButtonMapper(ConfigurationParams.ANGINA_INDEX,
            new ArrayList<Pair<String, Integer>>(){
                {
                    add(new Pair<String, Integer>(ConfigurationParams.NO_ANGINA_DURING_EXERCISE, 1));
                    add(new Pair<String, Integer>(ConfigurationParams.NON_LIMITING_ANGINA, 1));
                    add(new Pair<String, Integer>(ConfigurationParams.EXERCISE_LIMITING_ANGINA, 2));
                }
            }, false, Integer.MAX_VALUE);

    private RadioButtonMapper(String key, List<Pair<String, Integer>> radioButtonKeys, boolean shouldSetDefault, int defaultValue) {

        this.key = key;
        this.radioButtonKeys = radioButtonKeys;
        this.shouldSetDefault = shouldSetDefault;
        this.defaultValue = defaultValue;
    }

    public void map(Map<String, Object> evaluationValueMap) {
        final int[] value = new int[] {Integer.MAX_VALUE};
        for(Pair<String, Integer> p: radioButtonKeys) {
            if(evaluationValueMap.containsKey(p.first)) {
                if(evaluationValueMap.get(p.first) instanceof Boolean) {
                    if(((Boolean)evaluationValueMap.get(p.first))) {
                        value[0] = p.second;
                    }
                } else {
                    System.err.println("Parameter " + p.first + " is expected to be boolean. But it is not");
                }
                evaluationValueMap.remove(p.first);
            }
        }

        //Put value for the key
        evaluationValueMap.put(key, value[0]);

        //If all radiobuttons are false, do not put value for the key
        if(value[0] == Integer.MAX_VALUE) {
            if(shouldSetDefault){
                evaluationValueMap.put(key, defaultValue);
            } else {
                evaluationValueMap.remove(key);
            }
        }
    }

    public static RadioButtonMapper genderMapper() {
        return ageMapper;
    }

    public static RadioButtonMapper anginaIndexMapper() {
        return anginaIndexMapper;
    }
}
