public class Main {
    public static void main(String[] args) {
        System.out.println(converterArabRom(65));
        System.out.println(converterArabRom(976));
        System.out.println(converterArabRom(1158));
        System.out.println(converterArabRom(1942));
        System.out.println(converterArabRom(3396));
        System.out.println(converterArabRom(5327));
        System.out.println(converterArabRom(11252));
        System.out.println(converterArabRom(32638));
    }

    public static String converterArabRom(int number) {
        http://graecolatini.bsu.by/htm-different/num-converter-roman.htm
//        if (number>3999) {
        if (number>33999) {
            System.out.println("Out of range 0 - 3999");
            return "";
        }
//        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder valueStr = new StringBuilder();

        while (number > 0) {
            if (number>=10_000) {valueStr.append("X̅"); number-= 10000;}
            if (number>=9_000) {valueStr.append("I̅X̅"); number-= 9000;}
            else if (number>=8_000) {valueStr.append("V̅I̅̅I̅̅I̅̅"); number-= 8000;}
            else if (number>=7_000) {valueStr.append("V̅I̅̅I̅̅̅"); number-= 7000;}
            else if (number>=6_000) {valueStr.append("V̅I̅̅"); number-= 6000;}
            else if (number>=5_000) {valueStr.append("V̅"); number-= 5000;}
            else if (number>=4_000) {valueStr.append("I̅̅V̅"); number-= 4000;}
            else if (number>=1_000) {valueStr.append("M"); number-= 1000;}
            else if (number>=900) {valueStr.append("CM"); number-= 900;}
            else if (number>=800) {valueStr.append("DCCC"); number-= 800;}
            else if (number>=700) {valueStr.append("DCC"); number-= 700;}
            else if (number>=600) {valueStr.append("DC"); number-= 600;}
            else if (number>=500) {valueStr.append("D"); number-= 500;}
            else if (number>=400) {valueStr.append("CD"); number-= 400;}
            else if (number>=300) {valueStr.append("CCC"); number-= 300;}
            else if (number>=200) {valueStr.append("CC"); number-= 200;}
            else if (number>=100) {valueStr.append("C"); number-= 100;}
            else if (number>=90) {valueStr.append("XC");;number-= 90;}
            else if (number>=80) {valueStr.append("LXXX");;number-= 80;}
            else if (number>=70) {valueStr.append("LXX");;number-= 70;}
            else if (number>=60) {valueStr.append("LX");;number-= 60;}
            else if (number>=50) {valueStr.append("L");number-= 50;}
            else if (number>=40) {valueStr.append("XL");number-= 40;}
            else if (number>=30) {valueStr.append("XXX");number-= 30;}
            else if (number>=20) {valueStr.append("XX");number-= 20;}
            else if (number>=10) {valueStr.append("X"); number-= 10; }
            else if (number==9) {valueStr.append("IX"); number-= 9; }
            else if (number==8) {valueStr.append("VIII"); number-= 8; }
            else if (number==7) {valueStr.append("VII"); number-= 7;}
            else if (number==6) {valueStr.append("VI"); number-= 6;}
            else if (number==5) {valueStr.append("V"); number-= 5;}
            else if (number==4) {valueStr.append("IV"); number-= 4;}
            else if (number==3) {valueStr.append("III"); number-= 3;}
            else if (number==2) {valueStr.append("II"); number-= 2;}
            else if (number==1) {valueStr.append("I"); number-= 1;}
        }
        return valueStr.toString();
    }
}
