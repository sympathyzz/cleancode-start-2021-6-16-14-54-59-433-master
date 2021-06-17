package com.tw.academy.basic.$4_naming.practiceTwo;

public class PigLatin {
    //Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
    public static String pigIt(String str) {
        String[] arr_mark={".",",","-",":",";","!","?"};
        String[] arr = str.split(" ");
        char c;
        boolean flag = true;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr_mark.length; j++)
                if(arr[i].contains(arr_mark[j]) == true)
                    flag = false;

            if (flag){
                c = arr[i].charAt(0);
                arr[i] = arr[i].substring(1, arr[i].length());
                arr[i] = arr[i].replace(arr[i], arr[i] + c + "ay");
            }
            flag = true;
        }

        return String.join(" ", arr);
    }
}
