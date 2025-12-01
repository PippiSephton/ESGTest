package stringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class StringCalculator {
    public int add1(String string){
        int result = 0;
        String[] array = string.split(",");
        for(int i = 0; i< array.length; i++){
            String res = array[i].replace(",", "");
            if(res.equals("")){
                continue;
            }
            result += Integer.parseInt(res);
        }
        return result;
    }

    public int add2(String string){
        int result = 0;
        String[] array = string.split(",");
        for(int i = 0; i< array.length; i++){
            String res = array[i].replace(",", "");
            if(res.equals("")){
                continue;
            }
            result += Integer.parseInt(res);
        }
        return result;
    }
    public int add3(String string){
        int result = 0;
        String regex = "[^0-9]";
        String[] array = string.split(regex);
        for(int i = 0; i< array.length; i++){
            String res = array[i].replace(regex, "");
            if(res.equals("")){
                continue;
            }
            result += Integer.parseInt(res);
        }
        return result;

    }
    public int add4(String string){
        int result = 0;
        String regex = "[^0-9]";
        String[] array = string.split(regex);
        for(int i = 0; i< array.length; i++){
            String res = array[i].replace(regex, "");
            if(res.equals("")){
                continue;
            }
            result += Integer.parseInt(res);
        }
        return result;

    }
    public int add5(String string) throws Exception {
        int result = 0;
        String regex = "[^0-9-]";
        ArrayList<String> errorArray = new ArrayList<>();
        String[] array = string.split(regex);
        for(int i = 0; i< array.length; i++){
            if(array[i].isEmpty()){
                continue;
            }
            int num = Integer.parseInt(array[i]);
            if(num < 0){
                errorArray.add(String.valueOf(num));
                continue;
            }
            result += num;
        }
        if(!errorArray.isEmpty()){
            String errorMsg = "Cannot contain negative numbers ".concat(errorArray.get(0));
            for(int i = 1; i < errorArray.size(); i++) {
                errorMsg.concat(", "+errorArray.get(i));
            }
            throw new Exception(errorMsg);
        }
        return result;
    }
    public int add6(String string) throws Exception {
        int result = 0;
        String regex = "[^0-9-]";
        ArrayList<String> errorArray = new ArrayList<>();
        String[] array = string.split(regex);
        for(int i = 0; i< array.length; i++){
            if(array[i].isEmpty()){
                continue;
            }
            int num = Integer.parseInt(array[i]);
            if(num < 0){
                errorArray.add(String.valueOf(num));
                continue;
            } else if(num > 999){
                continue;
            }
            result += num;
        }
        if(!errorArray.isEmpty()){
            String errorMsg = "Cannot contain negative numbers ".concat(errorArray.get(0));
            for(int i = 1; i < errorArray.size(); i++) {
                errorMsg.concat(", "+errorArray.get(i));
            }
            throw new Exception(errorMsg);
        }
        return result;
    }
    public int add7(String string) throws Exception {
        int result = 0;
        String regex = "[^0-9-]";
        ArrayList<String> errorArray = new ArrayList<>();
        String[] array = string.split(regex);
        for(int i = 0; i< array.length; i++){
            if(array[i].isEmpty()){
                continue;
            }
            int num = Integer.parseInt(array[i]);
            if(num < 0){
                errorArray.add(String.valueOf(num));
                continue;
            } else if(num > 999){
                continue;
            }
            result += num;
        }
        if(!errorArray.isEmpty()){
            String errorMsg = "Cannot contain negative numbers ".concat(errorArray.get(0));
            for(int i = 1; i < errorArray.size(); i++) {
                errorMsg.concat(", "+errorArray.get(i));
            }
            throw new Exception(errorMsg);
        }
        return result;

    }
    public int add8(String string) throws Exception {
        int result = 0;
        String regex = "[^0-9-]";
        ArrayList<String> errorArray = new ArrayList<>();
        String[] array = string.split(regex);
        for(int i = 0; i< array.length; i++){
            if(array[i].isEmpty()){
                continue;
            }
            int num = Integer.parseInt(array[i]);
            if(num < 0){
                errorArray.add(String.valueOf(num));
                continue;
            } else if(num > 999){
                continue;
            }
            result += num;
        }
        if(!errorArray.isEmpty()){
            String errorMsg = "Cannot contain negative numbers ".concat(errorArray.get(0));
            for(int i = 1; i < errorArray.size(); i++) {
                errorMsg.concat(", "+errorArray.get(i));
            }
            throw new Exception(errorMsg);
        }
        return result;

    }
    public int add9(String string) throws Exception {
        int result = 0;
        String regex = "[^0-9-]";
        ArrayList<String> errorArray = new ArrayList<>();
        String[] array = string.split(regex);
        for(String number : array){
            if(number.isEmpty()){
                continue;
            }
            int num = Integer.parseInt(number);
            if(num < 0){
                errorArray.add(String.valueOf(num));
                continue;
            } else if(num > 999){
                continue;
            }
            result += num;
        }
        if(!errorArray.isEmpty()){
            String errorMsg = "Cannot contain negative numbers ".concat(errorArray.get(0));
            for(int i = 1; i < errorArray.size(); i++) {
                errorMsg.concat(", "+errorArray.get(i));
            }
            throw new Exception(errorMsg);
        }
        return result;

    }
}
